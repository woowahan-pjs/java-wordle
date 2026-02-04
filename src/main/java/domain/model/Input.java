package domain.model;

public class Input {

    private String value;
    private Result result;

    public Input(String value, Result result) {
        this.value = value;
        this.result = result;
    }

    public void saveTile(String tile){
        result.addTile(tile);
    }

    public String getValue() {
        return this.value;
    }


}
