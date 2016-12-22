package com.app.rakez.acid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RAKEZ on 10/26/2016.
 */
public class FragmentB extends Fragment {
    TextView t;
    List<String> desp = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        t= (TextView) getActivity().findViewById(R.id.fragBtv);
        desp.add("This is brain of computer. More description goes here");
        desp.add("This is display of computer. More description goes here");
        desp.add("This is input of computer. More description goes here");
        desp.add("This is xyz of computer. More description goes here");
        desp.add("This is gaming of computer. More description goes here");

    }

    public void changeData(int position){
        t.setText(desp.get(position));
    }
}
