package com.example.acer.myapplicationiu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.pchmn.materialchips.ChipView;

import java.util.ArrayList;
import java.util.List;

public class Interactions extends AppCompatActivity {
    ImageView imageView;
    ListView lst;
    Interactions1 interactions1 = new Interactions1();
    ArrayList<Model> ItemModelList;
    CustomAdapter2 customAdapter2;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interactions);
        imageView = (ImageView) findViewById(R.id.shto);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Interactions.this, Interactions1.class));

            }
        });

    }
}
