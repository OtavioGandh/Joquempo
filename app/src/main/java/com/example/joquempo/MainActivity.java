package com.example.joquempo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    public void selecionarPedra(View view){

        verificarGanhador("Pedra");
    }
    public void selecionarPapel(View view){

        verificarGanhador("Papel");
    }
    public void selecionarTesoura(View view){

        verificarGanhador("Tesoura");
    }

    private void verificarGanhador(String escolhaUsuario){

        String escolhaApp = gerarEscolhaAleatoriaApp();

        TextView textoResultado = findViewById(R.id.text_resultado);

        if(
                (escolhaApp == "Pedra" && escolhaUsuario == "Tesoura") ||
                (escolhaApp == "Papel" && escolhaUsuario == "Pedra") ||
                (escolhaApp == "Tesoura" && escolhaUsuario == "Papel")
         ){
                textoResultado.setText("Você Perdeu!!!");
        } else if (
                (escolhaUsuario=="Pedra" && escolhaApp == "Tesoura") ||
                (escolhaUsuario=="Papel" && escolhaApp == "Pedra") ||
                (escolhaUsuario=="Tesoura" && escolhaApp == "Papel")
        ) {
            textoResultado.setText("Você Ganhou!!!");
        }else {
            textoResultado.setText("Empate!!");
        }
    }

    private String gerarEscolhaAleatoriaApp() {

        int numeroAleatorio = new Random().nextInt(3);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};

        String escolhaApp = opcoes [numeroAleatorio];
        ImageView imagemApp = findViewById(R.id.image_app);

        switch (escolhaApp){
            case "Pedra":
                imagemApp.setImageResource(R.drawable.pedra);
                break;

            case "Papel":
                imagemApp.setImageResource(R.drawable.papel);
                break;

            case "Tesoura":
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        }
        return escolhaApp;

    }

}