package com.example.buildbuddy;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Programas extends AppCompatActivity {

    Button bt_back, bt_continuar;
    private CheckBox
            cb_win10,cb_win11, cb_win, cb_linux, cb_navegadores, cb_players, cb_pdf, cb_streaming,
            cb_office, cb_teamviewer, cb_bi,
            cb_ide, cb_android, cb_bd,
            cb_cs, cb_valorant_fortnite, cv_mine_pubg, cb_elden_resident, cb_cyber, cb_rdr2, cb_spider, cb_ffxvi, cb_assassins, cb_watch,
            cb_autocad, cb_catia, cb_solid, cb_autodesk,
            cb_premiere, cb_photoshop, cb_illustrator, cb_after, cb_vegas, cb_corel,
            cb_blender, cb_cinema, cb_maya, cb_3ds, cb_Zbrush, cb_unreal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programas);

        bt_back = (Button) (findViewById(R.id.bt_back));
        bt_continuar = (Button) (findViewById(R.id.bt_continuar));

        cb_win10 = (CheckBox) (findViewById(R.id.cb_win10));
        cb_win11 = (CheckBox) (findViewById(R.id.cb_win11));
        cb_win = (CheckBox) (findViewById(R.id.cb_win));
        cb_linux = (CheckBox) (findViewById(R.id.cb_linux));
        cb_navegadores = (CheckBox) (findViewById(R.id.cb_navegadores));
        cb_players = (CheckBox) (findViewById(R.id.cb_players));
        cb_pdf = (CheckBox) (findViewById(R.id.cb_pdf));
        cb_streaming = (CheckBox) (findViewById(R.id.cb_streaming));
        cb_office = (CheckBox) (findViewById(R.id.cb_office));
        cb_teamviewer = (CheckBox) (findViewById(R.id.cb_teamviewer));
        cb_bi = (CheckBox) (findViewById(R.id.cb_bi));
        cb_ide = (CheckBox) (findViewById(R.id.cb_ide));
        cb_android = (CheckBox) (findViewById(R.id.cb_android));
        cb_bd = (CheckBox) (findViewById(R.id.cb_bd));
        cb_cs = (CheckBox) (findViewById(R.id.cb_cs));
        cb_valorant_fortnite = (CheckBox) (findViewById(R.id.cb_valorant_fortnite));
        cv_mine_pubg = (CheckBox) (findViewById(R.id.cb_mine_pubg));
        cb_elden_resident = (CheckBox) (findViewById(R.id.cb_elden_resident));
        cb_cyber = (CheckBox) (findViewById(R.id.cb_cyber));
        cb_rdr2 = (CheckBox) (findViewById(R.id.cb_rdr2));
        cb_spider = (CheckBox) (findViewById(R.id.cb_spider));
        cb_ffxvi = (CheckBox) (findViewById(R.id.cb_ffxvi));
        cb_assassins = (CheckBox) (findViewById(R.id.cb_assassins));
        cb_watch = (CheckBox) (findViewById(R.id.cb_watch));
        cb_autocad = (CheckBox) (findViewById(R.id.cb_autocad));
        cb_catia = (CheckBox) (findViewById(R.id.cb_catia));
        cb_solid = (CheckBox) (findViewById(R.id.cb_solid));
        cb_autodesk = (CheckBox) (findViewById(R.id.cb_autodesk));
        cb_premiere = (CheckBox) (findViewById(R.id.cb_premiere));
        cb_photoshop = (CheckBox) (findViewById(R.id.cb_photoshop));
        cb_illustrator = (CheckBox) (findViewById(R.id.cb_illustrator));
        cb_after = (CheckBox) (findViewById(R.id.cb_after));
        cb_vegas = (CheckBox) (findViewById(R.id.cb_vegas));
        cb_corel = (CheckBox) (findViewById(R.id.cb_corel));
        cb_blender = (CheckBox) (findViewById(R.id.cb_blender));
        cb_cinema = (CheckBox) (findViewById(R.id.cb_cinema));
        cb_maya = (CheckBox) (findViewById(R.id.cb_maya));
        cb_3ds = (CheckBox) (findViewById(R.id.cb_3ds));
        cb_Zbrush = (CheckBox) (findViewById(R.id.cb_Zbrush));
        cb_unreal = (CheckBox) (findViewById(R.id.cb_unreal));

        bt_back.setOnClickListener(view -> Back());

        bt_continuar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int N=0, Processador=0, HD=0, RAM=0, Video = 0;
                if (cb_win10.isChecked()) {
                    N=1;
                    Processador=1;
                    HD=120;
                    RAM=4;
                    Video = 1;
                }
                if (cb_win11.isChecked()) {
                    N=1;
                    Processador=1;
                    HD=120;
                    RAM=4;
                    Video = 1;
                }
                if (cb_win.isChecked()) {
                    N=1;
                    Processador=1;
                    HD=120;
                    RAM=4;
                    Video = 1;
                }
                if (cb_linux.isChecked()) {
                    N=1;
                    Processador=1;
                    HD=120;
                    RAM=4;
                    Video = 1;
                }
                if (cb_navegadores.isChecked()) {
                    N=1;
                    Processador=1;
                    HD=120;
                    RAM=4;
                    Video = 1;
                }
                if (cb_players.isChecked()) {
                    N=1;
                    Processador=1;
                    HD=120;
                    RAM=4;
                    Video = 1;
                }
                if (cb_pdf.isChecked()) {
                    N=1;
                    Processador=1;
                    HD=120;
                    RAM=4;
                    Video = 1;
                }
                if (cb_streaming.isChecked()) {
                    N=1;
                    Processador=1;
                    HD=120;
                    RAM=4;
                    Video = 1;
                }
                if (cb_office.isChecked()) {
                    N=2;
                    Processador=1;
                    HD=120;
                    RAM=4;
                    Video = 1;
                }
                if (cb_teamviewer.isChecked()) {
                    N=2;
                    Processador=1;
                    HD=120;
                    RAM=4;
                    Video = 1;
                }
                if (cb_bi.isChecked()) {
                    N=2;
                    Processador=1;
                    HD=120;
                    RAM=4;
                    Video = 1;
                }
                if (cb_ide.isChecked()) {
                    N=3;
                    Processador=1;
                    HD=120;
                    RAM=4;
                    Video = 1;
                }
                if (cb_bd.isChecked()) {
                    N=3;
                    Processador=1;
                    HD=120;
                    RAM=4;
                    Video = 1;
                }
                if (cb_android.isChecked()) {
                    N=3;
                    Processador=1;
                    HD=120;
                    RAM=8;
                    Video = 1;
                }
                if (cb_cs.isChecked()) {
                    N=4;
                    Processador=1;
                    HD=120;
                    RAM=8;
                    Video = 2;
                }
                if (cb_valorant_fortnite.isChecked()) {
                    N=4;
                    Processador=1;
                    HD=120;
                    RAM=maior(RAM,4);
                    Video = 2;
                }

                if (cv_mine_pubg.isChecked()) {
                    N=4;
                    Processador=1;
                    HD=120;
                    RAM=maior(RAM, 16);
                    Video = 2;
                }
                if (cb_elden_resident.isChecked()) {
                    N=4;
                    Processador=2;
                    HD=120;
                    RAM=maior(RAM, 16);
                    Video = 2;
                }
                if (cb_cyber.isChecked()) {
                    N=4;
                    Processador=maior(Processador,1);
                    HD=240;
                    RAM=maior(RAM, 12);
                    Video = 2;
                }
                if (cb_rdr2.isChecked()) {
                    N=4;
                    Processador=maior(Processador,1);
                    HD=480;
                    RAM=maior(RAM, 12);
                    Video = 2;
                }
                if (cb_spider.isChecked()) {
                    N=4;
                    Processador=maior(Processador, 1);
                    HD=maior(HD, 240);
                    RAM=16;
                    Video = 2;
                }
                if (cb_ffxvi.isChecked()) {
                    N=4;
                    Processador=2;
                    HD=maior(HD, 240);
                    RAM=16;
                    Video = 3;
                }
                if (cb_assassins.isChecked()) {
                    N=4;
                    Processador=2;
                    HD=maior(HD, 240);
                    RAM=maior(RAM, 8);
                    Video = 3;
                }
                if (cb_watch.isChecked()) {
                    N=4;
                    Processador=2;
                    HD=maior(HD, 240);
                    RAM=maior(RAM, 8);
                    Video = maior(Video, 2);
                }
                if (cb_autocad.isChecked()) {
                    N=5;
                    Processador=maior(Processador, 1);
                    HD=maior(HD, 120);
                    RAM=32;
                    Video = maior(Video, 3);
                }
                if (cb_catia.isChecked()) {
                    N=5;
                    Processador=maior(Processador, 1);
                    HD=maior(HD, 120);
                    RAM=maior(RAM, 16);
                    Video = maior(Video, 2);
                }
                if (cb_solid.isChecked()) {
                    N=5;
                    Processador=maior(Processador, 1);
                    HD=maior(HD, 120);
                    RAM=maior(RAM, 16);
                    Video = maior(Video, 1);
                }
                if (cb_autodesk.isChecked()) {
                    N=5;
                    Processador=maior(Processador, 1);
                    HD=maior(HD, 120);
                    RAM=maior(RAM, 32);
                    Video = maior(Video, 2);
                }

                if (cb_premiere.isChecked()) {
                    N=6;
                    Processador=maior(Processador, 1);
                    HD=maior(HD, 120);
                    RAM=maior(RAM, 16);
                    Video = maior(Video, 2);
                }
                if (cb_photoshop.isChecked()) {
                    N=6;
                    Processador=maior(Processador, 1);
                    HD=maior(HD, 120);
                    RAM=maior(RAM, 16);
                    Video = maior(Video, 2);
                }
                if (cb_illustrator.isChecked()) {
                    N=6;
                    Processador=maior(Processador, 1);
                    HD=maior(HD, 120);
                    RAM=maior(RAM, 16);
                    Video = maior(Video, 2);
                }
                if (cb_after.isChecked()) {
                    N=6;
                    Processador=maior(Processador, 2);
                    HD=maior(HD, 120);
                    RAM=maior(RAM, 16);
                    Video = maior(Video, 2);
                }

                if (cb_vegas.isChecked()) {
                    N=6;
                    Processador=maior(Processador, 1);
                    HD=maior(HD, 120);
                    RAM=maior(RAM, 32);
                    Video = maior(Video, 3);
                }
                if (cb_corel.isChecked()) {
                    N=6;
                    Processador=maior(Processador, 2);
                    HD=maior(HD, 120);
                    RAM=maior(RAM, 16);
                    Video = maior(Video, 2);
                }
                if (cb_blender.isChecked()) {
                    N=7;
                    Processador=maior(Processador, 2);
                    HD=maior(HD, 120);
                    RAM=maior(RAM, 32);
                    Video = maior(Video, 3);
                }
                if (cb_cinema.isChecked()) {
                    N=7;
                    Processador=maior(Processador, 2);
                    HD=maior(HD, 120);
                    RAM=maior(RAM, 16);
                    Video = maior(Video, 2);
                }

                if (cb_maya.isChecked()) {
                    N=7;
                    Processador=maior(Processador, 2);
                    HD=maior(HD, 120);
                    RAM=maior(RAM, 32);
                    Video = maior(Video, 2);
                }
                if (cb_3ds.isChecked()) {
                    N=7;
                    Processador=maior(Processador, 2);
                    HD=maior(HD, 120);
                    RAM=maior(RAM, 32);
                    Video = maior(Video, 2);
                }
                if (cb_Zbrush.isChecked()) {
                    N=7;
                    Processador=maior(Processador, 3);
                    HD=maior(HD, 240);
                    RAM=maior(RAM, 32);
                    Video = maior(Video, 2);
                }
                if (cb_unreal.isChecked()) {
                    N=7;
                    Processador=maior(Processador, 2);
                    HD=maior(HD, 120);
                    RAM=maior(RAM, 32);
                    Video = maior(Video, 2);
                }

                Intent intent = getIntent();
                String username = intent.getStringExtra("username");

                float Valor = preco(Processador, HD, RAM, Video);
                Intent avancar = new Intent(Programas.this, Valores.class);
                avancar.putExtra("Nivel", N);
                avancar.putExtra("Processador", Processador);
                avancar.putExtra("HD", HD);
                avancar.putExtra("RAM", RAM);
                avancar.putExtra("Video", Video);
                avancar.putExtra("Valor", Valor);
                avancar.putExtra("username", username);
                startActivity (avancar);

            }
        });
    }

    private void Back(){
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        Intent voltar = new Intent(this, Home.class);
        voltar.putExtra("username", username);
        startActivity (voltar);
    }

    private int maior(int a, int b) {
        if (a >= b) {
            return a;
        }
        return b;
    }
    private float preco(int p, int s, int m, int v){
        float valor =0;

        if(p==1){
            valor = valor + 630 + 500 + 200;
        }
        if(p==2){
            valor = valor + 1300 + 800 + 280;
        }
        if(p==3){
            valor = valor + 2000 + 1400 + 320;
        }
        if(p==4){
            valor = valor + 4800 + 1400 + 600;
        }
        if(s == 120){
            valor = valor + 80;
        }
        if(s == 240){
            valor = valor + 130;
        }
        if(s == 480){
            valor = valor + 200;
        }
        if(m==4){
            valor = valor + 100;
        }
        if(m==8){
            valor = valor + 140;
        }
        if(m==12 || m==16){
            valor = valor + 200;
        }
        if(m==32){
            valor = valor + 400;
        }
        if(v==2){
            valor = valor + 1200;
        }
        if(v==3){
            valor = valor + 2200;
        }
        if(v==4){
            valor = valor + 6250;
        }

        return valor;
    }
}