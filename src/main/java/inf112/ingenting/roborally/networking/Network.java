package inf112.ingenting.roborally.networking;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

public class Network {
	public final static int DEFAULT_PORT_TCP = 54555;
	public final static int DEFAULT_PORT_UDP = 54777;
	public final static int DEFAULT_CLIENT_CONNECTION_TIMEOUT = 5000;

	private static Network instance;

	public NetworkHost host;
	public NetworkClient client;

	public enum NetworkType {
		CLIENT, HOST, NONE
	}

	public NetworkType networkType;

	private Network() {
		networkType = NetworkType.NONE;
	}

	public static Network getInstance() {
		if (instance == null)
			instance = new Network();

		return instance;
	}

	public void createHost() {
		if (networkType != NetworkType.NONE) {
			if (host != null) {
				host.dispose();
				host = null;
			}

			if (client != null) {
				client.dispose();
				client = null;
			}
		}

		host = new NetworkHost();
		networkType = NetworkType.HOST;
	}

	public void createClient() {
		if (networkType != NetworkType.NONE) {
			if (host != null) {
				host.dispose();
				host = null;
			}

			if (client != null) {
				client.dispose();
				client = null;
			}
		}

		client = new NetworkClient();
		networkType = NetworkType.CLIENT;

	}

	public NetworkType getNetworkType() {
		return networkType;
	}

	public static void registerObjects(EndPoint endpoint) {
		Kryo kryo = endpoint.getKryo();
		kryo.register(NetworkMessage.class);
	}
}
