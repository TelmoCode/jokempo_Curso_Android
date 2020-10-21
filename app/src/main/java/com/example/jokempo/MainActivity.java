package com.example.jokempo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pedraSelecionada(View view) {

        this.opcaoSelecionada("Pedra");
    }

    public void papelSelecionada(View view) {

        this.opcaoSelecionada("Papel");
    }

    public void tesouraSelecionada(View view) {

        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario) {

        int n1 = new Random().nextInt(3);
        ImageView imagemResultado = findViewById(R.id.img_resultado);
        TextView lbl_escolhaUsuario = findViewById(R.id.lbl_escolhaUsuario);
        String[] opcao = {"Pedra", "Papel", "Tesoura"};
        String escolhaApp = opcao[n1];
        switch (escolhaApp) {
            case "Pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        if (
                (escolhaApp == "Pedra" && escolhaUsuario == "Tesoura") ||
                (escolhaApp == "Papel" && escolhaUsuario == "Pedra") ||
                (escolhaApp == "Tesoura" && escolhaUsuario == "Papel")
        ) {
            lbl_escolhaUsuario.setText("Você Perdeu");

        } else if (
                (escolhaUsuario == "Pedra" && escolhaApp == "Tesoura") ||
                (escolhaUsuario == "Papel" && escolhaApp == "Pedra") ||
                (escolhaUsuario == "Tesoura" && escolhaApp == "Papel")
        ) {
            lbl_escolhaUsuario.setText("Você Ganhou");


        } else {

            lbl_escolhaUsuario.setText("Deu Empate");


        }

    }
}