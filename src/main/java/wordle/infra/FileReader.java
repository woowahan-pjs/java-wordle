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
            throw new FileReadFailException("파일 경로가 비었습니다.");
        }

        try {
            URL systemResource = getUrl(filePath);
            return Files.lines(Path.of(systemResource.toURI())).toList();
        } catch (IOException | URISyntaxException e) {
            throw new FileReadFailException("올바르지 않은 파일입니다. ("+ filePath +")");
        }
    }

    private URL getUrl(String filePath) {
        URL systemResource = ClassLoader.getSystemResource(filePath);
        if (systemResource == null) {
            throw new FileReadFailException("올바르지 않은 파일 경로입니다. (" + filePath + ")");
        }
        return systemResource;
    }
}
