package com.example.root.anonymousvoice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TwitterActivity extends AppCompatActivity {
    EditText description;
    Spinner category;
    ImageButton attachment;
    Button Posttwitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter);

        //Linking variables to id

        description=(EditText)findViewById(R.id.description);
        category=(Spinner)findViewById(R.id.category);
        attachment=(ImageButton)findViewById(R.id.attachmen);
        Posttwitter=(Button)findViewById(R.id.postFB);

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


        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(TwitterActivity.this, " CATEGORY : "+ String.valueOf(category.getSelectedItem()), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        //attachments
        attachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


        //  postbutton

        Posttwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //addValueEventListener(ValueEventListener);
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");

                myRef.setValue("Hello, World!");
            }
        });


    }
}
