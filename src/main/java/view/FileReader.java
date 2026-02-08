package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public final class FileReader {

    private FileReader() {

    }

    public static List<String> readAllLines(String resourceName) {
        InputStream is = FileReader.class
                .getClassLoader()
                .getResourceAsStream(resourceName);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            return br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
