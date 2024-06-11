package wordle.domain.word;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Letter {
    private static final Map<Character, Letter> cache = new HashMap<>();

    static {
        for (char c = 'a'; c <= 'z'; c++) {
            cache.put(c, new Letter(c));
        }
    }

    private final char ch;

    private Letter(char ch) {
        validateAlpha(ch);
        this.ch = ch;
    }

    private static void validateAlpha(char ch) {
        if (ch > 'z' || ch < 'a') {
            throw new IllegalArgumentException("shoud be alphabet");
        }
    }

    public static Letter from(char ch) {
        validateAlpha(ch);
        return cache.get(ch);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter letter = (Letter) o;
        return ch == letter.ch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ch);
    }
}
