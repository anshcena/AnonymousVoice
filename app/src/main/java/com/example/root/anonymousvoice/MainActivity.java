package com.example.root.anonymousvoice;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.NotificationCompatSideChannelService;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.net.Inet4Address;

public class MainActivity extends AppCompatActivity  {



    Button generatetoken,exit;
    ImageButton facebookb,twitterb;
    RadioGroup r;
    RadioButton rfb,rtw,rstatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //linking of buttons
        facebookb = (ImageButton) findViewById(R.id.fbbutton);
        twitterb = (ImageButton) findViewById(R.id.twbutton);
        generatetoken = (Button) findViewById(R.id.status);
        exit = (Button)findViewById(R.id.exit);
        r = (RadioGroup) findViewById(R.id.radio);






        // fb click button
        facebookb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jumpfbactivity = new Intent(getApplicationContext(), FbActivity.class);
                startActivity(jumpfbactivity);

            }
        });


        // twitter click button
        twitterb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jumptwitteractivity = new Intent(getApplicationContext(), TwitterActivity.class);
                startActivity(jumptwitteractivity);
            }
        });
        //onRadioButtonClicked

        //generate tokens


        generatetoken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog d = new Dialog(MainActivity.this);
                d.setContentView(R.layout.dailogboxforchecktokenstatus);
              //  d.setTitle("    CHOOSE");
                d.show();
                rfb = (RadioButton)d.findViewById(R.id.gofb);
                rtw = (RadioButton)d.findViewById(R.id.gotw);
                rstatus = (RadioButton)d.findViewById(R.id.checkstatus);

                rfb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent ii=new Intent(getApplicationContext(),Facebookpage.class);
                        startActivity(ii);
                    }
                });

                rtw.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent jj=new Intent(getApplicationContext(),TwitterAccount.class);
                        startActivity(jj);
                    }
                });

                rstatus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent kk=new Intent(getApplicationContext(),TokenStatus.class);
                        startActivity(kk);
                    }
                });

            }
        });




        //exit

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                a_builder.setMessage("ARE YOU SURE ?")
                        .setCancelable(false);
                a_builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                a_builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog obj = a_builder.create();
                obj.setTitle("EXIT APP");
                obj.show();


            }
        });

    }

}
