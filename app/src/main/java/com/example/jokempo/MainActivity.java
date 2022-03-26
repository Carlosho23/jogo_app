package com.example.jokempo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView jogador1;
    ImageView jogador2;

    ImageButton btnPedra;
    ImageButton btnPapel;
    ImageButton btnTesoura;

    Animation some;
    Animation aparece;

    int jogada1 = 0;
    int jogada2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jogador1 = findViewById(R.id.jogador_1);
        jogador2 = findViewById(R.id.jogador_2);
        btnPapel = findViewById(R.id.btn_papel);
        btnPedra = findViewById(R.id.btn_pedra);
        btnTesoura = findViewById(R.id.btn_tesoura);

        some = new AlphaAnimation(1,0);
        aparece = new AlphaAnimation(0,1);

        some.setDuration(1500);
        aparece.setDuration(500);

        some.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                jogador2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                jogador2.setVisibility(View.INVISIBLE);
                jogador2.startAnimation(aparece);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        aparece.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                sorteiaInimigo();
                jogador2.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                verificaJogada();
                jogador2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
    public void tocouBotao(View view){

        jogador1.setScaleX(-1);
        switch (view.getId()) {
            case(R.id.btn_pedra):jogador1.setImageResource(R.drawable.pedra);
            jogada1 = 1;
            break;
            case(R.id.btn_papel):jogador1.setImageResource(R.drawable.papel);
            jogada1 = 2;
            break;
            case(R.id.btn_tesoura):jogador1.setImageResource(R.drawable.tesoura);
            jogada1 = 3;
            break;
        }
        jogador2.setImageResource(R.drawable.interrogacao);
    }
    public void sorteiaInimigo(){
        Random r = new Random();
        int numRandom = r.nextInt(3);
        switch (numRandom){
            case 0:jogador2.setImageResource(R.drawable.pedra);
            jogada2 = 1;
            break;
            case 1:jogador2.setImageResource(R.drawable.papel);
            jogada2 = 2;
            break;
            case 2:jogador2.setImageResource(R.drawable.tesoura);
            jogada2 = 3;
            break;
        }
    }

    public void verificaJogada(){
        if(jogada1 == jogada2){
            Toast.makeText(this, "Empate!", Toast.LENGTH_SHORT).show();
        }

        if(jog)
    }

}