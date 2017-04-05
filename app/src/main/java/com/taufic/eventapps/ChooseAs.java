package com.taufic.eventapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ChooseAs extends FragmentActivity {

    private Button buttonEvent;
    private Button buttonGuest;

    public boolean isPrime(int s) {
        int count = 0;
        for (int i = 1; i <= s; i++) {
            if(s % i == 0) {
                count++;
            }
            if (count > 2) {
                return false;
            }
        }
        if (count > 2 || s == 1) {
            return false;
        }
        return true;
    }
    public boolean isPalindrome(String s) {
        String text = s.replaceAll("\\s+","");
        int length = text.length();
        for (int i = 0; i < length/2; i++) {
            if (text.charAt(i) != text.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_as);

        //Get Intent from HomeActivity and string
        Intent intent = getIntent();
        String nameInput = intent.getStringExtra("name");
        String nama = "name          : " + nameInput;
        if (isPalindrome(nameInput)) {
            Toast.makeText(getApplicationContext(), (nameInput + " " + "isPalindrome"), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), (nameInput + " " + "not Palindrome"), Toast.LENGTH_SHORT).show();
        }
        //set name
        TextView name = (TextView) findViewById(R.id.nama);
        name.setText(nama);
        buttonEvent = (Button) findViewById(R.id.buttonEvent);
        buttonEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getApplicationContext(), EventActivity.class), 1);
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
    protected void onActivityResult(int requestCode, int resutltCode, Intent data) {
        if(requestCode == 1 && resutltCode == RESULT_OK) {
            buttonEvent.setText(data.getStringExtra("event"));
        } else if(requestCode == 2 && resutltCode == RESULT_OK) {
            buttonGuest.setText(data.getStringExtra("guest"));
            String date = data.getStringExtra("date");
            String day = date.substring(date.length() - 2);
            String month = date.substring(6, 7);
            System.out.println(month);
            int dateInt = Integer.parseInt(day);
            int monthInt = Integer.parseInt(month);
            if(isPrime(monthInt)) {
                Toast.makeText(getApplicationContext(), "The month " + month + " is prime", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "The month " + month + " is not prime", Toast.LENGTH_SHORT).show();
            }
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
