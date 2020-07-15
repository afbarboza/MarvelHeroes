package Networking;

import android.content.Context;

import Controller.CallbackCharacterDataWrapper;
import Model.CharacterDataWrapper;
import Utils.Constants;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MarvelClient {
    private static Retrofit retrofit;
    private static MarvelEndpointAPI marvelEndpointAPI;
    private static Call<CharacterDataWrapper> getAllCharacters;

    private  static MarvelEndpointAPI getMarvelEndpointAPI() {
        if (marvelEndpointAPI == null) {
            Interceptor interceptor = new RequestInterceptor();

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.API_BASE_URL_VALUE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();

            marvelEndpointAPI = retrofit.create(MarvelEndpointAPI.class);
        }

        return marvelEndpointAPI;
    }

    public static void initRetrofit(Context context) {
        getAllCharacters = MarvelClient.getMarvelEndpointAPI().getAllCharacters();
        getAllCharacters.enqueue(new CallbackCharacterDataWrapper(context));
    }

}
