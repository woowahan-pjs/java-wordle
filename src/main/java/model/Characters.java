package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    public List<String> match(Characters answer) {
        List<Character> answerTemp = answer.characterList;
        String[] answerGroup = new String[WORD_LENGTH];
        Arrays.fill(answerGroup, "nonExist");

        for (int index = 0; index < WORD_LENGTH; index++) {
            if (characterList.get(index).isSame(answerTemp.get(index)).equals("match")) {
                answerGroup[index] = "match";
                answerTemp.remove(index);
            }
        }

        for (int index = 0; index < WORD_LENGTH; index++) {
            if (!answerGroup[index].equals("match")) {
                answerGroup[index] = inputMatchAnswer(characterList.get(index), answerTemp);
                answerTemp.remove(index);
            }
        }

        return List.of(answerGroup);
    }

    public String inputMatchAnswer(Character character, List<Character> answerTemp) {
        String result = "nonExist";

        for (int index = 0; index < answerTemp.size(); index++) {
            if (character.isSame(answerTemp.get(index)).equals("exist")) {
                result = "exist";
            }
        }

        return result;
    }
}
