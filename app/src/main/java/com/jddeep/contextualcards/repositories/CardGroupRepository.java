package com.jddeep.contextualcards.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jddeep.contextualcards.interfaces.APIinterface;
import com.jddeep.contextualcards.models.CardGroup;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class CardGroupRepository {

    private static final String BASE_URL = "http://www.mocky.io/v2/";

    private APIinterface apiInterface;
    private MutableLiveData<List<CardGroup>> cardGroupMutableLiveData;

    public CardGroupRepository() {
        cardGroupMutableLiveData = new MutableLiveData<>();

        OkHttpClient client = new OkHttpClient.Builder().build();

        apiInterface = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIinterface.class);
    }

    public void fetchCardGroups() {
        cardGroupMutableLiveData = new MutableLiveData<>();
        apiInterface.getCardGroups()
                .enqueue(new Callback<List<CardGroup>>() {
                    @Override
                    public void onResponse(Call<List<CardGroup>> call, Response<List<CardGroup>> response) {
                        if (response.body() != null) {
                            cardGroupMutableLiveData.postValue(response.body());
                            Log.e("Response Body: ", response.body().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<CardGroup>> call, Throwable t) {
                        Log.e("Response Failure: ", t.toString());
                        cardGroupMutableLiveData.postValue(null);
                    }
                });
    }

    public LiveData<List<CardGroup>> getCardGroupList() {
        return cardGroupMutableLiveData;
    }
}
