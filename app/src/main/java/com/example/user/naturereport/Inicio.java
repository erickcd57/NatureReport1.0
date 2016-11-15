package com.example.user.naturereport;

        import android.content.Intent;
        import android.net.Uri;
        import android.os.Environment;
        import android.provider.MediaStore;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import java.io.File;
        import java.util.UUID;


public class Inicio extends AppCompatActivity {

    Button Evidenciabtn;
    Button Salirbtn;
    Button Reportarbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Evidenciabtn = (Button) findViewById(R.id.Evidenciabtn);
        Salirbtn = (Button) findViewById(R.id.Salirbtn);
        Reportarbtn = (Button) findViewById(R.id.Reportarbtn);

        Evidenciabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = UUID.randomUUID().toString();
                Intent camaraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File carpetaFoto = new File(Environment.getExternalStorageDirectory(), "FotosEvidencia");
                carpetaFoto.mkdir();
                File foto = new File(carpetaFoto, "Evid"+nombre+".jpg");
                Uri uriGuardarFoto = Uri.fromFile(foto);
                camaraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriGuardarFoto);
                startActivityForResult(camaraIntent, 1);

            }
        });

        Salirbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent salir = new Intent(Intent.ACTION_MAIN);
                salir.addCategory(Intent.CATEGORY_HOME);
                salir.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(salir);
            }
        });

        Reportarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reportar = new Intent(Inicio.this, Formulario.class);
                startActivity(reportar);

            }
        });

    }

}
