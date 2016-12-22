package com.app.rakez.acid;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l= (ListView) findViewById(R.id.lv1);
        List<String> ls = new ArrayList<>();
        ls.add("Alert Box");
        ls.add("Data Communication");
        ls.add("Action Bar");
        ls.add("Login");
        ls.add("Notification");
        ls.add("Custom LV");
        ls.add("FragmentDemo");
        ls.add("Swipe Tabs");
        ls.add("Swipe Tab New");
        ls.add("Nav Drawer");
        ls.add("DataBase Illustration");
        ls.add("Messenger");
        ls.add("Caller");
        ls.add("SnackBar/FAB");
        ls.add("FlashLight");
        ls.add("JSONObject Req");
        ls.add("Load Image");
        ls.add("Post using Volley");
        ls.add("post Image");
        ls.add("PDFViewer");
        ls.add("GMap");
        ls.add("Scroll TextView");
        ls.add("Camera");
        ls.add("Music Player");
        ls.add("Custom List");





        ArrayAdapter<String> ad =new ArrayAdapter<String>(this,R.layout.list_item,ls);
        l.setAdapter(ad);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);

                    adb.setTitle("Alert");
                    adb.setMessage("Do You Really Want To Delete");
                    adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this,"You Clicked YES",Toast.LENGTH_SHORT).show();
                        }
                    });
                    adb.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Toast.makeText(MainActivity.this,"You Clicked NO",Toast.LENGTH_SHORT).show();
                        }
                    });
                    adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Toast.makeText(MainActivity.this,"You Clicked CANCEL",Toast.LENGTH_SHORT).show();

                        }
                    });
                    adb.show();

                }
                else if(i==1){

                    Intent in = new Intent("com.app.rakez.acid.DATACOMM");
                    String data = "Data To be Trasferred";
                    Bundle b = new Bundle();
                    b.putString("dt",data);
                    in.putExtras(b);
                    startActivity(in);

                }
                else if(i==2){
                    Intent in = new Intent("com.app.rakez.acid.ACTIONBAR");
                    startActivity(in);
                }
                else if(i==3){
                    Intent in = new Intent("com.app.rakez.acid.LOGIN");
                    startActivity(in);
                }
                else if(i==4){
                    Intent in = new Intent("com.app.rakez.acid.NOTIFICATIO");
                    startActivity(in);
                }
                else if(i==5){
                    Intent in = new Intent("com.app.rakez.acid.CUSTOMLV");
                    startActivity(in);
                }
                else if(i==6){
                    Intent in = new Intent("com.app.rakez.acid.FRAGMENTDEMO");
                    startActivity(in);

                }
                else if(i==7){
                    Intent in = new Intent("com.app.rakez.acid.SWIPETAB");
                    startActivity(in);

                }
                else if(i==9){
                    Intent in = new Intent("com.app.rakez.acid.NAVDRAWER");
                    startActivity(in);
                }
                else if(i==10){
                    Intent in = new Intent("com.app.rakez.acid.DATABASEILL");
                    startActivity(in);
                }
                else if(i==11){
                    Intent in = new Intent(MainActivity.this,Messenger.class);
                    startActivity(in);
                }
                else if(i==12){
                    Intent in = new Intent(MainActivity.this,Caller.class);
                    startActivity(in);
                }
                else if(i==13){
                    Intent in = new Intent(MainActivity.this,Sfab.class);
                    startActivity(in);
                }else if(i==14){
                    Intent in = new Intent(MainActivity.this,FlashLight.class);
                    startActivity(in);
                }
                else if(i==15){
                    Intent in = new Intent(MainActivity.this,JsonParser.class);
                    startActivity(in);
                }
                else if(i==16){
                    Intent in = new Intent(MainActivity.this,VolleyImage.class);
                    startActivity(in);
                }
                else if(i==17){
                    Intent in = new Intent(MainActivity.this,VolleyPost.class);
                    startActivity(in);
                }
                else if(i==18){
                    Intent in = new Intent(MainActivity.this,PostImage.class);
                    startActivity(in);
                }
                else if(i==19){
                    Intent in = new Intent(MainActivity.this,PDFViewer.class);
                    startActivity(in);
                }
                else if(i==20){
                    Intent in = new Intent(MainActivity.this,GMap.class);
                    startActivity(in);
                }




            }
        });


    }
}
