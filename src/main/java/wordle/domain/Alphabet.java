package wordle.domain;

import java.util.Arrays;

public enum Alphabet {
    a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z,
    A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;

    public static Alphabet of(final int codePoint) {
        return of(Character.toChars(codePoint));
    }

    public static Alphabet of(final char[] chars) {
        return of(String.valueOf(chars));
    }

    public static Alphabet of(final String alphabet) {
        return Arrays.stream(values())
                .filter(it -> it.name().equals(alphabet))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
