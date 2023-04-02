package controller;

import domain.WordleGames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static view.output.OutputView.printMain;

public class WordleController {


    public void start() {
        // view 의 Input~  기능을 통해서 입력받고
        // view 의 Output~ 기능을 통해서 출력하고
        printMain();

        String answer = searchAnswer();

        WordleGames wordleGames = new WordleGames();
        wordleGames.start(answer);

    }

    private String searchAnswer() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("words.txt");
        List<String> strings = new ArrayList<>();
        try {
             strings = readFromInputStream(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Long index = calculateAnswerIndex(strings);
        return strings.get(index.intValue());
    }

    private static Long calculateAnswerIndex(List<String> strings) {
        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.of(2021, 6, 19);
        long diffDays = Math.abs(ChronoUnit.DAYS.between(today, date));
        return Long.valueOf(diffDays % strings.size());
    }

    private static List<String> readFromInputStream(InputStream inputStream) throws IOException {
        List<String> txtFileLine = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                txtFileLine.add(line);
            }
        }
        return txtFileLine;
    }
}
