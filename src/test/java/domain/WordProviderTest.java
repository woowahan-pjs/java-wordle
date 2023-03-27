package domain;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WordProviderTest {

	@Test
	@DisplayName("파일이 있으면 파일 로드 성공")
	void test() {
		assertThatCode(() -> new WordProvider("src/test/resources/test10words.txt", LocalDate.now()))
			.doesNotThrowAnyException();
	}

	@Test
	@DisplayName("파일이 없으면 IllegalArgumentException throw")
	void fileNotFoundTest() {
		LocalDate now = LocalDate.now();
		assertThatThrownBy(() -> new WordProvider("src/test/resources/noFile.txt", now))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("파일 변환중에 err가 발생하였습니다.");

	}

	@Test
	@DisplayName("테스트 파일 공백 테스트")
	void getEmptyWordsTest() {
		LocalDate now = LocalDate.now();
		assertThatThrownBy(() -> new WordProvider("src/test/resources/testEmptyWords.txt", now))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("파일이 비어있습니다.");
	}

	@Test
	@DisplayName("현재날짜 - 2021년 6월 19일 % 배열의 크기 번재 단어를 정답으로 생성하는 테스트")
	void getAnswerByCriteriaDateTest() {
		LocalDate today = LocalDate.of(2021, 6, 29);
		WordProvider wordProvider = new WordProvider("src/test/resources/test10words.txt", today);
		String answer = wordProvider.getAnswer(today);
		assertThat(answer).isEqualTo("cigar");
	}
}
