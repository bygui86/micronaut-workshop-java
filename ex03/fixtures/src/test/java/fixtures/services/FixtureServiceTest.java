package fixtures.services;

import com.mongodb.reactivestreams.client.MongoClient;
import fixtures.apis.dtos.FixtureResponse;
import fixtures.domain.Fixture;
import fixtures.repos.FixtureRepository;
import fixtures.services.FixtureService;
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
public class FixtureServiceTest {

	@Inject
	FixtureService fixtureService;

	@Inject
	FixtureRepository repository;

	@Inject
	MongoClient mongoClient;

	@BeforeEach
	void cleanup() {

		Flowable.fromPublisher(mongoClient.getDatabase(DB_NAME)
				.getCollection(COLLECTION_NAME, Fixture.class)
				.deleteMany(new Document())).blockingFirst();
	}

	@Test
	void testToResponse(){
		Fixture fixture = repository
				.save(new Fixture(1L, 2L, (short)5, (short)0, new Date()))
				.blockingGet();
		FixtureResponse response = fixtureService.toResponse(fixture).blockingGet();

		assertEquals("CD Leganes", response.getHomeClubName());
		assertEquals("Getafe CF", response.getAwayClubName());
	}

}
