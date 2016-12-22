package com.app.rakez.acid;

import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.hardware.Camera;
import android.media.MediaPlayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;


public class FlashLight extends AppCompatActivity {

    Button btn;
    boolean isFlashOn,hasFlash;
    Camera.Parameters params;
    MediaPlayer mp;
    Camera camera;
    TextView linktv,customfont;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flash_light);
        btn = (Button) findViewById(R.id.fon);
        linktv = (TextView) findViewById(R.id.linktv);
        String text = "<a href='http://www.facebook.com'>Facebook</a>";
        linktv.setClickable(true);
        linktv.setMovementMethod(LinkMovementMethod.getInstance());
        linktv.setText(Html.fromHtml(text));

        customfont = (TextView) findViewById(R.id.customfont);
        AssetManager am = this.getApplicationContext().getAssets();
        Typeface tf = Typeface.createFromAsset(am,String.format(Locale.US,"fonts/%s","annapurna.ttf"));
        Typeface customface = Typeface.createFromAsset(getAssets(),"fonts/annapurna.ttf");

        customfont.setText("bjhsusbfuslejdfogjrorjqopwr niuhsdfnosef");
        customfont.setTypeface(tf);


        hasFlash =getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        if(!hasFlash){
            finish();
        }
        camera = Camera.open();
        params = camera.getParameters();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btn.getText().toString().equals("on")){
                    turnonflash();
                    btn.setText("off");
                }
                else if(btn.getText().toString().equals("off")){
                    turnoffflash();
                    btn.setText("on");
                }


            }
        });

    }

    public void turnonflash(){
        if(!isFlashOn){
            camera.getParameters();
            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(params);
            camera.startPreview();
            isFlashOn = true;
            mp = MediaPlayer.create(this,R.raw.flashon);

            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mp.release();
                }
            });
            mp.start();


        }

    }

    public void turnoffflash(){
        if(isFlashOn){
            camera.getParameters();
            params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(params);
            camera.stopPreview();
            isFlashOn = false;

        }
    }


}
