package inf112.ingenting.roborally.gui;

import com.strongjoshua.console.CommandExecutor;
import com.strongjoshua.console.LogLevel;
import com.strongjoshua.console.annotation.ConsoleDoc;
import inf112.ingenting.roborally.networking.Network;
import inf112.ingenting.roborally.networking.NetworkFlag;
import inf112.ingenting.roborally.networking.NetworkMessage;
import inf112.ingenting.roborally.screens.GameScreen;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

/**
 * PlayerCommandExecutor is a class that represents the methods that the player can execute by using
 * the in-game console.
 */
public class GameCommandExecutor extends CommandExecutor {
	// Listener for main class
	private GameScreen game;

	public void setGameScreenListener(GameScreen listener) {
		this.game = listener;
	}


	// Networking related commands
	@ConsoleDoc(description = "Creates a network host on the default TCP port." + Network.DEFAULT_PORT_TCP + ".")
	public void host() {
		host(Network.DEFAULT_PORT_TCP);
	}

	@ConsoleDoc(description = "Creates a network host on the given TCP port.", paramDescriptions = "The TCP port to bind the host to")
	public void host(int tcp) {
		Network network = Network.getInstance();
		network.createHost();

		try {
			network.host.setPort(tcp);
		} catch (IOException e) {
			console.log("Failed to create host on port " + tcp + "(TCP).\n\t" + e.getMessage(), LogLevel.ERROR);
			return;
		}

		console.log("Created host on port " + tcp, LogLevel.SUCCESS);
	}

	public void host(int tcp, int udp) {
		Network network = Network.getInstance();
		network.createHost();

		try {
			network.host.setPort(tcp, udp);
		} catch (IOException e) {
			console.log("Failed to create host on ports " + tcp + " (TCP) & " + udp + " (UDP).\n\t" + e.getMessage(), LogLevel.ERROR);
		}

		console.log("Created host on ports " + tcp + " (TCP) & " + udp + " (UDP).", LogLevel.SUCCESS);
	}

	@ConsoleDoc(description = "Creates a network client, allowing you to connect to game hosts.")
	public void client() {
		Network network = Network.getInstance();
		network.createClient();

		console.log("Created network client", LogLevel.SUCCESS);
	}

	@ConsoleDoc(description = "Finds and lists all available hosts on the default UDP port " + Network.DEFAULT_PORT_UDP + ".")
	public void findHosts() {
		findHosts(Network.DEFAULT_PORT_UDP, Network.DEFAULT_CLIENT_CONNECTION_TIMEOUT);
	}

	@ConsoleDoc(description = "Finds and lists all hosts available on the given port.", paramDescriptions = "The UDP port to search on")
	public void findHosts(int port) {
		findHosts(port, Network.DEFAULT_CLIENT_CONNECTION_TIMEOUT);
	}

	@ConsoleDoc(description = "Finds and lists all hosts available on the given port.", paramDescriptions = {"The UDP port to search on", "Time in ms to search for"})
	public void findHosts(int port, int timeout) {
		if (Network.getInstance().getNetworkType() != Network.NetworkType.CLIENT) {
			console.log("You must be a client to discover hosts.", LogLevel.ERROR);
			return;
		}

		console.log("Searching for hosts on port " + port + "...");

		Network network = Network.getInstance();
		List<InetAddress> hosts = network.client.findHosts(port, timeout);

		if (hosts.size() == 0) {
			console.log("Found 0 hosts on port " + port, LogLevel.ERROR);
		}
		else {
			console.log("Found " + hosts.size() + " hosts: ", LogLevel.SUCCESS);

			for (int i = 0; i < hosts.size(); i++) {
				console.log("\t" + (i + 1) + ": " + hosts.get(i).toString());
			}
		}
	}

	@ConsoleDoc(description = "Attempts to connect to a host with the given ip address.", paramDescriptions = "The IP address to connect to")
	public void connect(String ip) {
		if (Network.getInstance().getNetworkType() != Network.NetworkType.CLIENT) {
			console.log("You must be a client to connect to hosts.", LogLevel.ERROR);
			return;
		}

		Network network = Network.getInstance();
		try {
			network.client.connect(ip, Network.DEFAULT_PORT_TCP);
		} catch (IOException e) {
			console.log("Failed to connect to host " + ip + ", Error: " + e.getMessage(), LogLevel.ERROR);
		}
	}

	@ConsoleDoc(description = "Attempts to connect to a host with the given ip address and port.", paramDescriptions = {"The IP address to connect to", "The port to connect to"})
	public void connect(String ip, int tcpPort) {
		if (Network.getInstance().getNetworkType() != Network.NetworkType.CLIENT) {
			console.log("You must be a client to connect to hosts.", LogLevel.ERROR);
			return;
		}

		Network network = Network.getInstance();
		try {
			network.client.connect(ip, tcpPort);
		} catch (IOException e) {
			console.log("Failed to connect to host " + ip + ":" + tcpPort + ", Error: " + e.getMessage(), LogLevel.ERROR);
		}
	}

	@ConsoleDoc(description = "Send a message to other players.", paramDescriptions = "The message to send")
	public void say(String message) {
		switch (Network.getInstance().getNetworkType()) {
			case CLIENT:
				if (!Network.getInstance().client.isConnected()) {
					console.log("You are not connected to a host.", LogLevel.ERROR);
				}

				Network.getInstance().client.sendMessage(
						new NetworkMessage()
								.setNetworkStatus(NetworkFlag.CHAT_MESSAGE)
								.setMessage(message)
				);

				break;
			case HOST:
				Network.getInstance().host.sendMessageToClients(message);
				break;
			case NONE:
			default:
				console.log("You are offline.", LogLevel.ERROR);
				break;
		}

	}

	@ConsoleDoc(description = "Start the game")
	public void start() {
		game.startGame();
	}

	@ConsoleDoc(description = "Show cards")
	public void showCards() {
		if (game == null)
			console.log("Could not get cards", LogLevel.ERROR);
		else
			game.showCards();
	}
}
