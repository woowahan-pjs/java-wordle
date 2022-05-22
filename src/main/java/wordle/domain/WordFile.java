package wordle.domain;

import java.io.File;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordFile {
    private static final String FILE_PATH = "./src/main/resources/";
    private final File wordFile;
    private final Scanner scanner;
    private final List<String> wordList = new ArrayList<>();

    public WordFile(String fileName) {
        wordFile = new File(FILE_PATH + fileName);

        if (!wordFile.exists()) {
            throw new IllegalArgumentException("올바른 파일이 필요합니다.");
        }

        try {
            scanner = new Scanner(wordFile);

            while (scanner.hasNext()) {
                wordList.add(scanner.nextLine());
            }
        } catch (Exception e) {
            throw new RuntimeException("파일 스캐너 생성 시 에러가 발생했습니다.");
        }
    }

    public String findTargetWord(LocalDate targetDate) {
        final LocalDate conditionDate = LocalDate.of(2021, 6, 19);

        final long diffDays = ChronoUnit.DAYS.between(conditionDate, targetDate);

        final int targetIdx = Math.abs((int) diffDays % wordList.size());

        return wordList.get(targetIdx);
    }
}
