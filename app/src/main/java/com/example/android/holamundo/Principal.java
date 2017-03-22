package com.example.android.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
//declaramos variable
    private EditText cajaNombre;
    private EditText cajaApellido;
    private TextView lblMessage;
    private Intent i;
    private Bundle b;
    private Spinner comboGenero;
    private RadioButton r1,r2,r3;
    private ArrayAdapter<String> adapter;//sirve para llenar los combobox
    private String[] opc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
//capturamos las cajas de texto los combos y los radiobutton
        cajaNombre = (EditText) findViewById(R.id.txtNombre);
        cajaApellido = (EditText) findViewById(R.id.txtApellido);
        comboGenero=(Spinner) findViewById(R.id.cmbGenero);
        r1=(RadioButton)findViewById(R.id.r1);
        r2=(RadioButton)findViewById(R.id.r2);
        r3=(RadioButton)findViewById(R.id.r3);
        //creamos el onjeto intet que sirve para pasar de una actividad a otra
        i = new Intent(this,Saludo.class);
        //se cra el objeto bundle que sirver para encapsular datos
        b = new Bundle();
        opc=this.getResources().getStringArray(R.array.generos);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc);
        comboGenero.setAdapter(adapter);
    }

    public void saludar(View v) {
        String nomb,apell,genero,estadoCivil="";
        if (validar()) {
            //tomo el valor que la persona ingreso tanto en nombre como en apellido
            nomb = cajaNombre.getText().toString();
            apell = cajaApellido.getText().toString();
            //capturar genero
            genero=comboGenero.getSelectedItem().toString();

            if (r1.isChecked()) estadoCivil=getResources().getString(R.string.soltero);
            if (r2.isChecked()) estadoCivil=getResources().getString(R.string.casado);
            if (r3.isChecked()) estadoCivil=getResources().getString(R.string.divorciado);
            //Encapsulo los valores previamente tomados
            b.putString("Nombre", nomb);
            b.putString("Apellido", apell);
            b.putString("Genero",genero);
            b.putString("EstadoCivil",estadoCivil);
            //le paso al intent todos los datos en forma encapsulada con el bundle
            i.putExtras(b);
            //Arranco la actividad que el intent me diga
            startActivity(i);
        }
    }

public void borrar(View V){
    cajaNombre.setText("");
    cajaNombre.requestFocus();
    cajaApellido.setText("");
    comboGenero.setSelection(0);
    r1.setChecked(true);
}
    public boolean validar(){
        if (cajaNombre.getText().toString().isEmpty()){
            //tambien puede usar this en ves del getaplicationcontext
            cajaNombre.setError(getResources().getString(R.string.error_1));
            //Toast.makeText(getApplicationContext(),"Digite el nombre por favor",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (cajaApellido.getText().toString().isEmpty()){
            cajaApellido.setError(getResources().getString(R.string.error_2));
            //Toast.makeText(getApplicationContext(),"Digite el apellido por favor",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
