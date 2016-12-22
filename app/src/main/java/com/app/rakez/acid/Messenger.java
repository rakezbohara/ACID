package com.app.rakez.acid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Messenger extends AppCompatActivity {

    EditText ed1,ed2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messenger);
        ed1 = (EditText) findViewById(R.id.msg);
        ed2 = (EditText) findViewById(R.id.rnum);
        b1 = (Button) findViewById(R.id.msgsend);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = ed1.getText().toString();
                String number  = ed2.getText().toString();

                SmsManager sm = SmsManager.getDefault();
                sm.sendTextMessage(number,null,msg,null,null);


            }
        });
    }
}
