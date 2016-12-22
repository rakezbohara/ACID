package com.app.rakez.acid;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by RAKEZ on 10/21/2016.
 */
public class ActionBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actionbar);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("ActionBar Illustration");
        ab.setSubtitle("This is demo bar");
        ColorDrawable cd =new ColorDrawable(Color.parseColor("#f959f9"));
        ab.setBackgroundDrawable(cd);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.action_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.action_settings){

        }

        return super.onOptionsItemSelected(item);
    }
}
