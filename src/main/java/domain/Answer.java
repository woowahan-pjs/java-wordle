package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Answer {

    private final Word correctAnswer;

    public Answer(Word correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<Tile> compare(Word answer) {
        // 위치와 글자가 맞으면 초록색
        // 위치가 틀리고, 글자가 맞으면 노란색
        // 위치와 글자가 틀리면 회색
        List<Tile> tiles = new ArrayList<>();

        Map<Character, Long> map = this.correctAnswer.getWord()
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        for (int i = 0; i < 5; i++) {
            Long count = map.get(answer.getWord().charAt(i));

            if (Objects.isNull(count) || count == 0) {
                tiles.add(Tile.GRAY);
            } else {
                if (this.correctAnswer.getWord().charAt(i) == answer.getWord().charAt(i)) {
                    tiles.add(Tile.GREEN);
                } else {
                    tiles.add(Tile.YELLOW);
                }
                map.put(answer.getWord().charAt(i), count - 1);
            }
        }

        return tiles;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer that = (Answer) o;
        return Objects.equals(correctAnswer, that.correctAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correctAnswer);
    }
}
