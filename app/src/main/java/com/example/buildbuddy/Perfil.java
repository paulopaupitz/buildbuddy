package com.example.buildbuddy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Perfil extends AppCompatActivity {

    Button bt_redefinir, bt_editar, bt_voltar, bt_excluir;
    TextView tv_perfil_nome, tv_perfil_login, tv_perfil_email, tv_plogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        DataManager dataManager = new DataManager(this);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        bt_editar = (Button) (findViewById(R.id.bt_editar));
        bt_redefinir = (Button) (findViewById(R.id.bt_redefinir));
        bt_voltar = (Button) (findViewById(R.id.bt_voltar));
        bt_excluir = (Button) (findViewById(R.id.bt_excluir));

        tv_perfil_login = (TextView)(findViewById(R.id.tv_perfil_login));
        tv_perfil_nome = (TextView)(findViewById(R.id.tv_perfil_nome));
        tv_perfil_email = (TextView)(findViewById(R.id.tv_perfil_email));
        tv_plogin = (TextView)(findViewById(R.id.tv_Plogin));

        Cursor cursor = dataManager.consultarDados(username);

        if (cursor != null && cursor.moveToFirst()) {
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            String login = cursor.getString(cursor.getColumnIndex("username"));

            tv_perfil_nome.setText(nome);
            tv_perfil_email.setText(email);
            tv_perfil_login.setText(login);

            cursor.close();
        }

        bt_voltar.setOnClickListener(view -> Home());
        bt_redefinir.setOnClickListener(view -> Redefinir());
        bt_editar.setOnClickListener(view -> Editar());
        bt_excluir.setOnClickListener(view -> Excluir());

    }
    private void Home(){

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        Intent home = new Intent(this, Home.class);
        home.putExtra("username", username);
        startActivity (home);
    }
    private void Redefinir(){
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        Intent redefinir = new Intent(this, Redefinir_senha.class);
        redefinir.putExtra("username", username);
        startActivity (redefinir);
    }
    private void Editar(){
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        Intent editar = new Intent(this, Recadastrar.class);
        editar.putExtra("username", username);
        startActivity (editar);
    }

    private void Excluir() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmação");
        builder.setMessage("Tem certeza que deseja excluir o perfil?");

        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ExcluirPerfil();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void ExcluirPerfil() {
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        DataManager dataManager = new DataManager(this);
        String Username = username;

        if (dataManager.excluirPerfil(Username)) {
            Toast.makeText(this, "Perfil excluído com sucesso.", Toast.LENGTH_SHORT).show();
            Intent Login = new Intent(this, MainActivity.class);
            startActivity(Login);
        } else {
            Toast.makeText(this, "Erro ao excluir o perfil. Tente novamente.", Toast.LENGTH_SHORT).show();
        }
    }
}