package com.jddeep.contextualcards;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.jddeep.contextualcards.adapters.ContextualCardsAdapter;
import com.jddeep.contextualcards.models.CardGroup;
import com.jddeep.contextualcards.viewmodels.CardGroupViewModel;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements ContextualCardsAdapter.OnItemRemoveListener {
    private ContextualCardsAdapter contextualCardsAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private CardGroupViewModel cardGroupViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setTitle(getString(R.string.fampay));

        TextView loadingTv = findViewById(R.id.loading_tv);
        loadingTv.setVisibility(View.VISIBLE);
        contextualCardsAdapter = new ContextualCardsAdapter();
        cardGroupViewModel = ViewModelProviders.of(this).get(CardGroupViewModel.class);
        cardGroupViewModel.init();
        cardGroupViewModel.getCardGroupLiveData().observe(this, new Observer<List<CardGroup>>() {
            @Override
            public void onChanged(List<CardGroup> cardGroups) {
                if (cardGroups != null && cardGroups.size() > 0) {
                    loadingTv.setVisibility(View.GONE);
                    contextualCardsAdapter.setCardGroupList(cardGroups);
                } else {
                    loadingTv.setVisibility(View.VISIBLE);
                    loadingTv.setText(getString(R.string.no_data));
                }
            }
        });
        RecyclerView recyclerView = findViewById(R.id.contextual_cards_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(contextualCardsAdapter);
        contextualCardsAdapter.setOnItemRemoveListener(this);

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(this::refreshList);
    }

    private void refreshList() {
        cardGroupViewModel.fetchCardGroupList();
        contextualCardsAdapter = new ContextualCardsAdapter();
        contextualCardsAdapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onItemRemoved(int position) {
        /* TODO: We can remove the card group of required position
         *   from the list and update the adapter from here as well.
         * */
    }
}
