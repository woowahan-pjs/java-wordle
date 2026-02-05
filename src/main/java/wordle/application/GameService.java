package wordle.application;

import wordle.domain.game.Game;
import wordle.domain.game.GameInput;
import wordle.domain.game.GameResult;
import wordle.domain.game.validation.ValidationStatus;
import wordle.domain.matching.MatchResult;
import wordle.domain.word.Word;

public class GameService {

    private final Word wordleWord;
    private final Game wordleGame;
    private final GameResult gameResult;
    private final OutputPort outputPort;

    public GameService(Word wordleWord, Game wordleGame, GameResult gameResult, OutputPort outputPort) {
        this.wordleWord = wordleWord;
        this.wordleGame = wordleGame;
        this.gameResult = gameResult;
        this.outputPort = outputPort;
    }

    public String run(String userInput) {
        if (!wordleGame.canTry()) {
            return outputPort.makeTryCountErrorText();
        }

        GameInput input = new GameInput(userInput);
        ValidationStatus validationStatus = wordleWord.check(input);

        if (validationStatus != ValidationStatus.VALID) {
            return makeErrorMessage(validationStatus);
        }

        MatchResult[] resultArray = wordleWord.match(input);
        gameResult.addBoard(resultArray);
        wordleGame.checkFinished();

        return outputPort.makeBoardText(gameResult.getBoardList());
    }

    private String makeErrorMessage(ValidationStatus status) {
        return switch (status) {
            case INVALID_LENGTH -> outputPort.makeLengthErrorText();
            case NOT_ALPHABET -> outputPort.makeAlphabetErrorText();
            case NOT_IN_DICTIONARY -> outputPort.makeNotFoundErrorText();
            case NULL_INPUT -> outputPort.makeInvalidInputText();
            default -> "";
        };
    }
}
