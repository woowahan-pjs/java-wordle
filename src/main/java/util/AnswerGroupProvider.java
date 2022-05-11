package util;

import exception.AnswerGroupNotFoundException;
import exception.InvalidPathReferenceException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.Characters;

public class AnswerGroupProvider {

    private static final String FILE_NAME = "words.txt";

    public static List<Characters> provide() {
        List<Characters> answerGroup;

        URL resource = AnswerGroupProvider.class.getClassLoader().getResource(FILE_NAME);
        if (resource == null) {
            throw new InvalidPathReferenceException("잘못된 경로 입니다.");
        }
        try (Stream<String> lines = Files.lines(Paths.get(resource.toURI()))) {
            answerGroup = lines
                    .map(Characters::new)
                    .collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            throw new AnswerGroupNotFoundException("I/O exception 이거나 URI 참조로 구문을 분석할 수 없습니다.");
        }

        return answerGroup;
    }
}
