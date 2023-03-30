package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Answer {

    private final Word answer;

    public Answer(Word answer) {
        this.answer = answer;
    }

    public List<Tile> compare(Word answer) {
        // 위치와 글자가 맞으면 초록색
        // 위치가 틀리고, 글자가 맞으면 노란색
        // 위치와 글자가 틀리면 회색
        List<Tile> tiles = new ArrayList<>();

        Map<Letter, Long> letterMap = this.answer.getWord()
                                           .stream()
                                           .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        for (int i = 0; i < 5; i++) {
            Long count = letterMap.get(answer.getWord().get(i));

            if (Objects.isNull(count) || count == 0) {
                tiles.add(Tile.GRAY);
            } else {
                if (this.answer.getWord().get(i).equals(answer.getWord().get(i))) {
                    tiles.add(Tile.GREEN);
                } else {
                    tiles.add(Tile.YELLOW);
                }
                letterMap.put(answer.getWord().get(i), count - 1);
            }
        }

        return tiles;
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
