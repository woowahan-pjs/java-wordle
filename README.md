# 페어프로그래밍 진행

## 페어프로그래밍 결과물

### 기능 목록
- Word
  - [x] 하나의 알파벳만 입력이 가능하며, 입력이 오면 소문자로 변경한다.
  - [x] 알파벳이 아닌 입력이 오면 IllegalArgumentException 에러를 더진다.
- Words
  - [x] 5개의 Word로 구성된다.
  - [x] 5개의 Word가 아닌 경우 IllegalArgumentException 에러를 더진다.
- WordsBucket
  - [x] words.txt에서 Words들을 읽어온다.
  - [x] words.txt가 없을 경우 IllegalArgumentException 에러를 던진다.
  - [x] ((현재 날짜 - 2021년 6월 19일) % 배열의 크기) 번째의 단어를 Answer로 결정한다. 
- Answer
  - [x] 사용자가 제출한 Words와 비교하여 WordsMatchResult를 반환한다.
- MatchStatus
  - [x] Green, Yellow, Grey 색만을 갖는다.
- MatchResult
  - [x] 정답을 맞췄는지 확인한다.
- MatchResults
  - [x] 여러 개의 MatchResult를 관리한다.

### 프로그래밍 목표
- TDD로 개발할 것
- 우테캠Pro RacingCar2의 프로그래밍 요구사항을 모두 만족할 것
- Status 비교 로직 갈끔하게 구현해보기
- 인수 테스트까지 작성

### 코딩 스타일
- final
- 테스트 이름은 한글로
- 불필요한 @Data 메소드들 최소화

### Glossary
| 단어 | 설명 |
| --- | --- |
| Word | 하나의 알파벳 |
| Words | 하나의 단어 |
| WordsBucket | 단어 모음집 |
| Answer | 정답인 단어 |
| MatchStatus | 노랑, 초록, 회색 여부  |
| MatchResult | Words 매치 결과(회, 노, 노, 초, 초) |
| MatchResults | MatchResults에 대한 집합 |


## 페어프로그래밍 히스토리

### 4회차(Solo)
#### 진행 일정 및 목표
- 일시: 05/01
- 목표: 페어 이후 개인 리팩토링
  - Game과 출력하는 View단을 분리함
  - 주어진 프로그래밍 규칙에 어긋나는 부분 수정(3항 연산자)
  - 매직 넘버 제거 및 값 반환 시에 방어적 복사 처리
  - isCorrect 로직 수정
  - 주어진 요구사항에 맞게 출력하도록 변경

### 3회차
#### 진행 일정 및 목표
- 일시: 04/28
- 목표: 도메인이 아닌 게임 자체에 대한 구현
  - Game
  - Input, Output

### 2회차
#### 진행 일정 및 목표
- 일시: 04/23 20:00 ~ 13:00
- 목표: 도메인에 대한 기능 목록 구현
  - WordsBucket
  - Answer
  - MatchStatus
  - WordsMatchResult


#### 진행 결과

### 1회차
#### 진행 일정 및 목표 
- 일시: 4/23 13:00 ~ 16:00
- 목표
  - 코딩 스타일 크로스 체크(서로의 프리코스 코드 검토)
  - 기술 싱크(서로가 가진 기술 정보를 맞춤)
  - 프로그래밍 목표 설정 ex) TDD로 개발, 프로그래밍 요구사항 등
  - 간단한 설계로 유비쿼터스 언어 작성(Glossary 도출)
  - 기능목록 도출
  - 공통 코딩 스타일 협의
  
#### 진행 결과
- 코딩 스타일 크로스 체크(서로의 프리코프 코드 검토)
  - MangKyu
    - final을 항상 붙여줌
  - Yang
    - data 클래스용 메소드를 자주 만듬
- 기술 싱크(서로가 가진 기술 정보를 맞춤)
  - Java11에 익숙하지 않으므로 회고 프로세스에서 Java11 문법 검토
- 프로그래밍 목표 설정 ex) TDD로 개발, 프로그래밍 요구사항 등
  - TDD로 개발할 것
  - 우테캠Pro RacingCar2의 프로그래밍 요구사항을 모두 만족할 것
  - 인수 테스트까지 작성
  - Status 비교 로직 갈끔하게 구현해보기
- 간단한 설계로 Glossary 도출
- 기능 목록 도출
- 공통 코딩 스타일 협의
  - final 붙여주기



# 미션 - 워들

## 🔍 진행 방식

- 미션은 **과제 진행 요구 사항**, **기능 요구 사항**, **프로그래밍 요구 사항** 세 가지로 구성되어 있다.
- 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.
- **기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.**

---

## 🚀 기능 요구 사항

선풍적인 인기를 끌었던 영어 단어 맞추기 게임이다.

- 6x5 격자를 통해서 5글자 단어를 6번 만에 추측한다.
- 플레이어가 답안을 제출하면 프로그램이 정답과 제출된 단어의 각 알파벳 종류와 위치를 비교해 판별한다.
- 판별 결과는 흰색의 타일이 세 가지 색(초록색/노란색/회색) 중 하나로 바뀌면서 표현된다.
    - 맞는 글자는 초록색, 위치가 틀리면 노란색, 없으면 회색
    - 두 개의 동일한 문자를 입력하고 그중 하나가 회색으로 표시되면 해당 문자 중 하나만 최종 단어에 나타난다.
- 정답과 답안은 `words.txt`에 존재하는 단어여야 한다.
- 정답은 매일 바뀌며 ((현재 날짜 - 2021년 6월 19일) % 배열의 크기) 번째의 단어이다.

### 입출력 요구 사항

#### 실행 결과 예시

```
WORDLE을 6번 만에 맞춰 보세요.
시도의 결과는 타일의 색 변화로 나타납니다.
정답을 입력해 주세요.
hello

⬜⬜🟨🟩⬜

정답을 입력해 주세요.
label

⬜⬜🟨🟩⬜
🟨⬜⬜⬜🟩

정답을 입력해 주세요.
spell

⬜⬜🟨🟩⬜
🟨⬜⬜⬜🟩
🟩🟩⬜🟩🟩

정답을 입력해 주세요.
spill

4/6

⬜⬜🟨🟩⬜
🟨⬜⬜⬜🟩
🟩🟩⬜🟩🟩
🟩🟩🟩🟩🟩
```

---

## 🎯 프로그래밍 요구 사항

- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일은 변경할 수 없으며, **제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)를 원칙으로 한다.
    - 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
        - [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide)
        - [AssertJ User Guide](https://assertj.github.io/doc)
        - [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
        - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
    - 힌트: MVC 패턴 기반으로 구현한 후, View와 Controller를 제외한 Model에 대한 단위 테스트 추가에 집중한다.
