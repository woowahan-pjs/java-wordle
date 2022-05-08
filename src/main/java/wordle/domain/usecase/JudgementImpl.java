package wordle.domain.usecase;

import wordle.domain.design.Judgement;
import wordle.domain.vo.Color;
import wordle.domain.vo.JudgeResult;
import wordle.domain.vo.UserWord;

/**
 * 판별 결과는 흰색의 타일이 세 가지 색(초록색/노란색/회색) 중 하나로 바뀌면서 표현된다. 맞는 글자는 초록색, 위치가 틀리면 노란색, 없으면 회색 두 개의 동일한 문자를 입력하고 그중 하나가 회색으로 표시되면
 * 해당 문자 중 하나만 최종 단어에 나타난다.
 */
public class JudgementImpl implements Judgement {
    @Override
    public JudgeResult execute(String answer, UserWord input) {
        boolean[] ansUsed = new boolean[input.getValue().length()];
        boolean[] inputUsed = new boolean[input.getValue().length()];
        JudgeResult result = new JudgeResult(answer.length());

        getGreenResult(answer, input.getValue(), ansUsed, inputUsed, result);
        getYellowResult(answer, input.getValue(), ansUsed, inputUsed, result);
        getGrayResult(inputUsed, result);
        return result;
    }

    private void getGreenResult(String ans, String input, boolean[] ansUsed, boolean[] inputUSed,
                                JudgeResult judgeResult) {
        for (int i = 0; i < input.length(); ++i) {
            checkGreen(ans.charAt(i), input.charAt(i), ansUsed, inputUSed, judgeResult, i);
        }
    }

    private void checkGreen(char input, char ans, boolean[] ansUsed, boolean[] inputUSed, JudgeResult result, int idx) {
        if (ans == input) {
            ansUsed[idx] = true;
            inputUSed[idx] = true;
            result.setColor(idx, Color.GREEN);
        }
    }

    private void getYellowResult(String ans, String input, boolean[] ansUsed, boolean[] inputUSed,
                                 JudgeResult judgeResult) {
        for (int i = 0; i < input.length(); ++i) {
            if (inputUSed[i]) {
                continue;
            }
            for (int j = 0; j < ans.length(); ++j) {
                if (!ansUsed[j] && (input.charAt(i) == ans.charAt(j))) {
                    ansUsed[j] = true;
                    inputUSed[i] = true;
                    judgeResult.setColor(i, Color.YELLOW);
                    break;
                }
            }
        }
    }

    private void getGrayResult(boolean[] inputUsed, JudgeResult judgeResult) {
        for (int i = 0; i < inputUsed.length; ++i) {
            if (!inputUsed[i]) {
                judgeResult.setColor(i, Color.GRAY);
            }
        }
    }
}
