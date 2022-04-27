package util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.Characters;

public class AnswerGroupProvider {

    public List<Characters> provide() {
        List<Characters> answerGroup = new ArrayList<>();

        URL resource = this.getClass().getClassLoader().getResource("words.txt");
        try (Stream<String> lines = Files.lines(Paths.get(resource.toURI()));) {
            answerGroup = lines
                    .map(Characters::new)
                    .collect(Collectors.toList());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return answerGroup;
    }
}
