package com.wodle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.wodle.utils.FileUtils;
import com.wodle.utils.LocalDateTimeUtils;
import java.time.LocalDateTime;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class WordsGeneratorTest {

    private WordsGenerator wordsGenerator;

    @Test
    public void todayWordsTest() {
        wordsGenerator = new WordsGenerator(
            new TestFileUtils(),
            new TestLocalDateTimeUtils()
        );

        Word todayWord = wordsGenerator.getTodayWord();

        assertThat(todayWord.getWord()).isEqualTo("ddddd");
    }

    @Test
    public void fileNotFoundTodayWordsTest() {
        wordsGenerator = new WordsGenerator(
            new TestAbnormalFilePathFileUtils(),
            new TestLocalDateTimeUtils()
        );

        assertThatThrownBy(
            () -> wordsGenerator.getTodayWord()
        ).isInstanceOf(RuntimeException.class)
            .hasMessage("단어를 셋팅할수 없습니다");

    }

    public static class TestFileUtils extends FileUtils {

        @Override
        public Stream<String> getStreamByFileName(String filePath) {
            return super.getStreamByFileName("test.txt");
        }
    }

    public static class TestAbnormalFilePathFileUtils extends FileUtils {

        @Override
        public Stream<String> getStreamByFileName(String filePath) {
            return super.getStreamByFileName("NONE_FILE.txt");
        }
    }

    public static class TestLocalDateTimeUtils extends LocalDateTimeUtils {

        @Override
        public long getBetweenDays(LocalDateTime past, LocalDateTime future) {
            return 3;
        }
    }
}