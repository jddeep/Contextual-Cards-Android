package com.jddeep.contextualcards.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FormattedTitle {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("entities")
    @Expose
    private List<Entity> entities = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public FormattedTitle() {
    }

    /**
     *
     * @param entities
     * @param text
     */
    public FormattedTitle(String text, List<Entity> entities) {
        super();
        this.text = text;
        this.entities = entities;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

}