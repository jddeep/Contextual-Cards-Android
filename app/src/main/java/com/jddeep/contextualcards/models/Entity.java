package com.jddeep.contextualcards.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entity {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("other_url")
    @Expose
    private String otherUrl;
    @SerializedName("url_choice")
    @Expose
    private String urlChoice;
    @SerializedName("url")
    @Expose
    private String url;

    /**
     * No args constructor for use in serialization
     *
     */
    public Entity() {
    }

    /**
     *
     * @param color
     * @param text
     * @param type
     * @param otherUrl
     * @param url
     * @param urlChoice
     */
    public Entity(String text, String type, String color, String otherUrl, String urlChoice, String url) {
        super();
        this.text = text;
        this.type = type;
        this.color = color;
        this.otherUrl = otherUrl;
        this.urlChoice = urlChoice;
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOtherUrl() {
        return otherUrl;
    }

    public void setOtherUrl(String otherUrl) {
        this.otherUrl = otherUrl;
    }

    public String getUrlChoice() {
        return urlChoice;
    }

    public void setUrlChoice(String urlChoice) {
        this.urlChoice = urlChoice;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}