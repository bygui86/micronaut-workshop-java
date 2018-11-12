package clubs.repos.impl;

import clubs.domain.Club;
import clubs.repos.ClubRepository;
import io.micronaut.spring.tx.annotation.Transactional;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 12 Nov 2018
 */
@Singleton
public class ClubRepositoryImpl implements ClubRepository {

	@PersistenceContext
	private EntityManager entityManager;

	// public ClubRepositoryImpl(@CurrentSession EntityManager entityManager) {
	//
	// 	this.entityManager = entityManager;
	// }

	@Override
	@Transactional(readOnly = true)
	public Long count() {

		return entityManager.createQuery("select count(c) from Club c", Long.class).getSingleResult();
	}

	@Override
	@Transactional
	public Club save(@NotBlank final String name, final String stadium) {

		Club club = new Club(name);
		club.setStadium(stadium);
		entityManager.persist(club);
		return club;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Club> findAll() {

		return entityManager.createQuery("select c from Club c", Club.class).getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Club> find(@NotNull final Long id) {

		return Optional.ofNullable(entityManager.find(Club.class, id));
	}

}
