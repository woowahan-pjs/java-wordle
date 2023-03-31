package domain;

import java.util.*;
import java.util.stream.Collectors;

public class Answer {

    private final Word answer;

    private boolean isSuccess = false;

    public Answer(Word answer) {
        this.answer = answer;
    }

    public List<Tile> compare(Word answer) {
        Map<Letter, Long> letterMap = getLetterMap();

        List<Tile> result = new ArrayList<>();

        for (int i = 0; i < Word.WORD_LENGTH; i++) {
            Long count = letterMap.get(answer.getWord().get(i));

            Tile tile = getTile(count, this.answer.getWord().get(i), answer.getWord().get(i));
            result.add(tile);

            letterMap.put(answer.getWord().get(i), letterMap.getOrDefault(answer.getWord().get(i), 0L) - 1);
        }
        endGame(result);

        return result;
    }

    private Map<Letter, Long> getLetterMap() {
        return this.answer.getWord()
                .stream()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }

    private void endGame(List<Tile> result) {
        int count = Collections.frequency(result, Tile.GREEN);

        if (count == Word.WORD_LENGTH) {
            this.isSuccess = true;
        }
    }

    private Tile getTile(Long count, Letter answerLetter, Letter letter) {
        if (count == null || count <= 0) {
            return Tile.GRAY;
        }
        if (answerLetter.equals(letter)) {
            return Tile.GREEN;
        }
        return Tile.YELLOW;
    }

    public boolean isSuccess() {
        return isSuccess;
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

    @Override
    public String toString() {
        return "Answer{" +
                "answer=" + answer +
                '}';
    }
}
