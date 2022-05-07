package domain;

import camp.nextstep.edu.missionutils.Console;
import view.InputView;
import view.OutputView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int MAX_TRY_COUNT = 6;

    private final List<LetterResults> letterResults;
    private final LetterRepository letterRepository;
    private final Answer answer;
    private int count;

    public Game(LetterRepository letterRepository){
        letterResults = new ArrayList<>();
        this.letterRepository = letterRepository;
        this.answer = new Answer(letterRepository.getTodayAnswer(LocalDate.now()));
        this.count = 0;
        start();
    }

    private void start() {
        do {
            play();
        }while(isPlayable());
        quit();
    }

    private void play() {
        InputView.guide();
        Letters userAnswer = Letters.of(Console.readLine());
        validatePresence(userAnswer);
        letterResults.add(answer.compare(userAnswer));
        OutputView.result(letterResults);
    }

    private void validatePresence(Letters userAnswer) {
        if (!letterRepository.isContains(userAnswer)){
            OutputView.notExist();
            play();
        }
    }

    private boolean isPlayable() {
        return count++ < MAX_TRY_COUNT && !letterResults.contains(LetterResults.correctAll());
    }

    private void quit() {
        OutputView.quit();
    }
}
