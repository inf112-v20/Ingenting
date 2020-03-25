package inf112.ingenting.roborally.gui;

import com.strongjoshua.console.CommandExecutor;
import com.strongjoshua.console.LogLevel;
import com.strongjoshua.console.annotation.ConsoleDoc;
import inf112.ingenting.roborally.networking.Network;
import inf112.ingenting.roborally.networking.NetworkMessage;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

public class MyCommandExecutor extends CommandExecutor {

	public void executeCard(int a, int b){
		System.out.println("Should execute a programming card");
		System.out.println(a);
	}

	@ConsoleDoc(description = "Creates a network host on the default TCP port." + Network.DEFAULT_PORT_TCP + ".")
	public void host() {
		host(Network.DEFAULT_PORT_TCP);
	}

	@ConsoleDoc(description = "Creates a network host on the given TCP port.", paramDescriptions = "The TCP port to bind the host to")
	public void host(int tcpPort) {
		Network network = Network.getInstance();
		network.createHost();

		try {
			network.host.setPort(tcpPort);
		} catch (IOException e) {
			console.log("Failed to create host on port " + tcpPort + ", Error: " + e.getMessage(), LogLevel.ERROR);
		}

		console.log("Created host on port " + tcpPort, LogLevel.SUCCESS);
	}

	@ConsoleDoc(description = "Creates a network client, allowing you to connect to game hosts.")
	public void client() {
		Network network = Network.getInstance();
		network.createClient();

		console.log("Created network client", LogLevel.SUCCESS);
	}

	@ConsoleDoc(description = "Finds and lists all available hosts on the default TCP port " + Network.DEFAULT_PORT_TCP + ".")
	public void findHosts() {
		findHosts(Network.DEFAULT_PORT_TCP, Network.DEFAULT_CLIENT_CONNECTION_TIMEOUT);
	}

	@ConsoleDoc(description = "Finds and lists all hosts available on the given port.", paramDescriptions = "The TCP port to search on")
	public void findHosts(int port) {
		findHosts(port, Network.DEFAULT_CLIENT_CONNECTION_TIMEOUT);
	}

	@ConsoleDoc(description = "Finds and lists all hosts available on the given port.", paramDescriptions = {"The TCP port to search on", "Time in ms to search for"})
	public void findHosts(int port, int timeout) {
		if (Network.getInstance().networkType != Network.NetworkType.CLIENT) {
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
		if (Network.getInstance().networkType != Network.NetworkType.CLIENT) {
			console.log("You must be a client to connect to hosts.", LogLevel.ERROR);
			return;
		}

		Network network = Network.getInstance();
		try {
			network.client.connect(ip, Network.DEFAULT_PORT_TCP);
		} catch (IOException e) {
			console.log("Failed to connect to host " + ip + ", Error: " + e.getMessage(), LogLevel.ERROR);
		}

		console.log("Connected to host " + ip, LogLevel.SUCCESS);
	}

	@ConsoleDoc(description = "Attempts to connect to a host with the given ip address and port.", paramDescriptions = {"The IP address to connect to", "The port to connect to"})
	public void connect(String ip, int tcpPort) {
		if (Network.getInstance().networkType != Network.NetworkType.CLIENT) {
			console.log("You must be a client to connect to hosts.", LogLevel.ERROR);
			return;
		}

		Network network = Network.getInstance();
		try {
			network.client.connect(ip, tcpPort);
		} catch (IOException e) {
			console.log("Failed to connect to host " + ip + ":" + tcpPort + ", Error: " + e.getMessage(), LogLevel.ERROR);
		}

		console.log("Connected to host " + ip + ":" + tcpPort, LogLevel.SUCCESS);
	}

	@ConsoleDoc(description = "Send a message to other players.", paramDescriptions = "The message to send")
	public void say(String message) {
		switch (Network.getInstance().networkType) {
			case CLIENT:
				NetworkMessage networkMessage = new NetworkMessage();
				networkMessage.chatMessage = message;
				Network.getInstance().client.sendMessage(networkMessage);
				break;
			case HOST:
				break;
			case NONE:
			default:
				console.log("You are offline.", LogLevel.ERROR);
				break;
		}

	}

	public void displayCards() {
		console.log("Ørjan");
	}

}
