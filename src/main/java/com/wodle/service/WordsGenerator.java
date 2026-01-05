package com.wodle.service;

import com.wodle.domain.AnswerWord;
import com.wodle.utils.FileUtils;
import com.wodle.utils.LocalDateTimeUtils;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordsGenerator {

    private static final String FILE_PATH = "words.txt";

    public AnswerWord getTodayWord() {
        try (Stream<String> stream = FileUtils.getStreamByFileName(FILE_PATH)) {
            List<String> wordList = stream.collect(Collectors.toList());
            long fileMaxLines = wordList.size();
            int wordIndex = getTodayWordIndex(fileMaxLines);

            String todayWord = wordList.get(wordIndex);
            return new AnswerWord(todayWord);
        } catch (RuntimeException e) {
            throw new RuntimeException("단어를 셋팅할수 없습니다", e);
        }
    }

    private int getTodayWordIndex(long totalCount) {
        LocalDateTime base = LocalDate.of(2021, 6, 19)
            .atStartOfDay();
        LocalDateTime now = LocalDateTime.now();

        long betweenDays = LocalDateTimeUtils.getBetweenDays(base, now);

        return (int) (betweenDays % totalCount);
    }
}
