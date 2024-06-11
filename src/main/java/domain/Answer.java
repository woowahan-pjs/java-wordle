package domain;

public class Answer {
    private String value;

    public Answer(String value) {
        this.value = value;
    }

    Boolean exists(char inputChar) {
        return true;
    }

    Boolean isCorrect(int index, char inputChar) {
        return true;
    }
}
