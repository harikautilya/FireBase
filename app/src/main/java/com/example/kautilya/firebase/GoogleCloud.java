package com.example.kautilya.firebase;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.kautilya.firebase.Adapters.ListViewOptionsAdapter;
import com.example.kautilya.firebase.Data.API;

import java.util.ArrayList;

/**
 * Created by mahe on 4/5/2017.
 */

public class GoogleCloud extends AppCompatActivity {
    ListView apiOptions;
    ArrayList<API> apiArrayList;
    API api;
    private Drawable drawable;
    ListViewOptionsAdapter adapter;
    private Context context;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_cloud_options);
        apiOptions=(ListView)findViewById(R.id.apioptions);
        context=this;
        intilize();
        adapter=new ListViewOptionsAdapter(context,apiArrayList);
        apiOptions.setAdapter(adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void intilize() {
        apiArrayList=new ArrayList<>();

        api=new API();
        drawable=getDrawable(R.drawable.icon);
        api.setId(1);
        api.setImage(drawable);
        api.setName("MOBILE VISION");
        apiArrayList.add(api);

        api=new API();
        drawable=getDrawable(R.drawable.pizza);
        api.setId(2);
        api.setImage(drawable);
        api.setName("MAPS API");
        apiArrayList.add(api);

        api=new API();
        drawable=getDrawable(android.R.drawable.ic_menu_upload_you_tube);
        api.setId(3);
        api.setImage(drawable);
        api.setName("YOUTUBE API");
        apiArrayList.add(api);


    }

    /**
     * Created by mahe on 4/4/2017.
     */

}
