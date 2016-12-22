package com.app.rakez.acid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RAKEZ on 10/25/2016.
 */
public class FragmentA extends Fragment{
    ListView l;
    Communicator comm;
    List<String> ls= new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a,container,false);

    }

    /*@Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState==null){

        }else{
            counter = savedInstanceState.getInt("count");
        }
    }*/

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        comm= (Communicator) getActivity();
        l= (ListView) getActivity().findViewById(R.id.fragAlv);
        ls.add("cpu");
        ls.add("Monitor");
        ls.add("keyboard");
        ls.add("mouse");
        ls.add("joystick");
        ArrayAdapter<String> ad = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,ls);
        l.setAdapter(ad);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                comm.respond(i);
            }
        });



    }



    /*@Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count",counter);
    }*/
}
