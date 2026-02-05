package wordle.infrastructure.ui;

import wordle.application.OutputPort;
import wordle.domain.word.WordCondition;

import java.util.List;
import java.util.Objects;

public class ConsoleUI implements OutputPort {

    private static final int MAX_TRY_COUNT = WordCondition.MAX_TRY_COUNT.value();

    @Override
    public String makeWelcomeText() {
        return String.format("WORDLE을 %d 번 만에 맞춰 보세요.\n"
                + "시도의 결과는 타일의 색 변화로 나타납니다. ", MAX_TRY_COUNT);

    }

    @Override
    public String makeInputInfoText() {
        return "정답을 입력해 주세요.";
    }

    @Override
    public String makeBoardText(List<String> boardList) {
        StringBuilder boardStringBuilder = new StringBuilder();
        for (String board : boardList) {
            if (Objects.nonNull(board)) {
                boardStringBuilder.append(board).append("\n");
            }
        }
        return boardStringBuilder.toString();
    }

    @Override
    public String makeNotFoundErrorText() {
        return "답안은 `words.txt`에 존재하는 단어여야 합니다";
    }

    @Override
    public String makeInvalidInputText() {
        return "잘못된 입력입니다.";
    }

    @Override
    public String makeLengthErrorText() {
        return "길이가 일치하지 않습니다.";
    }

    @Override
    public String makeAlphabetErrorText() {
        return "단어는 알파벳이어야 합니다.";
    }

    @Override
    public String makeTryCountErrorText() {
        return "입력 제한 횟수를 넘어 갑니다";
    }
}
