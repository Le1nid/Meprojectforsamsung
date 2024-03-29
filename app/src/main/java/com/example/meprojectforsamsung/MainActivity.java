package com.example.meprojectforsamsung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final String MY_SETTINGS = "";


    CreateActivity c = new CreateActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        SharedPreferences sp = getSharedPreferences(MY_SETTINGS, Context.MODE_PRIVATE);
        ImageView car = (ImageView) findViewById(R.id.car);
        TextView end = (TextView) findViewById(R.id.text_end);
        Button bt = (Button) findViewById(R.id.button3);
        Button bt_v = (Button) findViewById(R.id.button_vnesti_summ);
        Button bt_add = (Button) findViewById(R.id.button_add);
        ImageView smile = (ImageView) findViewById(R.id.SMILE);


        boolean hasVisited = sp.getBoolean("hasVisited", false);

        if (!hasVisited) {

            Intent myIntent = new Intent(MainActivity.this, StartActivity.class);
            startActivity(myIntent);

            SharedPreferences.Editor e = sp.edit();
            e.putBoolean("hasVisited", true);
            e.apply();

        }

        if (sp.getBoolean("car1", false)) {
            bt_v.setVisibility(View.VISIBLE);
            bt_add.setVisibility(View.INVISIBLE);
        } else {
            bt_v.setVisibility(View.INVISIBLE);
            bt_add.setVisibility(View.VISIBLE);
        }


        if (car != null && end != null && bt != null) {
            smile.setVisibility(View.INVISIBLE);
            bt.setVisibility(View.INVISIBLE);
            car.setVisibility(View.INVISIBLE);
            end.setVisibility(View.INVISIBLE);
        }


        SharedPreferences.Editor e = sp.edit();
        if (sp.getBoolean("car1", false) && sp.getInt("time1", 0) > 0) {
            if (car != null &&  sp.getBoolean("car1", false)) {
                car.setVisibility(View.VISIBLE);
            }
            e.putInt("speed", 550 / sp.getInt("time1", 0));
            e.apply();

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(85, sp.getInt("position", 750), 0, 0);
            params.width = 125;
            params.height = 127;
            assert car != null;
            car.setLayoutParams(params);
        }

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt.setVisibility(View.INVISIBLE);
                smile.setVisibility(View.INVISIBLE);
                end.setVisibility(View.INVISIBLE);
                bt_add.setVisibility(View.VISIBLE);
            }
        });


    }


    public void Create(View view) {
        Intent myIntent = new Intent(MainActivity.this, CreateActivity.class);
        startActivity(myIntent);
    }


    public void Car_Movement(View view) {
        SharedPreferences sp = getSharedPreferences(MY_SETTINGS, Context.MODE_PRIVATE);
        Button bt_add = (Button) findViewById(R.id.button_add);
        Button bt_v = (Button) findViewById(R.id.button_vnesti_summ);
        TextView end = (TextView) findViewById(R.id.text_end);
        ImageView smile = (ImageView) findViewById(R.id.SMILE);
        ImageView car = (ImageView) findViewById(R.id.car);
        Button bt = (Button) findViewById(R.id.button3);
        if (sp.getBoolean("car1", false)) {

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(84, sp.getInt("position", 750) - sp.getInt("speed", 0), 0, 0);
            params.width = 125;
            params.height = 127;
            car.setLayoutParams(params);

            SharedPreferences.Editor e = sp.edit();
            e.putInt("position", sp.getInt("position", 750) - sp.getInt("speed", 0));
            e.apply();

            if (sp.getInt("position", 750) <= 200) {
                e.putBoolean("car1", false);
                e.apply();
                if (end != null && bt != null) {
                    bt_add.setVisibility(View.INVISIBLE);
                    bt_v.setVisibility(View.INVISIBLE);
                    bt.setVisibility(View.VISIBLE);
                    end.setVisibility(View.VISIBLE);
                    smile.setVisibility(View.VISIBLE);
                }
                if (car != null) {
                    car.setVisibility(View.INVISIBLE);
                }
                params.setMargins(84, sp.getInt("position", 750), 0, 0);
                params.width = 125;
                params.height = 127;
                car.setLayoutParams(params);
            }
        }

    }


}