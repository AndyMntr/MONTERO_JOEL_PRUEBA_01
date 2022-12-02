package com.example.monterojoel;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SegundoActivity extends AppCompatActivity {

    String[] lstDatosRecibidos;
    Button buttonCerrarS ;

    ActivityResultLauncher<Intent> activityResult =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK)
                    {
                        Bundle datos = result.getData().getExtras();
                        lstDatosRecibidos = datos.getStringArray("lstDatos");
                        editTextNombres.setText(lstDatosRecibidos[0].toString());
                        editTextApellidos.setText(lstDatosRecibidos[1].toString());
                        editTextDividendo.setText(lstDatosRecibidos[2].toString());
                        editTextDivisor.setText(lstDatosRecibidos[3].toString());
                        editTextNumero.setText(lstDatosRecibidos[4].toString());
                        buttonCerrarS.setEnabled(true);
                    }
                }
            });

    EditText editTextNombres, editTextApellidos, editTextDividendo, editTextDivisor, editTextNumero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        editTextNombres = findViewById(R.id.editTextTextNombres);
        editTextApellidos = findViewById(R.id.editTextTextApellidos);
        editTextDividendo = findViewById(R.id.editTextTextDivisor);
        editTextDivisor = findViewById(R.id.editTextTextDivisor);
        editTextNumero = findViewById(R.id.editTextTextInvertido);
        buttonCerrarS = findViewById(R.id.buttonCerrarSegundo);
    }


    public  void clicTercerActivity (View view) {
        Intent intent  = new Intent(this,TercerActivity.class);
        activityResult.launch(intent);
    }

    public  void  cerrar (View view){
        Intent intent = new Intent();
        intent.putExtra("lstDatos",lstDatosRecibidos);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }



}