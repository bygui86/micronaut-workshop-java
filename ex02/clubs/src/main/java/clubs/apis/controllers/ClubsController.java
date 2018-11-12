package clubs.apis.controllers;

import clubs.domain.Club;
import clubs.repos.ClubRepository;
import clubs.apis.ClubsApi;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;


@Controller("/")
@Validated
public class ClubsController implements ClubsApi {

    // @Inject
    private ClubRepository repository;

    public ClubsController(ClubRepository repository) {

        this.repository = repository;
    }

    @Override
    @Get("/")
    public List<Club> listClubs() {

        return repository.findAll();
    }

    @Override
    @Get("/{id}")
    public Club show(@NotNull Long id) {

        return repository.find(id).orElse(new Club("ERROR - NOT FOUND"));
    }

    @Override
    @Post("/")
    public Club save(@NotNull String name, String stadium) {

        return repository.save(name, stadium);
    }

}