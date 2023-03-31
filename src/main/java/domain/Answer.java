package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Answer {

    private final Word answer;

    private final Map<Letter, Long> letterMap;

    public Answer(Word answer) {

        this.answer = answer;
        this.letterMap = answer.getWord()
                            .stream()
                            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }

    public List<Tile> compare(Word answer) {
        List<Tile> result = new ArrayList<>();

        for (int i = 0; i < Word.WORD_LENGTH; i++) {
            Letter inputLetter = answer.getWord().get(i);
            Letter answerLetter = this.answer.getWord().get(i);
            Long count = letterMap.get(inputLetter);

            Tile tile = getTile(count, answerLetter, inputLetter);
            result.add(tile);

            decreaseCountIfAnswerCorrect(tile, inputLetter, count);
        }

        return result;
    }

    private void decreaseCountIfAnswerCorrect(Tile tile, Letter inputLetter, Long count) {
        if (tile.isNotWrong()) {
            letterMap.put(inputLetter, count - 1);
        }
    }

    private Tile getTile(Long count, Letter answerLetter, Letter letter) {
        if (count == null || count == 0) {
            return Tile.GRAY;
        }
        if (answerLetter.equals(letter)) {
            return Tile.GREEN;
        }
        return Tile.YELLOW;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer that = (Answer) o;
        return Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer);
    }
}
