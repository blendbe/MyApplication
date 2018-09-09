package com.example.acer.myapplicationiu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

public class CheckSyptomsActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_syptoms);
        toolbar = (Toolbar)findViewById(R.id.to);
        setSupportActionBar(toolbar);
        textView = toolbar.findViewById(R.id.age);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(null);
        final Button btnvazhdo = (Button) findViewById(R.id.btnVazhdoo);
        final EditText mosha = (EditText) findViewById(R.id.etMosha);
        btnvazhdo.setEnabled(false);
        mosha.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String mosha1 = mosha.getText().toString();
                if (!mosha1.isEmpty())
                {
                    btnvazhdo.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                String mosha1 = mosha.getText().toString();
                if (mosha1.isEmpty())
                {
                    btnvazhdo.setEnabled(false);
                }
            }
        });

        btnvazhdo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(CheckSyptomsActivity.this, AdvancedSearchBarActivity.class));
                }
            });

    }
}
