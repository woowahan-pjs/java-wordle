package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Characters {

    private static final int WORD_LENGTH = 5;

    private List<Character> characterList;

    public Characters(String inputString) {
        validate(inputString);
        List<Character> characterList = new ArrayList<>();
        String[] split = inputString.split("");
        for (int i = 0; i < WORD_LENGTH; i++) {
            characterList.add(new Character(split[i], i));
        }
        this.characterList = characterList;
    }

    public List<Character> getCharacters() {
        return characterList;
    }

    private void validate(String value) {
        if (value.length() != WORD_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
    //Todo 현재 메서드에서는 두 가지 일을 하는것 같다. 분리해보자. set을 통해 값을 변경하고 있는데 이 부분을 불변으로 바꿀수는 없을까?
    public List<Result> match(Characters answer) {
        Map<Character,Character> check = new HashMap<>();

        List<Result> list = new ArrayList<>();
        for (Character input : characterList) {
            inputMatchAnswer(input, answer, check);
            list.add(Result.NON_EXIST);
        }

        for (Character ans : answer.characterList) {
            if(check.containsKey(ans)){
                Character input = check.get(ans);
                list.set(input.getPosition(), input.isSame(ans));
            }
        }

        return list;
    }
    //Todo Character로 로직 이동을 할 수 있지 않을까?
    private void inputMatchAnswer(Character input, Characters answer, Map<Character, Character> check) {
        for (Character ans : answer.characterList) {
            if(input.isSame(ans) == Result.MATCH){
                check.put(ans,input);
                return;
            }
            if(input.isSame(ans) == Result.EXIST && !check.containsKey(ans)){
                check.put(ans,input);
            }
        }
    }
}
