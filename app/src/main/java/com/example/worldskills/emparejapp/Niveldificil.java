package com.example.worldskills.emparejapp;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

import java.util.ArrayList;

public class Niveldificil extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveldificil);
    }
}
