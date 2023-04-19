package domain;

public class Round {

	private static final int MAX_ROUND = 6;

	private int value;

	public Round() {
		this.value = 0;
	}

	public void next() {
		if (isMaxRound()) {
			throw new IllegalArgumentException("더 이상 라운드를 진행할 수 없습니다.");
		}
		value++;
	}

	public boolean isMaxRound() {
		return value == MAX_ROUND;
	}

	public int getValue() {
		return value;
	}
}
