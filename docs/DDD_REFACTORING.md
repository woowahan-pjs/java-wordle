# DDD 구조 리팩토링 완료

## 변경 사항

기존 Hexagonal Architecture에서 DDD(Domain-Driven Design) 구조로 리팩토링을 완료했습니다.

## 새로운 디렉토리 구조

```
src/main/java/wordle/
├── domain/                          # 도메인 계층 - 핵심 비즈니스 로직
│   ├── word/                       # Word 도메인
│   │   ├── Word.java              # Aggregate Root
│   │   ├── Answer.java            # Value Object
│   │   ├── AnswerSelector.java    # Domain Service
│   │   ├── WordRepository.java    # Repository Interface
│   │   └── WordCondition.java     # Domain Constants
│   ├── game/                       # Game 도메인
│   │   ├── Game.java              # Aggregate Root
│   │   ├── GameResult.java        # Value Object (Result → GameResult)
│   │   ├── GameInput.java         # Value Object (Input → GameInput)
│   │   └── validation/            # 검증 관련
│   │       ├── InputValidator.java
│   │       └── ValidationStatus.java
│   └── matching/                   # Matching 도메인 (정답 비교)
│       ├── AnswerComparator.java  # Domain Service
│       └── MatchResult.java       # Value Object (ResultValues → MatchResult)
├── application/                     # 애플리케이션 계층 - Use Case
│   ├── GameService.java           # Application Service (Client → GameService)
│   └── OutputPort.java            # Output Port Interface
└── infrastructure/                  # 인프라 계층 - 기술적 구현
    ├── App.java                   # Entry Point
    ├── persistence/               # 영속성
    │   └── FileWordRepository.java
    └── ui/                        # 사용자 인터페이스
        └── ConsoleUI.java         # (ConsoleOutputAdapter → ConsoleUI)
```

## 주요 변경 내용

### 1. 패키지 구조 변경
- **기존**: `application`, `domain`, `infrastructure` (기술 중심)
- **새로운**: `wordle.domain.{word, game, matching}` (도메인 중심)

### 2. 클래스 이름 변경
더 명확한 의미를 가진 이름으로 변경:
- `Input` → `GameInput`
- `Result` → `GameResult`
- `ResultValues` → `MatchResult`
- `Client` → `GameService`
- `ConsoleOutputAdapter` → `ConsoleUI`

### 3. 도메인별 그룹화
비즈니스 개념에 따라 클래스를 그룹화:
- **word**: 단어 관련 (Answer, Word, WordRepository, AnswerSelector)
- **game**: 게임 로직 (Game, GameInput, GameResult, validation)
- **matching**: 정답 비교 (AnswerComparator, MatchResult)

## DDD 구조의 장점

1. **직관성**: 패키지 이름만 봐도 무엇을 하는지 명확
2. **도메인 중심**: 비즈니스 로직이 기술적 세부사항과 분리
3. **확장성**: 새로운 도메인 추가 시 독립적으로 확장 가능
4. **응집도**: 관련된 클래스들이 같은 패키지에 모여 있음
5. **유지보수성**: 변경 시 영향 범위를 쉽게 파악 가능

## 빌드 및 테스트

모든 테스트가 정상적으로 통과했습니다:

```bash
./gradlew clean build
# BUILD SUCCESSFUL

./gradlew test
# All tests passed
```

## Migration Guide

기존 코드를 새 구조에서 사용하려면 다음과 같이 import를 변경:

```java
// 기존
import domain.model.Word;
import domain.model.Input;
import domain.model.Result;
import application.service.Client;

// 새로운 구조
import wordle.domain.word.Word;
import wordle.domain.game.GameInput;
import wordle.domain.game.GameResult;
import wordle.application.GameService;
```
