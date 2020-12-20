package com.example.lista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText textIn;
    private EditText textDel;
    private TextView textView;
    private AATree tree = new AATree();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textIn = (EditText) findViewById(R.id.textIn);
        textDel = (EditText) findViewById(R.id.textDel);
        textView = (TextView) findViewById(R.id.viewNodes);
    }

    public void Insertar(View view){
        String valor = textIn.getText().toString();
        int numValor = Integer.parseInt(valor);
        textIn.setText("");
    }

    public void Eliminar(View view){
        String valor = textDel.getText().toString();
        int numValor = Integer.parseInt(valor);
    }

    public void Mostrar(String nodes){
        textView.setText(nodes);
    }

}