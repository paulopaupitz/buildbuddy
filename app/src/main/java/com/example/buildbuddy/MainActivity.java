package com.example.buildbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity {
    Button btLogin, bt_cadastro, bt_recadastrar;
    EditText etLogin, etSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLogin = (EditText)(findViewById(R.id.etLogin));
        etSenha = (EditText)(findViewById(R.id.etSenha));

        btLogin = (Button)(findViewById(R.id.btLogin));
        bt_cadastro = (Button)(findViewById(R.id.bt_cadastro));
        bt_recadastrar = (Button)(findViewById(R.id.bt_recadastrar));

        bt_cadastro.setOnClickListener(view -> Cadastro());
        bt_recadastrar.setOnClickListener(view -> Recadastrar());

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = etLogin.getText().toString();
                String senha = etSenha.getText().toString();

                DataManager dataManager = new DataManager(MainActivity.this);

                if (dataManager.verificarCredenciais(login, senha)) {
                    alert("Bem-vindo! Login realizado com sucesso!");
                    Home();
                } else {
                    alert("Login e/ou senha incorretos!");
                }

                dataManager.close();
            }
        });
    }

    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
    private void Home(){

        String login = etLogin.getText().toString();
        String senha = etSenha.getText().toString();

        Intent home = new Intent(this, Home.class);
        home.putExtra("username", login);
        home.putExtra("senha", senha);
        startActivity (home);
    }
    private void Cadastro(){
        Intent Cadastro = new Intent(this, Cadastrar.class);
        startActivity (Cadastro);
    }
    private void Recadastrar(){
        Intent Recadastrar = new Intent(this, Esqueci_Senha.class);
        startActivity (Recadastrar);
    }

}