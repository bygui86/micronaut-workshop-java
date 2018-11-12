package fixtures.services;

import fixtures.apis.clients.ClubsClient;
import fixtures.apis.dtos.FixtureResponse;
import fixtures.domain.Fixture;
import io.reactivex.Maybe;

import javax.inject.Singleton;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 12 Nov 2018
 */
@Singleton
public class FixtureService {

	private ClubsClient clubsClient;

	public FixtureService(ClubsClient clubsClient) {

		this.clubsClient = clubsClient;
	}

	public Maybe<FixtureResponse> toResponse(Fixture fixture) {
		return Maybe.zip(
				clubsClient.findTeam(fixture.getHomeClubId()),
				clubsClient.findTeam(fixture.getAwayClubId()),
				(homeClub, awayClub) -> new FixtureResponse(
						homeClub.getName(),
						awayClub.getName(),
						homeClub.getStadium(),
						fixture.getHomeScore(),
						fixture.getAwayScore(),
						fixture.getDate())
		);
	}

}
