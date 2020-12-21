package com.example.lista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Clase para ejecutar la aplicacion. Atributos que son un cuadro para ingreasr texto, un TextView para ver el arbol y el arbol AA.
 */
public class MainActivity extends AppCompatActivity {

    private EditText textIn;
    private TextView textView;
    private AATree tree = new AATree();

    /**
     * Crea los componentes
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textIn = (EditText) findViewById(R.id.textIn);
        textView = (TextView) findViewById(R.id.viewNodes);
    }

    /**
     * Insertar un numero en el arbol
     * @param view
     */
    public void Insertar(View view){
        String valor = textIn.getText().toString();
        int numValor = Integer.parseInt(valor);
        tree.insert(numValor);
        Mostrar(tree.print(tree.getRoot()));
        tree.ResetString();
    }

    /**
     * Mostar el arbol, acercandose a la estructura que este deberia de tener fuera del codigo.
     * @param nodes
     */
    public void Mostrar(String nodes){
        textView.setText(nodes);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }

}