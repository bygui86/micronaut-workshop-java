package clubs.apis;

import clubs.domain.Club;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 12 Nov 2018
 */
public interface ClubsApi {

	@Get("/")
	List<Club> listClubs();

	@Get("/{id}")
	Club show(@NotNull Long id);

	@Post("/")
	Club save(@NotNull String name, String stadium);

}
