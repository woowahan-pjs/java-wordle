# 기능 설명 

### controller
1. GameHost
- Service Layer을 통해 게임의 흐름을 통제한다 

### service
1. InputManager
- 사용자의 입력을 Word 객체로 전달 받는다
2. ViewManger
- 사용자에게 출력하는 모든 로직을 담당한다
3. WordsGenerator 
- 날짜에 따라 오늘의 정답 단어를 AnswerWord로 추출한다

### domain
1. Word
- 입력받은 단어에 대해 저장 및 검증
2. AnswerWord
- Word를 상속받아, 다른 Word와의 비교 결과를 산출
3. Result
- 사용자의 입력 하나에 대한 게임 결과를 저장
4. TileColor
- Enum으로써, TileColor 별 표시 할 데이터를 저장
5. Coin 
- 문자 입력 가능 횟수를 의미
- 최초 코인 개수를 통해 생성
- 문자 입력시 코인 개수 감소
- 코인이 남아있는지 여부 확인

### utils
1. FileUtils
- 파일 경로를 받아 Stream<String>을 반환
2. LocalDateTimeUtils
- 입력받은 2개의 날짜 차이를 반환
3. StringUtils
- 입력받은 문자에 대해 5개의 소문자로 구성된 문자인지 검증