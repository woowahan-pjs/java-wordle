package model;

import java.util.List;

public class WordSelector {

    private final WordIndexCalculator calculator;
    private final List<String> words;

    WordSelector(WordIndexCalculator calculator, List<String> words) {
        this.calculator = calculator;
        this.words = words;
    }

    public String getTodayWord() {
        long todayIndex = calculator.getTodayWordIndex();
        return words.get((int) todayIndex);
    }
}
