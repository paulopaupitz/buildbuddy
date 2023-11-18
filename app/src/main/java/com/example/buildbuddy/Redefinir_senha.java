package com.example.buildbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Redefinir_senha extends AppCompatActivity {

    Button bt_recadastro;
    ImageButton bt_voltarL;
    EditText et_novaSenha, et_RnovaSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redefinir_senha);

        bt_recadastro = (Button) (findViewById(R.id.bt_recadastro));
        bt_voltarL = (ImageButton) (findViewById(R.id.bt_voltarL));

        et_novaSenha = (EditText) (findViewById(R.id.et_novaSenha));
        et_RnovaSenha = (EditText) (findViewById(R.id.et_RnovaSenha));

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        bt_recadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DataManager dataManager = new DataManager(Redefinir_senha.this);
                String novaSenha = et_novaSenha.getText().toString();
                String RnovaSenha = et_RnovaSenha.getText().toString();

                if (novaSenha.equals("") || RnovaSenha.equals("")) {
                    Toast.makeText(Redefinir_senha.this, "Senha não inserida. Tente novamente!", Toast.LENGTH_SHORT).show();
                }
                else if (!novaSenha.equals(RnovaSenha)){
                    Toast.makeText(Redefinir_senha.this, "Senhas não iguais. Tente novamente!", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (dataManager.atualizarSenha(username, novaSenha)) {
                        Toast.makeText(Redefinir_senha.this, "Senha atualizada com sucesso.", Toast.LENGTH_SHORT).show();
                        Voltar();
                    } else {
                        Toast.makeText(Redefinir_senha.this, "Erro ao atualizar a senha. Tente novamente.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        bt_voltarL.setOnClickListener(view -> Voltar());
    }

    private void Voltar(){
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        Intent voltar = new Intent(this, Perfil.class);
        voltar.putExtra("username", username);
        startActivity (voltar);
    }
}