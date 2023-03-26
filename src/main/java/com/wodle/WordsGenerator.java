package com.wodle;

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

    private final FileUtils fileUtils;
    private final LocalDateTimeUtils localDateTimeUtils;

    public WordsGenerator(FileUtils fileUtils, LocalDateTimeUtils localDateTimeUtils) {
        this.fileUtils = fileUtils;
        this.localDateTimeUtils = localDateTimeUtils;
    }

    public Word getTodayWord(){
        try (Stream<String> stream = getStreamByFileName()) {
            long fileMaxLines = stream.count();
            long wordIndex = getTodayWordIndex(fileMaxLines);

            String todayWord = stream.skip(wordIndex)
                .findFirst()
                .orElseThrow(
                    () -> new RuntimeException("단어를 셋팅할수 없습니다")
                );
            return new Word(todayWord);
        } catch (RuntimeException e) {
            throw new RuntimeException("단어를 셋팅할수 없습니다", e);
        }
    }

    private Stream<String> getStreamByFileName(){
        URL resource = getClass().getClassLoader().getResource(FILE_PATH);

        if (resource == null){
            throw new IllegalArgumentException("File not found");
        }

        try {
            return Files.lines(Path.of(resource.toURI()));
        } catch (IOException e){
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private int getTodayWordIndex(long totalCount) {
        LocalDateTime base = LocalDate.of(2021, 6, 19)
            .atStartOfDay();
        LocalDateTime now = LocalDateTime.now();

        long betweenDays = Duration.between(base, now).toDays();

        return (int) (betweenDays % totalCount);
    }
}
