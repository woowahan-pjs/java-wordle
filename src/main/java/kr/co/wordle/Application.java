package kr.co.wordle;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Answer answer = new Answer();
        Console console = new Console();
        console.init();

        while (true) {
            String input = console.inputView();
            Round round = new Round(input);
            Map<Tile, Integer> result = round.roundResult(answer);

            if (result.getOrDefault(Tile.GREEN, 0) == 5) {
                System.out.println("끝");
                break;
            }
            System.out.println("다시");
        }
    }
}
