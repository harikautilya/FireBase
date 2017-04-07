package com.example.kautilya.firebase.Data;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/**
 * Created by mahe on 4/5/2017.
 */

public class API {

    int Id;
    Drawable image;
    String name;

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
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
