package com.app.rakez.acid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class VolleyImage extends AppCompatActivity {

    NetworkImageView niv;
    Button b;
    ImageLoader imageLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volley_image);
        niv = (NetworkImageView) findViewById(R.id.niv);
        b = (Button) findViewById(R.id.loadni);
        imageLoader = AppController.getInstance().getImageLoader();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                niv.setImageUrl("https://cdn.colorlib.com/wp/wp-content/uploads/sites/2/colorlib-logo-top.png", imageLoader);

            }
        });
        }
}
