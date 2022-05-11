package wordle.app.word.adapter;

import wordle.app.word.domain.Words;

public class ContainWordsRequest {

    private final Words words;

    public ContainWordsRequest(final Words words) {
        this.words = words;
    }

    public Words getWords() {
        return words;
    }

}
