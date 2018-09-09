package com.example.acer.myapplicationiu;

import android.app.Activity;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;
import java.util.List;

public class AktivitetiHosp extends AppCompatActivity {
    String [] emrat = {"Spitali rajonal i Pejes", "SHSKUK - Klinika e fizioterapise",
            "Klinika dentare MEDIDENT", "Klinika dentare - DR.BESI", "Klinika PSIKO-MED", "Klinika MAXOFACIALIS"};
    String [] descriptions = {"Spital i te gjitha sherbimeve spitalore", "Klinike e rehabilitimit fizikal",
            "Klinike e te gjitha sherbimeve dentare", "Klinike e te gjitha sherbimeve dentare", "Klinike e sherbimeve psikiatrike",
    "Klinike e sherbimeve maksilofaciale"};
    String [] rruga = {"Rruga: 'Nezhdet Basha' Nr. 65", "Rruga: 'Fatmir Ukaj' Nr.34", "Rruga: 'Misin Kabashi', Nr.13",
            "Rruga 'Mbreteresha Teute' Nr.14", "Rruga 'Mitrush Gashi' Nr.16", "Rr. 'Nezhdet Gorani', Nr. 19"};
    String [] telefoni = {"044-4499044", "0800-12220", "9999-3333", "+38349831123", "+38344984123", "+3834591232"};
    Toolbar toolbar;
    ImageView imageView;
    Bundle bundle;
    String qyteti;
    String [] emratPrishtine = {"Instituti i Oftamologjise - Klinika Gjermane e Syrit",
            "Qendra Klinike Universitare e Kosoves", "Qendra Laserike e Syrit 'KUBATI'", "Spitali Aloka", "Spitali Amerikan", "Q.D.T 'Rezonanca'",
       "Spitali LINDJA", "Bahceci Specialty Hospital", "Gopal-Dent", "Spitali Evropian Ortopedik", "Vita Hospital", "Ars Medica", "Dental-V"};
    String [] descPrishtine = {"Klinike e sherbimeve te syrit", "Spital i te gjitha sherbimeve spitalore", "Klinike profesionale e sherbimeve te syrit",
    "Spital i te gjitha sherbimeve spitalore", "Spital i te gjitha sherbimeve spitalore", "Spital i te gjitha sherbimeve spitalore",
    "Spital i sherbimeve gjinekologjike", "Spital i te gjitha sherbimeve spitalore", "Klinike e te gjitha sherbimeve dentare", "Spital i sherbimeve gjinekologjike",
    "Spital i sherbimeve gjinekologjike", "Spital i sherbimeve gjinekologjike", "Spital i sherbimeve dentare"};
    String [] rrugaPr = {"Rruga: 'Nezhdet Basha' Nr. 65", "Rruga: 'Fatmir Ukaj' Nr.34", "Rruga: 'Misin Kabashi', Nr.13",
            "Rruga 'Mbreteresha Teute' Nr.14", "Rruga 'Mitrush Gashi' Nr.16", "Rr. 'Nezhdet Gorani', Nr. 19", "Rruga: 'Nezhdet Basha' Nr. 65", "Rruga: 'Fatmir Ukaj' Nr.34", "Rruga: 'Misin Kabashi', Nr.13",
            "Rruga 'Mbreteresha Teute' Nr.14", "Rruga 'Mitrush Gashi' Nr.16", "Rr. 'Nezhdet Gorani', Nr. 19", "Rruga 'Mbreteresha Teute' Nr.14" };
    String [] telefoniPr = {"044-4499044", "0800-12220", "9999-3333", "+38349831123", "+38344984123", "+3834591232","044-4499044",
            "0800-12220", "9999-3333", "+38349831123", "+38344984123", "+3834591232", "+383431321" };
    int spitalPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktiviteti_hosp);
        final ListView listView = (ListView)findViewById(R.id.hospList);
        CustomAdapter customAdapter = new CustomAdapter();
        bundle = new Bundle();
        qyteti = getIntent().getStringExtra("qyteti");
        Log.d("g", qyteti);
        toolbar = (Toolbar)findViewById(R.id.toolbarHosp);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(null);

        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                spitalPos = position;
                if (spitalPos == 0)
                {
                    Intent intent = new Intent(AktivitetiHosp.this, PershkrimiHospitalit.class);
                    bundle.putInt("spitali", position);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else if (spitalPos == 1)
                {
                    Intent intent = new Intent(AktivitetiHosp.this, PershkrimiHospitalit.class);
                    bundle.putInt("spitali", position);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });


    }
    class CustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            if (qyteti.equals("Prishtine"))
            {
                return emratPrishtine.length;
            }
          return emrat.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.hospitallist, null);
            TextView textView = (TextView)convertView.findViewById(R.id.txt90);
            TextView textView1 = (TextView)convertView.findViewById(R.id.txt91);
            TextView textView2 = (TextView)convertView.findViewById(R.id.txt92);
            TextView textView3 = (TextView)convertView.findViewById(R.id.txt93);
            if (qyteti.equals("Prishtine"))
            {
             textView.setText(emratPrishtine[position]);
                textView1.setText(descPrishtine[position]);
                textView2.setText(rrugaPr[position]);
                textView3.setText(telefoniPr[position]);
            }
            else {
                textView.setText(emrat[position]);
                textView1.setText(descriptions[position]);
                textView2.setText(rruga[position]);
                textView3.setText(telefoni[position]);

            }
            return convertView;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.harta, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.hartaHosp)
        {
            if (qyteti.equals("Prishtine"))
            {
                Intent intent = new Intent(AktivitetiHosp.this, HartaSpitaleve.class);
                bundle.putString("spitali", qyteti);
                intent.putExtras(bundle);
                startActivity(intent);
            }
            else if (qyteti.equals("Peje"))
            {
                Intent intent = new Intent(AktivitetiHosp.this, HartaSpitaleve.class);
                bundle.putString("spitali", qyteti);
                intent.putExtras(bundle);
                startActivity(intent);
            }

        }
        return true;
    }
}