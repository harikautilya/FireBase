package com.example.kautilya.firebase.Libraires;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.BuildConfig;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.kautilya.firebase.R;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;
import com.google.android.gms.vision.face.Landmark;

import java.io.File;
import java.io.IOException;


/**
 * Created by mahe on 4/5/2017.
 */

public class MobileVision extends AppCompatActivity {

    Bitmap bitmap;
    Context context;
    private Uri imageUri;
    File photoFile;
    Button cameraopen;

    private static final int REQUEST_TAKE_PHOTO = 1;
    private String TAG=getCallingPackage();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK)
        {
            bitmap = (Bitmap) data.getExtras().get("data");
            detectFaces();
            Toast.makeText(context,"Photo successfully taken ",Toast.LENGTH_SHORT).show();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_detection);
        context = this;
        cameraopen=(Button)findViewById(R.id.cameraopen);

        cameraopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchCamera();
            }
        });


    }

    void detectFaces()
    {
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setLandmarkType(FaceDetector.ALL_LANDMARKS)
                .build();

        if (detector.isOperational()) {
            Log.d(TAG,"CHECKING AND VERFIYING ");
            Frame frame = new Frame.Builder().setBitmap(bitmap).build();
            SparseArray<Face> faces = detector.detect(frame);
            Log.d("Check","success detected");
            for (int i = 0; i < faces.size(); ++i) {
                Log.d("Check","success");
                Face face = faces.valueAt(i);
                for (Landmark landmark : face.getLandmarks()) {

                    int cx = (int) (landmark.getPosition().x);
                    int cy = (int) (landmark.getPosition().y);
                    Log.d("FACE SUCCESS  "+landmark.getType(),cx+","+cy);
                }
            }
        }
        detector.release();
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void dispatchCamera() {
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_TAKE_PHOTO);
        }
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (camera.resolveActivity(getPackageManager()) != null) {
            String temp = "temp";
            photoFile = new File(this.getCacheDir(), "hello.jpg");
            if (photoFile != null) {
                startActivityForResult(camera, REQUEST_TAKE_PHOTO);
            }
        } else {
            Toast.makeText(context, "Camera not supported", Toast.LENGTH_LONG).show();
        }
    }

}
