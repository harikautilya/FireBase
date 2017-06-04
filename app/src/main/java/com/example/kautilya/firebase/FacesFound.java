package com.example.kautilya.firebase;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Spinner;

/**
 * Created by mahe on 4/8/2017.
 */

public class FacesFound extends AppCompatActivity {
    ImageView facesdisplay;
    Spinner facesList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_found);

        facesdisplay=(ImageView)findViewById(R.id.facesphoto);
        facesList=(Spinner)findViewById(R.id.facespeople);



    }
}
