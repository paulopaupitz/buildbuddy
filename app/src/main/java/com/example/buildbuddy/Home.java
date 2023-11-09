package com.example.buildbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;


public class Home extends AppCompatActivity {

    Button btSair, btLista, btConsulta, bt_perfil;
    TextView tv_hlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    btSair = (Button) (findViewById(R.id.btSair));
    btConsulta = (Button) (findViewById(R.id.bt_Consulta));
    btLista = (Button) (findViewById(R.id.btLista));
    bt_perfil = (Button) (findViewById(R.id.bt_perfil));
    tv_hlogin = (TextView)(findViewById(R.id.tv_hlogin));

    Intent intent = getIntent();
    String username = intent.getStringExtra("username");
    tv_hlogin.setText(String.valueOf(username));

    btSair.setOnClickListener(view -> Sair());
    btConsulta.setOnClickListener(view -> Programas());
    btLista.setOnClickListener(view -> Lista());
    bt_perfil.setOnClickListener(view -> Perfil());

    }

    private void Sair(){
        Intent TelaLogin = new Intent(this, MainActivity.class);
        startActivity (TelaLogin);
    }
    private void Programas(){
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        Intent Programas = new Intent(this, Programas.class);
        Programas.putExtra("username", username);
        startActivity (Programas);
    }
    private void Lista(){
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        Intent Lista = new Intent(this, listaDeCompras.class);
        Lista.putExtra("username", username);
        startActivity (Lista);
    }
    private void Perfil(){
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        Intent Perfil = new Intent(this, Perfil.class);
        Perfil.putExtra("username", username);
        startActivity (Perfil);
    }
}