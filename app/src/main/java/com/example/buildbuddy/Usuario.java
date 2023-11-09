package com.example.buildbuddy;

public class Usuario {
    private String username, senha, nome, email;

    public Usuario(String username, String senha, String nome, String email) {
        this.username = username;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
    }
    public String getNomeUsuario() {
        return username;
    }
    public String getSenha() {return senha;}
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
}
