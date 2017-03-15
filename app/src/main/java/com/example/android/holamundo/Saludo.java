package com.example.android.holamundo;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Saludo extends AppCompatActivity {

    private TextView saludo;
    private  Bundle b;
    private String aux,nomb,apell;
    private Resources res;


    @Override
    //on create es lo primero que se ejecuta
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);

        saludo = (TextView)findViewById(R.id.txtSaludo);
        b= getIntent().getExtras();
        nomb = b.getString("Nombre");
        apell=b.getString("Apellido");
        res = this.getResources();

        aux=res.getString(R.string.saludo)+" "+nomb+" "+apell+" "+res.getString(R.string.partesaludo2);
        saludo.setText(aux);
    }
}
