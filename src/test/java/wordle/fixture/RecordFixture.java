package wordle.fixture;

import wordle.domain.Record;
import wordle.domain.Results;

public class RecordFixture {

    public static Record create(Results results, Results... resultsList) {
        Record record = new Record();
        record.add(results);
        for (Results value : resultsList) {
            record.add(value);
        }
        return record;
    }

}
