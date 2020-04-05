package com.example.ge_android_vendor;

public class Item {

    private String Title;
    private String Description;

    public Item(String title, String description) {
        Title = title;
        Description = description;
    }

    String getTitle(){
        return Title;
    }

    String getDescription() {
        return Description;
    }
}
