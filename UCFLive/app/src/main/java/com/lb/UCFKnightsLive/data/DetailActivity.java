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
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.lb.UCFKnightsLive.data.database.DataSource;
import com.lb.UCFKnightsLive.data.model.DataItem;
import com.lb.UCFKnightsLive.data.sample.SampleDataProvider;
import java.util.List;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.Toolbar;

@SuppressWarnings("FieldCanBeLocal")
public class DetailActivity extends AppCompatActivity{
   // private WebView wv1;
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
               //openMain();
               openJitsi();
              /*  Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("org.jitsi.meet");
                startActivity(LaunchIntent);
                String wv1 = "titleName";
              // wv1.loadUrl("javascript:document.getElementById('titleName').value = '"+titleName+"';");
*/

            }
        });

    }

    public void openJitsi(){
        Intent intent = new Intent(this, Jitsi.class);
        startActivity(intent);
    }
    public void openMain(){
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
    }
}
