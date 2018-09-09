package com.example.acer.myapplicationiu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListaBarnatoreve extends AppCompatActivity {
    String [] emrat = {"Barnatore LIKA", "Barnatore KASTRATI",
            "Barnatore LEOMED", "Barnatore ROLI", "Barnatore IKRE PHARM", "Barnatore EDONA"};
    String [] descriptions = {"Rruga 'Mbreteresha Teute'", "Rruga 'Mbreteresha Teute'",
            "Rruga 'Mbreteresha Teute'", "Rruga 'Mbreteresha Teute'", "Rruga 'Adem Jashari'",
            "Rruga 'Wesley Clark'", "Rruga 'Eliot Engel'"};
    String [] rruga = {"Orari i punes: 08-21", "Orari i punes: 08-24", "Orari i punes: 08-22",
            "Orari i punes: 08-21", "Orari i punes: 08-23", "Orari i punes: 07-20"};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_barnatoreve);
        listView = (ListView)findViewById(R.id.lstPharma);
        CAdapter2 customAdapter = new CAdapter2();
        listView.setAdapter(customAdapter);

    }
    public class CAdapter2 extends BaseAdapter
    {

        @Override
        public int getCount() {
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
            convertView = getLayoutInflater().inflate(R.layout.pharmacylist, null);
            TextView textView = (TextView)convertView.findViewById(R.id.txtbarn);
            TextView textView1 = (TextView)convertView.findViewById(R.id.txtrr);
            TextView textView2 = (TextView)convertView.findViewById(R.id.txtor);
            textView.setText(emrat[position]);
            textView1.setText(descriptions[position]);
            textView2.setText(rruga[position]);
            return convertView;
        }
    }
}
