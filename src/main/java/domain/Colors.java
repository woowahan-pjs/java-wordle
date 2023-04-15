package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Colors {

    private static final Colors ALL_GREENS = new Colors(
        List.of(Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN));

    private final List<Color> colors;

    public Colors(Color... colors) {
        this(Arrays.stream(colors)
            .collect(Collectors.toList()));
    }

    public Colors(List<Color> colors) {
        this.colors = colors;
    }

    public boolean isAllGreen() {
        return ALL_GREENS.equals(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Colors colors1 = (Colors) o;
        return Objects.equals(colors, colors1.colors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colors);
    }

    @Override
    public String toString() {
        return colors.toString();
    }
}
