package domain;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class WordPool implements Words {
    private final Long BASE_TIME_EPOCH_DAY = LocalDate.of(2021, 6, 19).toEpochDay();
    List<Letters> words;
    Letters todayWord;

    public WordPool() {
        setWords();
        setTodayWord();
    }

    private void setWords() {
        InputStream words = ClassLoader.getSystemResourceAsStream("words.txt");

        assert words != null;
        this.words = new BufferedReader(new InputStreamReader(words)).lines()
                .map(Letters::of)
                .collect(Collectors.toList());
    }

    private void setTodayWord() {
        long nowEpochDay = LocalDate.now().toEpochDay();
        int daysFromStandard = (int) (nowEpochDay - BASE_TIME_EPOCH_DAY);
        this.todayWord = words.get(daysFromStandard % words.size());
    }


    @Override
    public Letters getTodayWords() {
        return todayWord;
    }

    @Override
    public boolean contains(Letters letter) {
        return words.contains(letter);
    }
}
