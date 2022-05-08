package wordle.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import wordle.domain.design.WordGenerator;

public class WordGeneratorImpl implements WordGenerator {

    // words.txt 파일을 배열로 만들어서 ((현재 날짜 - 2021년 6월 19일) % 배열의 크기) 번째의 단어를 반환한다

    private static final String FILENAME = "src/main/resources/words.txt";
    private static final List<String> WORDS = getDefaultWords(FILENAME);
    private static final String REFERENCE_DATE = "2021-06-19";

    private static List<String> getDefaultWords(String fileName) {
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            return lines.collect(Collectors.toList());
        } catch (IOException e) {
            return List.of(
                    "cigar", "rebut", "sissy", "humph", "awake", "blush", "focal", "evade", "naval", "serve", "heath",
                    "dwarf", "model", "karma", "stink", "grade", "quiet", "bench", "abate", "feign", "major", "death",
                    "fresh", "crust", "stool", "colon", "abase", "marry", "react", "batty", "pride", "floss", "helix",
                    "croak", "staff", "paper", "unfed", "whelp", "trawl", "outdo", "adobe", "crazy", "sower", "repay",
                    "digit", "crate", "cluck", "spike", "mimic", "pound", "maxim", "linen", "unmet", "flesh", "booby",
                    "forth", "first", "stand", "belly", "ivory", "seedy", "print", "yearn", "drain", "bribe", "stout"
            );
        }
    }

    @Override
    public String execute() {
        return WORDS.get(findIndex());
    }

    private int findIndex() {
        LocalDate now = LocalDate.now();
        LocalDate referenceDay = LocalDate.parse(REFERENCE_DATE, DateTimeFormatter.ISO_LOCAL_DATE);
        Duration diff = Duration.between(now.atStartOfDay(), referenceDay.atStartOfDay());
        long diffDays = Math.abs(diff.toDays());
        return (int) (diffDays % WORDS.size());
    }
}
