package wordle.domain.design;

public interface GameManager {
    void start(); //WORDLE을 6번 만에 맞춰 보세요. 시도의 결과는 타일의 색 변화로 나타납니다.

    void end(); // 게임 종료시킴
}
