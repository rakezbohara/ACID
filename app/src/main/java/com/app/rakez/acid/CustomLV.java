package com.app.rakez.acid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RAKEZ on 10/24/2016.
 */
public class CustomLV extends AppCompatActivity {
    ListView lv;
    List<Product> l = new ArrayList<Product>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_lv);
        lv= (ListView) findViewById(R.id.customlv);

        l.add(new Product("CPU","This is Core2Duo from intel of 2.4Ghz","$24",R.drawable.app_icon));
        l.add(new Product("MotherBoard","This is Core2Duo from intel of 2.4Ghz","$24",R.drawable.application_exit));
        l.add(new Product("RAM","This is Core2Duo from intel of 2.4Ghz","$24",R.drawable.history_clear));
        l.add(new Product("HardDisk","This is Core2Duo from intel of 2.4Ghz","$24",R.drawable.settings));
        l.add(new Product("Mouse","This is Core2Duo from intel of 2.4Ghz","$24",R.drawable.pngsample2));
        l.add(new Product("Keyboard","This is Core2Duo from intel of 2.4Ghz","$24",R.drawable.app_icon));
        l.add(new Product("Power Cable","This is Core2Duo from intel of 2.4Ghz","$24",R.drawable.history_clear));
        l.add(new Product("CPU","This is Core2Duo from intel of 2.4Ghz","$24",R.drawable.app_icon));

        ArrayAdapter<Product> ad = new MyListAdapter();
        lv.setAdapter(ad);



    }
    public class MyListAdapter extends ArrayAdapter<Product>{

        public MyListAdapter(){
            super(CustomLV.this, R.layout.custon_listitem,l);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView  = convertView;
            if(convertView==null){
                itemView =getLayoutInflater().inflate(R.layout.custon_listitem,parent,false);
            }
            Product currentProduct = l.get(position);
            ImageView imageView = (ImageView)itemView.findViewById(R.id.lvicon);
            TextView titleView = (TextView) itemView.findViewById(R.id.lvtitle);
            TextView descView = (TextView) itemView.findViewById(R.id.lvdesc);
            TextView priceView = (TextView) itemView.findViewById(R.id.lvprice);

            imageView.setImageResource(currentProduct.getIcon());
            titleView.setText(currentProduct.getTitle());
            descView.setText(currentProduct.getDesc());
            priceView.setText(currentProduct.getPrice());

            return itemView;

        }
    }
}
