package com.example.android.holamundo;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Saludo extends AppCompatActivity {

    private TextView saludo;
    private  Bundle b;
    private String aux,nomb,apell,genero,estadoCivil;
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
        genero=b.getString("Genero");
        estadoCivil=b.getString("EstadoCivil");
        res = this.getResources();

        aux=res.getString(R.string.saludo)+" "+nomb+" "+apell+" "+res.getString(R.string.partesaludo2);
        aux=aux+"\n\n"+res.getString(R.string.tudatosson);
        aux=aux+"\n "+res.getString(R.string.nombre)+": "+nomb;
        aux=aux+"\n "+res.getString(R.string.apellido)+": "+apell;
        aux=aux+"\n "+res.getString(R.string.genero)+": "+genero;
        aux=aux+"\n "+res.getString(R.string.estadoCivil)+": "+estadoCivil;
        saludo.setText(aux);
    }
}
