package com.example.buildbuddy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Resultados extends AppCompatActivity {

    Button btvoltar, bt_terminar;
    ImageButton bt_item1,bt_item2,bt_item3, bt_item4, bt_item5, bt_item6, bt_item7, bt_item8, bt_item9;
    TextView tv_maior, tv_menor, tv_nivel, tv_amd, tv_intel, tv_ssd, tv_ram, tv_radeon, tv_nvidia,
             tv_amdpm, tv_intelpm, tv_recomenda1, tv_recomenda2, tv_recomenda3, tv_recomenda4,
             tv_fonte, tv_valor;

    int Nivel, Processador, HD, RAM, Video;
    float Preco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        DataManager dataManager = new DataManager(this);

        btvoltar = (Button) (findViewById(R.id.btvoltar));
        bt_terminar = (Button) (findViewById(R.id.bt_terminar));
        bt_item1 = (ImageButton) (findViewById(R.id.bt_item1));
        bt_item2 = (ImageButton) (findViewById(R.id.bt_item2));
        bt_item3 = (ImageButton) (findViewById(R.id.bt_item3));
        bt_item4 = (ImageButton) (findViewById(R.id.bt_item4));
        bt_item5 = (ImageButton) (findViewById(R.id.bt_item5));
        bt_item6 = (ImageButton) (findViewById(R.id.bt_item6));
        bt_item7 = (ImageButton) (findViewById(R.id.bt_item7));
        bt_item8 = (ImageButton) (findViewById(R.id.bt_item8));
        bt_item9 = (ImageButton) (findViewById(R.id.bt_item9));


        tv_maior = (TextView) (findViewById(R.id.tv_maior));
        tv_nivel = (TextView) (findViewById(R.id.tv_nivel));
        tv_amd = (TextView) (findViewById(R.id.tv_amd));
        tv_intel = (TextView) (findViewById(R.id.tv_intel));
        tv_amdpm = (TextView) (findViewById(R.id.tv_amdpm));
        tv_intelpm = (TextView) (findViewById(R.id.tv_intelpm));
        tv_recomenda1 = (TextView) (findViewById(R.id.tv_recomenda1));
        tv_recomenda2 = (TextView) (findViewById(R.id.tv_recomenda2));
        tv_recomenda3 = (TextView) (findViewById(R.id.tv_recomenda3));
        tv_recomenda4 = (TextView) (findViewById(R.id.tv_recomenda4));
        tv_ssd = (TextView) (findViewById(R.id.tv_ssd));
        tv_ram = (TextView) (findViewById(R.id.tv_ram));
        tv_radeon = (TextView) (findViewById(R.id.tv_radeon));
        tv_nvidia = (TextView) (findViewById(R.id.tv_nvidia));
        tv_fonte = (TextView) (findViewById(R.id.tv_fonte));
        tv_valor = (TextView) (findViewById(R.id.tv_valor));

        Nivel = getIntent().getIntExtra("Nivel",0);
        Processador = getIntent().getIntExtra("Processador",0);
        HD = getIntent().getIntExtra("HD",0);
        RAM = getIntent().getIntExtra("RAM",0);
        Video = getIntent().getIntExtra("Video",0);
        Preco = getIntent().getFloatExtra("Preco", 0);
        float Maior = getIntent().getFloatExtra("Maior", 0);
        String username = getIntent().getStringExtra("username");

        if(Maior < Preco){
            AlertDialog.Builder Error = new AlertDialog.Builder(Resultados.this);
            Error.setTitle("Atenção!");
            Error.setMessage("Orçamento abaixo do preço estimado do computador!");
            Error.setNeutralButton("OK", null);
            Error.create().show();
        }

        if(Nivel == 4){
            tv_recomenda1.setText(String.valueOf("Adição de armazenamento interno (HD) de pelo menos 1TB"));
            tv_recomenda2.setText(String.valueOf("Configurações não recomendadas para jogos em 4K"));
        }
        if(Nivel == 6){
            tv_recomenda4.setText(String.valueOf("Adição de armazenamento interno (HD) de pelo menos 1TB"));
        }
        if(Nivel == 7){
            tv_recomenda1.setText(String.valueOf("Processador Core I5 13600K ou Ryzen 5 5800X3D"));
            tv_recomenda2.setText(String.valueOf("32GB de Memória RAM, caso use Blender até 48GB"));
            tv_recomenda3.setText(String.valueOf("Placa de vídeo Geforce RTX 3060TI ou Radeon RX6750XT"));
            tv_recomenda4.setText(String.valueOf("Adição de armazenamento interno (HD) de pelo menos 1TB"));
        }

        if(Processador == 1){
            tv_intel.setText(String.valueOf("Core I3 10100"));
            tv_amd.setText(String.valueOf("Ryzen 5 4600G"));
            tv_intelpm.setText(String.valueOf("Chipset H510M"));
            tv_amdpm.setText(String.valueOf("Chipset A520M"));

        }
        if(Processador == 2){
            tv_intel.setText(String.valueOf("Core I5 11600K"));
            tv_amd.setText(String.valueOf("Ryzen 7 5700X"));
            tv_intelpm.setText(String.valueOf("Chipset B560M"));
            tv_amdpm.setText(String.valueOf("Chipset B550M"));
        }
        if(Processador == 3){
            tv_intel.setText(String.valueOf("Core I5 13600K"));
            tv_amd.setText(String.valueOf("Ryzen 5 5800X3D"));
            tv_intelpm.setText(String.valueOf("Chipset Z690"));
            tv_amdpm.setText(String.valueOf("Chipset X570"));
        }
        if(Processador == 4){
            tv_intel.setText(String.valueOf("Core I9 13900KS"));
            tv_amd.setText(String.valueOf("Ryzen 7 7950X"));
            tv_intelpm.setText(String.valueOf("Chipset Z690"));
            tv_amdpm.setText(String.valueOf("Chipset X570"));
        }

        if(Video == 1){
            tv_radeon.setText(String.valueOf("Integrado (Junto ao processador)"));
            tv_nvidia.setText(String.valueOf("Integrado (Junto ao processador)"));
            tv_fonte.setText(String.valueOf("Fonte de 250 Watts "));
        }
        if(Video == 2){
            tv_radeon.setText(String.valueOf("Radeon RX6600"));
            tv_nvidia.setText(String.valueOf("Geforce RTX 2060"));
            tv_fonte.setText(String.valueOf("Fonte de 500 Watts "));
        }
        if(Video == 3){
            tv_radeon.setText(String.valueOf("Radeon RX6750XT"));
            tv_nvidia.setText(String.valueOf("Geforce RTX 3060TI"));
            tv_fonte.setText(String.valueOf("Fonte de 600 Watts "));
        }
        if(Video == 4){
            tv_radeon.setText(String.valueOf("Radeon RX7900XTX"));
            tv_nvidia.setText(String.valueOf("Geforce 4070TI"));
            tv_fonte.setText(String.valueOf("Fonte de 800 Watts "));
        }

        tv_nivel.setText(String.valueOf(Nivel));
        tv_valor.setText(String.valueOf(Preco));
        tv_ssd.setText(String.valueOf(HD+ "GB de armazenamento interno (Preferência a tecnologia M2-NVME)"));
        tv_ram.setText(String.valueOf( RAM+ "GB de Memória RAM"));

        tv_maior.setText(String.valueOf(Maior));

        String Label1 = ("Processador AMD " + tv_amd.getText().toString());
        String Label2 = ("Processador Intel " + tv_intel.getText().toString());
        String Label3 = ("Placa mãe " + tv_amdpm.getText().toString());
        String Label4 = ("Placa mãe " + tv_intelpm.getText().toString());
        String Label5 = ("SSD de " + tv_ssd.getText().toString());
        String Label6 = tv_ram.getText().toString();
        String Label7 = ("Placa de vídeo " + tv_radeon.getText().toString());
        String Label8 = ("Placa de vídeo " +tv_nvidia.getText().toString());
        String Label9 = ("Fonte de "+ tv_fonte.getText().toString());

        btvoltar.setOnClickListener(view -> Voltar());
        bt_terminar.setOnClickListener(view -> Terminar());

        bt_item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Itens item = new Itens(username, Label1);

                long resultado = dataManager.inserirItem(item);
                if(resultado != -1){
                    Toast.makeText(Resultados.this, "Item inserido na lista de compras!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Resultados.this, "Registro inválido. Tente novamente!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt_item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Itens item = new Itens(username, Label2);

                long resultado = dataManager.inserirItem(item);
                if(resultado != -1){
                    Toast.makeText(Resultados.this, "Item inserido na lista de compras!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Resultados.this, "Registro inválido. Tente novamente!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt_item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Itens item = new Itens(username, Label3);

                long resultado = dataManager.inserirItem(item);
                if(resultado != -1){
                    Toast.makeText(Resultados.this, "Item inserido na lista de compras!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Resultados.this, "Registro inválido. Tente novamente!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt_item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Itens item = new Itens(username, Label4);

                long resultado = dataManager.inserirItem(item);
                if(resultado != -1){
                    Toast.makeText(Resultados.this, "Item inserido na lista de compras!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Resultados.this, "Registro inválido. Tente novamente!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt_item5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Itens item = new Itens(username, Label5);

                long resultado = dataManager.inserirItem(item);
                if(resultado != -1){
                    Toast.makeText(Resultados.this, "Item inserido na lista de compras!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Resultados.this, "Registro inválido. Tente novamente!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt_item6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Itens item = new Itens(username, Label6);

                long resultado = dataManager.inserirItem(item);
                if(resultado != -1){
                    Toast.makeText(Resultados.this, "Item inserido na lista de compras!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Resultados.this, "Registro inválido. Tente novamente!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt_item7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Itens item = new Itens(username, Label7);

                long resultado = dataManager.inserirItem(item);
                if(resultado != -1){
                    Toast.makeText(Resultados.this, "Item inserido na lista de compras!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Resultados.this, "Registro inválido. Tente novamente!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt_item8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Itens item = new Itens(username, Label8);

                long resultado = dataManager.inserirItem(item);
                if(resultado != -1){
                    Toast.makeText(Resultados.this, "Item inserido na lista de compras!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Resultados.this, "Registro inválido. Tente novamente!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt_item9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Itens item = new Itens(username, Label9);

                long resultado = dataManager.inserirItem(item);
                if(resultado != -1){
                    Toast.makeText(Resultados.this, "Item inserido na lista de compras!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Resultados.this, "Registro inválido. Tente novamente!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void Voltar(){
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        Intent voltar = new Intent(this, Valores.class);
        voltar.putExtra("Nivel", Nivel);
        voltar.putExtra("Processador", Processador);
        voltar.putExtra("HD", HD);
        voltar.putExtra("RAM", RAM);
        voltar.putExtra("Video", Video);
        voltar.putExtra("Valor", Preco);
        voltar.putExtra("username", username);
        startActivity (voltar);
    }
    public void Terminar(){
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        Intent terminar = new Intent(this, Home.class);
        terminar.putExtra("username", username);
        startActivity (terminar);
    }
}