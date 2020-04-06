package com.example.ge_android_vendor;

public class Item {

    private String Title;
    private String Description;
    private final int ImageResource;

    public Item(String title, String description,int imageResource) {
        Title = title;
        Description = description;
        ImageResource = imageResource;
    }

    String getTitle(){
        return Title;
    }

    String getDescription() {
        return Description;
    }

    public int getImageResource() {
        return ImageResource;
    }
}
