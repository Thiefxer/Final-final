
public class TileFactory {
	public GameTile setTurn(int turn) {
		if (turn % 2 == 0) {
			return new XTile();
		} else {
			return new OTile();
		}
	}
}
