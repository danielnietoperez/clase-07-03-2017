package com.example.android.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    private EditText txtNombre;
    private TextView lblMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        lblMessage = (TextView) findViewById(R.id.lblMessage);
    }

    public void saludar(View v) {
        String aux = txtNombre.getText().toString();
        lblMessage.setText("@string/saludo" + aux);
    }
}
