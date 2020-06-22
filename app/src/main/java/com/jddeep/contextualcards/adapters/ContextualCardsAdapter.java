package com.jddeep.contextualcards.adapters;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.card.MaterialCardView;
import com.jddeep.contextualcards.R;
import com.jddeep.contextualcards.models.Card;
import com.jddeep.contextualcards.models.CardGroup;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContextualCardsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<CardGroup> cardGroupList = new ArrayList<>();
    private boolean scrollable = false;
    private OnItemRemoveListener onItemRemoveListener;

    public void setCardGroupList(List<CardGroup> cardGroupList) {
        this.cardGroupList = cardGroupList;
        notifyDataSetChanged();
    }

    public void setOnItemRemoveListener(OnItemRemoveListener onItemRemoveListener) {
        this.onItemRemoveListener = onItemRemoveListener;
    }

    static class NonScrollableLLViewHolder extends RecyclerView.ViewHolder {
        LinearLayout nonScrollableLl;

        NonScrollableLLViewHolder(@NonNull View itemView) {
            super(itemView);
            nonScrollableLl = itemView.findViewById(R.id.non_scrollable_ll);
        }
    }

    static class ScrollableViewHolder extends RecyclerView.ViewHolder {
        HorizontalScrollView scrollableHv;
        LinearLayout scrollableLl;

        ScrollableViewHolder(@NonNull View itemView) {
            super(itemView);
            scrollableHv = itemView.findViewById(R.id.horizontal_scrollable_item_hv);
            scrollableLl = itemView.findViewById(R.id.scrollable_ll);
        }
    }

    static class BigDisplayCardViewHolder extends RecyclerView.ViewHolder
            implements View.OnLongClickListener {
        RelativeLayout bigCardViewRl;
        MaterialCardView remindLaterCv;
        MaterialCardView dismissNowCv;
        MaterialCardView bigCard;
        TextView bigCardDisplayTv;
        TextView withActionTv;
        TextView descriptionTv;
        Button actionBtn;

        BigDisplayCardViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnLongClickListener(this);
            bigCardViewRl = itemView.findViewById(R.id.big_card_items_rl);
            remindLaterCv = itemView.findViewById(R.id.remind_later_cv);
            dismissNowCv = itemView.findViewById(R.id.dismiss_now_cv);
            bigCard = itemView.findViewById(R.id.big_card);
            bigCardDisplayTv = itemView.findViewById(R.id.big_card_display_tv);
            withActionTv = itemView.findViewById(R.id.with_action_tv);
            descriptionTv = itemView.findViewById(R.id.description_tv);
            actionBtn = itemView.findViewById(R.id.big_card_action_btn);
            bigCardViewRl.setVisibility(View.VISIBLE);
        }

        float start = 0.0f;
        float end = 0.5f;

        @Override
        public boolean onLongClick(View v) {
            Animation animation = new TranslateAnimation(
                    Animation.RELATIVE_TO_SELF, //fromXType
                    start,                       //fromXValue
                    Animation.RELATIVE_TO_SELF, //toXType
                    end,                      //toXValue
                    Animation.RELATIVE_TO_SELF, //fromYType
                    0.0f,                       //fromYValue
                    Animation.RELATIVE_TO_SELF, //toYType
                    0.0f);                      //toYValue
            animation.setDuration(500);
            animation.setFillAfter(true);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    float temp = start;
                    start = end;
                    end = temp;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
            bigCard.startAnimation(animation);
            return true;
        }
    }

    static class SmallDisplayCardViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView smallDisplayCard;
        CircleImageView smallDisplayCardIv;
        TextView smallDisplayCardTv;
        TextView aryaStarkTv;

        SmallDisplayCardViewHolder(@NonNull View itemView) {
            super(itemView);
            smallDisplayCard = itemView.findViewById(R.id.small_display_card);
            smallDisplayCardIv = itemView.findViewById(R.id.small_display_card_iv);
            smallDisplayCardTv = itemView.findViewById(R.id.small_display_card_tv);
            aryaStarkTv = itemView.findViewById(R.id.arya_stark_tv);
        }
    }

    static class CenterCardViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView centerCard;
        CircleImageView centerCardIv;
        TextView aryaStarkTv;
        TextView centerCardTv;
        Button actionBtn1;
        Button actionBtn2;

        CenterCardViewHolder(@NonNull View itemView) {
            super(itemView);
            centerCard = itemView.findViewById(R.id.center_card);
            centerCardIv = itemView.findViewById(R.id.center_card_iv);
            aryaStarkTv = itemView.findViewById(R.id.center_card_arya_stark_tv);
            centerCardTv = itemView.findViewById(R.id.center_card_tv);
            actionBtn1 = itemView.findViewById(R.id.center_card_btn1);
            actionBtn2 = itemView.findViewById(R.id.center_card_btn2);
        }
    }

    static class ImageCardViewHolder extends RecyclerView.ViewHolder {
        LinearLayout imageCardLl;
        MaterialCardView imageCard;

        ImageCardViewHolder(@NonNull View itemView) {
            super(itemView);
            imageCard = itemView.findViewById(R.id.image_card);
            imageCardLl = itemView.findViewById(R.id.image_card_ll);
        }
    }

    static class SmallCardWithArrowViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView smallArrowCard;
        TextView smallArrowCardTv;

        SmallCardWithArrowViewHolder(@NonNull View itemView) {
            super(itemView);
            smallArrowCard = itemView.findViewById(R.id.small_arrow_card);
            smallArrowCardTv = itemView.findViewById(R.id.small_card_with_arrow_tv);
        }
    }

    @Override
    public int getItemViewType(int position) {
        int itemViewTypeNo = 3; //Big Display Card Default
        scrollable = cardGroupList.get(position).getIsScrollable();
        switch (cardGroupList.get(position).getDesignType()) {
            case "HC3":
                itemViewTypeNo = 3; // Big Display Card
                break;
            case "HC1":
                itemViewTypeNo = 1; // Small Display Card
                break;
            case "HC4":
                itemViewTypeNo = 4; // Center Card
                break;
            case "HC5":
                itemViewTypeNo = 5; // Image Card
                break;
            case "HC6":
                itemViewTypeNo = 6; // Small Card with Arrow
                break;
        }
        return itemViewTypeNo;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        switch (viewType){
//            case 1: return new SmallDisplayCardViewHolder(LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.small_display_card_item_layout, parent, false));
//            case 3: return new BigDisplayCardViewHolder(LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.big_card_item_layout, parent, false));
//            case 4: return new CenterCardViewHolder(LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.center_card_item_layout, parent, false));
//            case 5: return new ImageCardViewHolder(LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.image_card_item_layout, parent, false));
//            case 6: return new SmallCardWithArrowViewHolder(LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.small_card_with_arrow_item_layout, parent, false));
//        }
        //default
        if (!scrollable)
            return new NonScrollableLLViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.horizontal_non_scrollable_item_layout, parent, false));
        else return new ScrollableViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.horizontal_scrollable_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case 1:
                if (!scrollable)
                    layNonScrollableSmallDisplayCard((NonScrollableLLViewHolder) holder,
                            cardGroupList.get(position).getCards());
                else layScrollableSmallDisplayCard((ScrollableViewHolder) holder,
                        cardGroupList.get(position).getCards());
                break;
            case 3:
                layNonScrollableBigCards((NonScrollableLLViewHolder) holder,
                        cardGroupList.get(position).getCards(), position);
                break;
            case 4:
                layNonScrollableCenterCard((NonScrollableLLViewHolder) holder, cardGroupList.get(position).getCards());
                break;
            case 5:
                layNonScrollableImageCard((NonScrollableLLViewHolder) holder,
                        cardGroupList.get(position).getCards());
                break;
            case 6:
                layNonScrollableSmallArrowCard((NonScrollableLLViewHolder) holder,
                        cardGroupList.get(position).getCards());
                break;
        }
    }

    private void layNonScrollableBigCards(NonScrollableLLViewHolder nonScrollableLLViewHolder,
                                          List<Card> cards, int position) {
        for (Card card : cards) {
            BigDisplayCardViewHolder bigDisplayCardViewHolder = new BigDisplayCardViewHolder(LayoutInflater.from(nonScrollableLLViewHolder.itemView.getContext())
                    .inflate(R.layout.big_card_item_layout, (ViewGroup) nonScrollableLLViewHolder.itemView, false));
            bigDisplayCardViewHolder.bigCardViewRl.setVisibility(View.VISIBLE);
            bigDisplayCardViewHolder.bigCard.setCardBackgroundColor(Color
                    .parseColor(card.getBgColor()));
            bigDisplayCardViewHolder.bigCardDisplayTv.setText(card.getFormattedTitle()
                    .getEntities().get(0).getText());
            bigDisplayCardViewHolder.bigCardDisplayTv.setTextColor(Color.parseColor(
                    card.getFormattedTitle()
                            .getEntities().get(0).getColor()
            ));
            bigDisplayCardViewHolder.withActionTv.setText(card.getFormattedTitle()
                    .getEntities().get(1).getText());
            bigDisplayCardViewHolder.withActionTv.setTextColor(Color.parseColor(
                    card.getFormattedTitle()
                            .getEntities().get(1).getColor()
            ));
            bigDisplayCardViewHolder.descriptionTv.setText(card.getFormattedDescription()
                    .getEntities().get(0).getText());
            bigDisplayCardViewHolder.descriptionTv.setTextColor(Color.parseColor(
                    card.getFormattedDescription()
                            .getEntities().get(0).getColor()
            ));
            bigDisplayCardViewHolder.actionBtn.setText(card.getCta().get(0).getText());
            bigDisplayCardViewHolder.actionBtn.setTextColor(Color.parseColor(card.getCta().get(0).getTextColor()));
            bigDisplayCardViewHolder.actionBtn.setBackgroundColor(Color.parseColor(card.getCta().get(0).getBgColor()));
            bigDisplayCardViewHolder.remindLaterCv.setOnClickListener(v -> {
                bigDisplayCardViewHolder.bigCardViewRl.setVisibility(View.GONE);
                if (onItemRemoveListener != null)
                    onItemRemoveListener.onItemRemoved(position);
            });
            bigDisplayCardViewHolder.dismissNowCv.setOnClickListener(v -> {
                bigDisplayCardViewHolder.bigCardViewRl.setVisibility(View.GONE);
                if (onItemRemoveListener != null)
                    onItemRemoveListener.onItemRemoved(position);
            });
            bigDisplayCardViewHolder.itemView.setLayoutParams(new LinearLayout.LayoutParams(
                    0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f
            ));
            nonScrollableLLViewHolder.nonScrollableLl.addView(bigDisplayCardViewHolder.itemView);
        }
    }

    private void layNonScrollableSmallDisplayCard(NonScrollableLLViewHolder nonScrollableLLViewHolder,
                                                  List<Card> cards) {
        for (Card card : cards) {
            SmallDisplayCardViewHolder smallDisplayCardViewHolder =
                    new SmallDisplayCardViewHolder(LayoutInflater.from(nonScrollableLLViewHolder.itemView.getContext())
                            .inflate(R.layout.small_display_card_item_layout, (ViewGroup) nonScrollableLLViewHolder.itemView, false));

            smallDisplayCardViewHolder.smallDisplayCard.setCardBackgroundColor(Color.parseColor(
                    card.getBgColor()
            ));
            smallDisplayCardViewHolder.smallDisplayCardTv.setText(card.getTitle()); // could be formatted title
            smallDisplayCardViewHolder.aryaStarkTv.setText(card.getDescription()); // could be formatted desc
            Glide.with(smallDisplayCardViewHolder.itemView)
                    .load(card.getIcon().getImageUrl())
                    .into(smallDisplayCardViewHolder.smallDisplayCardIv);
            smallDisplayCardViewHolder.smallDisplayCard.setLayoutParams(new LinearLayout.LayoutParams(
                    0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f
            ));
            nonScrollableLLViewHolder.nonScrollableLl.addView(smallDisplayCardViewHolder.itemView);
        }
    }

    private void layNonScrollableCenterCard(NonScrollableLLViewHolder nonScrollableLLViewHolder,
                                            List<Card> cards) {
        for (Card card : cards) {
            CenterCardViewHolder centerCardViewHolder = new CenterCardViewHolder(LayoutInflater.from(nonScrollableLLViewHolder.itemView.getContext())
                    .inflate(R.layout.center_card_item_layout, (ViewGroup) nonScrollableLLViewHolder.itemView, false));
            centerCardViewHolder.aryaStarkTv.setText(card.getTitle());
            centerCardViewHolder.centerCardTv.setText(card.getDescription());
            Glide.with(centerCardViewHolder.itemView)
                    .load(card.getIcon().getImageUrl())
                    .into(centerCardViewHolder.centerCardIv);
            centerCardViewHolder.actionBtn1.setText(card.getCta().get(0).getText());
            centerCardViewHolder.actionBtn2.setText(card.getCta().get(1).getText());
            centerCardViewHolder.centerCard.setLayoutParams(new LinearLayout.LayoutParams(
                    0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f
            ));
            nonScrollableLLViewHolder.nonScrollableLl.addView(centerCardViewHolder.itemView);
        }
    }

    private void layNonScrollableImageCard(NonScrollableLLViewHolder nonScrollableLLViewHolder,
                                           List<Card> cards) {
        for (Card card : cards) {
            ImageCardViewHolder imageCardViewHolder = new ImageCardViewHolder(LayoutInflater.from(nonScrollableLLViewHolder.itemView.getContext())
                    .inflate(R.layout.image_card_item_layout, (ViewGroup) nonScrollableLLViewHolder.itemView, false));
            Glide.with(imageCardViewHolder.itemView)
                    .load(card.getBgImage().getImageUrl())
                    .into(new CustomTarget<Drawable>() {
                        @Override
                        public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                            imageCardViewHolder.imageCardLl.setBackground(resource);
                        }

                        @Override
                        public void onLoadCleared(@Nullable Drawable placeholder) {
                            imageCardViewHolder.imageCardLl.setBackground(placeholder);
                        }
                    });
            imageCardViewHolder.itemView.setLayoutParams(new LinearLayout.LayoutParams(
                    0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f
            ));
            nonScrollableLLViewHolder.nonScrollableLl.addView(imageCardViewHolder.itemView);
        }
    }

    private void layNonScrollableSmallArrowCard(NonScrollableLLViewHolder nonScrollableLLViewHolder,
                                                List<Card> cards) {
        for (Card card : cards) {
            SmallCardWithArrowViewHolder smallCardWithArrowViewHolder = new SmallCardWithArrowViewHolder(LayoutInflater.from(nonScrollableLLViewHolder.itemView.getContext())
                    .inflate(R.layout.small_card_with_arrow_item_layout, (ViewGroup) nonScrollableLLViewHolder.itemView, false));
            smallCardWithArrowViewHolder.smallArrowCard.setCardBackgroundColor(Color.parseColor(
                    card.getBgColor()
            ));
            smallCardWithArrowViewHolder.smallArrowCardTv.setText(card.getTitle());
            smallCardWithArrowViewHolder.smallArrowCard.setLayoutParams(new LinearLayout.LayoutParams(
                    0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f
            ));
            nonScrollableLLViewHolder.nonScrollableLl.addView(smallCardWithArrowViewHolder.itemView);
        }
    }

    // Currently, we are allowing small cards scrollable.
    // The same functionality needs to be applied for other types
    // of scrollable cards as well.
    private void layScrollableSmallDisplayCard(ScrollableViewHolder scrollableViewHolder,
                                               List<Card> cards) {
        for (Card card : cards) {
            SmallDisplayCardViewHolder smallDisplayCardViewHolder =
                    new SmallDisplayCardViewHolder(LayoutInflater.from(scrollableViewHolder.itemView.getContext())
                            .inflate(R.layout.small_display_card_item_layout, (ViewGroup) scrollableViewHolder.itemView, false));

            smallDisplayCardViewHolder.smallDisplayCard.setCardBackgroundColor(Color.parseColor(
                    card.getBgColor()
            ));
            smallDisplayCardViewHolder.smallDisplayCardTv.setText(card.getTitle()); // could be formatted title
            smallDisplayCardViewHolder.aryaStarkTv.setText(card.getDescription()); // could be formatted desc
            Glide.with(smallDisplayCardViewHolder.itemView)
                    .load(card.getIcon().getImageUrl())
                    .into(smallDisplayCardViewHolder.smallDisplayCardIv);
            scrollableViewHolder.scrollableLl.addView(smallDisplayCardViewHolder.itemView);
        }
    }

    @Override
    public int getItemCount() {
        return cardGroupList.size();
    }

    public interface OnItemRemoveListener {
        void onItemRemoved(int position);
    }
}
