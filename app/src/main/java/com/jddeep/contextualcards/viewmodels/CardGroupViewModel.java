package com.jddeep.contextualcards.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.jddeep.contextualcards.models.CardGroup;
import com.jddeep.contextualcards.repositories.CardGroupRepository;

import java.util.List;

public class CardGroupViewModel extends AndroidViewModel {
    private CardGroupRepository cardGroupRepository;
    private LiveData<List<CardGroup>> cardGroupLiveData;

    public CardGroupViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        cardGroupRepository = new CardGroupRepository();
        fetchCardGroupList();
        cardGroupLiveData = cardGroupRepository.getCardGroupList();
    }

    public void fetchCardGroupList() {
        cardGroupRepository.fetchCardGroups();
    }

    public LiveData<List<CardGroup>> getCardGroupLiveData() {
        return cardGroupLiveData;
    }
}
