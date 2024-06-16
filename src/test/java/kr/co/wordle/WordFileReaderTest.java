package kr.co.wordle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class WordFileReaderTest {

    @Test
    void 파일읽기() {
        List<String> words = WordFileReader.readWordsInFile();
        Assertions.assertFalse(words.isEmpty());
    }
}
