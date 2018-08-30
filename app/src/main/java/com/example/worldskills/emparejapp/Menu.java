package com.example.worldskills.emparejapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Menu extends AppCompatActivity {


    RadioButton iniciarjuego,verpuntajes,configuracion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        iniciarjuego  = findViewById(R.id.radioButton);
        verpuntajes = findViewById(R.id.radioButton2);
        configuracion = findViewById(R.id.radioButton3);
        iniciarjuego.setChecked(true);


    }
    //boton siguiente
    public void Siguente(View view) {
        if (iniciarjuego.isChecked()){
            String a,b;
            a = getIntent().getExtras().getString("nombre1");
            b = getIntent().getExtras().getString("nombre2");
            Intent intent = new Intent(this, Niveldedificultad.class);
            intent.putExtra("reenvio",a);
            intent.putExtra("reenvio2",b);
            startActivity(intent);
        }
        if (verpuntajes.isChecked()){
            //Intent intent = new Intent(this, Verpuntajes.class);
            //startActivity(intent);
        }
        if (configuracion.isChecked()){
            //Intent intent = new Intent(this,Configuracion.class);
            //startActivity(intent);
        }
    }
}
