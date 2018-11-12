package hello.galaxy;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.Test;


import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

// JUnit5
// @MicronautTest
public class HelloControllerTest {

    // JUnit5
    // @Inject
    // private EmbeddedServer server;

    @Test
    public void testIndex() throws Exception {
        try(EmbeddedServer server = ApplicationContext.run(EmbeddedServer.class)) {
            try(RxHttpClient client = server.getApplicationContext().createBean(RxHttpClient.class, server.getURL())) {
                assertEquals(HttpStatus.OK, client.toBlocking().exchange("/hello").status());
                assertEquals("Hello Galaxy!", client.toBlocking().exchange("/hello", String.class).body());
            }
        }
    }
}
