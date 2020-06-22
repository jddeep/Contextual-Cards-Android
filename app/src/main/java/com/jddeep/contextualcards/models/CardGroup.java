package com.jddeep.contextualcards.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CardGroup {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("design_type")
    @Expose
    private String designType;
    @SerializedName("card_type")
    @Expose
    private Integer cardType;
    @SerializedName("cards")
    @Expose
    private List<Card> cards = null;
    @SerializedName("is_scrollable")
    @Expose
    private Boolean isScrollable;

    /**
     * No args constructor for use in serialization
     *
     */
    public CardGroup() {
    }

    /**
     *
     * @param cards
     * @param isScrollable
     * @param designType
     * @param name
     * @param cardType
     * @param id
     */
    public CardGroup(Integer id, String name, String designType, Integer cardType, List<Card> cards, Boolean isScrollable) {
        super();
        this.id = id;
        this.name = name;
        this.designType = designType;
        this.cardType = cardType;
        this.cards = cards;
        this.isScrollable = isScrollable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignType() {
        return designType;
    }

    public void setDesignType(String designType) {
        this.designType = designType;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Boolean getIsScrollable() {
        return isScrollable;
    }

    public void setIsScrollable(Boolean isScrollable) {
        this.isScrollable = isScrollable;
    }

}