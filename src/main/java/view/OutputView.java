package view;

import domain.LetterResults;

import java.util.List;

public class OutputView {
    private static final String TOTAL_TRY = " / 6";
    private static final String GAME_QUIT = "게임이 종료 되었습니다";
    private static final String NOT_EXIST = "단어 목록에 존해하지 않습니다";

    public static void quit(int count){
        System.out.println(GAME_QUIT);
        System.out.println(count + TOTAL_TRY);
    }

    public static void notExist(){
        System.out.println(NOT_EXIST);
    }

    public static void result(List<LetterResults> letterResults){
        System.out.println(letterResults);
    }
}
