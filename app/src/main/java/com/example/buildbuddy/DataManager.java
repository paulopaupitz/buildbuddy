package com.example.buildbuddy;


import android.content.ClipData;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataManager {
    private DBHelper dbHelper;

    public DataManager (Context context){
        dbHelper = new DBHelper(context);
    }

    public long inserirUsuario(Usuario usuario) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("username", usuario.getNomeUsuario());
        cv.put("senha", usuario.getSenha());
        cv.put("nome", usuario.getNome());
        cv.put("email", usuario.getEmail());

        long id = db.insert("Utilizador", null, cv);

        return id;
    }

    public Cursor consultarDados(String username) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] colunas = {"nome", "email", "username"};
        String selecao = "username = ?";
        String[] selecaoArgs = {username};

        Cursor cursor = db.query("Utilizador", colunas, selecao, selecaoArgs, null, null, null);

        return cursor;
    }
    public boolean excluirPerfil(String username) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String selecao = "username = ?";
        String[] selecaoArgs = {username};

        int linhasAfetadas = db.delete("Utilizador", selecao, selecaoArgs);

        return linhasAfetadas > 0;
    }
    public boolean atualizarUsuario(Usuario usuario) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("username", usuario.getNomeUsuario());
        cv.put("nome", usuario.getNome());
        cv.put("email", usuario.getEmail());

        String selecao = "username = ?";
        String[] selecaoArgs = {usuario.getNomeUsuario()};

        int linhasAfetadas = db.update("Utilizador", cv, selecao, selecaoArgs);

        return linhasAfetadas > 0;
    }

    public boolean atualizarSenha(String username, String novaSenha) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("senha", novaSenha);

        String selecao = "username = ?";
        String[] selecaoArgs = {username};

        int linhasAfetadas = db.update("Utilizador", cv, selecao, selecaoArgs);

        return linhasAfetadas > 0;
    }
    public boolean verificarCredenciais(String username, String senha) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] colunas = { "username", "senha" };
        String selecao = "username = ? AND senha = ?";
        String[] selecaoArgs = {username, senha };

        Cursor cursor = db.query("Utilizador", colunas, selecao, selecaoArgs, null, null, null);

        boolean loginBemSucedido = cursor.moveToFirst();
        cursor.close();

        return loginBemSucedido;
    }

    public boolean verificarUsername(String username) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] colunas = { "_id" };
        String selecao = "username = ? ";
        String[] selecaoArgs = {username};

        Cursor cursor = db.query("Utilizador", colunas, selecao, selecaoArgs, null, null, null);

        boolean loginBemSucedido = cursor.moveToFirst();
        cursor.close();

        return loginBemSucedido;
    }

    public String getSenhaUsuario(String username) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] colunas = { "senha" };
        String selecao = "username = ?";
        String[] selecaoArgs = { username };

        Cursor cursor = db.query("Utilizador", colunas, selecao, selecaoArgs, null, null, null);

        String senha = null;
        if (cursor.moveToFirst()) {
            senha = cursor.getString(cursor.getColumnIndex("senha"));
        }

        cursor.close();
        return senha;
    }
    public long inserirItem(Itens item) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("username", item.getUsername());
        cv.put("item", item.getItem());

        long id = db.insert("Itens", null, cv);

        return id;
    }

    public Cursor consultarItens(String username) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] colunas = {"username", "item"};
        String selecao = "username = ?";
        String[] selecaoArgs = {username};

        Cursor cursor = db.query("Itens", colunas, selecao, selecaoArgs, null, null, null);

        return cursor;
    }

    public boolean excluirItens(String username) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String selecao = "username = ?";
        String[] selecaoArgs = {username};

        int linhasAfetadas = db.delete("Itens", selecao, selecaoArgs);

        return linhasAfetadas > 0;
    }
    public void close() {
        dbHelper.close();
    }
}
