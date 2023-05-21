package com.example.meprojectforsamsung;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CreateActivity extends AppCompatActivity {

    int dohod,summa,time;
    String edit_textDohod, edit_textSumma, edit_textTime;
    int input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        Button button = (Button) findViewById(R.id.button);

        EditText editText_dohod = (EditText) findViewById(R.id.editTextNumber);
        EditText editText_summa = (EditText) findViewById(R.id.editTextNumber2);
        EditText editText_time = (EditText) findViewById(R.id.editTextNumber3);

        TextView textView = (TextView) findViewById(R.id.textView1);

        ImageView button_g = (ImageView) findViewById(R.id.galochka);
        ImageView button_k = (ImageView) findViewById(R.id.krestik);

        editText_dohod.setText(edit_textDohod);
        editText_summa.setText(edit_textSumma);
        editText_time.setText(edit_textTime);

        button_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent myIntent = new Intent(CreateActivity.this, MainActivity.class);
                    startActivity(myIntent);
            }
        });

        button_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_dohod.setText(0);
                editText_summa.setText(0);
                editText_time.setText(0);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String dohod1 = editText_dohod.getText().toString();
                edit_textDohod = dohod1;
                dohod = Integer.parseInt(dohod1);

                String summa1 = editText_summa.getText().toString();
                edit_textSumma = summa1;
                summa = Integer.parseInt(summa1);

                String time1 = editText_time.getText().toString();
                edit_textTime = time1;
                time = Integer.parseInt(time1);

                calculate(dohod, summa, time, input);
            }

            @SuppressLint("SetTextI18n")
            public void calculate(int dohod, int summa, int time, int input){
                    input = summa / time;
                    if (input > dohod){
                        textView.setText("Мало времени для достижения назначенной суммы");

                }
                    else{
                        textView.setText("Ты готов отдавать " + input + " на накопление?");
                        button_g.setVisibility(View.VISIBLE);
                        button_k.setVisibility(View.VISIBLE);
                    }

            }



        });


    }

    public int getTime(){
        return time;
    }






}