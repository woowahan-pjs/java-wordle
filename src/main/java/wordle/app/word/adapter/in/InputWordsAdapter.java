package wordle.app.word.adapter.in;

import wordle.app.word.application.port.in.InputWordsPort;
import wordle.app.word.domain.Words;

public class InputWordsAdapter {

    private final InputWordsPort inputWordsPort;

    public InputWordsAdapter(final InputWordsPort inputWordsPort) {
        this.inputWordsPort = inputWordsPort;
    }

    public Words inputWords() {
        return inputWordsPort.inputWords();
    }

}
