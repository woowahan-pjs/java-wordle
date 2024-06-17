package wordle.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import wordle.design.WordGenerator;

public class WordGeneratorImpl implements WordGenerator {

    private static final List<String> WORDS = readFile();
    private static final String REFERENCE_DATE = "2021-06-19";

    @Override
    public String execute() {
        return WORDS.get(findIndex());
    }

    private static List<String> readFile() {

        List<String> lines = null;

        try {
            lines = Files.lines(Path.of("src/main/resources/words.txt")).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private int findIndex() {
        LocalDate now = LocalDate.now();
        LocalDate referenceDay = LocalDate.parse(REFERENCE_DATE, DateTimeFormatter.ISO_LOCAL_DATE);
        Duration diff = Duration.between(referenceDay.atStartOfDay(), now.atStartOfDay());
        long diffDays = diff.toDays();

        return (int) (diffDays % WORDS.size());
    }
}
