package wordle.infra;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import wordle.exception.FileReadFailException;

public class FileReader {

    public List<String> readByLine(String filePath) {
        if (filePath == null || filePath.isBlank()) {
            throw new FileReadFailException();
        }

        try {
            URL systemResource = getUrl(filePath);
            return Files.lines(Path.of(systemResource.toURI())).toList();
        } catch (IOException | URISyntaxException e) {
            throw new FileReadFailException();
        }
    }

    private URL getUrl(String filePath) {
        URL systemResource = ClassLoader.getSystemResource(filePath);
        if (systemResource == null) {
            throw new FileReadFailException();
        }
        return systemResource;
    }
}
