package com.wodle.service;

import com.wodle.domain.Result;
import com.wodle.domain.Word;

public interface ViewManager {
    void printGameStart();
    void printRequestWordInput();
    void notifyInvalidInputWord();
    void printCompareResult(Result woreCompareResult);
    void printResult(boolean isGameEnd, Word todayWord);
}
