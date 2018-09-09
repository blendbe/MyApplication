package com.example.acer.myapplicationiu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListaDoktorave extends AppCompatActivity {
    String [] emrat = {"Bardhyl Berdynaj", "Gezim Devolli", "Shkendije Berisha", "Jeta Gacaferi", "Mithat Emra", "Atdhe Myftari",  "Bashkim Baloku"};
    String [] descriptions = {"0 vleresime", "0 vleresime", "0 vleresime", "0 vleresime", "0 vleresime", "0 vleresime", "0 vleresime"};
    String [] rruga = {"Otorinolaringolog", "Kardiolog", "Nefrologe", "Oftamologe", "Internist", "Pulmolog", "Dentist"};
    String [] telefoni = {"044-4499044", "0800-12220", "9999-3333", "+38349831123", "+38344984123", "+3834591232"};
    int [] images = {R.drawable.docsphoto, R.drawable.docsphoto, R.drawable.docsphoto, R.drawable.docsphoto, R.drawable.docsphoto,
            R.drawable.docsphoto, R.drawable.docsphoto};
    Bundle bundle;
    ListView listt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_doktorave);
        listt = (ListView)findViewById(R.id.listaDoc);
        CAdapter3 cAdapter3 = new CAdapter3();
        listt.setAdapter(cAdapter3);
        bundle = new Bundle();
        listt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView)view.findViewById(R.id.docsName);
                String docname = textView.getText().toString();
                int pozita = position;
                if (pozita == 0)
                {
                    Intent intent = new Intent(ListaDoktorave.this, MapsActivity.class);
                    bundle.putInt("pozita", pozita);
                    bundle.putString("emri", docname);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else if (pozita == 1)
                {
                    Intent intent = new Intent(ListaDoktorave.this, MapsActivity.class);
                    bundle.putInt("pozita", pozita);
                    bundle.putString("emri", docname);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else
                {

                }

            }
        });
    }
    public class CAdapter3 extends BaseAdapter
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
            convertView = getLayoutInflater().inflate(R.layout.listadoktoreveshabllon, null);
            TextView textView = (TextView)convertView.findViewById(R.id.docsName);
            TextView textView1 = (TextView)convertView.findViewById(R.id.docTotalrating);
            TextView textView2 = (TextView)convertView.findViewById(R.id.docsSpeciality);
            ImageView imageView = (ImageView)convertView.findViewById(R.id.DocsPhoto) ;
            if (position % 2 == 0)
            {
             textView2.setText("Numer cift");
            }
            textView.setText(emrat[position]);
            textView1.setText(descriptions[position]);
            imageView.setImageResource(images[position]);
            return convertView;
        }
    }
}
