package view.input;

import java.util.Scanner;

public class InputView {

    private InputView() { }

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputPlayerWordle() {
        return SCANNER.nextLine();
    }

}
