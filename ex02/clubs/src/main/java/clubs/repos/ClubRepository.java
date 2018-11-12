package clubs.repos;

import clubs.domain.Club;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 12 Nov 2018
 */
public interface ClubRepository {

	Long count();

	Club save(@NotBlank String name, String stadium);

	List<Club> findAll();

	Optional<Club> find(@NotNull Long id);

}
