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

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapter);
    }

    //Metodo del boton
    public void Calcular(View view){
        String et1_String = et1.getText().toString();
        String et2_String = et2.getText().toString();

        int valor1_int = Integer.parseInt(et1_String);
        int valor2_int = Integer.parseInt(et2_String);

        String seleccion = spinner1.getSelectedItem().toString();
        if(seleccion.equals("Sumar")){
            int suma = valor1_int + valor2_int;
            String Resultado =  String.valueOf(suma);
            tv1.setText(Resultado);
        }else if(seleccion.equals("Restar")){
            int Resta = valor1_int - valor2_int;
            String Resultado =  String.valueOf(Resta);
            tv1.setText(Resultado);
        }else if(seleccion.equals("Multiplicar")){
            int Multiplicacion = valor1_int * valor2_int;
            String Resultado =  String.valueOf(Multiplicacion);
            tv1.setText(Resultado);
        }else if(seleccion.equals("Dividir")){
            if(valor2_int != 0){
                int Dividision = valor1_int / valor2_int;
                String Resultado =  String.valueOf(Dividision);
                tv1.setText(Resultado);
            }else{
                Toast.makeText(this,"No se puede dividir entre cero", Toast.LENGTH_LONG).show();
            }

        }
    }

}