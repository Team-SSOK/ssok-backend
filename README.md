<div align="center">
    <img width="850px" alt="SSOK" src="https://github.com/user-attachments/assets/e7bf97d5-f088-4a6e-acc0-e90235779d9d">
    </a>
    <h3>"블루투스 기반 간편 송금 서비스 SSOK"</h3> 
</div>

<br>

---

<br>

<details>
  <summary><b>[ 📋 개요 ]</b> </summary>

## 📋 개요

> 블루투스 기반 송금 기능을 제공하는 금융 서비스 **SSOK**의 백엔드 저장소입니다.

**SSOK**은 마이크로서비스 아키텍처(MSA)로 설계된 현대적인 금융 서비스 플랫폼으로,  
핀번호 기반 인증과 블루투스를 활용한 혁신적인 근거리 송금 서비스를 제공합니다.

### 🎯 핵심 기능
- **핀번호 기반 인증**: 간편하고 안전한 사용자 인증/인가
- **블루투스 근거리 송금**: 주변 사용자와의 직관적인 송금 서비스
- **실시간 알림**: FCM 푸시 알림 및 SMS 발송
- **오픈뱅킹 연동**: 외부 금융기관([OpenBanking](https://github.com/Team-SSOK/ssok-openbanking))과의 실시간 API 연동
- **통합 계좌 관리**: 다중 은행 계좌 통합 관리

<br/>
</details>

<details>
  <summary><b>[ ⭐ 서비스 기능 ]</b> </summary>

## ⭐ 서비스 기능

### [SSOK 회원 가입 및 PIN 번호 설정]

    - 본인의 휴대폰 번호로 본인 인증을 합니다.
    - 본인 인증 진행 후, 회원가입을 진행합니다.
    - 6자리의 숫자로 PIN 번호를 등록합니다.

<img width="100%" src="https://github.com/user-attachments/assets/f904816e-b80c-45e6-b1ab-0e2de8479476" alt="SSOK 회원 가입 및 PIN 번호 설정"/>


<br/>

### [계좌 연동 및 튜토리얼]

    - 첫 로그인 후, 계좌 연동하기 버튼을 눌러 본인의 계좌를 모두 불러옵니다. 
    - 연동할 계좌를 선택하여 앱에 계좌를 연동합니다.
    - 앱 사용 튜토리얼을 통해 앱의 기본 기능을 안내 받습니다.

<img width="100%" src="https://github.com/user-attachments/assets/d3ff9f39-e883-41bf-94c8-fdc7277a1dc9" alt="계좌 연동 및 튜토리얼"/>

<br/>

### [계좌 연동 및 주계좌 변경]

    - 다른 계좌를 추가적으로 연동할 수 있습니다.
    - 여러개의 계좌가 연동되었다면 계좌 카드 스와이프를 통해 여러 계좌를 확인하고 상세 정보를 확인할 수 있습니다.
    - 주계좌가 아닌 계좌를 길게 눌러 주계좌로 변경이 가능합니다.

<img width="100%" src="https://github.com/user-attachments/assets/a6338040-52d7-4973-8137-26eb9e17191d" alt="계좌 연동 및 주계좌 변경"/>

<br/>

### [일반 송금 및 송금 내역 조회]

    - 출금할 계좌를 눌러 계좌 상세 페이지로 진입합니다.
    - 송금 버튼을 눌러 송금할 계좌를 입력합니다. 이때, 최근 송금자가 있다면 해당 송금자를 선택하여 간편하게 계좌를 입력할 수 있습니다.
    - 송금 금액을 입력하여 송금을 진행합니다. 단, 동일 계좌 거래는 불가하고 음수 및 잔액을 초과하는 금액은 보낼 수 없습니다.
    - 메인 페이지에서 최근 송금 내역이 확인 가능하며, 계좌 상세 페이지에서 자세한 내역도 확인이 가능합니다.
    - 송금을 받은 SSOK 앱 사용자는 핸드폰에 송금 알림이 오게 됩니다.

<img width="100%" src="https://github.com/user-attachments/assets/00ef504f-2a4a-4870-97c3-31f4c90b82e2" alt="일반 송금 및 송금 내역 조회"/>

<br/>

### [블루투스 송금]

    - 하단에 송금 탭을 눌러 블루투스 송금 페이지로 진입합니다.
    - 주변에 SSOK 블루투스 송금 페이지로 블루투스 기능을 켠 SSOK 사용자가 있다면 조회하게 됩니다.
    - 주변 사용자를 터치하면 해당 사용자의 주계좌로 송금을 할 수 있습니다. 주변 사용자의 정보는 마스킹되어 안전하게 송금이 가능하게 됩니다.
    - 또한 블루투스 UUID를 통해 송금을 처리하도록 하여 수신자의 정보는 보호됩니다.
    - 송금 금액을 입력하여 송금을 진행합니다. 단, 동일 계좌 거래는 불가하고 음수 및 잔액을 초과하는 금액은 보낼 수 없습니다.
    - 블루투스 송금을 진행하면 송금 내역에는 블루투스 송금으로 저장되며 수신자의 정보는 마스킹되어 표시됩니다.
    - 송금을 받은 SSOK 앱 사용자는 핸드폰에 송금 알림이 오게 됩니다.

<img width="100%" src="https://github.com/user-attachments/assets/6b62e8cb-28ca-4ea7-b477-e0eb4423aac8" alt="블루투스 송금"/>

<br/>
</details>


<details>
  <summary><b>[ 🏗️ 아키텍처 ]</b> </summary>

## 🏗️ 아키텍처

SSOK은 **마이크로서비스 아키텍처**로 설계되어 각 도메인별로 독립적인 서비스로 구성되어 있습니다.

### 서비스 아키텍처
<img width="100%" src="https://github.com/user-attachments/assets/349de2c2-422c-4431-be01-b5dc49813d03" alt="서비스 아키텍처"/>

### 인프라 아키텍처
<img width="100%" src="https://github.com/user-attachments/assets/64e51bbb-2fb8-40b5-aba1-128a801dd1e5" alt="인프라 아키텍처"/>

<br/>
</details>

<details>
  <summary><b>[ 🛠️ 기술 스택 ]</b> </summary>

## 🛠️ 기술 스택

<img width="100%" src="https://github.com/user-attachments/assets/29fb48cb-36f0-4074-aaf5-f2c5275c44c5" alt="기술 스택"/>

### Backend Framework
- **Spring Boot 3.4.4**: 마이크로서비스 프레임워크
- **Spring Cloud 2024.0.0**: 마이크로서비스 인프라
- **Spring Security**: 인증/인가 처리
- **Spring Data JPA**: 데이터 액세스 레이어

### Communication
- **Spring Cloud Gateway**: API 게이트웨이
- **OpenFeign**: 서비스 간 HTTP 통신
- **gRPC**: 고성능 내부 서비스 통신
- **Apache Kafka**: 비동기 메시징

### Database & Cache
- **PostgreSQL**: 메인 데이터베이스
- **Redis**: 캐시 및 세션 스토어
- **H2**: 테스트 데이터베이스

### DevOps & Monitoring
- **Docker**: 컨테이너화
- **Kubernetes**: 오케스트레이션
- **Jenkins**: CI/CD 파이프라인
- **Micrometer + Prometheus**: 메트릭 수집
- **Actuator**: 헬스 체크 및 모니터링

### Logging

* **Slf4j + Logback**: 애플리케이션 로그 설정 및 레벨 제어
* **Fluent Bit**: 각 서비스의 로그를 수집하여 Fluentd로 전달
* **Fluentd → OpenSearch**: 집계된 로그를 OpenSearch에 저장
* **OpenSearch Dashboards**: 로그 시각화 및 분석
* **이상 탐지 및 알림**: 에러 및 이상 로그 발생 시 SSOM 및 Slack으로 실시간 알림 전송

<br/>
</details>

<details>
  <summary><b>[ 🔗 프로젝트 구조 & 서비스별 상세 문서 ]</b> </summary>

## 🔗 프로젝트 구조 & 서비스별 상세 문서

### 📂 프로젝트 구조

```
ssok-backend/
├── ssok-common/                    # 공통 라이브러리
├── ssok-gateway-service/           # API 게이트웨이
├── ssok-user-service/              # 사용자 관리 서비스
├── ssok-account-service/           # 계좌 관리 서비스
├── ssok-transfer-service/          # 송금 처리 서비스
├── ssok-bluetooth-service/         # 블루투스 매칭 서비스
├── ssok-notification-service/      # 알림 발송 서비스
├── docker-compose.yml             # 로컬 개발 환경
├── Jenkinsfile                    # CI/CD 파이프라인
└── gradle/                        # Gradle 빌드 설정
```
> 각 마이크로서비스의 상세 프로젝트 구조는 아래의 개별 README 문서를 참고해주세요.

---

각 마이크로서비스의 상세한 명세, 설정 방법, 실행 가이드는 개별 README 문서를 참고하세요.

### 📊 Core Services
| 서비스 | 설명 | 문서 링크 |
|--------|------|-----------|
| **Gateway Service** | API 라우팅, 인증 필터, CORS 처리 | [📖 상세 문서](./ssok-gateway-service/ssok_gateway_service_readme.md) |
| **User Service** | 사용자 관리, 인증/인가, 프로필 관리 | [📖 상세 문서](./ssok-user-service/ssok_user_service_readme.md) |
| **Account Service** | 계좌 관리, OpenBanking 연동 | [📖 상세 문서](./ssok-account-service/ssok_account_service_readme.md) |
| **Transfer Service** | 송금 처리, 거래 내역 관리 | [📖 상세 문서](./ssok-transfer-service/ssok_transfer_service_readme.md) |

### 🔧 Supporting Services
| 서비스 | 설명 | 문서 링크 |
|--------|------|-----------|
| **Bluetooth Service** | 블루투스 매칭, 근거리 송금 | [📖 상세 문서](./ssok-bluetooth-service/ssok_bluetooth_service_readme.md) |
| **Notification Service** | FCM 푸시 알림, SMS 발송 | [📖 상세 문서](./ssok-notification-service/ssok_notification_service_readme.md) |

### 📚 Common Libraries
| 모듈 | 설명 | 문서 링크 |
|------|------|-----------|
| **Common** | 공통 예외, 응답, 유틸리티, gRPC Proto | [📖 상세 문서](./ssok-common/ssok_common_readme.md) |

<br/>
</details>

<details>
  <summary><b>[ 🔀 Git Flow & 협업 가이드라인 ]</b> </summary>

## 🔀 Git Flow & 협업 가이드라인

SSOK 프로젝트는 **Git Flow 전략**을 기반으로 브랜치를 관리하며, 일관된 커밋 컨벤션과 PR 리뷰를 통해 협업 효율을 높입니다.

### 🧵 브랜치 전략

모든 브랜치는 `develop` 브랜치에서 파생되며, 기능 및 목적에 따라 다음과 같은 네이밍 규칙을 따릅니다:

| 브랜치               | 설명                 |
| ----------------- | ------------------ |
| `main`            | 제품으로 출시되는 운영 브랜치   |
| `develop`         | 통합 개발 브랜치 (기본 브랜치) |
| `feat/{이슈번호}/{JIRA 이슈 키}`     | 새로운 기능 개발 브랜치      |
| `fix/{이슈번호}/{JIRA 이슈 키}`      | 버그 수정 브랜치          |
| `refactor/{이슈번호}/{JIRA 이슈 키}` | 코드 리팩토링 브랜치        |
| `docs/{이슈번호}/{JIRA 이슈 키}`     | 문서 작업 브랜치          |
| `hotfix/{이슈번호}/{JIRA 이슈 키}`   | 운영 중 긴급 수정 브랜치     |

#### 📌 브랜치 네이밍 예시

```bash
feat/#1/SCRUM-30
fix/#2/SCRUM-41
refactor/#3/SCRUM-56
docs/#4/SCRUM-18
hotfix/#5/SCRUM-90
```

---

### ✅ 커밋 컨벤션

모든 커밋 메시지는 아래 형식을 따릅니다:

```
{Commit Type}: {의미 있는 메시지} ({깃헙 이슈 번호}, {JIRA 이슈 키})
- 상세 설명 (선택 사항)
```

#### 📌 커밋 예시

```bash
feat: 로그인 기능 구현 (#1, SCRUM-30)
- Spring Security 설정 추가
- JWT 발급 로직 구현
```

| 타입         | 설명            |
| ---------- | ------------- |
| `feat`     | 새로운 기능 추가     |
| `fix`      | 버그 수정         |
| `refactor` | 코드 개선 및 리팩토링  |
| `docs`     | 문서 작성/수정      |
| `test`     | 테스트 코드 작성     |
| `chore`    | 빌드/설정 등 기타 작업 |

---

> 🔒 모든 PR은 리뷰어 지정 및 CI 테스트 통과 후 병합합니다.

<br/>
</details>

<details>
  <summary><b>[ 🔄 CI/CD ]</b> </summary>

## 🔄 CI/CD

### CI/CD 워크플로우
<img width="100%" src="https://github.com/user-attachments/assets/49cabdf4-b133-4dff-9792-d8915dea4d1a" alt="CI/CD 워크플로우"/>

SSOK의 CI/CD는 **Jenkins + Docker + ArgoCD** 기반으로 운영되며, `develop` 브랜치의 변경 사항이 실시간 배포까지 자동화됩니다.

    1. 해당 저장소의 develop 브랜치에 변경사항 발생 (push/merge)
    2. Jenkins가 발생한 트리거를 확인하고 해당하는 서비스의 빌드 수행
    3. 빌드된 이미지는 Docker 이미지로 패키징되어 Docker Hub에 업로드
    4. 빌드후 Jenkins에서 Github ssok-deploy 저장소에 최신 이미지 버전으로 업데이트 및 자동 커밋
    5. ArgoCD가 변경을 감지하고 자동으로 해당 서비스 배포
    (ssok-deploy 저장소의 해당 서비스 HelmChart 렌더링 후 kustomization values.yaml 파일 오버라이드)

### Jenkins 파이프라인(CI)
develop 브랜치에 push 또는 merge가 발생하면 Jenkins CI/CD 파이프라인이 자동으로 실행됩니다.

```groovy
// Jenkinsfile 주요 단계
pipeline {
    stages {
        stage('Build') { ... }
        stage('Test') { ... }
        stage('Docker Build') { ... }
        stage('Deploy') { ... }
    }
}
```

**특징**
- **변경 감지**: 변경된 서비스만 빌드 및 배포
- **병렬 처리**: 독립적인 서비스 동시 빌드
- **롤백 지원**: 배포 실패 시 이전 버전으로 자동 롤백

### Kubernetes 배포 전략(CD)
- **Rolling Update**: Kubernetes의 `rollingUpdate` 전략을 통해 하나씩 Pod을 교체하며 배포합니다.
- **Readiness Probe 기반 트래픽 제어**: `readinessProbe`를 통해 준비되지 않은 Pod에는 트래픽이 전달되지 않도록 하여, 무중단 배포를 보장합니다.
- **Liveness Probe**: 장애가 발생한 Pod을 자동으로 재시작하여 안정성을 유지합니다.

<br/>
</details>

<details>
  <summary><b>[ 🔍 모니터링 & 로깅 ]</b> </summary>

## 🔍 모니터링 & 로깅

### 메트릭 수집 (Monitoring)

<img width="100%" src="https://github.com/user-attachments/assets/8a0a4208-66bf-4487-ba78-2c85d5e1a224" alt="매트릭 수집"/>

> 애플리케이션 및 인프라의 상태를 실시간 관측하여 이상 상황을 조기에 감지

* **Prometheus**: EKS 클러스터 노드 및 마이크로서비스의 메트릭 수집
* **Micrometer**: Spring Boot 기반의 서비스 메트릭 노출
* **Grafana**: 대시보드를 통해 시각화 및 실시간 모니터링
* **Alert Manager**: 설정한 알림 조건에 따라 이벤트 발생 시 Webhook을 통해 SSOM에 알림 전송

### 로그 수집 (Logging)

<img width="100%" src="https://github.com/user-attachments/assets/5b6f9ec5-e3a1-452d-9ff9-770045d6cd8a" alt="로그 수집"/>

> 서비스 오류나 예외 발생 시, 빠르게 로그를 수집하고 대응할 수 있도록 구성

* **Slf4j + Logback**: logback-spring.xml 기반 애플리케이션 로그 출력
* **Fluent Bit (Sidecar)**: 각 마이크로서비스 파드에 사이드카 형태로 구성되어 로그를 수집
* **Fluentd**: Fluent Bit에서 전달받은 로그를 OpenSearch에 적재
* **OpenSearch**: 수집된 로그를 저장 및 검색 가능
* **OpenSearch Dashboards**: 사용자 정의 대시보드를 통해 에러 로그 필터링 및 시각화
* **OpenSearch Alert Monitor**: 조건부 탐지 기반으로 이상 로그 발생 시 Webhook을 통해 SSOM에 알림 전송
* **OpenSearch Anomaly Detection**: OpenSearch Anomaly Detection 기능을 통해서 에러 발생률 & 송금 요청률 이상 탐지 후 Slack에 알림 전송
<img width="50%" src="https://github.com/user-attachments/assets/7e1fe4dd-f81d-439f-a689-17c34bb54258" alt="이상 탐지"/>

<br/>
</details>

<details>
  <summary><b>[ 🚀 빠른 시작 ]</b> </summary>

## 🚀 빠른 시작

### 1. 사전 요구사항
- **Java 17** 이상
- **Docker & Docker Compose**
- **Gradle 8.x**

### 2. 로컬 개발 환경 설정

```bash
# 저장소 클론
git clone https://github.com/Team-SSOK/ssok-backend.git
cd ssok-backend

# 인프라 서비스 실행 (PostgreSQL, Redis, Kafka)
docker-compose up -d postgres redis kafka

# 전체 서비스 빌드
./gradlew build

# 개별 서비스 실행 (예: User Service)
./gradlew :ssok-user-service:bootRun
```

### 3. Docker Compose 실행

```bash
# 전체 서비스 실행
docker-compose up -d

# 특정 서비스만 실행
docker-compose up -d ssok-gateway-service ssok-user-service

# 로그 확인
docker-compose logs -f ssok-user-service
```

### 4. 개별 서비스 Docker 빌드

```bash
# 특정 서비스 빌드 (예: Account Service)
docker build -f ssok-account-service/Dockerfile -t ssok-account-service:latest .

# 이미지 실행
docker run -p 8080:8080 ssok-account-service:latest
```

### 5. 환경 변수
주요 환경 변수는 각 서비스의 README 문서에서 확인할 수 있습니다.

<br/>
</details>

<details>
  <summary><b>[ 📚 참고 자료 ]</b> </summary>

## 📚 참고 자료

### 관련 저장소
- **[ssok-deploy](https://github.com/Team-SSOK/ssok-deploy)**: Jenkins, Kubernetes, Helm 설정
- **[ssok-openbanking](https://github.com/Team-SSOK/ssok-openbanking)**: 외부 금융기관 시뮬레이터
- **[ssok-frontend](https://github.com/Team-SSOK/ssok-frontend)**: 모바일 애플리케이션

### 문서
- **API 명세서**: 각 서비스별 README 참조
- **배포 가이드**: ssok-deploy 저장소 참조

<br/>
</details>

<details>
  <summary><b>[ 🤝 기여하기 ]</b> </summary>

## 🤝 기여하기

1. **Fork** 저장소
2. **Feature Branch** 생성 (`git checkout -b feature/amazing-feature`)
3. **Commit** 변경사항 (`git commit -m 'Add some amazing feature'`)
4. **Push** 브랜치 (`git push origin feature/amazing-feature`)
5. **Pull Request** 생성

### 개발 가이드라인
- **코드 스타일**: Google Java Style Guide 준수
- **커밋 메시지**: Conventional Commits 형식 사용
- **테스트**: 새로운 기능에 대한 테스트 코드 필수
- **문서**: API 변경 시 README 업데이트 필수

</details>

---

<div align="center">
    <sub>Built with ❤️ by SSOK Backend Team</sub>
</div>
