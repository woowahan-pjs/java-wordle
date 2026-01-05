package wordle.infra;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import wordle.exception.FileReadFailException;

public class FileReader {

    public List<String> readByLine(final String filePath) {
        if (filePath == null || filePath.isBlank()) {
            throw new FileReadFailException();
        }

        try (final Stream<String> lines = Files.lines(getPath(filePath))) {
            return lines.toList();
        } catch (final IOException | URISyntaxException e) {
            throw new FileReadFailException();
        }
    }

    private Path getPath(final String filePath) throws URISyntaxException {
        return Path.of(getUrl(filePath).toURI());
    }

    private URL getUrl(final String filePath) {
        final URL systemResource = ClassLoader.getSystemResource(filePath);
        if (systemResource == null) {
            throw new FileReadFailException();
        }
        return systemResource;
    }
}
