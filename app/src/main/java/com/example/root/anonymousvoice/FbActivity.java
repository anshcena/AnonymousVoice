package com.example.root.anonymousvoice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import static android.os.Build.VERSION_CODES.O;

public class FbActivity extends AppCompatActivity {

    EditText description;
    Spinner category;
    ImageButton attachment;
    Button Postfacebook;
  public static final int Pick_Image=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb);

        //Linking variables to id

        description=(EditText)findViewById(R.id.description);
        category=(Spinner)findViewById(R.id.category);
        attachment=(ImageButton)findViewById(R.id.attachmen);
        Postfacebook=(Button)findViewById(R.id.postFB);

        //Setting click actions

        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String inputdata;
                    inputdata=description.getText().toString();

            }
        });


        //Spinner
        // making adapter view
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.categories, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(adapter);

                 category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                        Toast.makeText(FbActivity.this, " CATEGORY : "+ String.valueOf(category.getSelectedItem()), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

            //attachments
        attachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
              startActivityForResult(Intent.createChooser(intent, "Select Picture"), Pick_Image);

            }
        });


        //  postbutton

        Postfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  des = description.getText().toString();

                //check whether the des empty or not
                if(des.length()>0 && category.getSelectedItem().toString() != "-----blank-----") {
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost("http://www.google.com/");

                    try {
                        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
                        //nameValuePairs.add(new BasicNameValuePair("id", "01"));
                        nameValuePairs.add(new BasicNameValuePair("description", des));
                        nameValuePairs.add(new BasicNameValuePair("category", category.getSelectedItem().toString()));
                        nameValuePairs.add(new BasicNameValuePair("media", attachment.toString()));
                        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                        httpclient.execute(httppost);
                        //description.setText(""); //reset the message text field
                        Toast.makeText(getBaseContext(),"Sent message to server",Toast.LENGTH_SHORT).show();
                    } catch (ClientProtocolException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    //display message if text field is empty
                    Toast.makeText(getBaseContext(),"All fields are required",Toast.LENGTH_SHORT).show();
                }
            }
        });



















        }
}
