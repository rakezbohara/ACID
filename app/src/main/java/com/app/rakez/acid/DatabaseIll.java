package com.app.rakez.acid;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by RAKEZ on 11/6/2016.
 */
public class DatabaseIll extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button b1,b2,b3,b4;
    TextView t1;
    DBHelper dbh;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_ill);
        dbh = new DBHelper(this);
        ed1 = (EditText) findViewById(R.id.dbname);
        ed2 = (EditText) findViewById(R.id.dbgrade);
        ed3= (EditText) findViewById(R.id.dbid);
        b1 = (Button) findViewById(R.id.dbinsert);
        b2 = (Button) findViewById(R.id.dbshow);
        b3 = (Button) findViewById(R.id.dbupdate);
        b4= (Button) findViewById(R.id.dbdelete);
        t1 = (TextView) findViewById(R.id.dbdisplay);
        t1.setMovementMethod(new ScrollingMovementMethod());
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name =ed1.getText().toString();
                String grade = ed2.getText().toString();
                boolean result = dbh.insertData(name,grade);
                if(result){
                    Toast.makeText(DatabaseIll.this,"Successfully Inserted",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(DatabaseIll.this,"Operation Failed",Toast.LENGTH_LONG).show();
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data=null;
                Cursor result = dbh.getAllData();
                int count = result.getCount();
                if(count==0){
                    data="data not found";

                }else{
                    while(result.moveToNext()){
                        data = data+ result.getString(0)+" " + result.getString(1)+" "+result.getString(2)+"\n";
                    }

                }
                t1.setText(data);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name =ed1.getText().toString();
                String grade = ed2.getText().toString();
                String id = ed3.getText().toString();
                dbh.updateData(name,grade,id);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = ed3.getText().toString();
                Integer result = dbh.deleteData(id);
                if(result>0){

                }else{

                }
            }
        });
    }
}
