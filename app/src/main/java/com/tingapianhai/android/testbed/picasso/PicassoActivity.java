package com.tingapianhai.android.testbed.picasso;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.tingapianhai.android.testbed.R;

public class PicassoActivity extends AppCompatActivity {

    private final static String url1 = "http://wallpaperwarrior.com/wp-content/uploads/2016/09/Wallpaper-16.jpg";
    private final static String url2 = "http://i.imgur.com/DvpvklR.png";

    private ImageView picassImage;
    private ImageView picassImage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);

        picassImage = (ImageView) findViewById(R.id.picasso_image);
        picassImage2 = (ImageView) findViewById(R.id.picasso_image2);

        loadImage(picassImage);
        loadImageWithCallback(picassImage2);
    }

    private void loadImage(ImageView image) {
        if (image == null) return;

        Picasso.with(this)
                .load(url1)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(image);
    }

    private void loadImageWithCallback(ImageView image) {
        if (image == null) return;

        Picasso.with(PicassoActivity.this)
                .load(url2)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(image, new Callback() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(PicassoActivity.this, "Picasso load success", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError() {
                        Toast.makeText(PicassoActivity.this, "Picasso image is fucked up", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
