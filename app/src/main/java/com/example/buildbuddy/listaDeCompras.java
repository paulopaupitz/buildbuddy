package com.example.buildbuddy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;


public class listaDeCompras extends AppCompatActivity {

    Button bt_voltarH, bt_excluirItens;
    List<Itens> listaItens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_compras);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        DataManager dataManager = new DataManager(this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        Cursor cursor = dataManager.consultarItens(username);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String item = cursor.getString(cursor.getColumnIndex("item"));
                criarItens(username, item);
            }
            cursor.close();
        }

        Adapter adapter = new Adapter(listaItens);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        bt_voltarH = (Button) (findViewById(R.id.bt_voltarH));
        bt_voltarH.setOnClickListener(view -> Home());

        bt_excluirItens = (Button) (findViewById(R.id.bt_excluirItens));
        bt_excluirItens.setOnClickListener(view -> excluirItens(username));
    }

    public void criarItens(String username, String item){

        Itens itens = new Itens(username, item);
        listaItens.add(itens);
    }

    public void excluirItens(String username){

        Adapter adapter = new Adapter(listaItens);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmação");
        builder.setMessage("Tem certeza que deseja excluir o perfil?");

        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DataManager dataManager = new DataManager(getApplicationContext());
                dataManager.excluirItens(username);

                listaItens.clear();
                adapter.notifyDataSetChanged();
                Toast.makeText(listaDeCompras.this, "Itens excluídos com sucesso.", Toast.LENGTH_SHORT).show();
                recreate();
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

    private void Home(){
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        Intent home = new Intent(this, Home.class);
        home.putExtra("username", username);
        startActivity (home);
    }
}