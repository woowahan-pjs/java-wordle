package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("결과 목록 테스트")
class ResultsTest {

	@DisplayName("결과 목록 생성 테스트")
	@Test
	void createResultsTest() {
		assertThatCode(Results::new)
			.doesNotThrowAnyException();
	}

	@DisplayName("처음 생성된 결과 목록은 결과가 들어있지 않다.")
	@Test
	void emptyWhenCreatedTest() {
		Results results = new Results();
		assertThat(results.size()).isZero();
	}

	@DisplayName("결과 목록에 결과를 추가할 수 있다")
	@Test
	void addResultTest() {
		// given
		Results results = new Results();
		List<MatchStatus> greenStatuses = List.of(
			MatchStatus.GREEN,
			MatchStatus.GREEN,
			MatchStatus.GREEN,
			MatchStatus.GREEN,
			MatchStatus.GREEN
		);
		Result greenResult = new Result(greenStatuses);

		List<MatchStatus> yellowStatuses = List.of(
			MatchStatus.YELLOW,
			MatchStatus.YELLOW,
			MatchStatus.YELLOW,
			MatchStatus.YELLOW,
			MatchStatus.YELLOW
		);
		Result yellowResult = new Result(yellowStatuses);

		// when
		results.add(greenResult);
		results.add(yellowResult);

		// then
		assertThat(results.size()).isEqualTo(2);
	}

	@DisplayName("result의 상태가 모두 green 일 경우 hasCorrect true 반환")
	@Test
	void returnTrueWhenResultHasAllGreenTest() {
		// given
		Results results = new Results();
		List<MatchStatus> greenStatuses = List.of(
			MatchStatus.GREEN,
			MatchStatus.GREEN,
			MatchStatus.GREEN,
			MatchStatus.GREEN,
			MatchStatus.GREEN
		);
		Result greenResult = new Result(greenStatuses);

		// when
		results.add(greenResult);

		// then
		assertThat(results.hasCorrect()).isTrue();
	}

	@DisplayName("result의 상태가 모두 green 이 아닐 경우 hasCorrect false 반환")
	@ParameterizedTest
	@MethodSource
	void returnFalseWhenResultHasNotGreenTest(Result result) {
		Results results = new Results();

		// when
		results.add(result);

		// then
		assertThat(results.hasCorrect()).isFalse();
	}

	private static Stream<Arguments> returnFalseWhenResultHasNotGreenTest() {
		return Stream.of(
			Arguments.of(new Result(List.of(
				MatchStatus.YELLOW,
				MatchStatus.GREEN,
				MatchStatus.GREEN,
				MatchStatus.GREEN,
				MatchStatus.GREEN
			))),
			Arguments.of(new Result(List.of(
				MatchStatus.YELLOW,
				MatchStatus.YELLOW,
				MatchStatus.YELLOW,
				MatchStatus.YELLOW,
				MatchStatus.YELLOW
			))),
			Arguments.of(new Result(List.of(
				MatchStatus.GRAY,
				MatchStatus.GRAY,
				MatchStatus.GRAY,
				MatchStatus.GRAY,
				MatchStatus.GREEN
			))),
			Arguments.of(new Result(List.of(
				MatchStatus.GRAY,
				MatchStatus.GREEN,
				MatchStatus.GREEN,
				MatchStatus.GREEN,
				MatchStatus.GREEN
			))));
	}

}
