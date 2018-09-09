package com.example.acer.myapplicationiu;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.NotificationChannel;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

public class MedicationAlarm extends BroadcastReceiver {
    private AlertDialog alertDialog;
    Bundle bundle;
    String mesazhi;
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel("ID", "Name", importance);
            notificationManager.createNotificationChannel(notificationChannel);
            builder = new NotificationCompat.Builder(context, notificationChannel.getId());
            mesazhi = intent.getAction();
        } else {
            builder = new NotificationCompat.Builder(context);
        }
        mesazhi = intent.getStringExtra("mesazhi1");
        if (mesazhi.matches(""))
        {
            builder = builder
                    .setSmallIcon(R.drawable.ic_access_time_black_24dp)
                    .setColor(ContextCompat.getColor(context, R.color.blue1))
                    .setContentTitle("RIKUJTIM")
                    .setTicker("ALARMI")
                    .setContentText("Njoftim per medikament")
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setAutoCancel(true);
            notificationManager.notify(1, builder.build());
        }
        else {
            builder = builder
                    .setSmallIcon(R.drawable.ic_access_time_black_24dp)
                    .setColor(ContextCompat.getColor(context, R.color.blue1))
                    .setContentTitle("RIKUJTIM")
                    .setTicker("ALARMI")
                    .setContentText(mesazhi)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setAutoCancel(true);
            notificationManager.notify(1, builder.build());
        }


    }


}

