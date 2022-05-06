package wordle.model;

public class TileLine {

	private TileStatus[] status;

	public TileLine(TileStatus[] status) {
		this.status = status;
	}

	public TileStatus[] getAllStatus() {
		return status;
	}
}
