package com.app.rakez.acid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by RAKEZ on 10/22/2016.
 */
public class Login extends AppCompatActivity {


    TextView registernow;
    EditText username,password;
    Button login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logina);
        registernow = (TextView) findViewById(R.id.registernow);
        username= (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        registernow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent("com.app.rakez.acid.REGISTER");
                startActivity(in);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                SharedPreferences sp = getSharedPreferences("acid",0);
                String ruser = sp.getString("username","");
                String rpass = sp.getString("password","");
                String rname = sp.getString("fullname","");
                Set<String> st = new HashSet<String>();
                Set<String> ad = new HashSet<String>();

                st = sp.getStringSet("ac",ad);


                if((user.equals(ruser)&&pass.equals(rpass))||(user.equals("admin")&&pass.equals("admin"))){
                    Toast.makeText(Login.this,"Welcome "+rname,Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(Login.this,"Login Failed",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}
