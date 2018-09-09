package com.example.acer.myapplicationiu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

public class IMT extends AppCompatActivity {
    EditText e1, e2;
    TextView e3, e4, e5, e6, e7;
    Double rezultati;
    Button btn;
    Toolbar toolbar;
    TextView hh;
  String rez;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imt);
        e1 = (EditText)findViewById(R.id.numriGjatesia);
        e2 = (EditText)findViewById(R.id.numriPesha);
        e3 = (TextView)findViewById(R.id.numriIMT);
        e4 = (TextView)findViewById(R.id.inter1);
        e5 = (TextView)findViewById(R.id.inter2);
        toolbar = (Toolbar)findViewById(R.id.toolbarIMT);
        e6 = (TextView)findViewById(R.id.inter3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        hh = (TextView)toolbar.findViewById(R.id.shtoIMT);
        getSupportActionBar().setTitle(null);
        e7 = (TextView)findViewById(R.id.inter4);
        btn = (Button)findViewById(R.id.kalkuloIMT);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gjatesia = e1.getText().toString();
                String pesha = e2.getText().toString();
                double gjatesia1 = Double.parseDouble(gjatesia);
                double pesha1 = Double.parseDouble(pesha);
                double rezultati = (pesha1/gjatesia1)/gjatesia1;
                String finali = String.valueOf(rezultati);
                e3.setText(finali);
                if (rezultati <18)
                {
                    e4.setBackgroundColor(Color.LTGRAY);
                }
                else if (rezultati >=18 || rezultati <25)
                {
                    e5.setBackgroundColor(Color.LTGRAY);
                }
                else if (rezultati >=25 || rezultati<30)
                {
                    e6.setBackgroundColor(Color.LTGRAY);
                }
                else
                {
                    e7.setBackgroundColor(Color.LTGRAY);
                }
            }
        });

    }
}
