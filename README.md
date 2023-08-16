# 원티드 프리온보딩 백엔드 인턴십 - 선발 과제


1. 과제 안내

과제 안내
* 본 과제는 원티드 프리온보딩 백엔드 인턴십 과정 이수를 위한 최소한의 수준을 파악하고, 교육생 선별을 목적으로 합니다.
* 교육생은 Python/Flask, Python/Django, JavaScript/Express, Java/Spring Boot 중 기술 스택을 선택하여, 게시판을 관리하는 RESTful API를 개발하고 그 결과를 제출해야 합니다. (3. API 요구사항 참고)
* 데이터 저장소로는 MySQL 8.0 버전의 관계형데이터베이스를 사용해주세요.
* API의 정상 동작 여부, 작성된 코드의 품질, Git & Github의 사용 수준 등이 평가 기준이 됩니다.
* 요구사항에 맞게 API를 만든 후에 아래의 기능을 추가할 경우 가산점이 주어집니다.
    * 통합 테스트 또는 단위 테스트 코드를 추가한 경우
    * docker compose를 이용하여 애플리케이션 환경을 구성한 경우 (README.md 파일에 docker-compose 실행 방법 반드시 기입)
    * 클라우드 환경(AWS, GCP)에 배포 환경을 설계하고 애플리케이션을 배포한 경우 (README.md 파일에 배포된 API 주소와 설계한 AWS 환경 그림으로 첨부)
* 진행 중 발생하는 문의사항은 이 레포지토리의 Issue로 등록해주세요.

과제 제출 필수 사항
* 과제의 소스코드는 반드시 본인의 GitHub 레포지토리에 Public으로 설정하여 업로드 해주세요.
* 레파지토리의 이름은 wanted-pre-onboarding-backend로 지정해야 합니다.
* README.md 파일에는 다음과 같은 사항들이 포함되어야 합니다:
    * 지원자의 성명
    * 애플리케이션의 실행 방법 (엔드포인트 호출 방법 포함)
    * 데이터베이스 테이블 구조
    * 구현한 API의 동작을 촬영한 데모 영상 링크
    * 구현 방법 및 이유에 대한 간략한 설명
    * API 명세(request/response 포함)
* 과제 제출은 참가 신청 시 수행한 과제의 레포지토리 주소를 제출하면 됩니다.
 

2. 주의 사항
* 제출한 링크가 잘못되었거나, 레파지토리에 접근할 수 없는 경우에는 탈락 처리됩니다.
* “과제 제출 필수 사항”을 준수하지 않을 경우에도 탈락 처리됩니다.
* 레파지토리에 접속했을 때 바로 소스코드가 보일 수 있도록 해주세요. 불필요한 depth는 허용되지 않습니다.
* 과제 제출 후에는 코드 변경을 지양해주시고, 평가와 무관하게 수정을 하고 싶을 경우 default branch(master or main)가 아닌 별도의 브랜치에서 작업해주세요.
 

3. API 요구 사항
                                                                                                        게시판을 관리하는 RESTful API를 개발해 주세요. 이때, 다음의 기능을 구현해야 합니다. 데이터베이스의 테이블 설계는 지원자분의 판단에 맡겨져 있습니다. 요구사항을 충족시키는 데 필요하다고 생각되는 구조로 자유롭게 설계해 주세요.
* 과제 1. 사용자 회원가입 엔드포인트
    * 이메일과 비밀번호로 회원가입할 수 있는 엔드포인트를 구현해 주세요.
    * 이메일과 비밀번호에 대한 유효성 검사를 구현해 주세요.
        * 이메일 조건: @ 포함
        * 비밀번호 조건: 8자 이상
        * 비밀번호는 반드시 암호화하여 저장해 주세요.
        * 이메일과 비밀번호의 유효성 검사는 위의 조건만으로 진행해 주세요. 추가적인 유효성 검사 조건은 포함하지 마세요.
* 과제 2. 사용자 로그인 엔드포인트
    * 사용자가 올바른 이메일과 비밀번호를 제공하면, 사용자 인증을 거친 후에 JWT(JSON Web Token)를 생성하여 사용자에게 반환하도록 해주세요.
    * 과제 1과 마찬가지로 회원가입 엔드포인트에 이메일과 비밀번호의 유효성 검사기능을 구현해주세요.
* 과제 3. 새로운 게시글을 생성하는 엔드포인트
* 과제 4. 게시글 목록을 조회하는 엔드포인트
    * 반드시 Pagination 기능을 구현해 주세요.
* 과제 5. 특정 게시글을 조회하는 엔드포인트
    * 게시글의 ID를 받아 해당 게시글을 조회하는 엔드포인트를 구현해 주세요.
* 과제 6. 특정 게시글을 수정하는 엔드포인트
    * 게시글의 ID와 수정 내용을 받아 해당 게시글을 수정하는 엔드포인트를 구현해 주세요.
    * 게시글을 수정할 수 있는 사용자는 게시글 작성자만이어야 합니다.
* 과제 7. 특정 게시글을 삭제하는 엔드포인트
    * 게시글의 ID를 받아 해당 게시글을 삭제하는 엔드포인트를 구현해 주세요.
    * 게시글을 삭제할 수 있는 사용자는 게시글 작성자만이어야 합니다.

