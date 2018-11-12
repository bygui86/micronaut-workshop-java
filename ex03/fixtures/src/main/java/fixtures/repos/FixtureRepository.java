package fixtures.repos;

import fixtures.domain.Fixture;
import io.reactivex.Flowable;
import io.reactivex.Single;

import javax.validation.Valid;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 12 Nov 2018
 */
public interface FixtureRepository {

	Single<Fixture> save(@Valid Fixture fixture);

	Flowable<Fixture> findAll();

	Single<Long> count();

}
