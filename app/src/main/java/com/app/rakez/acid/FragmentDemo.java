package com.app.rakez.acid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by RAKEZ on 10/25/2016.
 */
public class FragmentDemo extends AppCompatActivity implements Communicator {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_demo);


    }


    @Override
    public void respond(int position) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentB fb = (FragmentB) manager.findFragmentById(R.id.fragmentB);
        fb.changeData(position);
    }
}
