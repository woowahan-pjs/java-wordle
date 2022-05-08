package wordle.domain.design;

import wordle.domain.vo.Message;

public interface MessagePrinter {
    void execute(Message message);
}
