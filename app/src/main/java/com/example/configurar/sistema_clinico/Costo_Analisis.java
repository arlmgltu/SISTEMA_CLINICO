package com.example.configurar.sistema_clinico;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Costo_Analisis extends ActionBarActivity {
    private TipoAnalisisDAO objtipoandao;
    private List<String> lista;
    private Spinner spinner1;
    private TextView  textViewCosto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costo__analisis);
        objtipoandao = new TipoAnalisisDAO(this);
        try {
            objtipoandao.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        spinner1 = (Spinner)findViewById(R.id.VerSpinnerCostoAn);
        textViewCosto = (TextView)findViewById(R.id.TextView_VerCostoAn);
        lista = new ArrayList<String>();
    }
    public void verCostoAnalisis(View view){
        lista = new ArrayList<String>();
        lista = objtipoandao.VerCostoAnalisisSQL();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adaptador);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View a, int position, long id) {
                textViewCosto.setText(parent.getItemAtPosition(position).toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }

}
