package wordle.util;

import java.util.Scanner;

public class InputReader {

    public String getUserInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
