package wordle.impl;

import wordle.design.Judgement;
import wordle.vo.Color;
import wordle.vo.JudgeResult;

/**
 * 판별 결과는 흰색의 타일이 세 가지 색(초록색/노란색/회색) 중 하나로 바뀌면서 표현된다. 맞는 글자는 초록색, 위치가 틀리면 노란색, 없으면 회색 두 개의 동일한 문자를 입력하고 그중 하나가 회색으로 표시되면
 * 해당 문자 중 하나만 최종 단어에 나타난다.
 */
public class JudgementImpl implements Judgement {
    @Override
    public JudgeResult execute(String answer, String input) {
        boolean[] check = new boolean[input.length()];
        JudgeResult result = new JudgeResult();

        getGreenResult(answer, input, check, result);
        getYellowResult(answer, input, check, result);
        getGrayResult(check, result);
        return result;
    }

    private void getGreenResult(String ans, String input, boolean[] check, JudgeResult judgeResult) {
        for (int i = 0; i < input.length(); ++i) {
            checkGreen(ans.charAt(i), input.charAt(i), check, judgeResult, i);
        }
    }

    private void checkGreen(char input, char ans, boolean[] check, JudgeResult result, int idx) {
        if (ans == input) {
            check[idx] = true;
            result.setColor(idx, Color.GREEN);
        }
    }

    private void getYellowResult(String ans, String input, boolean[] check, JudgeResult judgeResult) {
        for (int i = 0; i < input.length(); ++i) {
            for (int j = 0; j < ans.length(); ++j) {
                if (!check[j] && input.charAt(i) == ans.charAt(j)) {
                    check[j] = true;
                    judgeResult.setColor(i, Color.YELLOW);
                    break;
                }
            }
        }
    }

    private void getGrayResult(boolean[] check, JudgeResult judgeResult) {
        for(int i=0;i<check.length;++i) {
            if(!check[i]) {
                judgeResult.setColor(i, Color.GRAY);
            }
        }
    }


    /*
    1. Green 인 것 부터 찾는다. -> index, color 모두 맞아야함
    2. Yellow 인 것을 찾는다. -> index 는 틀려야되고 color 는 같아야함
    3. 나머진 Gray 로 처리한다.
    단 답에는 존재하지만 유저 인풋에 두 개인 문자가 있을 수 있으므로
    check 배열을 사용해야 할 것 같다.
    결과는 Green Gray or Yellow Gray 가 되야한다.
     */
}
