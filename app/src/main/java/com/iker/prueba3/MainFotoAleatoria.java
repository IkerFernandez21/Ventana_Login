package com.iker.prueba3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainFotoAleatoria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_foto_aleatoria);
        TextView tv1 = findViewById(R.id.tvtab);
        registerForContextMenu(tv1);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_context,menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final ConstraintLayout myLayout = findViewById(R.id.mymainconstraint);
        switch (item.getItemId()){
            case R.id.item1:


                Snackbar sn1 = Snackbar
                        .make(myLayout,"Copiado!",Snackbar.LENGTH_LONG)
                        .setAction("DESHACER", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar sn1 = Snackbar.make(myLayout,"Accion restaurada", Snackbar.LENGTH_LONG);
                                sn1.show();
                            }
                        });
                sn1.show();


                return true;
            case R.id.item2:

                Snackbar sn2 = Snackbar
                        .make(myLayout,"Descargando...",Snackbar.LENGTH_LONG)
                        .setAction("DESHACER", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar sn22 = Snackbar.make(myLayout,"Accion restaurada", Snackbar.LENGTH_LONG);
                                sn22.show();
                            }
                        });
                sn2.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbarmenu_context, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }
        if (id == R.id.camera) {
            Toast toast = Toast.makeText(this,"going APPBAR CAMERA",Toast.LENGTH_LONG );
            toast.show();
        }
        return super.onOptionsItemSelected(item);
    }
}