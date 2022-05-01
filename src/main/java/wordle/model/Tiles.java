package wordle.model;

public class Tiles {

	private TileStatus[] status;

	public Tiles(TileStatus[] status) {
		this.status = status;
	}

	public TileStatus[] getStatus() {
		return status;
	}
}
