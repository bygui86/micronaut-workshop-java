package fixtures.apis;

import fixtures.domain.Club;
import io.micronaut.http.annotation.Get;
import io.reactivex.Maybe;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 12 Nov 2018
 */
public interface ClubsApi {

	@Get("/{id}")
	Maybe<Club> findTeam(Long id);

}
