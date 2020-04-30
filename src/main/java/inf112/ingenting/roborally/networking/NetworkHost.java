package inf112.ingenting.roborally.networking;

import com.badlogic.gdx.utils.Array;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.strongjoshua.console.LogLevel;
import inf112.ingenting.roborally.gui.GameConsole;
import inf112.ingenting.roborally.player.Player;

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

	public void sendMessageToClients(String message) {
		server.sendToAllTCP(new NetworkMessage().setNetworkStatus(NetworkFlag.CHAT_MESSAGE).setName("Host").setMessage(message));
	}

	public void dispose() {
		server.stop();
	}

	private void addListeners() {
		server.addListener(new Listener() {
			public void connected(Connection connection) {
				GameConsole.log("Connection received.", LogLevel.SUCCESS);

				connection.setName("Player " + server.getConnections().length);

				server.sendToTCP(
					connection.getID(), new NetworkMessage()
						.setNetworkStatus(NetworkFlag.CHAT_MESSAGE)
						.setMessage("Connected to host as " + connection.toString())
						.setName("Host")
				);

				server.sendToAllExceptTCP(connection.getID(), connection.toString() + " connected.");
				GameConsole.log("Client connected from " + connection.getRemoteAddressTCP().toString());
			}

			public void received(Connection connection, Object object) {
				GameConsole.log("Object received: " + object.toString(), LogLevel.SUCCESS);

				if (object instanceof NetworkMessage) {
					NetworkMessage networkMessage = (NetworkMessage) object;

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

						// Chat message is already in 'networkMessage'
						server.sendToAllTCP(networkMessage.setName(connection.toString()));
						GameConsole.log(networkMessage.name + ": " + networkMessage.message);
					}
				}
			}

			public void disconnected(Connection connection) {
				server.sendToAllTCP(connection.toString() + " disconnected.");
				GameConsole.log(connection.toString() + " disconnected.");
			}
		});
	}

	public int getPlayerCount() {
		return server.getConnections().length;
	}

	public Connection[] getConnections() {
		return server.getConnections();
	}

	public int getPlayerID(int index) {
		return server.getConnections()[index].getID();
	}

	public String getPlayerName(int index) {
		return server.getConnections()[index].toString();
	}

	public void sendPlayers(Array<Player> players) {
		PlayerPacket packet = new PlayerPacket(players);
		server.sendToAllTCP(packet);
	}
}
