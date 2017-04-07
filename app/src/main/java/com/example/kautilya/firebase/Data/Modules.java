package com.example.kautilya.firebase.Data;

import android.graphics.Bitmap;

/**
 * Created by mahe on 4/2/2017.
 */

public class Modules {

    int Id;
    Bitmap image;
    String name;

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }
}
