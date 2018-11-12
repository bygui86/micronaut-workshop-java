package fixtures.apis.dtos;

import java.util.Date;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 12 Nov 2018
 */
public class FixtureResponse {

	private String homeClubName;
	private String awayClubName;

	private String stadium;

	private Short homeScore;
	private Short awayScore;

	private Date date;

	public FixtureResponse(final String homeClubName, final String awayClubName, final String stadium, final Short homeScore, final Short awayScore, final Date date) {

		this.homeClubName = homeClubName;
		this.awayClubName = awayClubName;
		this.stadium = stadium;
		this.homeScore = homeScore;
		this.awayScore = awayScore;
		this.date = date;
	}

	public String getHomeClubName() {

		return homeClubName;
	}

	public void setHomeClubName(final String homeClubName) {

		this.homeClubName = homeClubName;
	}

	public String getAwayClubName() {

		return awayClubName;
	}

	public void setAwayClubName(final String awayClubName) {

		this.awayClubName = awayClubName;
	}

	public String getStadium() {

		return stadium;
	}

	public void setStadium(final String stadium) {

		this.stadium = stadium;
	}

	public Short getHomeScore() {

		return homeScore;
	}

	public void setHomeScore(final Short homeScore) {

		this.homeScore = homeScore;
	}

	public Short getAwayScore() {

		return awayScore;
	}

	public void setAwayScore(final Short awayScore) {

		this.awayScore = awayScore;
	}

	public Date getDate() {

		return date;
	}

	public void setDate(final Date date) {

		this.date = date;
	}
}
