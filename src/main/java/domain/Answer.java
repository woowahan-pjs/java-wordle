package domain;

public class Answer {

    private final Tiles tiles;

    public Answer(Tiles tiles) {
        this.tiles = tiles;
    }
    public boolean matches(Tiles tiles){
        return this.tiles.equals(tiles);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "tiles=" + tiles +
                '}';
    }
}
