package domain;

import camp.nextstep.edu.missionutils.Console;
import view.InputView;
import view.OutputView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int MAX_TRY_COUNT = 6;

    private Letters userAnswer;
    private final List<LetterResults> letterResults;
    private final LetterRepository letterRepository;
    private final Answer answer;
    private int count;

    public Game(LetterRepository letterRepository){
        letterResults = new ArrayList<>();
        this.letterRepository = letterRepository;
        this.answer = new Answer(letterRepository.getTodayAnswer(LocalDate.now()));
        this.count = 0;
    }

    public void start() {
        do {
            inputWord();
            play();
        }while(isPlayable());
        quit();
    }

    private void inputWord() {
        do {
            InputView.guide();
            userAnswer = Letters.of(Console.readLine());
        } while (!isPresence());
    }

    private boolean isPresence() {
        if (!letterRepository.isContains(userAnswer)){
            OutputView.notExist();
            return false;
        }
        return true;
    }

    private void play() {
        letterResults.add(answer.compare(userAnswer));
        OutputView.result(letterResults);
    }

    private boolean isPlayable() {
        return count++ < MAX_TRY_COUNT && !letterResults.contains(LetterResults.correctAll());
    }

    private void quit() {
        OutputView.quit(count);
    }
}
