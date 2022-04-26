package wordle.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordTxtFileScanner {
    private final Scanner scanner;

    WordTxtFileScanner(File wordFile) {
        if (!wordFile.exists()) {
            throw new IllegalArgumentException("올바른 파일이 필요합니다.");
        }

        try {
            scanner = new Scanner(wordFile);
        } catch (Exception e) {
            throw new RuntimeException("스캐너 생성 시 에러가 발생했습니다.");
        }
    }

    public List<String> toWordList() {
        final List<String> words = new ArrayList<>();

        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }

        return words;
    }
}
