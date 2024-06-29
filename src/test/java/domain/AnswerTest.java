package domain;

import infra.WordLoader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerTest {
    private final List<String> words = getWordList();
    Word answer = Word.createAnswer(LocalDate.of(2021, 6, 20), words);


    @ParameterizedTest
    @ValueSource(strings = {"serve"})
    @DisplayName("정답은 매일 바뀌며 ((현재 날짜 - 2021년 6월 19일) % 배열의 크기) 번째의 단어이다")
    void answerSelectTest(String input) {
        assertThat(answer).isEqualTo(new Word(input));
    }


    @ParameterizedTest
    @MethodSource("provideInputAnswer")
    @DisplayName("입력단어와 정답 비교")
    void matchTest(String input, List<HintLetter> hintLetters) {
        Word inputWord = Word.createInput(input, words);
        MatchResult matchResults = answer.match(inputWord);

        MatchResult expected = new MatchResult(hintLetters);
        assertThat(matchResults).isEqualTo(expected);
    }


    @ParameterizedTest
    @MethodSource("provideLocationAnswer")
    @DisplayName("입력단어와 중복 단어 위치 확인 테스트")
    void matchLocationTest(String input, List<HintLetter> hintLetters) {
        Word inputWord = Word.createInput(input, words);
        MatchResult matchResults = answer.match(inputWord);

        MatchResult expected = new MatchResult(hintLetters);
        assertThat(matchResults).isEqualTo(expected);
    }


    private static List<String> getWordList() {
        return WordLoader.read("src/test/resources/words.txt");
    }


    public static Stream<Object[]> provideInputAnswer() {
        return Stream.of(
                new Object[]{"serve", List.of(new HintLetter('s', Hint.CORRECT),
                        new HintLetter('e', Hint.CORRECT),
                        new HintLetter('r', Hint.CORRECT),
                        new HintLetter('v', Hint.CORRECT),
                        new HintLetter('e', Hint.CORRECT))},
                new Object[]{"sssss", List.of(new HintLetter('s', Hint.CORRECT),
                        new HintLetter('s', Hint.NOT_EXIST),
                        new HintLetter('s', Hint.NOT_EXIST),
                        new HintLetter('s', Hint.NOT_EXIST),
                        new HintLetter('s', Hint.NOT_EXIST))},
                new Object[]{"eeeee", List.of(new HintLetter('e', Hint.NOT_EXIST),
                        new HintLetter('e', Hint.CORRECT),
                        new HintLetter('e', Hint.NOT_EXIST),
                        new HintLetter('e', Hint.NOT_EXIST),
                        new HintLetter('e', Hint.CORRECT))},
                new Object[]{"grade", List.of(new HintLetter('g', Hint.NOT_EXIST),
                        new HintLetter('r', Hint.EXIST),
                        new HintLetter('a', Hint.NOT_EXIST),
                        new HintLetter('d', Hint.NOT_EXIST),
                        new HintLetter('e', Hint.CORRECT))}
        );
    }

    public static Stream<Object[]> provideLocationAnswer() {
        return Stream.of(
                new Object[]{"cigar", List.of(new HintLetter('c', Hint.NOT_EXIST),
                        new HintLetter('i', Hint.NOT_EXIST),
                        new HintLetter('g', Hint.NOT_EXIST),
                        new HintLetter('a', Hint.NOT_EXIST),
                        new HintLetter('r', Hint.EXIST))},
                new Object[]{"sissy", List.of(new HintLetter('s', Hint.CORRECT),
                        new HintLetter('i', Hint.NOT_EXIST),
                        new HintLetter('s', Hint.NOT_EXIST),
                        new HintLetter('s', Hint.NOT_EXIST),
                        new HintLetter('y', Hint.NOT_EXIST))},
                new Object[]{"naval", List.of(new HintLetter('n', Hint.NOT_EXIST),
                        new HintLetter('a', Hint.NOT_EXIST),
                        new HintLetter('v', Hint.EXIST),
                        new HintLetter('a', Hint.NOT_EXIST),
                        new HintLetter('l', Hint.NOT_EXIST))}
        );
    }
}
