package com.jddeep.contextualcards.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Card {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("formatted_title")
    @Expose
    private FormattedTitle formattedTitle;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("formatted_description")
    @Expose
    private FormattedDescription formattedDescription;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("bg_image")
    @Expose
    private BgImage bgImage;
    @SerializedName("bg_color")
    @Expose
    private String bgColor;
    @SerializedName("icon")
    @Expose
    private Icon icon;
    @SerializedName("cta")
    @Expose
    private List<Ctum> cta = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Card() {
    }

    /**
     *  @param name
     * @param title
     * @param formattedTitle
     * @param description
     * @param formattedDescription
     * @param url
     * @param bgImage
     * @param bgColor
     * @param icon
     * @param cta
     */
    public Card(String name, String title, FormattedTitle formattedTitle, String description, FormattedDescription formattedDescription, String url, BgImage bgImage, String bgColor, Icon icon, List<Ctum> cta) {
        super();
        this.name = name;
        this.title = title;
        this.formattedTitle = formattedTitle;
        this.description = description;
        this.formattedDescription = formattedDescription;
        this.url = url;
        this.bgImage = bgImage;
        this.bgColor = bgColor;
        this.icon = icon;
        this.cta = cta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FormattedTitle getFormattedTitle() {
        return formattedTitle;
    }

    public void setFormattedTitle(FormattedTitle formattedTitle) {
        this.formattedTitle = formattedTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FormattedDescription getFormattedDescription() {
        return formattedDescription;
    }

    public void setFormattedDescription(FormattedDescription formattedDescription) {
        this.formattedDescription = formattedDescription;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BgImage getBgImage() {
        return bgImage;
    }

    public void setBgImage(BgImage bgImage) {
        this.bgImage = bgImage;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public List<Ctum> getCta() {
        return cta;
    }

    public void setCta(List<Ctum> cta) {
        this.cta = cta;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}