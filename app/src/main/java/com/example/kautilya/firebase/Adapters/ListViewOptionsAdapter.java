package com.example.kautilya.firebase.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kautilya.firebase.Data.API;
import com.example.kautilya.firebase.GoogleCloud;
import com.example.kautilya.firebase.Libraires.Maps;
import com.example.kautilya.firebase.Libraires.MobileVision;
import com.example.kautilya.firebase.Libraires.YouTube;
import com.example.kautilya.firebase.R;

import java.util.ArrayList;

/**
 * Created by mahe on 4/5/2017.
 */

public class ListViewOptionsAdapter extends BaseAdapter {

    ArrayList<API> apiArrayList;
    Context context;
    private LinearLayout image;
    private TextView apiName;

    public ListViewOptionsAdapter(Context context, ArrayList<API> apiArrayList) {
        this.context = context;
        this.apiArrayList = apiArrayList;
    }

    @Override
    public int getCount() {
        return apiArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return apiArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_view_cloud_apis_item, parent, false);
        image = (LinearLayout) view.findViewById(R.id.image_api);
        apiName = (TextView) view.findViewById(R.id.apiname);
        apiName.setText(apiArrayList.get(position).getName());
        image.setBackground(apiArrayList.get(position).getImage());
        int options = apiArrayList.get(position).getId();
        if (options == 1) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.getApplicationContext().startActivity(new Intent(context, MobileVision.class));
                }
            });
        } else if (options == 2) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.getApplicationContext().startActivity(new Intent(context, Maps.class));
                }
            });
        } else if (options == 3) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.getApplicationContext().startActivity(new Intent(context, YouTube
                        .class));
            }
        });
    }
        return view;
    }
}
