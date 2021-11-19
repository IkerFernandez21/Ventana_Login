package com.iker.prueba3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;

/*
*   @author IkerFernandez21
*   Prueba en clase de una ventana de login
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button botonregistrar = findViewById(R.id.button3);
        Button botonlogin = findViewById(R.id.boton1);
        Button botonfoto = findViewById(R.id.button4);
        botonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        botonregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, MainActivityRegistrar.class);


                startActivity(intent1);
            }
        });
        botonfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, MainFotoAleatoria.class);

                startActivity(intent2);
            }
        });

    }



}