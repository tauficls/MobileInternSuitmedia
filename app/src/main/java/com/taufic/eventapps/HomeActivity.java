package com.taufic.eventapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by taufic on 3/30/2017.
 */

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    }

    /*
        On click button will send Name to ChooseAs
     */
    public void sendName(View view) {
        Intent intent = new Intent(this, ChooseAs.class);
        EditText editText = (EditText) findViewById(R.id.inputNama);
        String name = editText.getText().toString();
        intent.putExtra("name", name);
        startActivity(intent);
    }
}
