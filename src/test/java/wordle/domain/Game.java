package wordle.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game {
    private static final int MAX_ATTEMPT = 6;

    private InputView inputView;
    private OutputView outputView;
    private AnswerReader answerReader;

    public void start() {
        // todo 게임 시작
        final Answer answer = answerReader.read(new TimeBaseAnswerSelector(LocalDate.now()));
        outputView.welcome();
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < MAX_ATTEMPT; i++) {
            final Word word = inputWord();
            final Result result = answer.examineResult(new Guess(word.getWord()));
            results.add(result);
            final boolean allMatch = results.stream().anyMatch(Result::allMatched);
            if (allMatch) {
                break;
            }
            outputView.insertWord();
        }
        outputView.showResults(results, MAX_ATTEMPT);
    }

    private Word inputWord() {
        try {
            outputView.insertWord();
            final String wordString = inputView.inputWord();
            final Word word = new Word(wordString);
            outputView.insertedWord(wordString);
            return word;
        } catch (final Exception e) {
            outputView.wrongWord();
            return inputWord();
        }
    }
}


interface InputView {
    String inputWord();
}

interface OutputView {
    void welcome();

    void insertWord();

    void wrongWord();

    void showResults(List<Result> results, final int maxAttempt);

    void insertedWord(String wordString);
}

class ConsoleInputView implements InputView {
    private final Scanner scanner;

    public ConsoleInputView() {
        this(new Scanner(System.in));
    }

    public ConsoleInputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String inputWord() {
        return scanner.nextLine();
    }
}

class ConsoleOutputView implements OutputView {

    @Override
    public void welcome() {
        System.out.println("WORDLE을 6번 만에 맞춰 보세요.");
        System.out.println("시도의 결과는 타일의 색 변화로 나타납니다.");
    }

    @Override
    public void insertWord() {
        System.out.println("정답을 입력해 주세요.");
    }

    @Override
    public void wrongWord() {
        System.out.println("단어가 올바르지 않습니다.");
        System.out.println("5글자의 소문자 알파벳으로 다시 입력해 주세요.");
    }

    @Override
    public void showResults(final List<Result> results, final int maxAttempt) {
        System.out.println("%s/%s".formatted(results.size(), maxAttempt));
        final String resultSentence = results.stream()
                .map(it -> it.getResult().stream()
                        .map(ResultType::name)
                        .collect(Collectors.joining())
                ).collect(Collectors.joining("\n"));

        System.out.println(resultSentence);
    }

    @Override
    public void insertedWord(final String wordString) {
        System.out.println(wordString);
    }
}

interface AnswerReader {
    Answer read(final Selector selector);
}

class AnswerFileReader implements AnswerReader {
    private static final String FILE_PATH = "src/main/resources/words.txt";
    private static final WordList wordList = initializeWordList();

    private static WordList initializeWordList() {
        try {
            final Path path = Paths.get(FILE_PATH);
            return new WordList(Files.readAllLines(path)
                    .stream()
                    .map(Word::new)
                    .toList());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Answer read(final Selector selector) {
        return new Answer(wordList.select(selector).getWord());
    }
}
