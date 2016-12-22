package com.app.rakez.acid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by RAKEZ on 10/22/2016.
 */
public class Register extends AppCompatActivity {

    TextView loginnow;
    EditText rfullname,rusername,rpassword,rcpassword;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        loginnow = (TextView) findViewById(R.id.loginnow);
        rfullname= (EditText) findViewById(R.id.rfullname);
        rusername= (EditText) findViewById(R.id.rusername);
        rpassword= (EditText) findViewById(R.id.rpassword);
        rcpassword= (EditText) findViewById(R.id.rcpassword);
        register= (Button) findViewById(R.id.register);

        loginnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent("com.app.rakez.acid.LOGIN");
                startActivity(in);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = rfullname.getText().toString();
                String username = rusername.getText().toString();
                String password = rpassword.getText().toString();
                String cpassword = rcpassword.getText().toString();
                Set<String> st = new HashSet<String>();
                st.add("abc");
                st.add("def");

                if(!fullname.equals("")&&!username.equals("")&&!password.equals("")&&!cpassword.equals("")&&password.equals(cpassword)){
                    SharedPreferences data = getSharedPreferences("acid",0);
                    SharedPreferences.Editor edi =data.edit();
                    edi.putString("fullname",fullname);
                    edi.putString("username",username);
                    edi.putString("password",password);
                    edi.putStringSet("ac",st);
                    edi.commit();
                    Toast.makeText(Register.this,"Registration Successful",Toast.LENGTH_SHORT);
                    rfullname.setText("");
                    rusername.setText("");
                    rpassword.setText("");
                    rcpassword.setText("");

                }else{
                    Toast.makeText(Register.this,"Registration failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
