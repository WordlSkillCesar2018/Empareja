package com.example.worldskills.emparejapp;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class Nivelfacil extends AppCompatActivity {

    Handler handler = new Handler();

    ArrayList<Integer> arraybarajado;

    int[] imagenes;

    ImageButton[] botonera = new ImageButton[8];

    int fondo;

    ImageButton ib0, ib1, ib2, ib3, ib4, ib5, ib6, ib7;

    ImageButton primera;

    boolean bloqueo = false;

    int primerclick,segundoclick;

    int acierto;

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivelfacil);

        cargarcartas();
        iniciar();
    }

    private void cargarcartas() {
        imagenes = new int[]{
                R.drawable.cartman,
                R.drawable.jimmy,
                R.drawable.kyle,
                R.drawable.wendy,
        };

        fondo = R.drawable.fondo;
    }

    public ArrayList<Integer> barajar(int longitud) {
        ArrayList resultado = new ArrayList();
        for (int i=0; i<longitud;i++ ){
            resultado.add(i % longitud/2);
            Collections.shuffle(resultado);
        }
        return resultado;
    }

    public void cargarbotones(){
        ib0 = (ImageButton)findViewById(R.id.im1);
        botonera[0]= ib0;
        ib1 = (ImageButton)findViewById(R.id.im2);
        botonera[1]= ib1;
        ib2 = (ImageButton)findViewById(R.id.im3);
        botonera[2]= ib2;
        ib3 = (ImageButton)findViewById(R.id.im4);
        botonera[3]= ib3;
        ib4 = (ImageButton)findViewById(R.id.im5);
        botonera[4]= ib4;
        ib5 = (ImageButton)findViewById(R.id.im6);
        botonera[5]= ib5;
        ib6 = (ImageButton)findViewById(R.id.im7);
        botonera[6]= ib6;
        ib7 = (ImageButton)findViewById(R.id.im8);
        botonera[7]= ib7;

    }

    public void confirmar (int i, final ImageButton imb){
        if (primera==null){
            primera=imb;
            primera.setScaleType(ImageButton.ScaleType.CENTER_CROP);
            primera.setImageResource(imagenes[arraybarajado.get(i)]);
            primera.setEnabled(false);
            primerclick = arraybarajado.get(i);
        }else {
            imb.setScaleType(ImageButton.ScaleType.CENTER_CROP);
            imb.setImageResource(imagenes[arraybarajado.get(i)]);
            imb.setEnabled(false);
            bloqueo = true;
            segundoclick = arraybarajado.get(i);
            if (primerclick == segundoclick) {
                primera = null;
                bloqueo = false;
                acierto++;
                Toast.makeText(getApplicationContext(),"bien",Toast.LENGTH_LONG).show();
                if (acierto == 5) {
                    Toast.makeText(getApplicationContext(),"bien",Toast.LENGTH_LONG).show();
                    /*mediaPlayer= new MediaPlayer();
                    MediaPlayer.create(this,R.raw.win1);
                    mediaPlayer.prepare(MediaPlayer);*/
                }
            } else {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        primera.setScaleType(ImageButton.ScaleType.CENTER_CROP);
                        primera.setImageResource(R.drawable.fondo);
                        imb.setScaleType(ImageButton.ScaleType.CENTER_CROP);
                        imb.setImageResource(R.drawable.fondo);
                        bloqueo=false;
                        primera.setEnabled(true);
                    }
                }, 1000);
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
