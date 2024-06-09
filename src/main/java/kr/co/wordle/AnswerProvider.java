package kr.co.wordle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class AnswerProvider {

    private static final String WORDS_FILE_PATH = "words.txt";

    public static String todayAnswer() {
        try {
            URL resource = AnswerProvider.class.getClassLoader().getResource(WORDS_FILE_PATH);
            List<String> strings = Files.readAllLines(Paths.get(resource.toURI()));
            int index = getTodayIndex();
            return strings.get(index);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static int getTodayIndex() {
        // TODO ((현재날짜 - 2021/6/19) % 배열의 크기) 계산
        LocalDate today = LocalDate.now();
        LocalDate reference = LocalDate.of(2021, 6, 19);
        return 0;
    }
}
