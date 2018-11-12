package clubs.apis.clients;

import clubs.apis.ClubsApi;
import io.micronaut.http.client.annotation.Client;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 12 Nov 2018
 */
@Client("/")
public interface ClubsClient extends ClubsApi {

	// no-ip
}
