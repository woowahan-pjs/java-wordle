package domain;

public interface Words {
    Letters getTodayWords();

    boolean contains(final Letters letter);

    default void isContains(final Letters letter) {
        if (!contains(letter)) {
            throw new IllegalArgumentException("해당 단어가 없습니다.");
        }
    }
}
