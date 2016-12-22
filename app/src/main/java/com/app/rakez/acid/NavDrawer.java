package com.app.rakez.acid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RAKEZ on 11/5/2016.
 */
public class NavDrawer extends AppCompatActivity {
    ListView lv;
    DrawerLayout drawerlayout;
    View drawerview;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer);

        drawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        drawerview  = findViewById(R.id.drawerview);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setHomeButtonEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);

        lv = (ListView) findViewById(R.id.country);
        List<String> ls = new ArrayList<>();
        ls.add("Nepal");
        ls.add("USA");
        ls.add("Russia");
        ls.add("China");
        ls.add("Bhutan");
        ls.add("Japan");
        ls.add("Italy");
        ls.add("Portugal");
        ls.add("Spain");
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ls);
        lv.setAdapter(ad);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Snackbar.make(view,adapterView.getItemAtPosition(i)+" is clicked",Snackbar.LENGTH_SHORT).show();
                drawerlayout.closeDrawer(drawerview);
            }
        });



    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
