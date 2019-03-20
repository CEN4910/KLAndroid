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
import com.lb.UCFKnightsLive.data.model.DataItem;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@SuppressWarnings("FieldCanBeLocal")
public class DetailActivity extends AppCompatActivity{

    private TextView titleName, videoDescription;
    private ImageView itemImage;
    private Button jitsi_sign_in_button;
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

        jitsi_sign_in_button = (Button) findViewById(R.id.jitsi_sign_in_button);
        jitsi_sign_in_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("org.jitsi.meet");
                startActivity(LaunchIntent);

/*

            Intent LaunchIntent = new Intent(Intent.ACTION_VIEW);
            LaunchIntent.setDataAndType( Uri.fromFile(new File( japk)), "japk/Jitsi Meet_v1.20.111_apkpure.com.apk");
            LaunchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(LaunchIntent);
            // attemptLogin();*/

// <option name="APK_PATH" value="$MODULE_DIR$/Jitsi Meet_v1.20.111_apkpure.com.apk" />
                //      <option name="APP_PACKAGE" value="org.jitsi.meet" />

            }
        });
    }

}
