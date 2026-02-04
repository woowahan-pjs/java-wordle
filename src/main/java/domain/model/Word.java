package domain.model;

import application.port.OutputPort;
import domain.port.WordRepository;

import static java.util.Objects.isNull;

import java.util.HashMap;
import java.util.Map;

public class Word {

    private Answer answer;
    private Input input;
    private WordRepository wordRepository;
    private OutputPort outputPort;

    public Word(Input input, Answer answer, WordRepository wordRepository, OutputPort outputPort) {
        this.input = input;
        this.answer = answer;
        this.wordRepository = wordRepository;
        this.outputPort = outputPort;
    }

    public boolean valid() {
        // TODO. 정책 논의 필요 (횟수 차감 여부) -> 차감 해버리기
        if (!validWord(input.getValue())) return false;

        if (!validNull(input.getValue())) return false;

        if (!validLength(input.getValue())) return false;

        if (!validAlphabet(input.getValue())) return false;

        return true;
    }

    public boolean validWord(String input) {
        if(!this.wordRepository.hasWord(input)){
            System.out.println(this.outputPort.getHasNotWordRepository());
            return false;
        }
        return true;
    }

    public boolean validNull(String input) {
        if (isNull(input)) {
            System.out.println(this.outputPort.getInvalidInputMessage());
            return false;
        }
        return true;
    }

    public boolean validLength(String input) {
        if (input.length() != WordCondition.입력_제한_길이.getValue()) {
            System.out.println(this.outputPort.getLengthMismatchMessage());
            return false;
        }
        return true;
    }

    public boolean validAlphabet(String input) {
        if (!input.matches("(?i)[a-z]+")) {
            System.out.println(this.outputPort.getNotAlphabetMessage());
            return false;
        }
        return true;
    }

    // 입력 : APPLE
    // 답 : AIRPO
    public void compareAnswer() {
        String answer = this.answer.getValue();
        String input = this.input.getValue();
        int length = answer.length();

        ResultValues[] results = new ResultValues[length];

        // 답안지의 문자 개수를 카운팅하여 Map에 저장한다.
        Map<Character, Integer> remain = getAnswerRemainCount(length, answer);

        // 1차: 초록색 판정
        checkedGreen(length, input, answer, results, remain);

        // 2차: 노란색 / 회색 판정
        checkedNotGreen(length, results, input, remain);

        // 결과 저장
        saveResults(results);
    }

    private void saveResults(ResultValues[] results) {
        for (ResultValues r : results) {
            this.input.saveTile(r.getValue());
        }
    }

    private void checkedNotGreen(int length, ResultValues[] results, String input,
        Map<Character, Integer> remain) {
        for (int i = 0; i < length; i++) {
            if (results[i] != null) {
                continue;
            }

            char in = Character.toLowerCase(input.charAt(i));
            int count = remain.getOrDefault(in, 0);

            if (count > 0) {
                results[i] = ResultValues.옐로우;
                remain.put(in, count - 1);
            }


            if (count == 0) {
                results[i] = ResultValues.그레이;
            }
        }
    }

    private static void checkedGreen(int length, String input, String answer, ResultValues[] results,
        Map<Character, Integer> remain) {
        for (int i = 0; i < length; i++) {
            char in = Character.toLowerCase(input.charAt(i));
            char ans = Character.toLowerCase(answer.charAt(i));

            if (in == ans) {
                results[i] = ResultValues.그린;
                remain.put(in, remain.get(in) - 1); // 소비
            }
        }
    }

    public HashMap<Character, Integer> getAnswerRemainCount(int length, String answer) {
        // 정답 문자 개수 카운트>
        HashMap<Character, Integer> remain = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = Character.toLowerCase(answer.charAt(i));
            remain.put(c, remain.getOrDefault(c, 0) + 1);
        }

        return remain;
    }
}
