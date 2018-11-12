package fixtures.repos;

import com.mongodb.reactivestreams.client.MongoClient;
import fixtures.domain.Fixture;
import fixtures.repos.FixtureRepository;
import io.micronaut.test.annotation.MicronautTest;
import io.reactivex.Flowable;
import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.Date;

import static fixtures.repos.impl.FixtureRepositoryImpl.COLLECTION_NAME;
import static fixtures.repos.impl.FixtureRepositoryImpl.DB_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 12 Nov 2018
 */
@MicronautTest
public class FixtureRepositoryImplTest {

	@Inject
	FixtureRepository repository;

	@Inject
	MongoClient mongoClient;

	@BeforeEach
	void cleanup() {

		Flowable.fromPublisher(mongoClient.getDatabase(DB_NAME)
				.getCollection(COLLECTION_NAME, Fixture.class)
				.deleteMany(new Document()))
				.blockingFirst();
	}

	@Test
	void testCrud() {
		assertEquals(0, repository.count().blockingGet().longValue());

		repository.save(new Fixture(1L, 2L, (short)5, (short)0, new Date())).blockingGet();
		repository.save(new Fixture(3L, 4L, (short)5, (short)0, new Date())).blockingGet();
		assertEquals(2, repository.count().blockingGet().longValue());
		assertEquals(2, repository.findAll().toList().blockingGet().size());
	}

}
