package wordle.app.word.adapter.in;

import wordle.app.word.application.port.in.FindAnswerPort;
import wordle.app.word.domain.Answer;

public class FindAnswerAdapter {

    private final FindAnswerPort findAnswerPort;

    public FindAnswerAdapter(final FindAnswerPort findAnswerPort) {
        this.findAnswerPort = findAnswerPort;
    }

    public Answer findAnswer() {
        return findAnswerPort.findAnswer();
    }

}
