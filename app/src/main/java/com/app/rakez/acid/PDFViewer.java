package com.app.rakez.acid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import java.io.File;

public class PDFViewer extends AppCompatActivity {
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdfviewer);
        wv = (WebView) findViewById(R.id.wv);
        wv.getSettings().setJavaScriptEnabled(true);
        String url = "http://kmmc.in/wp-content/uploads/2014/01/lesson2.pdf";
        wv.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url="+url);

    }
}
