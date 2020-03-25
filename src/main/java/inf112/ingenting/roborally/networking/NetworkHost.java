package inf112.ingenting.roborally.networking;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import java.io.IOException;

public class NetworkHost {
	private Server server;

	public NetworkHost() {
		server = new Server();
		server.start();

		Network.registerNetworkObjects(server);
		addListeners();
	}

	public void setPort(int tcp) throws IOException {
		server.bind(tcp);
	}

	public void dispose() {
		server.stop();
	}

	private void addListeners() {
		server.addListener(new Listener() {
			public void received(Connection connection, Object object) {
				if (object instanceof NetworkMessage) {
					NetworkMessage networkMessage = (NetworkMessage) object;

					if (networkMessage.playerName.length() == 0)
						return;

					networkMessage.chatMessage = networkMessage.chatMessage.trim();
					if (networkMessage.chatMessage.length() == 0)
						return;

					server.sendToAllTCP(networkMessage);
				}
			}
		});
	}
}
