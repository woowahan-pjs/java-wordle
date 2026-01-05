package wordle.output;

import wordle.domain.design.MessagePrinter;
import wordle.domain.vo.Message;

public class MessagePrinterImpl implements MessagePrinter {
    @Override
    public void execute(Message message) {
        System.out.println(message.value);
    }
}
