package inf112.ingenting.roborally.networking;

public class NetworkTestHelper {
	public NetworkHost host;
	public NetworkClient client;
	public Network.NetworkType networkType;

	public void createHost() {
		host = new NetworkHost();
		networkType = Network.NetworkType.HOST;
	}

	public void createClient() {
		client = new NetworkClient();
		networkType = Network.NetworkType.CLIENT;

	}
}
