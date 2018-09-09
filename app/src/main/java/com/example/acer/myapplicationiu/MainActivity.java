package com.example.acer.myapplicationiu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private EditText etmail, etpass;
    private FirebaseAuth auth;
    private TextView tvRegjistrimi;
    private Button btnLogimi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRegjistrimi=(TextView)findViewById(R.id.tvRegjistrohu);
        etmail = (EditText)findViewById(R.id.etmail1);
        etpass = (EditText)findViewById(R.id.etpass1);
        auth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser != null)
        {
            startActivity(new Intent(MainActivity.this, Fragment1.class));
        }
        tvRegjistrimi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SignUpActivity.class));
            }
        });
        btnLogimi = (Button)findViewById(R.id.btnLog);
        btnLogimi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etmail.getText().toString().trim();
                String password = etpass.getText().toString().trim();
                auth = FirebaseAuth.getInstance();
                if (email.isEmpty() || password.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Plotesoni te gjitha fushat!",Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this,"U autentifikuat me sukses!",Toast.LENGTH_SHORT).show();
                            FirebaseUser user = auth.getCurrentUser();

                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"Emaili ose fjalekalimi jane dhene gabim!",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        startActivity(new Intent(MainActivity.this,Fragment1.class));
                    }
                });

            }
        });



    }
}
