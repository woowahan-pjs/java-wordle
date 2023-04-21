package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class AnswerExtractor {

    public static String extractAnswer(String fileName) {
        return searchAnswer(fileName);
    }

    private static String searchAnswer(String fileName) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(fileName);
        try {
            List<String> textFileLines = readFromInputStream(inputStream);
            Integer index = calculateAnswerIndex(textFileLines);
            return textFileLines.get(index);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Integer calculateAnswerIndex(List<String> strings) {
        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.of(2021, 6, 19);
        long diffDays = Math.abs(ChronoUnit.DAYS.between(today, date));
        return Long.valueOf(diffDays % strings.size()).intValue();
    }

    private static List<String> readFromInputStream(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        return extractTextLines(bufferedReader);
    }

    private static List<String> extractTextLines(BufferedReader br) throws IOException {
        List<String> txtFileLine = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            txtFileLine.add(line);
        }
        return txtFileLine;
    }
}
