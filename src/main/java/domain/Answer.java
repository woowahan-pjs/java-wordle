package domain;

import java.util.*;

public class Answer {
    private final Word answerWord;

    private Answer(Word answerWord) {
        this.answerWord = answerWord;
    }

    public static Answer from(String input) {
        return new Answer(Word.from(input));
    }

    public Result compare(Word word) {
        List<MatchStatus> matchStatuses = new ArrayList<>();
        Map<Character, Integer> charMap = new HashMap<>();
        for (Letter letter : answerWord.getLetters()) {
            charMap.put(letter.getLetter(), charMap.getOrDefault(letter.getLetter(), 0) + 1);
        }
        for (int i = 0; i < word.getLetters().size(); i++) {
            if (word.getLetters().get(i).getLetter().equals(answerWord.getLetters().get(i).getLetter())) {
                if (charMap.get(word.getLetters().get(i).getLetter()) > 0) {
                    charMap.put(word.getLetters().get(i).getLetter(), charMap.get(word.getLetters().get(i).getLetter()) - 1);
                    matchStatuses.add(MatchStatus.GREEN);
                    continue;
                }
                matchStatuses.add(MatchStatus.GRAY);
                continue;
            }
            if (charMap.containsKey(word.getLetters().get(i).getLetter())) {
                matchStatuses.add(MatchStatus.YELLOW);
                continue;
            }
            matchStatuses.add(MatchStatus.GRAY);
        }


        return new Result(matchStatuses);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Answer answer = (Answer) o;

        return Objects.equals(answerWord, answer.answerWord);
    }

    @Override
    public int hashCode() {
        return answerWord != null ? answerWord.hashCode() : 0;
    }
}
