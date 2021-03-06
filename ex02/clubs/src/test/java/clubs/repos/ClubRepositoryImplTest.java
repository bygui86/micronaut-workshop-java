package clubs.repos;

import clubs.domain.Club;
import clubs.repos.ClubRepository;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 12 Nov 2018
 */
@MicronautTest
class ClubRepositoryImplTest {

	@Inject
	ClubRepository repository;

	@Test
	void testCrudOperations() {
		assertEquals(0L, repository.count().longValue());

		repository.save("Real Madrid", "Santiago Bernabeu");
		repository.save("FC Barcelona", "Camp Nou");
		assertEquals(2L, repository.count().longValue());

		List<Club> allClubs = repository.findAll();
		assertEquals(2, allClubs.size());

		Club realMadrid = repository.find(1L).get();
		assertSame("Santiago Bernabeu", realMadrid.getStadium());

		assertEquals(Optional.empty(), repository.find(27L));
	}

}
