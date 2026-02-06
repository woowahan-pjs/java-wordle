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
            throw new FileReadFailException("파일 경로가 비어있습니다.");
        }
        try (final Stream<String> lines = Files.lines(getFilePath(filePath))) {
            return lines.toList();
        } catch (IOException | URISyntaxException exception) {
            throw new FileReadFailException("파일 읽기 중 에러가 발생했습니다. path: " + filePath, exception);
        }
    }

    private Path getFilePath(final String filePath) throws URISyntaxException {
        return Path.of(getUrl(filePath).toURI());
    }

    private URL getUrl(final String filePath) {
        final URL systemResource = ClassLoader.getSystemResource(filePath);
        if (Objects.isNull(systemResource)) {
            throw new FileReadFailException("해당 경로의 파일을 찾을 수 없습니다. path: " + filePath);
        }
        return systemResource;
    }
}
