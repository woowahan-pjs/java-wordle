package wordle.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {

    public String getUserInput() {
        //TODO: input stream error
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e); // TODO: change
        }
    }
}