## 과제 제출 필수사항

### 지원자 성명 : 권형택

### 애플리케이션 실행방법
1. ```git clone - https://github.com/naht94/wanted-pre-onboarding-backend.git```
 
2. ```/src/main/resources``` 경로에 application.properties 파일 생성

```properties
jwt.secret=VlwEyVBsYt9V7zq57TejMnVUyzblYcfPQye08f7MGVA9XkHa
jwt.accessTokenExpires=86400000
jwt.refreshTokenExpires=86400000

server.port=9090
spring.profiles.active=prod
spring.jpa.open-in-view=false
```

3. ```/src/main/resources``` 경로에 application-prod.properties 파일 생성
```properties
spring.jpa.generate-ddl=true
spring.jpa.show-sql=true

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://andb.cyfnanmsxs7l.us-east-2.rds.amazonaws.com:3306/userboard

spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl

spring.datasource.username=root
spring.datasource.password=anima-01
```
4. 우상단 ```MAVEN``` 클릭 ```projrct명``` 클릭 ```package``` 실행
5. 실행 되지 않을 경우 ```Build``` ```Rebuild Project``` 후 4번과정 반복
6. 빌드 결과물은 ```target```폴더 내에 .jar파일로 작성됨.
7. ```java -jar [파일명].jar```명령어로 서버실행.
8. 사용가능한 엔드포인트 등은 아래에 후술될 것임.
9. ex) test 가능한 request등을 http 폴더 내에 작성해둠.

### 데이터베이스 테이블 구조
![스크린샷 2023-08-16 오후 7 08 53](https://github.com/naht94/wanted-pre-onboarding-backend/assets/126442625/d747c010-a931-4889-8212-63418b537679)
### [구현한 API의 동작을 촬영한 데모 영상 링크](https://youtu.be/L8Lx65mfXXw)

### 구현 방법 및 이유에 대한 간략한 설명

#### 컨트롤러
 - 객체로 요청, 응답 처리. Vaild와 dto를 이용해서 requestbody의 데이터를 검증하도록 함.
#### 레포지토리
 - 작성일과 수정일을 데이터로 가질 수 있는 테이블에 상속을 이용해서 데이터를 가질 수 있도록 함.
#### 서비스
 - crud외에 로직처리를 할 부분을 서비스클래스를 만들어 처리
#### 예외
 - restcontrolleradvice를 이용해서 예외가 발생하면 오류발생 메세지를 전송하도록 만들어줌.
 - enum을 이용해 코드별로 메세지를 전송할 수 있도록 작성.
----
#### 인증 인가
 - 스프링 부트 security를 이용해 jwt 토큰을 받을 수 있도록 함.
 - OncePerRequestFilter 이용해 요청마다 토큰을 확인해 없다면 거를 수 있도록 만듬.
#### 페이징
 - 조인 연산을 줄이기 위해 writer_email 역정규화.
### API 명세

#### 회원가입
```bash
curl -X POST -H "Content-Type: application/json" 'http://localhost:9090/api/auth/sign-up' \

-d '{
"email": "naht94@lol.com",
"pwd": "12345678"
}'
```
#### 로그인
```bash
curl -X POST -H "Content-Type: application/json" 'http://localhost:9090/api/auth/login' \

-d '{
"email": "naht94@lol.com",
"pwd": "12345678"
}'
```
#### 유저 확인
```bash
curl --location 'http://localhost:9090/api/users/1'
```
#### 게시글 작성
```bash
curl -X POST -H "Content-Type: application/json" 'http://localhost:9090/api/posts' \
-H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuYWh0OTRAbG9sLmNvbSIsImF1dGgiOiJST0xFX1VTRVIiLCJleHAiOjE2OTIyNjI0OTZ9.8JT2g_BSmVSBT6prQ9mUXARgR1IyW5G0eRx9xTv7h8I'

-d '{
"title":"제목3",
"contents":"작성글4"
}'
```
#### 게시글 조회
```bash
curl --location 'http://localhost:9090/api/posts/1'
```
#### 게시글 조회 페이지
```bash
curl --location 'http://localhost:9090/api/posts?page=0'
```
#### 게시글 수정
```bash
curl -X PUT -H "Content-Type: application/json" 'http://localhost:9090/api/posts/1' \
-H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuYWh0OTRAbG9sLmNvbSIsImF1dGgiOiJST0xFX1VTRVIiLCJleHAiOjE2OTIyNjI0OTZ9.8JT2g_BSmVSBT6prQ9mUXARgR1IyW5G0eRx9xTv7h8I'

-d '{
"title":"제목2",
"contents":"작성글2"
}'
```
#### 게시글 삭제
```bash
curl -X DELETE -H "Content-Type: application/json" 'http://localhost:9090/api/posts/1' \
-H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuYWh0OTRAbG9sLmNvbSIsImF1dGgiOiJST0xFX1VTRVIiLCJleHAiOjE2OTIyNjI0OTZ9.8JT2g_BSmVSBT6prQ9mUXARgR1IyW5G0eRx9xTv7h8I'
```