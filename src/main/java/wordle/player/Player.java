package wordle.player;

import camp.nextstep.edu.missionutils.Console;
import wordle.domain.Words;

public class Player {

    public Words inputWords() {
        return new Words(Console.readLine());
    }

}
