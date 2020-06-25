package Controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import Model.Character;
import Model.CharacterCollection;
import Model.CharacterDataContainer;
import Model.CharacterDataWrapper;
import Utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallbackCharacterDataWrapper implements Callback<CharacterDataWrapper> {
    private Context context;
    private static final String TAG = "CallbackCharacterDataWr";

    public CallbackCharacterDataWrapper(Context context) {
        this.context = context;
    }

    @Override
    public void onResponse(Call<CharacterDataWrapper> call, Response<CharacterDataWrapper> response) {
        Log.d(TAG, "onResponse: SUCCESS");
        CharacterDataWrapper characterDataWrapper = response.body();
        CharacterDataContainer characterDataContainer = characterDataWrapper.getData();
        List<Character> allCharacters = characterDataContainer.getResults();

        for (Character c : allCharacters) {
            CharacterCollection.addNewCharacter(c);
        }

        Intent i = new Intent(Constants.EVENT_REQUEST_FINISIHED);
        context.sendBroadcast(i);
    }

    @Override
    public void onFailure(Call<CharacterDataWrapper> call, Throwable t) {
        Log.d(TAG, "onFailure: " + t.getMessage());
    }
}
