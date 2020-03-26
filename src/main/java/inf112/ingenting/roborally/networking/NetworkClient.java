package inf112.ingenting.roborally.networking;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.strongjoshua.console.LogLevel;
import inf112.ingenting.roborally.gui.GameConsole;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

public class NetworkClient {
	private Client client;

	public NetworkClient() {
		client = new Client();
		client.start();

		Network.registerObjects(client);
		addListeners();
	}

	public void connect(String ip) throws IOException {
		client.connect(Network.DEFAULT_CLIENT_CONNECTION_TIMEOUT, ip, Network.DEFAULT_PORT_TCP);
	}

	public void connect(String ip, int tcpPort) throws IOException {
		client.connect(Network.DEFAULT_CLIENT_CONNECTION_TIMEOUT, ip, tcpPort);
	}

	public List<InetAddress> findHosts() {
		return client.discoverHosts(Network.DEFAULT_PORT_TCP, Network.DEFAULT_CLIENT_CONNECTION_TIMEOUT);
	}

	public List<InetAddress> findHosts(int port) {
		return client.discoverHosts(port, Network.DEFAULT_CLIENT_CONNECTION_TIMEOUT);
	}

	public List<InetAddress> findHosts(int port, int timeout) {
		return client.discoverHosts(port, timeout);
	}

	public void disconnect() {
		client.close();
	}

	public void sendMessage(NetworkMessage message) {
		client.sendTCP(message);
	}

	public boolean isConnected() {
		return client.isConnected();
	}

	public void dispose() {
		client.stop();
	}

	private void addListeners() {
		client.addListener(new Listener() {
			public void received(Connection connection, Object object) {
				if (object instanceof NetworkMessage) {
					NetworkMessage networkMessage = (NetworkMessage) object;

					if (networkMessage.networkStatus == NetworkFlag.CHAT_MESSAGE)
						GameConsole.getInstance().log(networkMessage.name + ": " + networkMessage.message);

					if (networkMessage.networkStatus == NetworkFlag.LOG_ERROR)
						GameConsole.getInstance().log(networkMessage.message, LogLevel.ERROR);
				}
			}
		});
	}
}
