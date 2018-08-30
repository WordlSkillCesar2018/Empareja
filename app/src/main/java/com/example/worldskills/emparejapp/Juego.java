package com.example.wacho.coloritoapp;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Juego extends AppCompatActivity {
    String[] color = {"Amarillo", "Azul", "Rojo"};
    TextView colorr, crono, acierto, backk, desaciertos;
    int random = (int) (Math.random() * 3);
    int clik = 0;
    String[] colortexto = {"red", "blue", "yellow"};//{"#FF3333", "#3333FF", "#F6FF33"};//rojo, azul, amarillo
    int clik2 = 0;
    Button aaa, bbb, ccc;
    CountDownTimer countDownTimer,ct;

    @SuppressLint({"SetTextI18n", "ResourceAsColor", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        crono = findViewById(R.id.cronometro);
        backk = findViewById(R.id.back);
        colorr = findViewById(R.id.colores);
        colorr.setText(color[random]);
        colorr.setTextColor(Color.parseColor(colortexto[random]));
        acierto = findViewById(R.id.aciertos);
        desaciertos = findViewById(R.id.Desaciertos);
        String intento = getIntent().getExtras().getString("intento");
        if ("intento".equals(intento)) {
            crono.setVisibility(View.INVISIBLE);
        }else{
            duracion();
        }
        aaa = findViewById(R.id.button2);
        bbb = findViewById(R.id.button4);
        ccc = findViewById(R.id.button3);
        acierto.setText("Aciertos: " + clik);
        String a = String.valueOf(clik2);
        desaciertos.setText(a);
        backk.setText(colortexto[random]);
        duracion2();
    }


    @SuppressLint("SetTextI18n")
    public void amarillo(View view) {
        int rand = (int) (Math.random() * 3);
        int rando = (int) (Math.random() * 3);
        if ("yellow".equals(backk.getText())) {
            colorr.setText(color[rand]);
            colorr.setTextColor(Color.parseColor(colortexto[rando]));
            backk.setText(colortexto[rando]);
            clik++;
            acierto.setText("Aciertos: " + clik);
        } else {
            if (clik2 < 2) {
                clik2++;
                String a = String.valueOf(clik2);
                desaciertos.setText(a);
            } else {
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
                Intent intent = new Intent(Juego.this, Main2Activity.class);
                intent.putExtra("puntos", clik);
                intent.putExtra("desaciertos", clik2);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }
        int Ram = (int) (Math.random() * 3);
        if (Ram == 1) {
            azul();
        } else if (Ram == 2) {
            rojo();
        } else if (Ram == 3) {
            amarillo();
        }

        if (ct!=null) {
            ct.cancel();
            duracion2();
        }
    }

    @SuppressLint("SetTextI18n")
    public void rojo(View view) {
        int rand = (int) (Math.random() * 3);
        int rando = (int) (Math.random() * 3);
        if ("red".equals(backk.getText())) {
            colorr.setText(color[rand]);
            colorr.setTextColor(Color.parseColor(colortexto[rando]));
            backk.setText(colortexto[rando]);
            clik++;
            acierto.setText("Aciertos: " + clik);
        } else {
                if (clik2 < 2) {
                    clik2++;
                    String a = String.valueOf(clik2);
                    desaciertos.setText(a);
                } else {
                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                    }
                    Intent intent = new Intent(Juego.this, Main2Activity.class);
                    intent.putExtra("puntos", clik);
                    intent.putExtra("desaciertos", clik2);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
        }

        int Ram = (int) (Math.random() * 3);
        if (Ram == 1) {
            azul();
        } else if (Ram == 2) {
            rojo();
        } else if (Ram == 3) {
            amarillo();
        }

        if (ct!=null) {
            ct.cancel();
            duracion2();
        }
    }

    @SuppressLint("SetTextI18n")
    public void azul(View view) {
        int rand = (int) (Math.random() * 3);
        int rando = (int) (Math.random() * 3);
        if ("blue".equals(backk.getText())) {
            colorr.setText(color[rand]);
            colorr.setTextColor(Color.parseColor(colortexto[rando]));
            backk.setText(colortexto[rando]);
            clik++;
            acierto.setText("Aciertos: " + clik);
        } else {
            if (clik2 < 2) {
                clik2++;
                String a = String.valueOf(clik2);
                desaciertos.setText(a);
            } else {
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
                Intent intent = new Intent(Juego.this, Main2Activity.class);
                intent.putExtra("puntos", clik);
                intent.putExtra("desaciertos", clik2);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }
        int Ram = (int) (Math.random() * 3);
        if (Ram == 1) {
            azul();
        } else if (Ram == 2) {
            rojo();
        } else if (Ram == 3) {
            amarillo();
        }

        if (ct!=null) {
            ct.cancel();
            duracion2();
        }
    }

    public void azul() {
        float a = (float) 539.500;
        float b = (float) 324.000;
        float c = (float) 24.000;
        float d = (float) 171.500;
        aaa.setY(a);
        aaa.setX(d);
        bbb.setY(a);
        bbb.setX(b);
        ccc.setY(a);
        ccc.setX(c);
    }

    public void rojo() {
        float a = (float) 539.500;
        float b = (float) 315.000;
        float c = (float) 24.000;
        float d = (float) 171.500;
        aaa.setY(a);
        aaa.setX(b);
        bbb.setY(a);
        bbb.setX(c);
        ccc.setY(a);
        ccc.setX(d);
    }

    public void amarillo() {
        float a = (float) 539.500;
        float b = (float) 171.500;
        float c = (float) 24.000;
        float d = (float) 324.000;
        aaa.setY(a);
        aaa.setX(b);
        bbb.setY(a);
        bbb.setX(c);
        ccc.setY(a);
        ccc.setX(d);
    }


    public void duracion() {
        String a1 = getIntent().getExtras().getString("time");
        if ("uno".equals(a1)) {
            countDownTimer=new CountDownTimer(60000, 10) {
                public void onTick(long millisUntilFinished) {
                    crono.setText(getIntent().getExtras().getInt("fallas"));
                }

                public void onFinish() {
                    String a1 = desaciertos.getText().toString();
                    int a = Integer.parseInt(a1);
                    if (a != 2) {
                        if (countDownTimer!=null) {
                            countDownTimer.cancel();
                        }                        Intent intent = new Intent(Juego.this, Main2Activity.class);
                        intent.putExtra("puntos", clik);
                        intent.putExtra("desaciertos", clik2);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    } else {
                        if (countDownTimer!=null) {
                            countDownTimer.cancel();
                        }
                    }
                }
            }.start();
        }

        if ("dos".equals(a1)) {
            countDownTimer=new CountDownTimer(120000, 10) {
                public void onTick(long millisUntilFinished) {
                    crono.setText("" + millisUntilFinished / 10);
                }

                public void onFinish() {
                    String a1 = desaciertos.getText().toString();
                    int a = Integer.parseInt(a1);
                    if (a != 2) {
                        if (countDownTimer!=null) {
                            countDownTimer.cancel();
                        }
                        Intent intent = new Intent(Juego.this, Main2Activity.class);
                        intent.putExtra("puntos", clik);
                        intent.putExtra("desaciertos", clik2);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    } else {
                        if (countDownTimer!=null) {
                            countDownTimer.cancel();
                        }
                    }
                }
            }.start();
        }

        if ("tres".equals(a1)) {
            crono.setVisibility(View.INVISIBLE);
        }

        if (!"uno".equals(a1) && !"dos".equals(a1) && !"tres".equals(a1)){
            countDownTimer=new CountDownTimer(30000, 10) {
                public void onTick(long millisUntilFinished) {
                    crono.setText("" + millisUntilFinished / 10);
                }

                public void onFinish() {
                    String a1 = desaciertos.getText().toString();
                    int a = Integer.parseInt(a1);
                    if (a != 2) {
                        if (countDownTimer!=null) {
                            countDownTimer.cancel();
                        }
                        Intent intent = new Intent(Juego.this, Main2Activity.class);
                        intent.putExtra("puntos", clik);
                        intent.putExtra("desaciertos", clik2);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    } else {
                        if (countDownTimer!=null) {
                        countDownTimer.cancel();
                        }
                    }
                }
            }.start();
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if (countDownTimer!=null) {
                countDownTimer.cancel();
                ct.cancel();
            }
            Intent intent = new Intent(this, Main3Activity.class);
            startActivity(intent);
            finish();
        }
        return false;
    }

    public void duracion2() {
            ct = new CountDownTimer(3000, 10) {
                public void onTick(long millisUntilFinished) {

                }

                public void onFinish() {
                    String a1 = desaciertos.getText().toString();
                    int a = Integer.parseInt(a1);
                    if (a != 2) {
                        int rand = (int) (Math.random() * 3);
                        int rando = (int) (Math.random() * 3);
                        colorr.setText(color[rand]);
                        colorr.setTextColor(Color.parseColor(colortexto[rando]));
                        backk.setText(colortexto[rando]);
                        clik2++;
                        String a2 = String.valueOf(clik2);
                        desaciertos.setText(a2);
                        duracion2();
                    }else{
                        if (ct!=null) {
                            ct.cancel();
                            Intent intent = new Intent(Juego.this, Main2Activity.class);
                            intent.putExtra("puntos", clik);
                            intent.putExtra("desaciertos", clik2);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    }

                    int Ram = (int) (Math.random() * 3);
                    if (Ram == 1) {
                        azul();
                    } else if (Ram == 2) {
                        rojo();
                    } else if (Ram == 3) {
                        amarillo();
                    }
                }
            }.start();
        }
    }
