# RestTest

- new - spring legacy project - spring mvc project
- project name: `RestTest`
- root package: `com.test.Rest`

---

#### 자바 버전과 pom.xml 수정

- 프로젝트 우클릭 -> Project Facets -> Java 11
- properties 태그에 있는 java-version 11
- 그 아래 스프링 버전 5.0.7.RELEASE로
- 맨 아래쪽 plugin 태그 -> maven plugin 내부
  - configuration 태그 내부 source, target 내부 11로 변경

---
### Rest, Representational State Transfer
- 웹 상의 자원(문서, 이미지, 동영상, 데이터 등)의 위치를 자원명으로 표시해서 자원의 상태를 주고 받기 위한 행동 + 표현법
- __웹 상의 자원을 URI 자체로도 식별 가능하게 URI을 만들자(***)__
- 표준안이 없다.
- REST API or RESTful API

<!-- ---

#### 파일, 패키지

##### src/main/java - Controller
- com.test.aop.controller
  - `MemoController.java`
- com.test.aop.service
  - `MemoService.java`
- com.test.aop.aspect
  - `Logger.java`

##### src/main/webapp - View
- WEB-INF/views
  - `list.jsp`
  - `add.jsp`
  - `view.jsp` -->