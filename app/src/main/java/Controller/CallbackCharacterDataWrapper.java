package Controller;

import android.util.Log;

import java.util.List;

import Model.Character;
import Model.CharacterDataContainer;
import Model.CharacterDataWrapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallbackCharacterDataWrapper implements Callback<CharacterDataWrapper> {
    private static final String TAG = "CallbackCharacterDataWr";

    @Override
    public void onResponse(Call<CharacterDataWrapper> call, Response<CharacterDataWrapper> response) {
        Log.d(TAG, "onResponse: SUCCESS");
        CharacterDataWrapper characterDataWrapper = response.body();
        CharacterDataContainer characterDataContainer = characterDataWrapper.getData();
        List<Character> allCharacters = characterDataContainer.getResults();

        for (Character c : allCharacters) {
            Log.d(TAG, "onResponse: " + c.getName());
        }
    }

    @Override
    public void onFailure(Call<CharacterDataWrapper> call, Throwable t) {
        Log.d(TAG, "onFailure: " + t.getMessage());
    }
}
