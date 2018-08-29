package com.example.worldskills.emparejapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Niveldedificultad extends AppCompatActivity {

    RadioButton facil,medio,dificil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveldedificultad);
        facil  = findViewById(R.id.radioButtonfacil);
        medio = findViewById(R.id.radioButtonmedio);
        dificil = findViewById(R.id.radioButtondificil);
        facil.setChecked(true);
    }

    public void Jugar(View view) {
        if (facil.isChecked()) {
            String a, b;
            a = getIntent().getExtras().getString("nombre1");
            b = getIntent().getExtras().getString("nombre2");
            Intent intent = new Intent(this,Nivelfacil.class);
            intent.putExtra("reenviojuego", a);
            intent.putExtra("reenviojuego2", b);
            startActivity(intent);
        }
    }
}
