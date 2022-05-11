package util;

import exception.AnswerGroupNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.Characters;

public class AnswerGroupProvider {

    private static final String FILE_NAME = "words.txt";
    private static final String FILE_PATH = "./src/main/resources/";

    public static List<Characters> provide() {
        List<Characters> answerGroup;
        Path path = Paths.get(FILE_PATH + FILE_NAME);
        try (Stream<String> lines = Files.lines(path)) {
            answerGroup = lines
                    .map(Characters::new)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new AnswerGroupNotFoundException(FILE_PATH + FILE_NAME + "의 파일을 찾지 못했습니다.");
        }

        return answerGroup;
    }
}
