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

public class MaterialesPrincipal extends Activity {
    private MaterialesDAO objmaterialesdao;
    EditText editTextCodMa,editTextNombMa,editTextMarcaMa,editTextFuncMa,editTextMatMa;

    private List<String> lista;
    private TextView textView;
    private EditText editText;
    private Spinner spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materiales_principal);

        editTextCodMa= (EditText)findViewById(R.id.txt_CodMa);
        editTextNombMa = (EditText)findViewById(R.id.txt_NombMa);
        editTextMarcaMa = (EditText)findViewById(R.id.txt_MarcaMa);
        editTextFuncMa = (EditText)findViewById(R.id.txt_FuncMa);
        editTextMatMa = (EditText)findViewById(R.id.txt_MatMa);
        textView =(TextView)findViewById(R.id.TextView_VerMateriales);
        objmaterialesdao = new MaterialesDAO(this);
        try {
            objmaterialesdao.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        spinner1 = (Spinner)findViewById(R.id.VerSpinnerMateriales);
        lista = new ArrayList<String>();
    }

    public void limpiarMateriales(View view) {
        editTextCodMa.setText("");
        editTextNombMa.setText("");
        editTextMarcaMa.setText("");
        editTextFuncMa.setText("");
        editTextMatMa.setText("");
    }
    public void guardarMateriales(View view){
        String cod_materiales=editTextCodMa.getText().toString();
        String nom_material=editTextNombMa.getText().toString();
        String marca=editTextMarcaMa.getText().toString();
        String funcion=editTextFuncMa.getText().toString();
        String material_fabricacion=editTextMatMa.getText().toString();
        long j=0;
        j=objmaterialesdao.insertarMaterialesSQL(cod_materiales,nom_material,marca,funcion,material_fabricacion);
        if (j==0){
            Toast.makeText(getApplicationContext(), "Registro no insertado", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Registro insertado",Toast.LENGTH_LONG).show();
            editTextCodMa.setText("");
            editTextNombMa.setText("");
            editTextMarcaMa.setText("");
            editTextFuncMa.setText("");
            editTextMatMa.setText("");
            editTextCodMa.requestFocus();
        }
    }
    public void verMateriales(View view){
        lista = new ArrayList<String>();

        lista = objmaterialesdao.VerMaterialesSQL();
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
    public void eliminarMateriales(View view){
        String cod_materiales=editTextCodMa.getText().toString();
        long j=0;
        j=objmaterialesdao.eliminarMaterialesSQL(cod_materiales);
        if (j==0){
            Toast.makeText(getApplicationContext(),"Material no eliminado",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Material eliminado",Toast.LENGTH_SHORT).show();
            editTextCodMa.setText("");
        }
    }

}
