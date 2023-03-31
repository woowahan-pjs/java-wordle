package wordle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class GameMachine {
    //목표: words.txt 에서 정답을 하나 불러온다.
    public String findQuestion() {
        List<String> list = wrodsTxtFileToList();
        int index = calcGetQuestionIndex(list.size());
        return list.get(index);
    }

    private List<String> wrodsTxtFileToList() {
        try {
            Path path = Paths.get(ClassLoader.getSystemResource("words.txt").toURI());

            return Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException("file load failed!!!!!", e);
        }

    }

    private int calcGetQuestionIndex(int wordsTxtSize) {
        long todayToEpochDay = LocalDate.now().toEpochDay();
        long standardDateToEpochDay = LocalDate.of(2021, Month.JUNE, 19).toEpochDay();

        return (int) ((todayToEpochDay - standardDateToEpochDay) % wordsTxtSize);
    }

    public static List<Result> compare(String question, String answer) {
        String[] questionStrings = question.split("");

        String[] answerStrings = answer.split("");

        List<Result> results = new ArrayList<>();

        for (int i = 0; i < questionStrings.length; i++) {
            if (questionStrings[i].equals(answerStrings[i])) {
                results.add(Result.정답);
            } else if (answer.contains(questionStrings[i])) {
                results.add(Result.문자만_같음);
            } else {
                results.add(Result.틀림);
            }
        }

        return results;
    }
}
