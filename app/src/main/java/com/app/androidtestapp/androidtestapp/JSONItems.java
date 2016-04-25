package com.app.androidtestapp.androidtestapp;

import java.io.Serializable;

/**

 * Holds the information about the image asnd description
 */
public class JSONItems implements Serializable {

    private String image;
    private String description;
    private String thumbnail;

    public JSONItems(){}

    //getters and setters


    public String getImage() {
        return image;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
