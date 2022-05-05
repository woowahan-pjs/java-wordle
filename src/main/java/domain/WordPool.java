package domain;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WordPool implements Words {
    private final Long BASE_TIME_EPOCH_DAY = LocalDate.of(2021, 6, 19).toEpochDay();
    private final String WORD_TEXT_FILE_NAME = "words.txt";
    private List<Letters> words;
    private Letters todayWord;

    public WordPool() {
        setWords();
        setTodayWord();
    }

    private void setWords() {
        this.words = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream(WORD_TEXT_FILE_NAME))
                )).lines()
                .map(Letters::of)
                .collect(Collectors.toList());
    }

    private void setTodayWord() {
        final long nowEpochDay = LocalDate.now().toEpochDay();
        final int daysFromStandard = (int) (nowEpochDay - BASE_TIME_EPOCH_DAY);
        this.todayWord = words.get(daysFromStandard % words.size());
    }


    @Override
    public Letters getTodayWords() {
        return todayWord;
    }

    @Override
    public boolean contains(final Letters letter) {
        return words.contains(letter);
    }
}
