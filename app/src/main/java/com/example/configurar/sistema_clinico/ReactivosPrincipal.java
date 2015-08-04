package com.example.configurar.sistema_clinico;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReactivosPrincipal extends Activity {
    private ReactivosDAO objreactivosdao;
    EditText editTextCodRe,editTextNombRe,editTextGrupoRe,editTextCod,editTextUnRe,editTextEspRe;

    private List<String> lista;
    private TextView textView;
    private EditText editText;
    private Spinner spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reactivos_principal);

        editTextCodRe = (EditText)findViewById(R.id.txt_CodReac);
        editTextNombRe = (EditText)findViewById(R.id.txt_NombReac);
        editTextGrupoRe = (EditText)findViewById(R.id.txt_GrupoReac);
        editTextUnRe = (EditText)findViewById(R.id.txt_UnidadQ);
        editTextEspRe = (EditText)findViewById(R.id.txt_EspQ);
        textView =(TextView)findViewById(R.id.TextView_VerReactivos);
        objreactivosdao = new ReactivosDAO(this);
        try {
            objreactivosdao.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        spinner1 = (Spinner)findViewById(R.id.VerSpinnerReactivos);
        lista = new ArrayList<String>();
    }

    public void limpiarReactivos(View view) {
        editTextCodRe.setText("");
        editTextNombRe.setText("");
        editTextGrupoRe.setText("");
        editTextUnRe.setText("");
        editTextEspRe.setText("");
    }
    public void guardarReactivos(View view){
        String cod_reactivos=editTextCodRe.getText().toString();
        String nom_reactivo=editTextNombRe.getText().toString();
        String grupo_reactivo= editTextGrupoRe.getText().toString();
        String unidad_reactivo=editTextUnRe.getText().toString();
        String esp_quimica=editTextEspRe.getText().toString();
        long j=0;
        j=objreactivosdao.insertarReactivosSQL(cod_reactivos,nom_reactivo,grupo_reactivo,unidad_reactivo,esp_quimica);
        if (j==0){
            Toast.makeText(getApplicationContext(), "Reactivo no insertado", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Reactivo insertado",Toast.LENGTH_LONG).show();
            editTextCodRe.setText("");
            editTextNombRe.setText("");
            editTextGrupoRe.setText("");
            editTextUnRe.setText("");
            editTextEspRe.setText("");
        }
    }
    public void verReactivosSpinner(View view){
        lista = new ArrayList<String>();

        lista = objreactivosdao.VerReactivosSQL();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adaptador);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View a, int position, long id) {
                textView.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void eliminarReactivos(View view){
        String cod_reactivos=editTextCodRe.getText().toString();
        long i=0;
        i=objreactivosdao.eliminarReactivosSQL(cod_reactivos);
        if (i==0){
            Toast.makeText(getApplicationContext(),"Registro no eliminado",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Registro eliminado",Toast.LENGTH_SHORT).show();
            editTextCodRe.setText("");
        }
    }

}
