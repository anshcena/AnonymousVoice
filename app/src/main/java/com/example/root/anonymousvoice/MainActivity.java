package com.example.root.anonymousvoice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


    Button generatetoken,exit;
    ImageButton facebookb,twitterb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //linking of buttons
        facebookb=(ImageButton)findViewById(R.id.fbbutton);
        twitterb=(ImageButton)findViewById(R.id.twbutton);

        // fb click button
        facebookb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jumpfbactivity=new Intent(getApplicationContext(),FbActivity.class);

            }
        });




        // twitter click button
        twitterb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jumptwitteractivity=new Intent(getApplicationContext(),TwitterActivity.class);
            }
        });

    }
}
