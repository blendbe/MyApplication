package com.example.acer.myapplicationiu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class Interactions1 extends AppCompatActivity {
    ListView listView, listView1;
    TextView res;
    EditText editText;
    ArrayList<Model> ItemModelList;
    CustomAdapter2 customAdapter2;
    Button btn;
    String[] meds = {"Paracetamol", "Iboprufen", "Diazepam", "Buskopan", "Talvosilen",
            "Cafetin", "Omega 3", "Dafalgan", "Gotu Kola", "Acetaminophen", "Adderall",
            "Amoxicillin", "Ativan", "Baktrim"};
    int[] add = {R.drawable.ic_add_circle_black_24dp, R.drawable.ic_add_circle_black_24dp,
            R.drawable.ic_add_circle_black_24dp, R.drawable.ic_add_circle_black_24dp,
            R.drawable.ic_add_circle_black_24dp, R.drawable.ic_add_circle_black_24dp,
            R.drawable.ic_add_circle_black_24dp, R.drawable.ic_add_circle_black_24dp,
            R.drawable.ic_add_circle_black_24dp, R.drawable.ic_add_circle_black_24dp,
            R.drawable.ic_add_circle_black_24dp, R.drawable.ic_add_circle_black_24dp,
            R.drawable.ic_add_circle_black_24dp, R.drawable.ic_add_circle_black_24dp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interactions1);
        listView = (ListView) findViewById(R.id.listMed);
        listView1 = (ListView)findViewById(R.id.lstremove);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolInter);
        editText = (EditText) findViewById(R.id.eKerko);
        res = (TextView) findViewById(R.id.nores);
        ItemModelList = new ArrayList<>();
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Shiko interaksionet");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        customAdapter2 = new CustomAdapter2(getApplicationContext(), ItemModelList);
        listView1.setAdapter(customAdapter2);
        final CustomAdapter1 adapter = new CustomAdapter1(this, getMeds());
        listView.setAdapter(adapter);
        btn = (Button)findViewById(R.id.ShfaqInteraksion);
        btn.setVisibility(View.GONE);
        if (listView1.getCount() == 0)
        if (listView1.getAdapter().getCount() >1)
        {
            btn.setVisibility(View.VISIBLE);
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView)view.findViewById(R.id.IntMedTxt);
                String text = textView.getText().toString();
                Model md = new Model(text);
                ItemModelList.add(md);
                customAdapter2.notifyDataSetChanged();
                if (listView1.getAdapter().getCount() >1)
                {
                    btn.setVisibility(View.VISIBLE);
                }
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                adapter.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private ArrayList<MedikamentetModel> getMeds() {
        ArrayList<MedikamentetModel> meds1 = new ArrayList<MedikamentetModel>();
        MedikamentetModel m;
        for (int i = 0; i < meds.length; i++) {
            m = new MedikamentetModel(meds[i], add[i]);
            meds1.add(m);
        }
        return meds1;
    }
}

