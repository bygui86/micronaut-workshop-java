package fixtures.domain;



/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 12 Nov 2018
 */
public class Club {

	private Long id;

	private String name;

	private String stadium;

	public Club(final String name) {

		this.name = name;
	}

	public Long getId() {

		return id;
	}

	public void setId(final Long id) {

		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName(final String name) {

		this.name = name;
	}

	public String getStadium() {

		return stadium;
	}

	public void setStadium(final String stadium) {

		this.stadium = stadium;
	}

}
