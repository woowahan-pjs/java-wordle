package view;

import domain.LetterResults;

public class OutputView {
    private static final String GAME_QUIT = "게임이 종료 되었습니다";
    private static final String NOT_EXIST = "단어 목록에 존해하지 않습니다";
    private static final String ANSWER = "정답입니다";


    public static void quit(){
        System.out.println(GAME_QUIT);
    }

    public static void notExist(){
        System.out.println(NOT_EXIST);
    }

    public static void answer(){
        System.out.println(ANSWER);
    }

    public static void result(LetterResults letterResults){
        System.out.println(letterResults);
    }
}
