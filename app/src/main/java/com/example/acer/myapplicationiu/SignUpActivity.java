package com.example.acer.myapplicationiu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    private Button btnRegister;
    private ProgressDialog progressDialog;
    private FirebaseAuth auth;
    private EditText etmail, ettpsw1, ettpsw2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        progressDialog = new ProgressDialog(this);
        Spinner qyteti = (Spinner) findViewById(R.id.qytetii);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.qytetet, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        qyteti.setAdapter(adapter);
        TextView tvKycuu = (TextView) findViewById(R.id.tvKycu);
        tvKycuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
            }
        });
        btnRegister = (Button) findViewById(R.id.btnRegjistrimi);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etmail = (EditText) findViewById(R.id.etmail1);
                ettpsw1 = (EditText) findViewById(R.id.etpass1);
                ettpsw2 = (EditText) findViewById(R.id.etpass2);
                String email = etmail.getText().toString().trim();
                String password = ettpsw2.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Shenoni email adresen!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Shenoni fjalekalimin!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Fjalekalimi duhet te kete te pakten 6 karaktere!", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressDialog.setMessage("Duke regjistruar shfrytezuesin...");
                progressDialog.show();
                auth = FirebaseAuth.getInstance();
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(SignUpActivity.this,"U regjistruat me sukses!",Toast.LENGTH_SHORT).show();
                            progressDialog.hide();

                        }
                        else
                        {
                            Toast.makeText(SignUpActivity.this,"Regjistrimi deshtoi!",Toast.LENGTH_SHORT).show();
                            progressDialog.hide();
                            return;
                        }
                        startActivity(new Intent(SignUpActivity.this,Fragment1.class));
                    }
                });

            }
        });
    }
}

