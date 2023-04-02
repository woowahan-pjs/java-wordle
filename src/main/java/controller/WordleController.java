package controller;

import domain.WordleGames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static view.output.OutputView.printMain;

public class WordleController {


    public void start() {
        // view 의 Input~  기능을 통해서 입력받고
        // view 의 Output~ 기능을 통해서 출력하고
        printMain();

        String answer = "answer";

        WordleGames wordleGames = new WordleGames();
        wordleGames.start(answer);

    }

    public static void main(String[] args) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("words.txt");

        System.out.println(readFromInputStream(is));
    }

    private static String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
