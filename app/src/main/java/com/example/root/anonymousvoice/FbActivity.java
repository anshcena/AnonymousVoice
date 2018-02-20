package com.example.root.anonymousvoice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;

import static android.os.Build.VERSION_CODES.O;

public class FbActivity extends AppCompatActivity  {

    EditText description;
    Spinner category;
    ImageButton attachment;
    Button Postfacebook;
    TextView textFile;
    private static final int MY_INTENT_CLICK=302;
    String des = "";
    String inputdata;
    String selectedImagePath;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb);

        //Linking variables to id
        description = (EditText) findViewById(R.id.description);
        category = (Spinner) findViewById(R.id.category);
        attachment = (ImageButton) findViewById(R.id.attachmen);
        Postfacebook = (Button) findViewById(R.id.postFB);
       textFile=(TextView)findViewById(R.id.textfile);
        //Setting click actions

        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                inputdata = description.getText().toString();

            }
        });


        //Spinner
        // making adapter view
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categories, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(adapter);

        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                Toast.makeText(FbActivity.this, " CATEGORY : " + String.valueOf(category.getSelectedItem()), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });

        //attachments
        attachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent();

                intent.setType("image/*");

                intent.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(intent, "Select Image From Gallery"), MY_INTENT_CLICK);


            }
        });


        //  postbutton

        Postfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpClient client=new DefaultHttpClient();
                HttpPost post=new HttpPost("http://192.168.43.35:8000/facebookPOST");
                File file=new File(selectedImagePath);
                MultipartEntity e=new MultipartEntity();
                try {
                    e.addPart("description",new StringBody(des));
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }
                try {
                    e.addPart("category",new StringBody(category.getSelectedItem().toString()));
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }
                e.addPart("media",new FileBody(file));
                post.setEntity(e);
                try {
                    HttpResponse response=client.execute(post);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });


    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {


            if(resultCode == Activity.RESULT_OK && data != null)
                {
                    if (requestCode == MY_INTENT_CLICK)
                    {



                        Uri selectedImageUri = data.getData();

                        //MEDIA GALLERY
                        selectedImagePath = ImageFilePath.getPath(getApplicationContext(), selectedImageUri);
                        Log.i("Image File Path", ""+selectedImagePath);


                        textFile.setText("File selected : \n"+selectedImagePath);
                    }
                }
            }
        }
    }





