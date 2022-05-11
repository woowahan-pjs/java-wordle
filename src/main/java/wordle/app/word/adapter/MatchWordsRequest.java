package wordle.app.word.adapter;

import wordle.app.word.domain.Answer;
import wordle.app.word.domain.Words;

public class MatchWordsRequest {

    private final Answer answer;
    private final Words words;

    public MatchWordsRequest(final Answer answer, final Words words) {
        this.answer = answer;
        this.words = words;
    }

    public Answer getAnswer() {
        return answer;
    }

    public Words getWords() {
        return words;
    }

}
