package com.iker.prueba3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainFotoAleatoria extends AppCompatActivity {
    private ImageView imagen1;
    ActivityResultLauncher<String> ar;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private SwipeRefreshLayout swipeLayout;
    private WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_foto_aleatoria);
        TextView tv1 = findViewById(R.id.tvtab);
        wv1 = findViewById(R.id.webvi);
        //imagen1=findViewById(R.id.imageView);
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);
        registerForContextMenu(tv1);
        wv1.getSettings().setBuiltInZoomControls(true);
        WebSettings ws = wv1.getSettings();
        ws.setJavaScriptEnabled(true);


        wv1.loadUrl("https://thispersondoesnotexist.com/");



    }

    protected SwipeRefreshLayout.OnRefreshListener
                mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            /*Toast toast0 = Toast.makeText(MainFotoAleatoria.this,"Hola , es un texto de ejemplo al hacer swipe",Toast.LENGTH_LONG);
            toast0.show();*/
            wv1.reload();
            swipeLayout.setRefreshing(false);
        }
    };


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
            Toast toast = Toast.makeText(this,"Abriendo la camara",Toast.LENGTH_LONG );
            toast.show();

            /*Intent capturaFoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(capturaFoto,0);
            */



        }
        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == requestCode && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            //imagen1.setImageBitmap(imageBitmap);
        }
    }

}