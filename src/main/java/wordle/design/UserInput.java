package wordle.design;

import wordle.vo.UserWord;

public interface UserInput {
    public UserWord execute(); // 유저의 인풋을 입력받는다.
}
