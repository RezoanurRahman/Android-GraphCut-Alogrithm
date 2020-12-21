package com.example.rezoan503s.camera;

import android.content.Intent;
import android.media.MediaMetadata;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import 	android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import org.opencv.android.OpenCVLoader;
import java.io.File;



public class MainActivity extends AppCompatActivity {
    String path=Environment.getExternalStorageDirectory().toString()+"/Pictures";
    private static final String TAG="Opencv";
    static
    {
        if (OpenCVLoader.initDebug()) {
            Log.d(TAG, "Loaded");
        } else {
            Log.d(TAG, "Not loaded");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton mainmenu_floatingbutton_add =(FloatingActionButton)findViewById(R.id.mainmenu_floatingbutton_add);

        mainmenu_floatingbutton_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"worked",Toast.LENGTH_LONG).show();


                File imageview= new File(path,"test.jpg");
                Uri uri= Uri.fromFile(imageview);
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                i.putExtra(MediaStore.EXTRA_OUTPUT,uri);
                startActivityForResult(i,10);
            }
        });

    }
}
