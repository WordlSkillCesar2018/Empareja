package com.example.worldskills.emparejapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Inicio extends AppCompatActivity {

    EditText et1,et2;
    SqliteOpenHelper sqliteOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        et1=findViewById(R.id.Nombre1);
        et2=findViewById(R.id.Nombre2);
    }

    public void ingresar(View view) {
        String Nombre1=et1.getText().toString();
        String Nombre2=et2.getText().toString();
        Intent intent=new Intent(this, Menu.class);
        intent.putExtra("nombre1",Nombre1);
        intent.putExtra("nombre2",Nombre2);
        startActivity(intent);
    }
}
