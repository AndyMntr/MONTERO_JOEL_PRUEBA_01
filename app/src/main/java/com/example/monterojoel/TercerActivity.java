package com.example.monterojoel;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TercerActivity extends AppCompatActivity {

    EditText editTextNombres, editTextApellidos, editTextDividendo , editTextDivisor, editTextNumero;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer);
        editTextNombres = findViewById(R.id.editTextTextMostrarNombresTercer);
        editTextApellidos = findViewById(R.id.editTextTextApellidosTercer);
        editTextDividendo= findViewById(R.id.editTextTextDividendoTercer);
        editTextDivisor= findViewById(R.id.editTextTextDivisorTercer);
        editTextNumero =  findViewById(R.id.editTextTextNumero);
    }


    public void cerrar (View view){
        String nombres = editTextNombres.getText().toString();
        String apellidos = editTextApellidos.getText().toString();
        String dividendo = editTextDividendo.getText().toString();
        String divisor = editTextDivisor.getText().toString();
        String numero = editTextNumero.getText().toString();

        String[] lstDatos = new String[5];
        lstDatos[0]= nombres;
        lstDatos[1]=apellidos;
        lstDatos[2]= dividendo;
        lstDatos[3]=divisor;
        lstDatos[4]=numero;

        Intent intent = new Intent();
        intent.putExtra("lstDatos",lstDatos);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }





}