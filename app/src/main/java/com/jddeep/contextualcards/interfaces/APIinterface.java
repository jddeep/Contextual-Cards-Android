package com.jddeep.contextualcards.interfaces;

import com.jddeep.contextualcards.models.CardGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIinterface {

    @GET("5ed79368320000a0cc27498b/")
    Call<List<CardGroup>> getCardGroups();
}
