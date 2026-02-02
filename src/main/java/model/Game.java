package model;

import controller.WordInputHandler;
import view.WordDrawer;

import java.util.List;

public class Game {

    private final String todayWord;
    private final TrialCounter trialCounter;
    private final WordInputHandler inputHandler;
    private final WordComparator wordComparator;

    public Game(String todayWord) {
        this.todayWord = todayWord;
        this.trialCounter = new TrialCounter();
        this.inputHandler = new WordInputHandler();
        this.wordComparator = new WordComparator();
    }

    public void play() {
        while (trialCounter.keepTrying()) {
            System.out.println("정답을 입력해 주세요.");
            processInput(inputHandler.inputWord());
        }
        WordDrawer.showTheEnd(trialCounter.isGameOver(), trialCounter.getTrials());
    }

    private void processInput(String input) {
        trialCounter.increment();
        List<Integer> partial = wordComparator.getPartialMatchedIndex(input, todayWord);
        List<Integer> perfect = wordComparator.getPerfectMatchedIndex(input, todayWord);
        if (perfect.size() == 5) {
            trialCounter.gameOver();
        }
        WordDrawer.draw(partial, perfect);
        WordDrawer.showPrompt(trialCounter.getTrials());
    }
}
