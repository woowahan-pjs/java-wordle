package wordle.ui;

import wordle.domain.Record;

public interface OutputView {

    void welcome();

    void askAnswer();

    void showRecord(Record record);

    void successEnd(Record record);

    void failEnd(Record record);

    void wrongAnswer();

    void unexpectedEnd();
}
