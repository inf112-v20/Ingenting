package inf112.ingenting.roborally.networking;

/**
 * Class used for communicating information between network players.
 *
 * Currently supports chat messages, but can later be extended to communicate status messages, etc.
 */
public class NetworkMessage {
	public String name;
	public String message;
	public NetworkFlag networkStatus;

	public NetworkMessage setName(String name) {
		this.name = name;

		return this;
	}

	public NetworkMessage setMessage(String message) {
		this.message = message;

		return this;
	}

	public NetworkMessage setNetworkStatus(NetworkFlag flag) {
		networkStatus = flag;

		return this;
	}
}
