package com.techboxsys.loteria_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText input1;
    private EditText input2;
    private EditText input3;
    private EditText input4;
    private EditText input5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        input1 = (EditText) findViewById(R.id.input1);
        input2 = (EditText) findViewById(R.id.input2);
        input3 = (EditText) findViewById(R.id.input3);
        input4 = (EditText) findViewById(R.id.input4);
        input5 = (EditText) findViewById(R.id.input5);

        validation(input1);
        validation(input2);
        validation(input3);
        validation(input4);
        validation(input5);
        input1.getText();
        input2.getText();
        input3.getText();
        input4.getText();
        input5.getText();
    }

    void validation(final EditText input){
        input.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    int value;
                    try{
                        Log.d("Valor inserido", ""+ input.getText());
                        value = Integer.parseInt(input.getText().toString());
                        Log.d("Valor inserido", ""+ value);
                        if (value < 1 || value > 50){
                            Toast.makeText(getApplicationContext(), "Digite valores entre 1 e 50", Toast.LENGTH_SHORT).show();
                        }
                    }catch ( NumberFormatException e){
                        Toast.makeText(getApplicationContext(), "Digite um valor", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }

    public void clickButton(View v){
        Toast.makeText(getApplicationContext(), "clicou", Toast.LENGTH_SHORT).show();
        Log.i("Valor 1",""+ input1.getText());
        Log.i("Valor 2",""+ input2.getText());
        Log.i("Valor 3",""+ input3.getText());
        Log.i("Valor 4",""+ input4.getText());
        Log.i("Valor 5",""+ input5.getText());
    }
}
