package com.example.buildbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Recadastrar extends AppCompatActivity {

    Button bt_recadastro, bt_voltarP;
    EditText et_rname, et_rlogin, et_remail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recadastrar);

        DataManager dataManager = new DataManager(this);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String senha = dataManager.getSenhaUsuario(username);

        et_rname = (EditText)(findViewById(R.id.et_rname));
        et_rlogin = (EditText)(findViewById(R.id.et_rlogin));
        et_remail = (EditText)(findViewById(R.id.et_remail));

        bt_recadastro = findViewById(R.id.bt_recadastro);
        bt_voltarP = findViewById(R.id.bt_voltarP);

        bt_voltarP.setOnClickListener(view -> Perfil());

        bt_recadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newUsername = et_rlogin.getText().toString();
                String name = et_rname.getText().toString();
                String email = et_remail.getText().toString();

                Usuario usuario = new Usuario(newUsername, senha, name, email);

                if (dataManager.atualizarUsuario(usuario)) {
                    Toast.makeText(Recadastrar.this, "Perfil atualizado com sucesso!", Toast.LENGTH_SHORT).show();
                    Perfil();
                } else {
                    Toast.makeText(Recadastrar.this, "Erro ao atualizar o perfil. Tente novamente.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

private void Perfil() {
    Intent intent = getIntent();
    String username = intent.getStringExtra("username");

    Intent perfil = new Intent(this, Perfil.class);
    perfil.putExtra("username", username);
    startActivity(perfil);
    }
}