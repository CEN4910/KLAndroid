package com.lb.UCFKnightsLive.data;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
//import android.app.Activity;
import android.widget.MediaController;
import android.widget.Toast;

import com.lb.UCFKnightsLive.data.model.DataItem;

import java.io.IOException;
import java.io.InputStream;

@SuppressWarnings("FieldCanBeLocal")
public class ArchiveActivity extends AppCompatActivity{

    private TextView titleName, videoDescription;
    private ImageView itemImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);



        DataItem item = getIntent().getExtras().getParcelable(DataItemAdapter.ITEM_KEY);
        if (item == null) {
            throw new AssertionError("Null data item received!");
        }

        titleName = (TextView) findViewById(R.id.titleItemName);

        videoDescription = (TextView) findViewById(R.id.videoDescription);
        itemImage = (ImageView) findViewById(R.id.itemImage);

        titleName.setText(item.getItemName());
        videoDescription.setText(item.getDescription());

        InputStream inputStream = null;
        try {
            String imageFile = item.getImage();
            inputStream = getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(inputStream, null);
            itemImage.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        setContentView(R.layout.activity_archive);
        VideoView videoView =(VideoView)findViewById(R.id.videoView);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.mink);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

    }

}
