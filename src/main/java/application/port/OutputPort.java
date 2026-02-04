package application.port;

public interface OutputPort {

    String getWelcomeMessage();

    String getInputInfoMessage();

    String getBoards(StringBuilder[] boards);

    String getHasNotWordRepository();

    String getInvalidInputMessage();

    String getLengthMismatchMessage();

    String getNotAlphabetMessage();

    String getTryCountExceededMessage();
}
