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

		Network.registerObjects(server);
		addListeners();
	}

	public void setPort(int tcp) throws IOException {
		server.bind(tcp, Network.DEFAULT_PORT_UDP);
	}

	public void setPort(int tcp, int udp) throws IOException {
		server.bind(tcp, udp);
	}

	public void dispose() {
		server.stop();
	}

	private void addListeners() {
		server.addListener(new Listener() {
			public void connected(Connection connection) {
				connection.setName("Player " + server.getConnections().length);

				server.sendToTCP(
					connection.getID(), new NetworkMessage()
						.setMessage("Connected to host as " + connection.toString())
				);

				server.sendToAllExceptTCP(connection.getID(), connection.toString() + " connected.");
			}

			public void received(Connection connection, Object object) {
				if (object instanceof NetworkMessage) {
					NetworkMessage networkMessage = (NetworkMessage) object;

					// Is chat message
					if (networkMessage.networkStatus == NetworkFlag.CHAT_MESSAGE) {
						networkMessage.message = networkMessage.message.trim();
						if (networkMessage.message.length() == 0)
						{
							server.sendToTCP(
								connection.getID(),
								new NetworkMessage()
									.setNetworkStatus(NetworkFlag.LOG_ERROR)
									.setMessage("Invalid message.")
							);
							return;
						}

						server.sendToAllTCP(networkMessage.setName(connection.toString()));
					}
				}
			}

			public void disconnected(Connection connection) {
				server.sendToAllTCP(connection.toString() + " disconnected.");
			}
		});
	}
}
