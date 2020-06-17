package Controller;

import Model.CharacterDataWrapper;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MarvelEndpointAPI {
    @GET("/v1/public/characters")
    Call<CharacterDataWrapper> getAllCharacters();
}
