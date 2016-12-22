package com.app.rakez.acid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by RAKEZ on 10/21/2016.
 */
public class DataComm extends AppCompatActivity {

    TextView t;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datacomm);
        t= (TextView) findViewById(R.id.receivertv);
        Bundle b = getIntent().getExtras();
        String data = b.getString("dt");
        t.setText(data);

    }
}
