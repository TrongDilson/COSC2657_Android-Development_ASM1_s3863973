package com.example.assignment1_s3863973;

public class SurvivalTip {
    private String title;
    private String description;
    private String imageResName;

    // Constructor
    public SurvivalTip(String title, String description, String imageResName) {
        this.title = title;
        this.description = description;
        this.imageResName = imageResName;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageResName() {
        return imageResName;
    }

    // Setter methods (optional, if needed)
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageResName(String imageResName) {
        this.imageResName = imageResName;
    }
}
