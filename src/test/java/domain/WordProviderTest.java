package domain;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WordProviderTest {

    @Test
    @DisplayName("파일이 있으면 파일 로드 성공")
    void test() {
        WordProvider wordProvider = new WordProvider("src/test/resources/test10words.txt", LocalDate.now());
        wordProvider.getWordList("src/test/resources/test10words.txt");
    }

    @Test
    @DisplayName("파일이 없으면 IllegalArgumentException throw")
    void fileNotFoundTest() {
        WordProvider wordProvider = new WordProvider("src/test/resources/test10words.txt",LocalDate.now());
        assertThatThrownBy(()->wordProvider.getWordList("/asfas.txt"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("파일 변환중에 err가 발생하였습니다.");

    }

    @Test
    @DisplayName("테스트 파일의 단어 갯수 테스트")
    void get10WordsTest() {
        WordProvider wordProvider = new WordProvider("src/test/resources/test10words.txt",LocalDate.now());
        List<String> words = wordProvider.getWordList("src/test/resources/test10words.txt");
        assertThat(words.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("테스트 파일 공백 테스트")
    void getEmptyWordsTest() {
        WordProvider wordProvider = new WordProvider("src/test/resources/test10words.txt",LocalDate.now());
        assertThatThrownBy(()->wordProvider.getWordList("src/test/resources/testEmptyWords.txt"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("파일이 비어있습니다.");
    }

    @Test
    @DisplayName("현재날짜 - 2021년 6월 19일 % 배열의 크기 번재 단어를 정답으로 생성하는 테스트")
    void getAnswerByCriteriaDateTest() {
        LocalDate today = LocalDate.of(2021, 6, 29);
        WordProvider wordProvider = new WordProvider("src/test/resources/test10words.txt",today);
        String answer = wordProvider.getAnswer(today);
        assertThat(answer).isEqualTo("cigar");
    }
}
