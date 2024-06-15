package wordle.ui;

import wordle.domain.Record;
public interface OutputView {

    void welcome();

    void askAnswer();

    void showRecord(Record record);

    void end(Record record);
}
