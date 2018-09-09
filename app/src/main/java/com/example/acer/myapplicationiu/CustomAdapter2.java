package com.example.acer.myapplicationiu;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter2 extends BaseAdapter {
     Context context;
     ArrayList<Model> itemModelList;
     Button button;

    public CustomAdapter2(Context context, ArrayList<Model> itemModelList) {
        this.context = context;
        this.itemModelList = itemModelList;
    }

    @Override
    public int getCount() {
        return itemModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = null;
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.interactionmeds, null);
            TextView tvName = (TextView) convertView.findViewById(R.id.interMeds);
            ImageView imgRemove = (ImageView) convertView.findViewById(R.id.deleteDrug);
            Model m = itemModelList.get(position);
            button = (Button)convertView.findViewById(R.id.ShfaqInteraksion);
            tvName.setText(m.getName());
            imgRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemModelList.remove(position);
                    notifyDataSetChanged();
                }
            });

        }
        return convertView;
    }
}
