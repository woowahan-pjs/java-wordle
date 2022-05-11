package wordle.app.bucket.adapter;

import wordle.app.bucket.application.port.in.ContainWordsPort;

public class ContainWordsAdapter {

    private final ContainWordsPort containWordsPort;

    public ContainWordsAdapter(final ContainWordsPort containWordsPort) {
        this.containWordsPort = containWordsPort;
    }

    public boolean contains(final ContainWordsRequest request) {
        if (request != null) {
            return containWordsPort.contains(request.getWords());
        }

        throw new IllegalArgumentException("ContainWordsRequest is null");
    }

}
