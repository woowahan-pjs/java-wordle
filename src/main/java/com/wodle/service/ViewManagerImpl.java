package com.wodle.service;

import com.wodle.domain.Result;
import com.wodle.domain.TileColor;
import com.wodle.domain.Word;
import java.util.LinkedList;
import java.util.List;

public class ViewManagerImpl implements ViewManager{

    private static final String FAIL_RESULT_TEXT = "실패 하셨습니다.";
    private static final String SUCCESS_RESULT_TEXT = "성공 하셨습니다.";
    private static final String TODAY_WORD_PREFIX = "오늘의 단어 ";
    private static final String REQUEST_WORD_TEXT = "정답을 입력해 주세요.";
    private static final String INPUT_WORD_ERROR_TEXT = "단어는 소문자 5개로 구성된 영단어입니다.";
    private static final String GAME_INITIALIZING_TEXT = "WORDLE을 6번 만에 맞춰 보세요.\n"
        + "시도의 결과는 타일의 색 변화로 나타납니다.";

    private final List<List<TileColor>> wordMatchResults;

    public ViewManagerImpl() {
        wordMatchResults = new LinkedList<>();
    }

    public void printGameStart() {
        System.out.println(GAME_INITIALIZING_TEXT);
    }

    public void printRequestWordInput() {
        System.out.println(REQUEST_WORD_TEXT);
    }

    public void notifyInvalidInputWord() {
        System.out.println(INPUT_WORD_ERROR_TEXT);
    }

    public void printCompareResult(Result woreCompareResult) {
        wordMatchResults.add(woreCompareResult.getMatchStatus());

        for (List<TileColor> wordMatchResult : wordMatchResults) {
            print(wordMatchResult);
            System.out.println();
        }
    }

    public void printResult(boolean isGameEnd, Word todayWord) {
        if (isGameEnd) {
            successResultPrint();
            return;
        }

        failResultPrint(todayWord);
    }

    private void failResultPrint(Word todayWord) {
        System.out.println(FAIL_RESULT_TEXT);
        System.out.println(TODAY_WORD_PREFIX + todayWord.getWord());
    }

    private void successResultPrint() {
        System.out.println(SUCCESS_RESULT_TEXT);
    }

    private void print(List<TileColor> curWordMatchResult) {
        for (TileColor tileColor : curWordMatchResult) {
            System.out.print(tileColor.getPrint());
        }
    }
}
