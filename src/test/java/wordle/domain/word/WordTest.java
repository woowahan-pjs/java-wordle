package wordle.domain.word;

import static org.junit.jupiter.api.Assertions.*;

import wordle.domain.game.GameInput;
import wordle.domain.game.GameResult;
import wordle.domain.game.validation.ValidationStatus;
import wordle.domain.matching.MatchResult;
import wordle.infrastructure.persistence.FileWordRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordTest {

    @Test
    void match() {
        // given
        WordRepository wordRepository = new FileWordRepository();
        GameResult result = new GameResult();
        Answer answer = new Answer("AIRPO");
        GameInput input = new GameInput("AIRPO");
        Word word = new Word(answer, wordRepository);
        // when
        MatchResult[] results = word.match(input);
        result.addBoard(results);
        // then
        Assertions.assertEquals("🟩🟩🟩🟩🟩", result.getLastBoard());
    }

    @Test
    void 기본_판정_로직_완전_일치() {
        WordRepository wordRepository = new FileWordRepository();
        GameResult result = new GameResult();
        Answer answer = new Answer("apple");
        GameInput input = new GameInput(answer.value());
        Word word = new Word(answer, wordRepository);

        MatchResult[] results = word.match(input);
        result.addBoard(results);

        Assertions.assertEquals("🟩🟩🟩🟩🟩", result.getLastBoard());
    }

    @Test
    void 기본_판정_로직_완전_불일치() {
        // given
        WordRepository wordRepository = new FileWordRepository();
        GameResult result = new GameResult();
        Answer answer = new Answer("APPLE");
        GameInput input = new GameInput("BVSKI");
        Word word = new Word(answer, wordRepository);
        // when
        MatchResult[] results = word.match(input);
        result.addBoard(results);
        // then
        Assertions.assertEquals("⬜⬜⬜⬜⬜", result.getLastBoard());
    }

    @Test
    void 중복판정_성공() {
        // given
        WordRepository wordRepository = new FileWordRepository();
        GameResult result = new GameResult();
        Answer answer = new Answer("APPLE");
        GameInput input = new GameInput("AAABB");
        Word word = new Word(answer, wordRepository);
        // when
        MatchResult[] resultArray = word.match(input);
        result.addBoard(resultArray);
        // then
        Assertions.assertEquals("🟩⬜⬜⬜⬜", result.getLastBoard());
    }

    @Test
    void valid_정상_입력() {
        WordRepository wordRepository = new FileWordRepository();
        GameResult result = new GameResult();
        Answer answer = new Answer("apple");
        GameInput input = new GameInput("apple");
        Word word = new Word(answer, wordRepository);

        Assertions.assertEquals(ValidationStatus.VALID, word.check(input));
    }

    @Test
    void valid_null_입력() {
        WordRepository wordRepository = new FileWordRepository();
        GameResult result = new GameResult();
        Answer answer = new Answer("apple");
        GameInput input = new GameInput(null);
        Word word = new Word(answer, wordRepository);

        Assertions.assertEquals(ValidationStatus.NULL_INPUT, word.check(input));
    }

    @Test
    void valid_길이_불일치() {
        WordRepository wordRepository = new FileWordRepository();
        GameResult result = new GameResult();
        Answer answer = new Answer("apple");
        GameInput input = new GameInput("a");
        Word word = new Word(answer, wordRepository);

        Assertions.assertEquals(ValidationStatus.INVALID_LENGTH, word.check(input));
    }

    @Test
    void valid_알파벳_외_문자() {
        WordRepository wordRepository = new FileWordRepository();
        GameResult result = new GameResult();
        Answer answer = new Answer("apple");
        GameInput input = new GameInput("appl1");
        Word word = new Word(answer, wordRepository);

        Assertions.assertEquals(ValidationStatus.NOT_ALPHABET, word.check(input));
    }

    @Test
    void valid_사전_없음() {
        WordRepository wordRepository = new FileWordRepository();
        GameResult result = new GameResult();
        Answer answer = new Answer("apple");
        GameInput input = new GameInput("zzzzz");
        Word word = new Word(answer, wordRepository);

        Assertions.assertEquals(ValidationStatus.NOT_IN_DICTIONARY, word.check(input));
    }

}
