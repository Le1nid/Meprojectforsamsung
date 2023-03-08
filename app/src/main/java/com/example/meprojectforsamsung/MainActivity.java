package com.example.meprojectforsamsung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);

        EditText editText_dohod = (EditText) findViewById(R.id.editTextNumber);
        EditText editText_summa = (EditText) findViewById(R.id.editTextNumber2);
        EditText editText_time = (EditText) findViewById(R.id.editTextNumber3);

        TextView textView = (TextView) findViewById(R.id.textView);
        String dohod1 = editText_dohod.getText().toString();
        int dohod = Integer.parseInt(dohod1);

        String summa1 = editText_dohod.getText().toString();
        int summa = Integer.parseInt(summa1);

        String time1 = editText_dohod.getText().toString();
        int time = Integer.parseInt(time1);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView.setText(dohod);
            }
        });
    }





}