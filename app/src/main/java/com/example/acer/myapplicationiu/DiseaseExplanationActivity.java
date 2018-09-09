package com.example.acer.myapplicationiu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class DiseaseExplanationActivity extends AppCompatActivity {
    ListView diseaseExpl;
    TextView textView;
    String disease;
    String [] options = {"Shfrytezimi", "Efektet anesore", "Masat paraprake", "Interaksionet", "Overdoza", "Cmimi"};
    int [] fotot = {R.drawable.ic_keyboard_arrow_right_black_24dp,R.drawable.ic_keyboard_arrow_right_black_24dp,
            R.drawable.ic_keyboard_arrow_right_black_24dp, R.drawable.ic_keyboard_arrow_right_black_24dp,
            R.drawable.ic_keyboard_arrow_right_black_24dp, R.drawable.ic_keyboard_arrow_right_black_24dp};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_explanation);
        ImageView drugImage = (ImageView) findViewById(R.id.drugImage1);
        final ListView diseaseExpl = (ListView)findViewById(R.id.listExplanation);
        textView = (TextView) findViewById(R.id.explanation);
        CustomAdapter customAdapter = new CustomAdapter();
        diseaseExpl.setAdapter(customAdapter);
        disease = getIntent().getStringExtra("DISEASE");
        textView.setText(disease);
        drugImage.setImageDrawable(getDrawable(R.drawable.noimage));
        diseaseExpl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 5)
                {
                    Intent intent = new Intent(DiseaseExplanationActivity.this, CmimiIlaceve.class);
                    intent.putExtra("opsioni", disease);
                    startActivity(intent);
                }
            }
        });
        if (disease.equals("Paracetamol")) {
            drugImage.setImageDrawable(getDrawable(R.drawable.paracetamol));
             textView.setText(disease);
        }
        if (disease.equals("Iboprufen"))
        {
            drugImage.setImageDrawable(getDrawable(R.drawable.brufen));
            textView.setText(disease);
        }
        if (disease.equals("Diazepam"))
        {
            drugImage.setImageDrawable(getDrawable(R.drawable.diazepam));
            textView.setText(disease);
        }


    }
    class CustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return options.length;
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
            convertView = getLayoutInflater().inflate(R.layout.diseaseexplay, null);
            TextView textView = (TextView)convertView.findViewById(R.id.option);
            ImageView imageView = (ImageView)convertView.findViewById(R.id.imgoption);
            textView.setText(options[position]);
            imageView.setImageResource(fotot[position]);

            return convertView;
        }
    }



}
