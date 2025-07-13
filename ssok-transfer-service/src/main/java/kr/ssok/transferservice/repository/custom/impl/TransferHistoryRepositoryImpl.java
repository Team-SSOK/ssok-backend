package kr.ssok.transferservice.repository.custom.impl;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.ssok.transferservice.dto.response.TransferCounterpartResponseDto;
import kr.ssok.transferservice.entity.QTransferHistory;
import kr.ssok.transferservice.enums.TransferMethod;
import kr.ssok.transferservice.enums.TransferType;
import kr.ssok.transferservice.repository.custom.TransferHistoryRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 송금 이력 QueryDSL 쿼리 구현체
 */
@Repository
@RequiredArgsConstructor
public class TransferHistoryRepositoryImpl implements TransferHistoryRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<TransferCounterpartResponseDto> findRecentCounterparts(List<Long> accountIds) {
        QTransferHistory h = QTransferHistory.transferHistory;
        if (accountIds == null || accountIds.isEmpty()) return List.of();

        // 1) 최신순으로 (계좌, 시간) 1,000건만 읽는다
        List<Tuple> tuples = queryFactory
                .select(h.counterpartAccount, h.createdAt)
                .from(h)
                .where(
                        h.accountId.in(accountIds),
                        h.transferType.eq(TransferType.WITHDRAWAL),
                        h.transferMethod.eq(TransferMethod.GENERAL)
                )
                .orderBy(h.createdAt.desc())
                .limit(1000)    // 50개를 뽑기 위해 충분히 큰 수
                .fetch();

        // 2) 첫 50개 고유 계좌 뽑기
        List<String> distinctAccts = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        for (Tuple t : tuples) {
            String acct = t.get(h.counterpartAccount);
            if (seen.add(acct)) {
                distinctAccts.add(acct);
                if (distinctAccts.size() == 50) break;
            }
        }
        if (distinctAccts.isEmpty()) return List.of();

        // 3) 그 50개 계좌에 대해 한 번만 나머지 정보 조회
        List<TransferCounterpartResponseDto> dtos = queryFactory
                .select(Projections.constructor(
                        TransferCounterpartResponseDto.class,
                        h.counterpartName,
                        h.counterpartAccount,
                        h.counterpartBankCode,
                        h.createdAt  // lastTransferAt 으로 사용
                ))
                .from(h)
                .where(
                        h.accountId.in(accountIds),
                        h.transferType.eq(TransferType.WITHDRAWAL),
                        h.transferMethod.eq(TransferMethod.GENERAL),
                        h.counterpartAccount.in(distinctAccts)
                )
                .orderBy(h.createdAt.desc())  // DTO 결과를 최신순으로
                .fetch();

        return dtos;
    }

    /**
     * (Deprecated - 테스트 이후 삭제 예정)
     * 주어진 계좌 ID 리스트를 기반으로 최근 송금(출금)한 상대방 목록을 조회
     * - 조회 기준: 일반(GENERAL) 송금이면서, 출금(WITHDRAWAL) 타입인 건만.
     * - 중복 상대방 계좌는 제거하고, 가장 최근 송금 시점을 기준으로 정렬
     *
     * @param accountIds 조회 대상 계좌 ID 리스트
     * @return 중복 제거된 송금 상대방 목록 (TransferCounterpartResponseDto 리스트)
     */
//    @Override
//    public List<TransferCounterpartResponseDto> findRecentCounterparts(List<Long> accountIds) {
//        QTransferHistory history = QTransferHistory.transferHistory;
//
//        if (accountIds == null || accountIds.isEmpty()) {
//            // 빈 결과 리턴
//            return List.of();
//        }
//
//        // 1. DB에서 조건에 맞는 송금 이력만 조회하고 바로 DTO로 매핑
//        List<TransferCounterpartResponseDto> fetchedResults = queryFactory
//                .select(
//                        // Projections.constructor을 통해 SELECT 결과를 바로 DTO 생성자로 매핑
//                        Projections.constructor(
//                                TransferCounterpartResponseDto.class,
//                                history.counterpartName,
//                                history.counterpartAccount,
//                                history.counterpartBankCode,
//                                history.createdAt.max() // max(createdAt)로 최신 송금 시간
//                        )
//                )
//                .from(history)
//                .where(
//                        history.accountId.in(accountIds),                   // 조회할 계좌 ID 중 하나
//                        history.transferType.eq(TransferType.WITHDRAWAL),   // 출금 건만
//                        history.transferMethod.eq(TransferMethod.GENERAL)   // 일반 송금만
//                )
//                .groupBy(history.counterpartAccount, history.counterpartName, history.counterpartBankCode) // 상대방 계좌번호 + 이름 기준 그룹핑
//                .orderBy(history.createdAt.max().desc()) // 최근 송금 시점 기준 정렬
//                .limit(50) // 최대 50개만 조회
//                .fetch(); // SQL 실행 및 결과 fetch
//
//        return fetchedResults;
//    }
}
