package wordle.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TilesTest {

	@ParameterizedTest
	@MethodSource("parameterProvider")
	void 단어의_비교결과_타일_배열이_반환된다(String answerWord, String inputWord, TileStatus[] expectedTileStatus) {
		//given
		Word answer = Word.from(answerWord);

		// when
		Tiles matchResult = answer.calculateMatched(Word.from(inputWord));
		TileStatus[] matchResultStatus = matchResult.getStatus();

		// then
		assertThat(matchResultStatus).isEqualTo(expectedTileStatus);
	}

	private static Stream<Arguments> parameterProvider() {
		return Stream.of(
			Arguments.arguments("apple", "apple",
				new TileStatus[]{TileStatus.GREEN, TileStatus.GREEN, TileStatus.GREEN, TileStatus.GREEN,
					TileStatus.GREEN}),
			Arguments.arguments("apple", "world",
				new TileStatus[]{TileStatus.GRAY, TileStatus.GRAY, TileStatus.GRAY, TileStatus.GREEN, TileStatus.GRAY})
		);
	}

}
