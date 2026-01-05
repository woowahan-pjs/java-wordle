# 미션 - 워들
- 참여자 : 우지, 구월

## 시퀀스 다이어그램
```mermaid
sequenceDiagram
actor User
participant OutputView
participant InputView
participant Game
Note right of Game: 게임 시작

Game ->> OutputView: User 에게 환영 문구를 보여줘라
OutputView ->> User: WORDLE을 6번 만에 맞춰 보세요.<br>시도의 결과는 타일의 색 변화로 나타납니다.
Game ->> WordListReader: 사전 요청
WordListReader ->> Game: 사전 응답
Game ->> WordList: 정답 요청
WordList ->> Game: 정답 응답
loop 게임시작 6라운드
loop 단어 검증
Game ->> OutputView: 정답 입력 문구를 보여줘라
OutputView ->> User: 정답을 입력해 주세요.
User ->> InputView: 예상 단어 입력
InputView->>Game: 예상 단어 입력
activate Game
Game->>WordList: 단어 확인
WordList->>Game: 단어 확인 결과  
alt is 잘못된 단어
Game ->> OutputView: 잘못된 단어라고 알려줘라
OutputView ->> User: 잘못된 단어를 입력하셨습니다.
else is 올바른 단어
end
end
Game ->> Word: 정답인지 확인해라
Word ->> Answer: 체점해줘
Answer ->> Word: 체점완료
Word ->> Game: 정답 결과 반환
Game ->> Results: 정답인가?
Results ->> Game: 정답여부 반환

	break when Results 가 정답일 경우 
      Game ->> OutputView: 결과를 화면에 나타내라
			OutputView ->> User: 4/6<br> [1][1][1][1][1][1]
			Note right of Game: 게임 종료
end
Game ->> Results: 기회를 다 사용했는가?
Results ->> Game: 기회 사용 여부 반환
break when 기회를 다 사용했다면
Game ->> OutputView: 결과를 화면에 나타내라
OutputView ->> User: 6/6<br> [1][1][1][1][1][0]
Note right of Game: 게임 종료
end
deactivate Game
end
```

---

## 클래스 설계

### view

```mermaid
classDiagram
	class Game {
		start()
	}
	class InputView {
		Scanner scanner
		Word inputWord()
	}
	class OutputView {
		void welcome()
		void insertWord()
		void wrongWord()
		void showResults(Results results)
	}
	class enum ResultColor {
		String color // 🟩, 🟨, ⬜
		ResultType type
		
		String color(ResultType type)
	}
```

### Word

```mermaid
classDiagram
	Answer -- WordSelector
	class Word {
		List<Alphabet> alphabets
	}
	Word -- Alphabet
	class Alphabet {
		
	}
	Word <|-- Answer
	class Answer {
		Word word
		Result examineResult(Guess guess)
	}
	class EpochDayBaseAnswerSelector {
		Word select()
	}
	class WordSelector {
		Word select()	
	}
	WordSelector <|-- EpochDayBaseAnswerSelector
	
	Word <|-- Guess
	class Guess {
		Word word
	}
	
	class WordList {
		Word find(Word word)
		Word select(Selector selector)
	}
	
	class WordListReader {
		WordList read()
	}
	class WordListFileReader {
		WordList read()	
	}
	WordListReader <|-- WordListFileReader
	WordList -- WordListReader
```

### Result

```mermaid
classDiagram
	class Result {
		List<ResultType> resultTypes
		boolean allMatched()
	}
	
	class Results {
		List<Result> resultList
		boolean hasAnswer()
	}
	
	class enum ResultType {
		char type // MATCHED, EXIST, MISMATCHED
	}
```
---

## 테스트케이스

- Game
    - [x]  게임은 지정된 횟수만큼 입력받고 종료된다.
- Word
    - [x]  단어에 알파벳 소문자가 아닌 문자가 들어오면 예외를 반환한다.
    - [x]  단어는 5글자이다.
    - [x]  단어가 5글자가 아니면 예외를 반환한다.
- Answer
    - [x]  정답은 답안을 기반으로 결과를 반환할 수 있다.
- AnswerSelector
    - [x]  정답은 매일 바뀌며 `((현재 날짜 - 2021년 6월 19일) % 배열의 크기)` 번째의 단어이다.
- WordList
    - [x]  주어진 단어가 WordList 안에 있으면 true를 반환한다.
    - [x]  주어진 단어가 WordList 안에 없으면 false를 반환한다.
    - [x]  주어진 Selector의 조건에 해당하는 단어를 추출한다.
- Result
    - [x]  판별 결과는 세 가지 색(초록색/노란색/회색) 중 하나로 표현되어야 한다.
- Results
    - [x]  정답을 포함하고 있는 경우 true를 반환한다.
    - [x]  정답을 포함하고 있지 않은 경우 false를 반환한다.
