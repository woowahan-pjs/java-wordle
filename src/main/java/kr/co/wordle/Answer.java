package kr.co.wordle;

public class Answer {

    private final String value;

    public Answer() {
        this.value = AnswerProvider.todayAnswer();
    }

    public char charAt(int index) {
        return value.charAt(index);
    }

    public boolean contains(char target) {
        return value.indexOf(target) > -1;
    }

    public int[] countPerCharacter() {
        int[] count = new int[26];
        for (char ch : value.toCharArray()) {
            count[ch - 'a']++;
        }
        return count;
    }
}
