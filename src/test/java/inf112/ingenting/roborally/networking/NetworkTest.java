package inf112.ingenting.roborally.networking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

public class NetworkTest {
	Network network;

	@Before
	public void setup() {
		network = Network.getInstance();
	}

	@Test
	public void createClient() {
		network.createClient();

		Assert.assertEquals(Network.NetworkType.CLIENT, network.getNetworkType());
	}

	@Test
	public void createHost() {
		network.createHost();

		Assert.assertEquals(Network.NetworkType.HOST, network.getNetworkType());
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
	public void clientFindHosts() throws IOException {
		NetworkTestHelper network = new NetworkTestHelper();

		this.network.createHost();
		this.network.host.setPort(Network.DEFAULT_PORT_TCP, Network.DEFAULT_PORT_UDP);

		network.createClient();
		Assert.assertNotEquals(0, network.client.findHosts(Network.DEFAULT_PORT_UDP).size());
	}

	@Test
	public void clientConnectToHost() throws IOException {
		NetworkTestHelper network = new NetworkTestHelper();

		this.network.createHost();
		this.network.host.setPort(Network.DEFAULT_PORT_TCP, Network.DEFAULT_PORT_UDP);

		network.createClient();

		List<InetAddress> hosts = network.client.findHosts(Network.DEFAULT_PORT_UDP);

		Assert.assertFalse(network.client.isConnected());

		network.client.connect(hosts.get(0).getHostAddress());

		Assert.assertTrue(network.client.isConnected());
	}
}
