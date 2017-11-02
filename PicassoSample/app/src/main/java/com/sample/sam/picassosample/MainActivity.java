package com.sample.sam.picassosample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        url = "image url";

        ImageView imageView = (ImageView) findViewById(R.id.iv_bg);
        Picasso.with(getBaseContext()).load(url).fit().into(imageView);
    }
}
