package com.example.acer.myapplicationiu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShfaqSemundjet extends AppCompatActivity {
   ListView lstView;
   Bundle bundle;
   ArrayList<Integer> lstFound = new ArrayList<>();
   ArrayList<String> dname;
  DatabaseCheck db;
  Cursor res;
  TextView understandRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shfaq_semundjet);
        this.deleteDatabase("projektikosmed.db");
        Toolbar toolbar12 = (Toolbar) findViewById(R.id.toolbar12);
        setSupportActionBar(toolbar12);
        understandRes = (TextView)findViewById(R.id.understandresults);
        bundle = new Bundle();
        db = new DatabaseCheck(this);
        dname = new ArrayList<>();
        getSupportActionBar().setTitle("Identifikimi i semundjeve");
        toolbar12.setTitleTextColor(Color.parseColor("#FFFFFF"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bundle = getIntent().getExtras();
        int pozita = bundle.getInt("pozita");
        lstFound = bundle.getIntegerArrayList("listapozita");
        understandRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog alert = new AlertDialog.Builder(ShfaqSemundjet.this).create();
                alert.setTitle("Interpretimi i rezultateve");
                alert.setMessage("- Perqindja e treguar poshte semundjes tregon sa pershtaten simptomat e futura me simptomat e seciles semundje.\n \n" +
                        "- Nuk paraqet gjasen e te pasurit ate semundje.\n \n" +
                        "- Nese nje semundje eshte e listuar ketu, nuk do te thote qe ju e posedoni ate. \n \n" +
                        "- Bisedoni me doktorin tuaj per te kuptuar me shume rreth rezultatit te simptomave tuaja.");


                alert.show();
                alert.setIcon(R.drawable.ic_assessment_black_24dp);
            }

        });
        int count = lstFound.size();
        if (count ==1)
        {
            res = db.data(lstFound.get(0),0,0,0);
        }
        else if (count == 2)
        {
            res = db.data(lstFound.get(0), lstFound.get(1), 0, 0);
        }
        else if (count == 3)
        {
            res = db.data(lstFound.get(0), lstFound.get(1), lstFound.get(2), 0);
        }
        else if (count == 4)
        {
            res = db.data(lstFound.get(0), lstFound.get(1), lstFound.get(2), lstFound.get(3));
        }
        Log.d("POZITA", "P" + lstFound);
        if (res != null && res.moveToFirst())
        {
           while (res.moveToNext())
           {
               float a = res.getFloat(1)*100;
               int b = Math.round(a);
               dname.add(res.getString(0) + " \n " + b + "%");
           }
            Log.d("POZITAA", "P" + dname);
        }
        lstView = (ListView)findViewById(R.id.listashfaq);
        ArrayAdapter adapter = new ArrayAdapter(ShfaqSemundjet.this,android.R.layout.simple_list_item_1, dname);
        lstView.setAdapter(adapter);
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)lstView.getItemAtPosition(position);
                ArrayList<String> vargu = new ArrayList<>();
                vargu.add(item);
                    Intent intenti = new Intent(ShfaqSemundjet.this, Sqarimet.class);
                    bundle.putString("semundja", item);
                    intenti.putExtras(bundle);
                    startActivity(intenti);

                }

            });

    }
}
