package com.app.rakez.acid;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by RAKEZ on 10/23/2016.
 */
public class Notificatio extends AppCompatActivity {

    String nottitile = "New Notice";
    String notmessage = "This is new message";
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nnn);
        b=(Button)findViewById(R.id.btnnotify);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager nmanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new Notification(R.drawable.application_exit,nottitile,System.currentTimeMillis());
                Intent notIntent = new Intent("com.app.rakez.acid.NOTIFICATIO");
                PendingIntent pIntent = PendingIntent.getActivity(Notificatio.this,0,notIntent,0);
                notification.setLatestEventInfo(Notificatio.this,nottitile,notmessage,pIntent);
                nmanager.notify(9999,notification);






            }
        });
    }
}
