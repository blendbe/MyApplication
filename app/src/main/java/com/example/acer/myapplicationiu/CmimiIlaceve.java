package com.example.acer.myapplicationiu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class CmimiIlaceve extends AppCompatActivity {
   Spinner spinner;
   String drug;
   String [] qytetet = new String[] {"Prishtine","Peje", "Gjakove", "Gjilan", "Mitrovice", "Ferizaj", "Decan", "Istog", "Kamenice",
           "Kline", "Prizren", "Podujeve", "Vushtrri", "Suhareke", "Rahovec", "Drenas", "Lipjan", "Malisheve", "Viti",
           "Skenderaj", "Dragash", "Fushe Kosove", "Kacanik", "Shtime"};
   String [] barnatorja = {"LIKA", "KUSHTRIMI MED", "LEO MED", "ROLI", "Ikre Pharm", "Edona", "Besa Pharm","Omega", "ZHUBI", "Syri" };
   String [] adresa = {"Rruga 'Mbreteresha Teute'","Rruga 'Mbreteresha Teute'","Rruga 'Mbreteresha Teute'", "Rruga 'Adem Jashari'",
           "Rruga 'Wesley Clark", "Rruga 'Eliot Engel'", "Rruga 'Adem Jashari'", "Rruga 'Meledine Albright'",
           "Rruga 'William Wolker", "Rruga 'Fehmi Agani'" };
   String [] orari = {"08-21", "08-24", "08-22", "08-22", "08-20", "07-22", "09-23", "08-23", "08-23", "08-20"};
   String [] cmimiParacetamol = {"0.50 €", "0.50 €", "0.30 €", "0.20 €", "0.25 €", "0.30 €", "0.35 €", "0.45 €", "0.40 €", "0.40 €"};
    String [] cmimiDiazepam = {"1.30", "1.30 €", "1.50 €", "1.50 €", "1.45 €", "1.40 €", "1.35 €", "1.30 €", "1.50 €", "1.60 €" };
    String [] cmimiIboprufen = {"0.70", "0.60 €", "0.65 €", "0.70 €", "0.75 €", "0.80 €", "0.85 €", "0.80 €", "0.60 €", "0.60 €"};
    String [] barnatorjaGotu = {"LIKA", "LEO MED", "KUSHTRIM MED"};
    String [] adresaGoku = {"Rruga 'Mbreteresha Teute'", "Rruga 'Mbreteresha Teute'", "Rruga 'Mbreteresha Teute'"};
    String [] orariGoku = {"08-21", "08-24", "08-22"};
    String [] cmimiGoku = {"7.30 €", "6.50 €", "6.90 €"};
    String [] info = {"Nuk ka informacion"};
    ArrayAdapter arrayAdapter;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmimi_ilaceve);
        spinner = (Spinner)findViewById(R.id.citiess);
        drug = getIntent().getStringExtra("opsioni");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, qytetet);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        lista = (ListView)findViewById(R.id.listaBarn);
        final customAdapter4 customAdapter4 = new customAdapter4();
        String text = spinner.getSelectedItem().toString();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String qyteti = (String)spinner.getItemAtPosition(position);
                if (qyteti.equals("Peje"))
                {
                    if ((!drug.equals("Paracetamol")) && (!drug.equals("Diazepam")) && (!drug.equals("Iboprufen")) && (!drug.equals("Gotu Kola")))
                    {
                        ArrayAdapter adapter = new ArrayAdapter(CmimiIlaceve.this,android.R.layout.simple_list_item_1, info);
                        lista.setAdapter(adapter);
                    }
                    else {
                        lista.setAdapter(customAdapter4);
                    }
                }
                else
                {
                    lista.setAdapter(null);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    public class customAdapter4 extends BaseAdapter {

        @Override
        public int getCount() {
            if (drug.equals("Gotu Kola"))
            {
                return barnatorjaGotu.length;
            }
            else if ((drug.equals("Paracetamol"))  || (drug.equals("Diazepam")) || (drug.equals("Iboprufen")))
            {
            return barnatorja.length;}
            else
            {
                return info.length;
            }
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
            convertView = getLayoutInflater().inflate(R.layout.listailaceve, null);
            if (position % 2 == 0) {
                convertView.setBackgroundColor(Color.rgb(229, 229, 255));
            }
            TextView textView = (TextView) convertView.findViewById(R.id.emriBarnatorja);
            TextView textView1 = (TextView) convertView.findViewById(R.id.adresa);
            TextView textView2 = (TextView) convertView.findViewById(R.id.orari);
            TextView textView3 = (TextView) convertView.findViewById(R.id.cmimi);
            if (drug.equals("Diazepam")) {
                textView.setText(barnatorja[position]);
                textView1.setText(adresa[position]);
                textView2.setText(orari[position]);
                textView3.setText(cmimiDiazepam[position]);
            }
            else if (drug.equals("Iboprufen")) {
                textView.setText(barnatorja[position]);
                textView1.setText(adresa[position]);
                textView2.setText(orari[position]);
                textView3.setText(cmimiIboprufen[position]);

            }
            else if (drug.equals("Paracetamol"))
            {
                textView.setText(barnatorja[position]);
                textView1.setText(adresa[position]);
                textView2.setText(orari[position]);
                textView3.setText(cmimiParacetamol[position]);
            }
            else if (drug.equals("Gotu Kola"))
            {
              textView.setText(barnatorjaGotu[position]);
              textView1.setText(adresaGoku[position]);
              textView2.setText(orariGoku[position]);
              textView3.setText(cmimiGoku[position]);

            }

            return convertView;
        }
    }
}
