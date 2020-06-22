package com.jddeep.contextualcards.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BgImage {

    @SerializedName("image_type")
    @Expose
    private String imageType;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("asset_type")
    @Expose
    private String assetType;

    /**
     * No args constructor for use in serialization
     *
     */
    public BgImage() {
    }

    /**
     *
     * @param imageUrl
     * @param imageType
     * @param assetType
     */
    public BgImage(String imageType, String imageUrl, String assetType) {
        super();
        this.imageType = imageType;
        this.imageUrl = imageUrl;
        this.assetType = assetType;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

}
