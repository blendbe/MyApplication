package com.example.acer.myapplicationiu;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListaMedikamenteveActivity extends AppCompatActivity {
    MaterialSearchView searchViewLista;
    ListView listaMedikamente;
    String[] listaamed = {
            "Paracetamol",
            "Iboprufen",
            "Diazepam",
            "Buskopan",
            "Talvosilen",
            "Cafetin",
            "Omega 3",
            "Dafalgan",
            "Gotu Kola",
            "Astma",
            "Teshtime"
    };
    String [] info = {"Nuk ka rezultate"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_medikamenteve);
        Toolbar toolbar14 = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar14);
        getSupportActionBar().setTitle("Kerko medikamente");
        toolbar14.setTitleTextColor(Color.parseColor("#000000"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listaMedikamente = (ListView) findViewById(R.id.listamed);

        searchViewLista = (MaterialSearchView) findViewById(R.id.search_view_medikamenti);
        listaMedikamente.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) listaMedikamente.getItemAtPosition(position);
                   Intent intent=new Intent(view.getContext(),DiseaseExplanationActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   intent.putExtra("DISEASE", item);
                   startActivityForResult(intent, position);
            }
        });
        searchViewLista.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {

            }
        });
        searchViewLista.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText != null && !newText.isEmpty()) {
                    List<String> lstFound = new ArrayList<String>();
                    for (String item : listaamed) {
                        if (item.toLowerCase().contains(newText.toLowerCase()))
                        {
                            lstFound.add(item);
                        }
                    }
                    Collections.sort(lstFound);
                    if (lstFound.size() == 0)
                    {
                        ArrayAdapter adapter = new ArrayAdapter(ListaMedikamenteveActivity.this, android.R.layout.simple_list_item_1, info);
                        listaMedikamente.setAdapter(adapter);
                    }
                    else
                    {
                    ArrayAdapter adapter = new ArrayAdapter(ListaMedikamenteveActivity.this, android.R.layout.simple_list_item_1, lstFound);
                    listaMedikamente.setAdapter(adapter);}
                } else {
                    ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(listaamed));
                    Collections.sort(arrayList);
                    ArrayAdapter adapter = new ArrayAdapter(ListaMedikamenteveActivity.this, android.R.layout.simple_list_item_1, listaamed);
                    listaMedikamente.setAdapter(adapter);
                }
                return true;
            }
        });
    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_item,menu);
            MenuItem item = menu.findItem(R.id.action_search);
            searchViewLista.setMenuItem(item);
            return true;
        }
    }

