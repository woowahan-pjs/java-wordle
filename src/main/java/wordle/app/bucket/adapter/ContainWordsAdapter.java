package wordle.app.bucket.adapter;

import wordle.app.bucket.application.port.in.ContainWordsPort;
import wordle.app.word.domain.Words;

public class ContainWordsAdapter {

    private final ContainWordsPort containWordsPort;

    public ContainWordsAdapter(final ContainWordsPort containWordsPort) {
        this.containWordsPort = containWordsPort;
    }

    public boolean contains(final Words words) {
        return containWordsPort.contains(words);
    }

}
