package fixtures.apis.clients;

import fixtures.apis.ClubsApi;
import fixtures.domain.Club;
import io.micronaut.retry.annotation.Fallback;
import io.reactivex.Maybe;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 12 Nov 2018
 */
@Fallback
public class ClubsClientMock implements ClubsApi {

	@Override
	public Maybe<Club> findTeam(final Long id) {

		Club club = new Club("MOCK-NAME");
		club.setId(id);
		club.setStadium("MOCK-STADIUM");
		return Maybe.just(club);
	}

}
