package com.example.operacionesconelcontrolspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Spinner spinner1;
    public EditText et1, et2;
    public TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.txt_valor1);
        et2 = (EditText) findViewById(R.id.txt_valor2);
        tv1 = (TextView) findViewById(R.id.tx_resultado);
        spinner1 = (Spinner) findViewById(R.id.spinner);

        String [] opciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};

        //Sin modificar El control Spinner
        //ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);

        //Modificando El control Spinner
        //spinner_item_formato: Fue creado para el diseño para el spinner
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_formato, opciones);


        spinner1.setAdapter(adapter);
    }

    //Metodo del boton
    public void calcular(View view) {
        String et1_String = et1.getText().toString();
        String et2_String = et2.getText().toString();

        double valor1_double = Double.parseDouble(et1_String);
        double valor2_double = Double.parseDouble(et2_String);

        String seleccion = spinner1.getSelectedItem().toString();
        if (seleccion.equals("Sumar")) {
            double suma = valor1_double + valor2_double;
            String resultado = String.valueOf(suma);
            tv1.setText(resultado);
        } else if (seleccion.equals("Restar")) {
            double resta = valor1_double - valor2_double;
            String resultado = String.valueOf(resta);
            tv1.setText(resultado);
        } else if (seleccion.equals("Multiplicar")) {
            double multiplicacion = valor1_double * valor2_double;
            String resultado = String.valueOf(multiplicacion);
            tv1.setText(resultado);
        } else if (seleccion.equals("Dividir")) {
            if (valor2_double != 0) {
                double division = valor1_double / valor2_double;
                String resultado = String.valueOf(division);
                tv1.setText(resultado);
            } else {
                Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_LONG).show();
            }
        }
    }

}