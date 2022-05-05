package domain;

public interface Words {
    Letters getTodayWords();

    boolean contains(Letters letter);

    default void isContains(Letters letter) {
        if (!contains(letter)) {
            throw new IllegalArgumentException("해당 단어가 없습니다.");
        }
    }
}
