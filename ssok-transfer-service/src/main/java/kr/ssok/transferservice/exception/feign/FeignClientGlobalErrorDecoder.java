package kr.ssok.transferservice.exception.feign;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import kr.ssok.transferservice.client.dto.response.OpenBankingResponse;
import kr.ssok.transferservice.exception.TransferException;
import kr.ssok.transferservice.exception.TransferResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * OpenFeign Client Error 전역 예외처리를 관리
 */
@Slf4j
@Component
public class FeignClientGlobalErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * OpenFeign에서 발생하는 Status Code와 응답 바디를 기반으로 오류를 커스텀 처리로 수행
     *
     * @param methodKey 메서드 키
     * @param response  Feign 응답 객체
     * @return 예외 객체
     */
    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            // 응답 바디를 InputStream으로 읽어서 문자열로 변환
            String responseBody = new BufferedReader(new InputStreamReader(
                    response.body().asInputStream(), StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));

            log.error("Feign Client Error - Method: {}, Status: {}, Response: {}",
                    methodKey, response.status(), responseBody);

            // OpenBankingResponse로 파싱
            OpenBankingResponse openBankingResponse = objectMapper.readValue(responseBody, OpenBankingResponse.class);

            // 상세 오류 메시지 추출
            if (openBankingResponse.getResult() != null) {
                Map<String, Object> result = openBankingResponse.getResult();
                String transactionId = (String) result.get("transactionId");
                String status = (String) result.get("status");
                String errorMessage = (String) result.get("message");
                log.error("상세 오류 - 트랜잭션 ID: {}, 상태: {}, 메시지: {}", transactionId, status, errorMessage);
            }

            // 에러 코드 처리
            String errorCode = openBankingResponse.getCode();

            // 커스텀 코드 기반으로 예외 처리
            return switch (errorCode) {
                case "TRANSFER002" -> new TransferException(TransferResponseStatus.WITHDRAWAL_ERROR);
                case "TRANSFER003" -> new TransferException(TransferResponseStatus.DEPOSIT_ERROR);
                case "COMMON0400" -> new TransferException(TransferResponseStatus.DORMANT_ACCOUNT);
                case "ACCOUNT001" -> new TransferException(TransferResponseStatus.ACCOUNT_NOT_FOUND);
                case "ACCOUNT003" -> new TransferException(TransferResponseStatus.INSUFFICIENT_BALANCE);
                default -> new TransferException(TransferResponseStatus.TRANSFER_FAILED);
            };
        } catch (IOException e) {
            log.error("Error while decoding Feign response: ", e);
            return new TransferException(TransferResponseStatus.TRANSFER_FAILED);
        }
    }
}