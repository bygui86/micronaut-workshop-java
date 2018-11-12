package clubs.apis.controllers;

import clubs.apis.clients.ClubsClient;
import clubs.domain.Club;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 12 Nov 2018
 */
@MicronautTest
public class ClubControllerTest {

	@Inject
	ClubsClient client;

	@Test
	void testGetOneClub() {
		Club realMadrid = client.save("Real Madrid", "Santiago Bernabeu");

		Club response = client.show(realMadrid.getId());
		assertEquals("Santiago Bernabeu", response.getStadium());
	}

	@Test
	void testFindAllClubs() {
		client.save("Real Madrid", "Santiago Bernabeu");
		client.save("FC Barcelona", "Camp Nou");

		assertEquals(2, client.listClubs().size());
	}
}
