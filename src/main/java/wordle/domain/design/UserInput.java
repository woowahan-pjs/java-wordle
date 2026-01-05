package wordle.domain.design;

import wordle.domain.vo.UserWord;

public interface UserInput {
    UserWord execute(); // 유저의 인풋을 입력받는다.

    void end();
}
