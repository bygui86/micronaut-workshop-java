package hello.galaxy;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 12 Nov 2018
 */
public class HelloWorldTest {

	private static EmbeddedServer server;
	private static HttpClient client;

	@BeforeClass
	public static void setupServer() {
		server = ApplicationContext.run(EmbeddedServer.class);
		client = server.getApplicationContext().createBean(HttpClient.class, server.getURL());
	}

	@AfterClass
	public static void stopServer() {
		if(server != null) { server.stop(); }
		if(client != null) { client.stop(); }
	}

	@Test
	public void testHelloWorkd() throws Exception {
		String body = client.toBlocking().retrieve("/hello");
		assertEquals(body, "Hello Galaxy!");
	}

}
