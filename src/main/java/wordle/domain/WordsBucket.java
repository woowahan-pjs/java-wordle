package wordle.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


public class WordsBucket {

    public static final LocalDate targetDate = LocalDate.of(2021, 6, 19);
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

    public int size() {
        return words.size();
    }

    public Answer findAnswer(final LocalDate today) {
        final int betweenDays = betweenDays(today);
        return new Answer(words.get((betweenDays % (words.size()))));
    }

    private int betweenDays(final LocalDate today) {
        return (int) ChronoUnit.DAYS.between(targetDate, today);
    }

    public boolean contains(Words words) {
        return this.words.contains(words);
    }

}
