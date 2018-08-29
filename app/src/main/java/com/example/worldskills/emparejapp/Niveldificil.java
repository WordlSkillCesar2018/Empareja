package com.example.worldskills.emparejapp;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class Niveldificil extends AppCompatActivity {

    final Handler handler = new Handler();

    ArrayList<Integer> arraybarajado;

    int[] imagenes;

    ImageButton[] botonera = new ImageButton[16];

    int fondo;

    ImageButton ib0, ib1, ib2, ib3, ib4, ib5, ib6, ib7,ib8,ib9,ib10,ib11,ib12,ib13,ib14,ib15;

    ImageButton primera;

    boolean bloqueo = false;

    int primerclick, segundoclick;

    int acierto=0;

    MediaPlayer mediaPlayer;

    int puntos1 = 0;
    int puntos2 = 0;
    int[] turno = new int[]{1,2};
    int turn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveldificil);
        cargarcartas();
        iniciar();
    }

    private void cargarcartas() {
        imagenes = new int[]{
                R.drawable.cartman,
                R.drawable.jimmy,
                R.drawable.kyle,
                R.drawable.wendy,
                R.drawable.butters,
                R.drawable.craig,
                R.drawable.kenny,
                R.drawable.stan
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
        ib12 = (ImageButton) findViewById(R.id.im13);
        botonera[12] = ib12;
        ib13 = (ImageButton) findViewById(R.id.im14);
        botonera[13] = ib13;
        ib14 = (ImageButton) findViewById(R.id.im15);
        botonera[14] = ib14;
        ib15 = (ImageButton) findViewById(R.id.im16);
        botonera[15] = ib15;

    }
//verificacion de coincidencia
    public void confirmar(int i, final ImageButton imb) {
        if (primera == null) {//se prueba si la no se ha clikeado
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
            if (primerclick == segundoclick) {//si coinsiden las dos cartas
                primera = null;
                bloqueo = false;
                acierto++;
                mediaPlayer = MediaPlayer.create(this, R.raw.win1);
                mediaPlayer.start();
                if (acierto == 8) {
                    Toast.makeText(getApplicationContext(), "ganaste", Toast.LENGTH_LONG).show();
                    mediaPlayer = MediaPlayer.create(this, R.raw.win1);
                    mediaPlayer.start();
                }
            } else {//si no coinciden las dos cartas vuelven a taparse
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        primera.setScaleType(ImageButton.ScaleType.CENTER_CROP);
                        primera.setImageResource(fondo);
                        imb.setScaleType(ImageButton.ScaleType.CENTER_CROP);
                        imb.setImageResource(fondo);
                        primera.setEnabled(true);
                        imb.setEnabled(true);
                        bloqueo = false;
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.lose1);
                        mediaPlayer.start();
                    }
                }, 1000);
            }
        }
    }


    public void iniciar() {
        arraybarajado = barajar(imagenes.length * 2);
        cargarbotones();

        for (int i = 0; i < botonera.length; i++) {
            botonera[i].setScaleType(ImageButton.ScaleType.CENTER_CROP);
            botonera[i].setImageResource(imagenes[arraybarajado.get(i)]);
        }

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < botonera.length; i++) {
                    botonera[i].setScaleType(ImageButton.ScaleType.CENTER_CROP);
                    botonera[i].setImageResource(fondo);
                }
            }
        }, 1000);

        for (int i = 0; i < arraybarajado.size(); i++) {
            final int j = i;
            botonera[i].setEnabled(true);
            botonera[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!bloqueo) {
                        confirmar(j, botonera[j]);
                    }
                }
            });
        }

    }
}
