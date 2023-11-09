package com.example.buildbuddy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{

    private static int version = 2;
    private static String name = "BaseDados.db";
    public DBHelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CriarTabela = "CREATE TABLE Utilizador (_id INTEGER PRIMARY KEY, username TEXT NOT NULL, senha TEXT NOT NULL, nome TEXT, email TEXT);";
        db.execSQL(CriarTabela);

        String CriarTabelaItens = "CREATE TABLE Itens (_id INTEGER PRIMARY KEY, username TEXT NOT NULL, item TEXT);";
        db.execSQL(CriarTabelaItens);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Utilizador;");
        onCreate(db);
    }
}
