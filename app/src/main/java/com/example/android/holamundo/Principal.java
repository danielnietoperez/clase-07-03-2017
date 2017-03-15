package com.example.android.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
//declaramos variable
    private EditText cajaNombre;
    private EditText cajaApellido;
    private TextView lblMessage;
    private Intent i;
    private Bundle b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
//capturamos las cajas
        cajaNombre = (EditText) findViewById(R.id.txtNombre);
        cajaApellido = (EditText) findViewById(R.id.txtApellido);
        //creamos el onjeto intet que sirve para pasar de una actividad a otra
        i = new Intent(this,Saludo.class);
        //se cra el objeto bundle que sirver para encapsular datos
        b = new Bundle();
    }

    public void saludar(View v) {
        String nomb,apell;
        //tomo el valor que la persona ingreso tanto en nombre como en apellido
        nomb = cajaNombre.getText().toString();
        apell= cajaApellido.getText().toString();
        //Encapsulo los valores previamente tomados
        b.putString("Nombre",nomb);
        b.putString("Apellido",apell);
        //le paso al intent todos los datos en forma encapsulada con el bundle
        i.putExtras(b);
        //Arranco la actividad que el intent me diga
        startActivity(i);
      /*  String aux = txtNombre.getText().toString();
        lblMessage.setText("Hola " + aux);*/
    }
}
