package com.example.meprojectforsamsung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final String MY_SETTINGS = "";



    CreateActivity c = new CreateActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sp = getSharedPreferences(MY_SETTINGS, Context.MODE_PRIVATE);
        ImageView car = (ImageView) findViewById(R.id.car);


        boolean hasVisited = sp.getBoolean("hasVisited", false);

        if (!hasVisited) {

            Intent myIntent = new Intent(MainActivity.this, StartActivity.class);
            startActivity(myIntent);

            SharedPreferences.Editor e = sp.edit();
            e.putBoolean("hasVisited", true);
            e.apply();

        }
        setContentView(R.layout.activity_main);

        SharedPreferences.Editor e = sp.edit();
        if(sp.getBoolean("car1", false)){
            e.putInt("speed", 450 / c.getTime());
            e.apply();

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(50, sp.getInt("top", 650) , 0, 0);
            car.setLayoutParams(params);
        }

    }

    public void Create(View view){
        ImageView car = (ImageView) findViewById(R.id.car);
        SharedPreferences sp = getSharedPreferences(MY_SETTINGS, Context.MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();
        car.setVisibility(View.VISIBLE);
        e.putInt("top", 650);
        e.putBoolean("car1", true);
        e.apply();
        Intent myIntent = new Intent(MainActivity.this, CreateActivity.class);
        startActivity(myIntent);
    }



    public void Car_Movement(View view){
        SharedPreferences sp = getSharedPreferences(MY_SETTINGS, Context.MODE_PRIVATE);
        ImageView car = (ImageView) findViewById(R.id.car);
        if(sp.getBoolean("car1" , false)){

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(50, sp.getInt("top", 650) - sp.getInt("speed", 0) , 0, 0);
            car.setLayoutParams(params);

            SharedPreferences.Editor e = sp.edit();
            e.putInt("top", sp.getInt("top", 650) - sp.getInt("speed", 0));
            e.apply();
        }

    }


}