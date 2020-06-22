package com.jddeep.contextualcards.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FormattedDescription {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("entities")
    @Expose
    private List<Entity_> entities = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public FormattedDescription() {
    }

    /**
     *
     * @param entities
     * @param text
     */
    public FormattedDescription(String text, List<Entity_> entities) {
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

    public List<Entity_> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity_> entities) {
        this.entities = entities;
    }

}