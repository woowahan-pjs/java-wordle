package com.wodle.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileUtilsTest {

    private FileUtils fileUtils;

    @BeforeEach
    public void init() {
        fileUtils = FileUtils.getInstance();
    }

    @Test
    public void getStreamByFileNameTest() {
        //given
        String fileName = "test.txt";

        //when
        Stream<String> streamByFileName = fileUtils.getStreamByFileName(fileName);
        List<String> wordList = streamByFileName.collect(Collectors.toList());
        //then
        assertAll(
            () -> assertThat(wordList)
                .hasSize(5)
                .containsExactly(
                    "aaaaa",
                    "bbbbb",
                    "ccccc",
                    "ddddd",
                    "eeeee"
                )
        );
    }

    @Test
    public void fileNotFoundTest() {
        //given
        String fileName = "NON_EXIST_FILE";

        //when && then
        assertThatThrownBy(
            () -> fileUtils.getStreamByFileName(fileName)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("File not found");
    }
}