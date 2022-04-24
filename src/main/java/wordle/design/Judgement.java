package wordle.design;

public interface Judgement {
    public boolean execute(String answer, String input); // 유저 인풋을 판단
}
