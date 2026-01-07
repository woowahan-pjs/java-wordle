package ui;

import domain.Word;

public class AnswerView {
    public void render(Word answer) {
        System.out.println(answer.getString());
    }
}
