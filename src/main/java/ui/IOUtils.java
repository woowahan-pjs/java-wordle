package ui;

import domain.Words;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class IOUtils {

    private IOUtils() {
    }

    public static Words readFromResource(String resourceName) {
        URL txtUrl = IOUtils.class.getClassLoader().getResource(resourceName);
        try {
            assert txtUrl != null;
            List<String> words = Files.readAllLines(Paths.get(txtUrl.toURI()));
            return new Words(words.toArray(new String[0]));
        } catch (IOException e) {
            System.out.println("파일을 읽는도중 문제가 발생했습니다.");
            throw new RuntimeException();
        } catch (URISyntaxException e) {
            System.out.println("존재하지 않는 경로 입니다.");
            throw new RuntimeException();
        }
    }
}
