package domain;

import java.util.List;
import java.util.Objects;

public class Colors {
    private static final List<Color> ALL_GREEN = List.of(Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN);
    private final List<Color> colors;

    public Colors(List<Color> colors) {
        this.colors = colors;
    }

    public void add(Color color) {
        colors.add(color);
    }

    public boolean isAllGreen() {
        return ALL_GREEN.equals(colors);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colors colors1 = (Colors) o;
        return Objects.equals(colors, colors1.colors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colors);
    }
}
