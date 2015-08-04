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

public class EspecialistaPrincipal extends Activity {
    private EmpleadoDAO objempleadodao;

    private List<String> lista;
    private Spinner spinner1,spinner2,spinner3;
    private TextView  textViewEspxNomb,textViewEspxApell,textViewEspxEsp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialista_principal);

        objempleadodao = new EmpleadoDAO(this);
        try {
            objempleadodao.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        spinner1 = (Spinner)findViewById(R.id.VerSpinnerEspecilistaxNombre);
        spinner2 = (Spinner)findViewById(R.id.VerSpinnerEspecilistaxApell);
        spinner3 = (Spinner)findViewById(R.id.VerSpinnerEspecilistaxEsp);
        textViewEspxNomb = (TextView)findViewById(R.id.TextView_VerEspxNomb);
        textViewEspxApell =(TextView)findViewById(R.id.TextView_VerEspxApell);
        textViewEspxEsp =(TextView)findViewById(R.id.TextView_VerEspxEsp);
        lista = new ArrayList<String>();
    }

    public void verEspecialistaxNomb(View view){
        lista = new ArrayList<String>();

        lista = objempleadodao.VerEspecialistaNSQL();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adaptador);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View a, int position, long id) {
                textViewEspxNomb.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void verEspecialistaxApell(View view){
        lista = new ArrayList<String>();

        lista = objempleadodao.VerEspecialistaASQL();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adaptador);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View a, int position, long id) {
                textViewEspxApell.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void verEspecialistaxEsp(View view){
        lista = new ArrayList<String>();

        lista = objempleadodao.VerEspecialistaESQL();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adaptador);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View a, int position, long id) {
                textViewEspxEsp.setText(parent.getItemAtPosition(position).toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
