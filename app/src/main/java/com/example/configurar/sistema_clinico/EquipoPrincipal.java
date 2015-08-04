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

public class EquipoPrincipal extends Activity {
    private EquipoDAO objequipodao;
    EditText editTextCodEq,editTextNombEq,editTextMarcaEq,editTextCodEstEq;

    private List<String> lista;
    private TextView textView;
    private EditText editText;
    private Spinner spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo_principal);
        editTextCodEq = (EditText)findViewById(R.id.txt_CodEquipo1);
        editTextNombEq = (EditText)findViewById(R.id.txt_NombEquipo1);
        editTextMarcaEq = (EditText)findViewById(R.id.txt_MarcaEquipo1);
        editTextCodEstEq = (EditText)findViewById(R.id.txt_EstadoEquipo1);
        textView =(TextView)findViewById(R.id.TextView_VerEquiposxCodigo);
        objequipodao = new EquipoDAO(this);
        try {
            objequipodao.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        spinner1 = (Spinner)findViewById(R.id.VerSpinnerEquipo);
        lista = new ArrayList<String>();

    }
    public void limpiarEquipo(View view) {
        editTextCodEq.setText("");
        editTextNombEq.setText("");
        editTextMarcaEq.setText("");
        editTextCodEstEq.setText("");
    }
    public void guardarEquipo1(View view){
        String cod_equipo=editTextCodEq.getText().toString();
        String nombre_equipo=editTextNombEq.getText().toString();
        String marca_equipo=editTextMarcaEq.getText().toString();
        String estado_equipo=editTextCodEstEq.getText().toString();
        long j=0;
        j=objequipodao.insertarEquipoSQL1(cod_equipo,nombre_equipo,marca_equipo,estado_equipo);
        if (j==0){
            Toast.makeText(getApplicationContext(), "Registro no insertado", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Registro insertado",Toast.LENGTH_LONG).show();
            editTextCodEq.setText("");
            editTextNombEq.setText("");
            editTextMarcaEq.setText("");
            editTextCodEstEq.setText("");
            editTextNombEq.requestFocus();
        }
    }
    public void verEquiposSpinner(View view){
        lista = new ArrayList<String>();

        lista = objequipodao.consultarVerEquipo2SQL();
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
    public void eliminarEquipo(View view){
        String cod_equipo=editTextCodEq.getText().toString();
        long j=0;
        j=objequipodao.eliminarEquipoSQL(cod_equipo);
        if (j==0){
            Toast.makeText(getApplicationContext(),"Registro no eliminado",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Registro eliminado",Toast.LENGTH_SHORT).show();
            editTextCodEq.setText("");
        }
    }
/*    public void modificarEquipo(View view){
        String cod_equipo=editTextCodEq.getText().toString();
        String nombre_equipo=editTextNombEq.getText().toString();
        String marca_equipo=editTextMarcaEq.getText().toString();
        String estado_equipo=editTextCodEstEq.getText().toString();
        long i=0;
        i=objequipodao.modificarEquipoSQL(cod_equipo,nombre_equipo,marca_equipo,estado_equipo);
        if (i==0){
            Toast.makeText(getApplicationContext(),"Registro no Modificado",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Registro Modificado",Toast.LENGTH_SHORT).show();
            editTextCodEq.setText("");
        }
    }*/
}
