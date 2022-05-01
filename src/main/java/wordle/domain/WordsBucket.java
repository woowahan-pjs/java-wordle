package wordle.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


public class WordsBucket {

    private static final LocalDate TARGET_DATE = LocalDate.of(2021, 6, 19);
    private final List<Words> words = new ArrayList<>();

    public WordsBucket(final String filePath) {
        final List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(filePath));
        } catch (final IOException e) {
            throw new IllegalArgumentException("Invalid file path: " + filePath);
        }

        for (final String line : lines) {
            words.add(new Words(line));
        }
    }

    public boolean contains(Words words) {
        return this.words.contains(words);
    }

    public Answer findAnswer(final LocalDate today) {
        final int betweenDays = betweenDays(today);
        return new Answer(findTodayWords(betweenDays));
    }

    private int betweenDays(final LocalDate today) {
        return (int) ChronoUnit.DAYS.between(TARGET_DATE, today);
    }

    private Words findTodayWords(final int betweenDays) {
        return words.get(findTodayIndex(betweenDays));
    }

    private int findTodayIndex(final int betweenDays) {
        return betweenDays % (words.size());
    }

}
