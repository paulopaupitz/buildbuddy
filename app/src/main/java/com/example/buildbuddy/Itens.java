package com.example.buildbuddy;

public class Itens {
    private String username;
    private String item;

    public Itens(String username, String item) {
        this.username = username;
        this.item = item;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
