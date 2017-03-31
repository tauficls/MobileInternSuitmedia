package com.taufic.eventapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ChooseAs extends AppCompatActivity {

    private Button buttonEvent;
    private Button buttonGuest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_as);

        //Get Intent from HomeActivity and string
        Intent intent = getIntent();
        String nameInput = intent.getStringExtra("name");

        //set name
        TextView name = (TextView) findViewById(R.id.name);
        name.setText(nameInput);
        buttonEvent = (Button) findViewById(R.id.buttonEvent);
        buttonEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getApplicationContext(), Event.class), 1);
            }
        });
        buttonGuest = (Button) findViewById(R.id.buttonGuest);
        buttonGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getApplicationContext(), Guest.class), 2);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resutlCode, Intent data) {
        if(requestCode == 1 && resutlCode == RESULT_OK) {
            buttonEvent.setText(data.getStringExtra("event"));
        } else if(requestCode == 2 && resutlCode == RESULT_OK) {
            buttonGuest.setText(data.getStringExtra("guest"));
            String date = data.getStringExtra("date");
            date = date.substring(date.length() - 2);
            int dateInt = Integer.parseInt(date);
            if(dateInt % 2 == 0 && dateInt % 3 == 0) {
                Toast.makeText(getApplicationContext(), "IOS", Toast.LENGTH_SHORT).show();
            } else if (dateInt % 2 == 0) {
                Toast.makeText(getApplicationContext(), "blackberry", Toast.LENGTH_SHORT).show();
            } else if (dateInt % 3 == 0) {
                Toast.makeText(getApplicationContext(), "android", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "feature phone", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
