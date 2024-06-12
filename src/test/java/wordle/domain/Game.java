package wordle.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game {
    private static final int MAX_ATTEMPT = 6;

    private InputView inputView;
    private OutputView outputView;
    private WordListReader wordListReader;

    public Game(InputView inputView, OutputView outputView, WordListReader wordListReader) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.wordListReader = wordListReader;
    }

    public void start() {
        // todo 게임 시작
        final WordList wordList = wordListReader.read();
        final Answer answer = new Answer(wordList.select(new TimeBaseAnswerSelector(LocalDate.now())));
        outputView.welcome();
        Results results = new Results(new ArrayList<>());
        for (int i = 0; i < MAX_ATTEMPT; i++) {
            final Guess guess = inputWord(wordList);
            final Result result = answer.examineResult(guess);
            results.add(result);
            outputView.showResults(results, MAX_ATTEMPT);
            if (results.isFinished()) {
                break;
            }
        }
    }

    private Guess inputWord(WordList wordList) {
        try {
            outputView.insertWord();
            final String wordString = inputView.inputWord();
            Guess guess = new Guess(wordList.find(wordString));
            outputView.insertedWord(wordString);
            return guess;
        } catch (final Exception e) {
            outputView.wrongWord();
            return inputWord(wordList);
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

    void showResults(Results results, final int maxAttempt);

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
    public void showResults(final Results results, final int maxAttempt) {
        if (results.isFinished()) {
            System.out.println("%s/%s".formatted(results.size(), maxAttempt));
        }

        final String resultSentence = results.getResults().stream()
                .map(it -> it.getResult().stream()
                        .map(ConsoleOutputView::color)
                        .collect(Collectors.joining())
                ).collect(Collectors.joining("\n"));

        System.out.println(resultSentence);
    }

    private static String color(final ResultType resultType) {
        return switch (resultType) {
            case MATCHED -> "🟩";
            case EXIST -> "🟨";
            case MISMATCHED -> "⬜";
        };
    }

    @Override
    public void insertedWord(final String wordString) {
        System.out.println(wordString);
    }
}

