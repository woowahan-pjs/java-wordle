package kr.co.wordle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class AnswerProvider {

    private static final String WORDS_FILE_PATH = "words.txt";

    private AnswerProvider() {
        
    }

    public static String todayAnswer() {
        try {
            URL resource = AnswerProvider.class.getClassLoader().getResource(WORDS_FILE_PATH);
            List<String> strings = Files.readAllLines(Paths.get(resource.toURI()));
            int dayDiff = getTodayIndex();
            return strings.get(dayDiff % strings.size());
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static int getTodayIndex() {
        LocalDate reference = LocalDate.of(2021, 6, 19);
        LocalDate today = LocalDate.now();
        Period period = Period.between(reference, today);
        return period.getDays();
    }
}
