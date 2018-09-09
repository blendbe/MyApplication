package com.example.acer.myapplicationiu;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import com.doodle.android.chips.ChipsView;

import java.util.Calendar;
import java.util.Timer;

public class RememberDrugsActivity extends AppCompatActivity {
    TimePicker timePicker;
    TextView textView;
    EditText editText;
    ChipsView chips;
    Bundle bundle;
    String mesazhi;
    Switch aSwitch;
    boolean on;
    private BroadcastReceiver mReceiver;
    String ora;
    Toolbar toolbar;
    TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remember_drugs);
        Timer timer = new Timer();
        timePicker = findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        toolbar = (Toolbar)findViewById(R.id.toolbarR);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(null);
        textView1 = (TextView)toolbar.findViewById(R.id.shtoNjoftim);

        editText = findViewById(R.id.mesazhiAlarmit);
        aSwitch = (Switch)findViewById(R.id.switchi);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    on = true;
                else
                    on = false;
            }
        });
        bundle = new Bundle();
        findViewById(R.id.btnSetAlarm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                if (Build.VERSION.SDK_INT >= 23) {
                    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), timePicker.getHour(), timePicker.getMinute(), 0);
                } else {
                    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), timePicker.getCurrentHour(), timePicker.getCurrentMinute(), 0);
                }
                setAlarm(calendar.getTimeInMillis());
                if (on == true)
                {
                ora = "Njoftimi u vendos me sukses ne: " + timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute() + " (Perditshem)";}
                else
                {
                    ora = "Njoftimi u vendos me sukses ne: " + timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute();
                }
                mesazhi = editText.getText().toString();
                AlertDialog alertDialog = new AlertDialog.Builder(RememberDrugsActivity.this)
                        .setTitle(mesazhi)
                        .setMessage(ora)
                        .setCancelable(true)
                        .create();
                alertDialog.show();
              Intent in = new Intent(RememberDrugsActivity.this, MedicationAlarm.class);
              in.putExtra("mesazhi1", mesazhi);
              PendingIntent sender = PendingIntent.getBroadcast(RememberDrugsActivity.this, 0, in, PendingIntent.FLAG_UPDATE_CURRENT);
            }

        });


    }
    private void setAlarm(long timeInMillis)
    {
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, MedicationAlarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        if (on == false){
        alarmManager.set(AlarmManager.RTC_WAKEUP, timeInMillis,pendingIntent);}
        else
        {
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, timeInMillis, AlarmManager.INTERVAL_DAY, pendingIntent);
        }

    }
}
