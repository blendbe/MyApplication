package com.example.acer.myapplicationiu;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class PershkrimiHospitalit extends AppCompatActivity {
   ViewPager viewPager;
   ListView listView;
   ArrayAdapter adapter;
   Button buttonIP, buttonAH, buttonQZ;
   String [] specialitiesAH = {"Alergji", "Alergji dhe imunologji", "Anesteziologji", "Diabet", "Emergjence", "Endokrinologji", "Gastroendokrinologji",
   "Gjinekologji", "Hematologji"};
    String [] specialitiesIP = {"Imunologji", "Nefrologji", "Neurokirurgji", "Neurologji", "Obstetrike", "Oftamologji", "Optometri",
            "Otorinolaringologji", "Patologji", "Pediatri", "Psikiatri", "Pulmologji"};
    String [] specialitiesQZ = {"Radiologji", "Reumatologji", "Urologji", "Vaskulare"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pershkrimi_hospitalit);
        listView = (ListView)findViewById(R.id.ListofDocs);
        adapter = new ArrayAdapter(PershkrimiHospitalit.this,android.R.layout.simple_list_item_1, specialitiesAH);
        listView.setAdapter(adapter);
        buttonIP = (Button)findViewById(R.id.listaIP);
        buttonAH = (Button)findViewById(R.id.listaAH);
        buttonQZ = (Button)findViewById(R.id.listaQZ);
        buttonQZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter = new ArrayAdapter(PershkrimiHospitalit.this,android.R.layout.simple_list_item_1, specialitiesQZ);
                listView.setAdapter(adapter);
            }
        });
        buttonAH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter = new ArrayAdapter(PershkrimiHospitalit.this,android.R.layout.simple_list_item_1, specialitiesAH);
                listView.setAdapter(adapter);
            }
        });
        buttonIP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter = new ArrayAdapter(PershkrimiHospitalit.this,android.R.layout.simple_list_item_1, specialitiesIP);
                listView.setAdapter(adapter);
            }
        });

    }
}
