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

public class ResultadoPrincipal extends ActionBarActivity {
    private ResultadosDAO objresultadodao;

    private List<String> lista;
    private Spinner spinner1,spinner2;
    private TextView textViewRexNomb,textViewRexAn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_principal);

        objresultadodao = new ResultadosDAO(this);
        try {
            objresultadodao.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        spinner1 = (Spinner)findViewById(R.id.VerSpinnerResultadoxNombre);
        spinner2 = (Spinner)findViewById(R.id.VerSpinnerREsxAn);

        textViewRexNomb = (TextView)findViewById(R.id.TextView_VerResultxNomb);
        textViewRexAn =(TextView)findViewById(R.id.TextView_VerResulxAn);

        lista = new ArrayList<String>();
    }
    public void verResultadoxNomb(View view){
        lista = new ArrayList<String>();

        lista = objresultadodao.VerResultadosNSQL();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adaptador);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View a, int position, long id) {
                textViewRexNomb.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void verResultadoxAn(View view){
        lista = new ArrayList<String>();

        lista = objresultadodao.VerResultadosNASQL();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adaptador);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View a, int position, long id) {
                textViewRexAn.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
