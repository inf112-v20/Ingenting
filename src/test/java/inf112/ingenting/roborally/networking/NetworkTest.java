package inf112.ingenting.roborally.networking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class NetworkTest {
	Network network;

	@Before
	public void setup() {
		network = Network.getInstance();
	}

	@Test
	public void createClient() {
		network.createClient();

		Assert.assertEquals(Network.NetworkType.CLIENT, network.networkType);
	}

	@Test
	public void createHost() {
		network.createHost();

		Assert.assertEquals(Network.NetworkType.HOST, network.networkType);
	}

	@Test
	public void createHostOnDefaultTCPPort() throws IOException {
		network.createHost();

		network.host.setPort(Network.DEFAULT_PORT_TCP); // Method throws an exception if it fails
	}

	@Test
	public void createHostOnPort25565() throws IOException {
		network.createHost();

		network.host.setPort(25565); // Method throws an exception if it fails
	}

	@Test
	public void connectToHostOnDefaultPortAndSendMessage() {

	}
}
