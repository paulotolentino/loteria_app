package com.techboxsys.loteria_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {


    private EditText input1;
    private EditText input2;
    private EditText input3;
    private EditText input4;
    private EditText input5;
    private Button numbers;
    private Button resetButton;
    private TextView acertosText;
    private TextView acerto1;
    private TextView acerto2;
    private TextView acerto3;
    private TextView acerto4;
    private TextView acerto5;
    private ImageView res1;
    private ImageView res2;
    private ImageView res3;
    private ImageView res4;
    private ImageView res5;


    private ArrayList<Integer> arr = new ArrayList<Integer>();
    private int acertos = -1; //Não foi feito o sorteio ainda

    private SortedSet<Integer> escolhidos = new TreeSet<>();
    private SortedSet<Integer> sorteados = new TreeSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        input3 = findViewById(R.id.input3);
        input4 = findViewById(R.id.input4);
        input5 = findViewById(R.id.input5);
        acertosText = findViewById(R.id.resultados);

        acerto1 = findViewById(R.id.acerto1);
        acerto2 = findViewById(R.id.acerto2);
        acerto3 = findViewById(R.id.acerto3);
        acerto4 = findViewById(R.id.acerto4);
        acerto5 = findViewById(R.id.acerto5);

        res1 = findViewById(R.id.extracao1);
        res2 = findViewById(R.id.extracao2);
        res3 = findViewById(R.id.extracao3);
        res4 = findViewById(R.id.extracao4);
        res5 = findViewById(R.id.extracao5);

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

        numbers = findViewById(R.id.button);
        resetButton = findViewById(R.id.button2);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Clicou", Toast.LENGTH_SHORT).show();
                Log.i("Valor 1", "" + input1.getText());
                Log.i("Valor 2", "" + input2.getText());
                Log.i("Valor 3", "" + input3.getText());
                Log.i("Valor 4", "" + input4.getText());
                Log.i("Valor 5", "" + input5.getText());
//                String valores = "";

                if (escolhidos.size() == 5) {
                    Log.i("", "\nSorteando os números...\n");
                    while (sorteados.size() < 5) {
                        Random rand = new Random();
                        int n = rand.nextInt(50) + 1;
                        if (!sorteados.contains(n)) {
                            sorteados.add(n);
                            if (escolhidos.contains(n)) {
                                acertos++;
                            }
                            Log.i("Valor", "" + n);
                            Log.i("nSorteados", "" + sorteados.size());
                        } else {
                            n = rand.nextInt(50) + 1;
                            Log.i("Valor repetido", "" + n);
                        }
//                        valores += " " + n;
                    }


                    arr.addAll(sorteados);

                    acertos++;
                    acerto1.setText(String.valueOf(arr.get(0)));
                    acerto2.setText(String.valueOf(arr.get(1)));
                    acerto3.setText(String.valueOf(arr.get(2)));
                    acerto4.setText(String.valueOf(arr.get(3)));
                    acerto5.setText(String.valueOf(arr.get(4)));
                    acertosText.setText(String.valueOf(acertos));
                    numbers.setVisibility(View.GONE);
                    resetButton.setVisibility(View.VISIBLE);
                    Log.i("Escolhidos", "" + escolhidos);
                    Log.i("Sorteados", "" + sorteados);
                    if (acertos + 1 == 5) {
                        Log.i("Acertos", "Bingo!");
                    } else {
                        Log.i("Acertos", "" + (acertos + 1));
                    }
                    Toast.makeText(getApplicationContext(), "Sorteio realizado com sucesso!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Escolha 5 números", Toast.LENGTH_SHORT).show();
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1.setText("");
                input2.setText("");
                input3.setText("");
                input4.setText("");
                input5.setText("");
                acertosText.setText("");
                sorteados = null;
                acertos = 0;
                escolhidos = null;

                acerto1.setText("");
                acerto2.setText("");
                acerto3.setText("");
                acerto4.setText("");
                acerto5.setText("");

                numbers.setVisibility(View.VISIBLE);
                resetButton.setVisibility(View.GONE);
            }
        });
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
                        } else {
                            if (escolhidos.contains(Integer.parseInt(input.getText().toString()))) {
                                Toast.makeText(getApplicationContext(), "Valor já repetido, insira um número diferente", Toast.LENGTH_SHORT).show();
                            } else {
                                escolhidos.add(Integer.parseInt(input.getText().toString()));
                                Log.i("nEscolhidos", "" + escolhidos.size());
                            }
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
