package com.example.meprojectforsamsung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Question extends AppCompatActivity {

    MainActivity ma = new MainActivity();
    //final String MY_SETTINGS = ma.GetSettings();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent myIntent = getIntent();
       // SharedPreferences sp = getSharedPreferences(MY_SETTINGS, Context.MODE_PRIVATE);


        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);

        TextView textView = (TextView) findViewById(R.id.textView5);

        String input = myIntent.getStringExtra("input");

        textView.setText(input);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Question.this, MainActivity.class);
         //       SharedPreferences.Editor e = sp.edit();
           //     e.putInt("Tables", sp.getInt("Tables", 0) + 1);
             //   e.apply();
                startActivity(myIntent);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Question.this, CreateActivity.class);
                startActivity(myIntent);
            }
        });
    }


}