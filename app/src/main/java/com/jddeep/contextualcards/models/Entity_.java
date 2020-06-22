package com.jddeep.contextualcards.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entity_ {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("color")
    @Expose
    private String color;

    /**
     * No args constructor for use in serialization
     *
     */
    public Entity_() {
    }

    /**
     *
     * @param color
     * @param text
     * @param type
     */
    public Entity_(String text, String type, String color) {
        super();
        this.text = text;
        this.type = type;
        this.color = color;
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

}