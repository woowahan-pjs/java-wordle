package wordle.app.word.adapter.in;

import wordle.app.word.application.port.in.ContainWordsPort;

public class WordsBucketAdapter {

    private final ContainWordsPort containWordsPort;

    public WordsBucketAdapter(final ContainWordsPort containWordsPort) {
        this.containWordsPort = containWordsPort;
    }

    public boolean contains(final ContainWordsRequest request) {
        if (request != null) {
            return containWordsPort.contains(request.getWords());
        }

        throw new IllegalArgumentException("ContainWordsRequest is null");
    }

}
