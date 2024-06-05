package com.wodle.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileUtils {

    public static Stream<String> getStreamByFileName(String filePath) {
        URL resource = FileUtils.class.getClassLoader().getResource(filePath);
        if (resource == null) {
            throw new IllegalArgumentException("File not found");
        }
        try {
            return Files.lines(Path.of(resource.toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
