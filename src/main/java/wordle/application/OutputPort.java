package wordle.application;

import java.util.List;

public interface OutputPort {

    String makeWelcomeText();

    String makeInputInfoText();

    String makeBoardText(List<String> boardList);

    String makeNotFoundErrorText();

    String makeInvalidInputText();

    String makeLengthErrorText();

    String makeAlphabetErrorText();

    String makeTryCountErrorText();
}
