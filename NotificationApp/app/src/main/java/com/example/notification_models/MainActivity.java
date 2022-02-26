package com.example.notification_models;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText msg;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msg=(EditText)findViewById(R.id.editTextTextPersonName);
        send=(Button)findViewById(R.id.button);
        send.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(MainActivity.this,MainActivity.class);
                        PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity.this,0,intent,0);
                        Notification noti;
                        NotificationManager manager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                        CharSequence name="Alert Notification";
                        int importance=NotificationManager.IMPORTANCE_HIGH;
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            NotificationChannel channel= new NotificationChannel("CUSTOM_CHANNEL",name,importance);
                            noti = new Notification.Builder(MainActivity.this,"CUSTOM_CHANNEL").setContentTitle("New Message").setContentText(msg.getText().toString()).setContentIntent(pendingIntent).setSmallIcon(R.mipmap.ic_launcher).build();
                            manager.createNotificationChannel(channel);
                        }
                        else
                        {
                            noti = new Notification.Builder(MainActivity.this).setContentTitle("New Message").setContentText(msg.getText().toString()).setContentIntent(pendingIntent).setSmallIcon(R.mipmap.ic_launcher).build();
                        }
                        noti.flags|=Notification.FLAG_AUTO_CANCEL;
                        manager.notify(0,noti);
                    }
                }
        );
    }
}