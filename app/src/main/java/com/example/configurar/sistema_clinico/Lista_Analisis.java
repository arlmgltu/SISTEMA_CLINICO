package com.example.configurar.sistema_clinico;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Lista_Analisis extends Activity {

    private TipoAnalisisDAO objtipo1andao;
    private List<String> lista;
    private Spinner spinner1;
    private TextView textViewAnalisis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista__analisis);

        objtipo1andao = new TipoAnalisisDAO(this);
        try {
            objtipo1andao.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        spinner1 = (Spinner)findViewById(R.id.VerSpinnerAnalisis);
        textViewAnalisis = (TextView)findViewById(R.id.TextView_VerAnalisis);
        lista = new ArrayList<String>();
    }

    public void verListaAnalisis(View view){
        lista = new ArrayList<String>();
        lista = objtipo1andao.VerListaAnalisisSQL();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adaptador);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View a, int position, long id) {
                textViewAnalisis.setText(parent.getItemAtPosition(position).toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }


}
