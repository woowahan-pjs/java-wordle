package kr.co.wordle;

public class Answer {

    private final String value;
    private final int[] countPerCharacter = new int[26];

    public Answer() {
        this.value = AnswerProvider.todayAnswer();
        countPerCharacter();
    }

    protected Answer(String value) {
        this.value = value;
        countPerCharacter();
    }

    private void countPerCharacter() {
        for (char ch : value.toCharArray()) {
            countPerCharacter[ch - 'a']++;
        }
    }

    public int[] getCountPerCharacter() {
        return countPerCharacter;
    }

    public char charAt(int index) {
        return value.charAt(index);
    }

}
