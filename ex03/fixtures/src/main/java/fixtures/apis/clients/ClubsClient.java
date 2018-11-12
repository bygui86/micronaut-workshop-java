package fixtures.apis.clients;

import fixtures.apis.ClubsApi;
import io.micronaut.http.client.annotation.Client;


@Client("clubs") // dicovery application name
public interface ClubsClient extends ClubsApi {

    // no-op
}
