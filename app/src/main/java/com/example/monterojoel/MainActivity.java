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


public class MainActivity extends AppCompatActivity {

    String[] lstDatosRecibidos;
    Button buttonMostrar ;
    EditText editTextNombres, editTextApellidos, editTextDivisor, editTextDividendo, editTextEntera, editTextResiduo, editTextInvertido;

    ActivityResultLauncher<Intent> activityResult =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if (result.getResultCode() == Activity.RESULT_OK)
                    {
                        Bundle datos = result.getData().getExtras();
                        lstDatosRecibidos = datos.getStringArray("lstDatos");

                        String nombres = lstDatosRecibidos[0].toString();
                        String apellidos = lstDatosRecibidos[1].toString();
                        String dividendo = lstDatosRecibidos[2].toString();
                        String divisor = lstDatosRecibidos[3].toString();

                        editTextNombres.setText(nombres);
                        editTextApellidos.setText(apellidos);
                        editTextDivisor.setText(divisor);
                        editTextDividendo.setText(dividendo);
                        buttonMostrar.setEnabled(true);
                    }
                }
            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonMostrar = findViewById(R.id.buttonMostrarResultados);
        editTextNombres = findViewById(R.id.editTextTextMostrarNombres);
        editTextApellidos = findViewById(R.id.editTextTextApellidos);
        editTextDividendo  = findViewById(R.id.editTextTextMostrarDividendo);
        editTextDivisor = findViewById(R.id.editTextTextDivisor);
        editTextEntera = findViewById(R.id.editTextTextEntera);
        editTextResiduo = findViewById(R.id.editTextTextMostrarResiduo);
        editTextInvertido= findViewById(R.id.editTextTextInvertido);
    }



    public  void  clicSegundoActivity (View view) {
        Intent intent = new Intent(this,SegundoActivity.class);
        activityResult.launch(intent);
    }

    public  void  mostrarDatos (View view){

        String dividendo = lstDatosRecibidos[2].toString();
        String divisor = lstDatosRecibidos[3].toString();

        int dividend=  Integer.valueOf(lstDatosRecibidos[2].toString());
        int divisr = Integer.valueOf(lstDatosRecibidos[3].toString());
        int invertid = Integer.valueOf((lstDatosRecibidos[4].toString()));


        editTextEntera.setText(String.valueOf(divisionEntera(dividend,divisr)));
        editTextResiduo.setText(String.valueOf(divisionDecimal(dividend,divisr)));
        editTextInvertido.setText(String.valueOf(invertido(invertid)));
    }

    public static double divisionDecimal( int x, int y ) {
        double res= x%y;

        return res;
    }

    public static int divisionEntera( int x, int y ) {
        double res= x%y;
        int num = (int) (x - res);
        return num;
    }

    public  static  double invertido (int numero) {
        double resto,invertido = 0;
        while( numero > 0 ) {
            resto = numero % 10;
            invertido = invertido * 10 + resto;
            numero /= 10;
        }
        return invertido;
    }



}