package wordle.app.word.adapter.out;

import wordle.app.word.application.port.out.WordsBucketPort;
import wordle.app.word.domain.Answer;
import wordle.app.word.domain.Words;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


public class FileWordsBucket implements WordsBucketPort {

    private final List<Words> words = new ArrayList<>();
    private final LocalDate answerDate;

    public FileWordsBucket(final String filePath, final LocalDate answerDate) {
        final List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(filePath));
        } catch (final IOException e) {
            throw new IllegalArgumentException("Invalid file path: " + filePath);
        }

        for (final String line : lines) {
            words.add(new Words(line));
        }

        this.answerDate = answerDate;
    }

    public boolean contains(final Words words) {
        return this.words.contains(words);
    }

    public Answer findAnswer(final LocalDate today) {
        final int betweenDays = betweenDays(today);
        return new Answer(findTodayWords(betweenDays));
    }

    private int betweenDays(final LocalDate today) {
        return (int) ChronoUnit.DAYS.between(answerDate, today);
    }

    private Words findTodayWords(final int betweenDays) {
        return words.get(findTodayIndex(betweenDays));
    }

    private int findTodayIndex(final int betweenDays) {
        return betweenDays % (words.size());
    }

}
