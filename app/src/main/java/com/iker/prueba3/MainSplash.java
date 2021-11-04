package com.iker.prueba3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainSplash extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_splash);
        View decoracion = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decoracion.setSystemUiVisibility(uiOptions);
        ImageView img =(ImageView) findViewById(R.id.imageView3);
        ImageView img2= (ImageView) findViewById(R.id.imageView4);
        TextView tx1 = (TextView) findViewById(R.id.textView);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.fadein);
        Animation myanim2 = AnimationUtils.loadAnimation(this,R.anim.logoanim);
        img.startAnimation(myanim);
        img2.startAnimation(myanim2);
        tx1.startAnimation(myanim2);


        openApp(true);
    }

    private void openApp(boolean LocationPermision) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent1 = new Intent(MainSplash.this, MainActivity.class);
                startActivity(intent1);
            }
        },4000);
    }

}