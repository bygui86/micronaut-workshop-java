package fixtures.apis.controllers;

import fixtures.apis.dtos.FixtureResponse;
import fixtures.repos.FixtureRepository;
import fixtures.services.FixtureService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Flowable;

import javax.inject.Inject;


@Controller("/")
public class FixtureController {

    @Inject
    private FixtureService fixtureService;

    @Inject
    private FixtureRepository fixtureRepository;

    @Get("/")
    public Flowable<FixtureResponse> list() {

        return fixtureRepository.findAll().flatMapMaybe(fixture -> fixtureService.toResponse(fixture));
    }

}