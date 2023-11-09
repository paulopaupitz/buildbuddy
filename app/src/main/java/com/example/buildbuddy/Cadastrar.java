package com.example.buildbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastrar extends AppCompatActivity {

    Button bt_voltarL, bt_cadastrar;
    EditText et_name, et_login, et_email, et_senha, et_rsenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        DataManager dataManager = new DataManager(this);

        bt_voltarL = (Button) (findViewById(R.id.bt_voltarP));
        bt_cadastrar = (Button) (findViewById(R.id.bt_recadastro));
        et_name = (EditText)(findViewById(R.id.et_rname));
        et_login = (EditText)(findViewById(R.id.et_rlogin));
        et_email = (EditText)(findViewById(R.id.et_remail));
        et_senha = (EditText)(findViewById(R.id.et_novaSenha));
        et_rsenha = (EditText)(findViewById(R.id.et_RnovaSenha));

        bt_voltarL.setOnClickListener(view -> Login());
        bt_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = et_login.getText().toString();
                String name = et_name.getText().toString();
                String email = et_email.getText().toString();
                String senha = et_senha.getText().toString();
                String rsenha = et_rsenha.getText().toString();

                Usuario usuario = new Usuario(username, senha, name, email);

                if (username.equals("")){
                    Toast.makeText(Cadastrar.this, "Login não inserido. Tente novamente!", Toast.LENGTH_SHORT).show();
                }
                else if (senha.equals("") || rsenha.equals("")) {
                    Toast.makeText(Cadastrar.this, "Senha não inserida. Tente novamente!", Toast.LENGTH_SHORT).show();
                }
                else if (!senha.equals(rsenha)){
                    Toast.makeText(Cadastrar.this, "Senhas não iguais. Tente novamente!", Toast.LENGTH_SHORT).show();
                }
                else {
                    long resultado = dataManager.inserirUsuario(usuario);
                    if(resultado != -1){
                        Toast.makeText(Cadastrar.this, "Registro inserido com sucesso!", Toast.LENGTH_SHORT).show();
                        Login();
                    }
                    else{
                        Toast.makeText(Cadastrar.this, "Registro inválido. Tente novamente!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void Login() {
        Intent login = new Intent(this, MainActivity.class);
        startActivity(login);
    }
}