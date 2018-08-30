package com.example.worldskills.emparejapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Niveldedificultad extends AppCompatActivity {

    //niveles de dificultad
    RadioButton facil,medio,dificil;
    String a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveldedificultad);
        facil  = findViewById(R.id.radioButtonfacil);
        medio = findViewById(R.id.radioButtonmedio);
        dificil = findViewById(R.id.radioButtondificil);
        //marca el primer radiobutton
        facil.setChecked(true);
        a = getIntent().getExtras().getString("reenvio");
        b = getIntent().getExtras().getString("reenvio2");
    }



    //actividad del boton
    public void Jugar(View view) {
        //opciones de Niveles
        if (facil.isChecked()) {
            Intent intent = new Intent(this,Nivelfacil.class);
            intent.putExtra("reenviojuego", a);
            intent.putExtra("reenviojuego2", b);
            startActivity(intent);
        }
        if (medio.isChecked()) {
            Intent intent = new Intent(this,Nivelmedio.class);
            intent.putExtra("reenviojuego", a);
            intent.putExtra("reenviojuego2", b);
            startActivity(intent);
        }
        if (dificil.isChecked()) {
            Intent intent = new Intent(this,Niveldificil.class);
            intent.putExtra("reenviojuego", a);
            intent.putExtra("reenviojuego2", b);
            startActivity(intent);
        }
    }
}
