package inf112.ingenting.roborally.networking;

import com.badlogic.gdx.utils.Array;
import inf112.ingenting.roborally.player.Player;

public class PlayerPacket {
	public Array<Player> players;

	public PlayerPacket() {
		players = new Array<>();
	}

	public PlayerPacket(Array<Player> players) {
		this.players = players;
	}
}
