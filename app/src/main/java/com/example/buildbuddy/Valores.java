package com.example.buildbuddy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class Valores extends AppCompatActivity {

    Button bt_continue, bt_volta;
    float maior;
    SeekBar sb_valor;
    TextView tv_valores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valores);

        bt_continue = (Button) (findViewById(R.id.bt_continue));
        bt_volta = (Button) (findViewById(R.id.bt_volta));
        sb_valor = (SeekBar) (findViewById(R.id.sb_valor));
        tv_valores = (TextView)(findViewById(R.id.tv_valores));

        sb_valor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress == 7000){
                    tv_valores.setText("Valor: Mais que R$"+progress+",00");
                }
                else{
                    tv_valores.setText("Valor: Até R$"+progress+",00");
                }
                maior = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        bt_volta.setOnClickListener(view -> voltar());
        bt_continue.setOnClickListener(view -> continuar(maior));
        
    }

    public void voltar(){
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        Intent voltar = new Intent(this, Programas.class);
        voltar.putExtra("username", username);
        startActivity (voltar);
    }

    public void continuar(float maior){

        Intent intent = getIntent();
        int N = intent.getIntExtra("Nivel", 0);
        int Processador = intent.getIntExtra("Processador", 0);
        int HD = intent.getIntExtra("HD", 0);
        int RAM = intent.getIntExtra("RAM", 0);
        int Video = intent.getIntExtra("Video", 0);
        float Preco = intent.getFloatExtra("Valor", 0);
        String username = intent.getStringExtra("username");

        Intent continuar = new Intent(this, Resultados.class);
        continuar.putExtra("Nivel", N);
        continuar.putExtra("Processador", Processador);
        continuar.putExtra("HD", HD);
        continuar.putExtra("RAM", RAM);
        continuar.putExtra("Video", Video);
        continuar.putExtra("Preco", Preco);
        continuar.putExtra("username", username);
        continuar.putExtra("Maior", maior);
        startActivity (continuar);

    }
}