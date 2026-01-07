# 미션 - 워들

### 구현 목록
- 단어 불러오기
- 매일 바뀌는 정답단어 선택
- 단어 입력
    - 입력시 단어목록에 있나 검증
- 비교 로직
    - 같을때, 있을떄, 없을때 따른 비교결과
- 게임로직
    - 6회 초과시 게임오버
    - 정답시 게임클리어
- ui
    - 비교 결과, 라운드 출력

### 리팩터링 포인트
- [x] final 붙혀주기
- [x] Inputword 에 availableWords 상태로 가지고 있을 필요는 없다.  
- [x] InputWord와 Answer를 합치기?  
- [x] match 에 for 문안 함수로 발라내기  
- [x] isEndGame 플래그 변수 네이밍 변경
- [x] 검증
  - [x] 5글자 검증  
  - [x] 영단어 검증
- [x] 예외 try catch  
- [x] GameManager에 있는 List<MatchResults> 의 변수명 변경  
- [x] HintView에 3depth 줄이기  
- [x] InputWord의 마지막 테스트함수 이름  
- [x] MatchResult에 inputChar가 쓰이지 않고 있어서 클래스 자체를 지우고 그냥 Hint만 쓰기
- ~~[ ] 구조 변경~~
  - ~~[ ] GameManager의 의존성 줄여두기~~  
  - ~~[ ] String 말고 char 배열로 쓸지?  -> 좀 더 고민해보기~~
  - ~~[ ] 분리된 view 부분 합칠지?~~ 

