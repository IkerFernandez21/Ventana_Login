package com.iker.prueba3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;

public class MainBab extends AppCompatActivity {
    BottomAppBar botonappbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bab);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        botonappbar = findViewById(R.id.botton_app_bar);
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainBab.this, "Has pulsado el boton FAB", Toast.LENGTH_SHORT).show();
            }
        });

        botonappbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainBab.this,"Menu clickado",Toast.LENGTH_SHORT).show();
            }
        });
        botonappbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.heart:
                        Toast.makeText(MainBab.this, "Has pulsado el corazon", Toast.LENGTH_SHORT).show();break;
                    case R.id.searh:
                        Toast.makeText(MainBab.this, "Has pulsado el mundo", Toast.LENGTH_SHORT).show();break;

                }
                return false;
            }
        });
    }
}