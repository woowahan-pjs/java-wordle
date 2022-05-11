package model;

import static model.Result.EXIST;
import static model.Result.MATCH;
import static model.Result.NON_EXIST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Characters {

    public static final String OUT_OF_WORD_LENGTH_ERR_MSG = "문자열의 길이가 5자가 아닙니다.(입력된 문자열의 길이는 %d입니다.)";
    private static final int WORD_LENGTH = 5;

    private final List<Character> characters;

    public Characters(String inputString) {
        validate(inputString);
        this.characters = createCharacters(inputString);
    }

    private List<Character> createCharacters(String inputString) {
        List<Character> characterList = new ArrayList<>();
        String[] split = inputString.split("");
        for (int i = 0; i < WORD_LENGTH; i++) {
            characterList.add(new Character(split[i], i));
        }
        return characterList;
    }

    public List<Character> convertToList() {
        return characters;
    }

    private void validate(String value) {
        if (value.length() != WORD_LENGTH) {
            throw new IllegalArgumentException(String.format(OUT_OF_WORD_LENGTH_ERR_MSG, value.length()));
        }
    }

    public Results match(Characters answer) {
        Map<Character, Character> check = new HashMap<>();

        List<Result> list = new ArrayList<>();
        for (Character input : characters) {
            inputMatchAnswer(input, answer, check);
            list.add(NON_EXIST);
        }

        for (Character ans : answer.characters) {
            if (check.containsKey(ans)) {
                Character input = check.get(ans);
                list.set(input.getPosition(), input.isSame(ans));
            }
        }

        return new Results(list);
    }

    private void inputMatchAnswer(Character input, Characters answer, Map<Character, Character> check) {
        for (Character ans : answer.characters) {
            if (input.isSame(ans) == MATCH) {
                check.put(ans, input);
                return;
            }
            if (input.isSame(ans) == EXIST && !check.containsKey(ans)) {
                check.put(ans, input);
            }
        }
    }
}
