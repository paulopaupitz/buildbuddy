package com.example.buildbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Esqueci_Senha extends AppCompatActivity {

    Button bt_redefinir_ns;
    ImageButton bt_voltar_es;
    EditText et_login_es, et_senha_es, et_rsenha_es;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueci_senha);

        bt_redefinir_ns = (Button) (findViewById(R.id.bt_redefinir_ns));
        bt_voltar_es = (ImageButton) (findViewById(R.id.bt_voltar_es));

        et_login_es = (EditText) (findViewById(R.id.et_login_es));
        et_senha_es = (EditText) (findViewById(R.id.et_senha_es));
        et_rsenha_es = (EditText) (findViewById(R.id.et_rsenha_es));

        bt_redefinir_ns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DataManager dataManager = new DataManager(Esqueci_Senha.this);
                String username = et_login_es.getText().toString();
                String NovaSenha = et_senha_es.getText().toString();
                String RNovaSenha = et_rsenha_es.getText().toString();


                if (dataManager.verificarUsername(username)) {
                    if (NovaSenha.equals("") || RNovaSenha.equals("")) {
                        Toast.makeText(Esqueci_Senha.this, "Senha não inserida. Tente novamente!", Toast.LENGTH_SHORT).show();
                    }
                    else if (!NovaSenha.equals(RNovaSenha)){
                        Toast.makeText(Esqueci_Senha.this, "Senhas não iguais. Tente novamente!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if (dataManager.atualizarSenha(username, NovaSenha)) {
                            Toast.makeText(Esqueci_Senha.this, "Senha atualizada com sucesso.", Toast.LENGTH_SHORT).show();
                            Voltar();
                        } else {
                            Toast.makeText(Esqueci_Senha.this, "Erro ao atualizar a senha. Tente novamente.", Toast.LENGTH_SHORT).show();
                        }
                    }
                    Intent intent = new Intent(Esqueci_Senha.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Esqueci_Senha.this, "Login não encontrado. Verifique o login inserido.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        bt_voltar_es.setOnClickListener(view -> Voltar());
    }
    private void Voltar(){

        Intent voltar = new Intent(this, MainActivity.class);
        startActivity (voltar);
    }
}