package com.taufic.eventapps;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by taufic on 3/30/2017.
 */

public class HomeActivity extends Activity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        imageView = (ImageView) findViewById(R.id.selfImage);
    }

    /*
            On click button will send Name to ChooseAs
         */
    public void sendName(View view) {
        Button btn = (Button) view.findViewById(R.id.buttonHome);
        btn.setBackgroundResource(R.drawable.btn_signup_selected);
        Intent intent = new Intent(this, ChooseAs.class);
        EditText editText = (EditText) findViewById(R.id.inputNama);
        String name = editText.getText().toString();
        intent.putExtra("name", name);
        startActivity(intent);
    }

    /* Choose an image from Gallery */
    public void openImage(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 3);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == 3) {
                // Get the url from data
                Uri uri = data.getData();
                if (uri != null) {
                    // Get the path from the Uri
                    String path = getPathFromURI(uri);
                    // Set the image in ImageView
                    imageView.setImageURI(uri);
                }
            }
        }
    }

    /* Get the real path from the URI */
    public String getPathFromURI(Uri contentUri) {
        String resource = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            resource = cursor.getString(column_index);
        }
        cursor.close();
        return resource;
    }
}
