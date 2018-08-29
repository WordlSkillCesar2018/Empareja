package com.example.worldskills.emparejapp;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Nivelmedio extends AppCompatActivity {

    final Handler handler = new Handler();

    ArrayList<Integer> arraybarajado;

    int[] imagenes;

    ImageButton[] botonera = new ImageButton[12];

    int fondo;

    ImageButton ib0, ib1, ib2, ib3, ib4, ib5, ib6, ib7,ib8,ib9,ib10,ib11;

    ImageButton primera;

    boolean bloqueo = false;

    int primerclick, segundoclick;

    int acierto;

    MediaPlayer mediaPlayer;

    int puntos1 = 0;
    int puntos2 = 0;
    int[] turno = new int[]{1,2};
    int turn;
    TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivelmedio);
        tv1 = findViewById(R.id.textView4);
        tv2 = findViewById(R.id.textView5);
        cargarcartas();
        iniciar();
        String a,b;
        a = getIntent().getExtras().getString("reenviojuego");
        b = getIntent().getExtras().getString("reenviojuego2");
        int Ramdon = (int) Math.random()*2;
        turn = turno[Ramdon];
        if (turn==1){
            tv1.setText(a);
            tv1.setTextColor(Color.parseColor("black"));
        }else if (turn==2){
            tv2.setText(b);
            tv2.setTextColor(Color.parseColor("gray"));
        }
    }

    private void cargarcartas() {
        imagenes = new int[]{
                R.drawable.cartman,
                R.drawable.jimmy,
                R.drawable.kyle,
                R.drawable.wendy,
                R.drawable.butters,
                R.drawable.craig
        };

        fondo = R.drawable.fondo;
    }

    public ArrayList<Integer> barajar(int longitud) {
        ArrayList resultado = new ArrayList();
        for (int i = 0; i < longitud; i++) {
            resultado.add(i % longitud / 2);
            Collections.shuffle(resultado);
        }
        return resultado;
    }

    public void cargarbotones() {
        ib0 = (ImageButton) findViewById(R.id.im1);
        botonera[0] = ib0;
        ib1 = (ImageButton) findViewById(R.id.im2);
        botonera[1] = ib1;
        ib2 = (ImageButton) findViewById(R.id.im3);
        botonera[2] = ib2;
        ib3 = (ImageButton) findViewById(R.id.im4);
        botonera[3] = ib3;
        ib4 = (ImageButton) findViewById(R.id.im5);
        botonera[4] = ib4;
        ib5 = (ImageButton) findViewById(R.id.im6);
        botonera[5] = ib5;
        ib6 = (ImageButton) findViewById(R.id.im7);
        botonera[6] = ib6;
        ib7 = (ImageButton) findViewById(R.id.im8);
        botonera[7] = ib7;
        ib8 = (ImageButton) findViewById(R.id.im9);
        botonera[8] = ib8;
        ib9 = (ImageButton) findViewById(R.id.im10);
        botonera[9] = ib9;
        ib10 = (ImageButton) findViewById(R.id.im11);
        botonera[10] = ib10;
        ib11 = (ImageButton) findViewById(R.id.im12);
        botonera[11] = ib11;

    }

    public void confirmar(int i, final ImageButton imb) {
        if (primera == null) {
            primera = imb;
            primera.setScaleType(ImageButton.ScaleType.CENTER_CROP);
            primera.setImageResource(imagenes[arraybarajado.get(i)]);
            primera.setEnabled(false);
            primerclick = arraybarajado.get(i);
        } else {
            imb.setScaleType(ImageButton.ScaleType.CENTER_CROP);
            imb.setImageResource(imagenes[arraybarajado.get(i)]);
            imb.setEnabled(false);
            bloqueo = true;
            segundoclick = arraybarajado.get(i);
            if (primerclick == segundoclick) {
                primera = null;
                bloqueo=false;
                acierto++;
                mediaPlayer = MediaPlayer.create(this, R.raw.win1);
                mediaPlayer.start();
                if (turn==1){
                    tv1.setTextColor(Color.parseColor("black"));
                    turn=1;
                }else if (turn==2){
                    tv2.setTextColor(Color.parseColor("gray"));
                    turn=2;
                }
                if (acierto == 6) {
                    Toast.makeText(getApplicationContext(), "ganaste", Toast.LENGTH_LONG).show();
                    mediaPlayer = MediaPlayer.create(this, R.raw.end);
                    mediaPlayer.start();
                }
            } else {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        primera.setScaleType(ImageButton.ScaleType.CENTER_CROP);
                        primera.setImageResource(fondo);
                        imb.setScaleType(ImageButton.ScaleType.CENTER_CROP);
                        imb.setImageResource(fondo);
                        bloqueo = false;
                        primera.setEnabled(true);
                        imb.setEnabled(true);
                        if (turn==1){
                            tv1.setTextColor(Color.parseColor("black"));
                            turn=2;
                        }else if (turn==2){
                            tv2.setTextColor(Color.parseColor("gray"));
                            turn=1;
                        }
                    }
                }, 1000);
                mediaPlayer = MediaPlayer.create(this, R.raw.lose1);
                mediaPlayer.start();
            }
        }
    }


    public void iniciar(){
        arraybarajado = barajar(imagenes.length*2);
        cargarbotones();

        for (int i=0;i<botonera.length;i++){
            botonera[i].setScaleType(ImageButton.ScaleType.CENTER_CROP);
            botonera[i].setImageResource(imagenes[arraybarajado.get(i)]);
        }

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<botonera.length;i++){
                    botonera[i].setScaleType(ImageButton.ScaleType.CENTER_CROP);
                    botonera[i].setImageResource(fondo);
                }
            }
        },1000);

        for (int i=0; i<arraybarajado.size();i++){
            final int j = i;
            botonera[i].setEnabled(true);
            botonera[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!bloqueo){
                        confirmar(j,botonera[j]);
                    }
                }
            });

        }
    }
}
