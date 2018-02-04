package com.example.root.anonymousvoice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class FbActivity extends AppCompatActivity {

    EditText description;
    Spinner category;
    ImageButton attachment;
    Button Postfacebook;

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

        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.categories, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(adapter);


        //







        }
}
