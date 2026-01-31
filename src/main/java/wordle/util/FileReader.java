package wordle.util;

import wordle.exception.FileReadFailException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class FileReader {

    // NOTE: 파일을 하나씩 읽고 리스트로 반환
    public List<String> readByLine(final String filePath) {
        if (Objects.isNull(filePath) || filePath.isBlank()) {
            throw new FileReadFailException();
        }
        try (final Stream<String> lines = Files.lines(getFilePath(filePath))) {
            return lines.toList();
        } catch (IOException | URISyntaxException exception) {
            throw new FileReadFailException();
        }
    }

    private Path getFilePath(final String filePath) throws URISyntaxException {
        return Path.of(getUrl(filePath).toURI());
    }

    private URL getUrl(final String filePath) {
        final URL systemResource = ClassLoader.getSystemResource(filePath);
        if (Objects.isNull(systemResource)) {
            throw new FileReadFailException();
        }
        return systemResource;
    }
}
