package model;

import controller.WordInputHandler;
import view.FileReader;
import view.WordDrawer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.time.Clock;

public class WordleGame {

    private final WordInputHandler inputHandler;
    private final TrialCounter trialCounter;
    private final WordComparator comparator;
    private final WordDrawer drawer;
    private final WordIndexCalculator calculator;
    private String todayWord;
    private final List<String> words;

    public WordleGame() throws IOException {
        words = FileReader.readAllLines("./words.txt");

        inputHandler = new WordInputHandler();
        trialCounter = new TrialCounter(6);

        comparator = new WordComparator();
        drawer = new WordDrawer();
        calculator = new WordIndexCalculator(words.size()
                , LocalDateTime.of(2021, 6, 19, 0, 0)
                , Clock.systemDefaultZone());
    }

    public void start() {
        WordSelector wordSelector = new WordSelector(calculator, words);
        todayWord = wordSelector.getTodayWord();

        while (trialCounter.keepTrying()) {
            playTurn();
        }
        WordDrawer.showTheEnd(trialCounter.isSolved());
    }

    private void playTurn() {

        System.out.println("정답을 입력해 주세요. " + trialCounter.getTrials() + " / " + trialCounter.getMaxTrials());

        String input = inputHandler.inputWord();
        trialCounter.increment();

        WordResult result = comparator.compare(input, todayWord);

        if (result.isPerfect()) {
            trialCounter.solveTheAnswer();
        }

        drawer.addResult(result);
        drawer.showPrompt();
    }
}
