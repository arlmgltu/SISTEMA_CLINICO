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

public class EmpleadoPrincipal extends Activity {
    private EmpleadoDAO objempleadodao;
    EditText editTextCodEm,editTextDNIEm,editTextNombEm,editTextApellEm,editTextFechEm,editTextDirEm,editTextSueldoEm,editTextSexoEm;
    EditText cod_espe,espe_e;
    private List<String> lista;
    private TextView textView;
    private EditText editText;
    private Spinner spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleado_principal);
        editTextCodEm = (EditText)findViewById(R.id.txt_CodEmpleado1);
        editTextDNIEm = (EditText)findViewById(R.id.txt_DNIEmpleado1);
        editTextNombEm = (EditText)findViewById(R.id.txt_NombEmpleadoo1);
        editTextApellEm = (EditText)findViewById(R.id.txt_ApellEmpl1);
        editTextFechEm = (EditText)findViewById(R.id.txt_FechEmpl1);
        editTextDirEm = (EditText)findViewById(R.id.txt_DirEmpl1);
        editTextSueldoEm = (EditText)findViewById(R.id.txt_SueldoEmpl1);
        editTextSexoEm = (EditText)findViewById(R.id.txt_SexoEmpl1);
        cod_espe = (EditText)findViewById(R.id.txt_CodEspe);
        espe_e = (EditText)findViewById(R.id.txt_EspecialidadEsp);

        textView =(TextView)findViewById(R.id.TextView_VerEmpleados);
        objempleadodao = new EmpleadoDAO(this);
        try {
            objempleadodao.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        spinner1 = (Spinner)findViewById(R.id.VerSpinnerEmpleados);
        lista = new ArrayList<String>();
    }
    public void limpiarEmpleado(View view) {
        editTextCodEm.setText("");
        editTextDNIEm.setText("");
        editTextNombEm.setText("");
        editTextApellEm.setText("");
        editTextFechEm.setText("");
        editTextDirEm.setText("");
        editTextSueldoEm.setText("");
        editTextSexoEm.setText("");
    }
    public void guardarEmpleado(View view){
        String cod_empleado=editTextCodEm.getText().toString();
        String dni_empleado=editTextDNIEm.getText().toString();
        String nombre_empleado=editTextNombEm.getText().toString();
        String apellidos_empleado= editTextApellEm.getText().toString();
        String fecha_ingreso=editTextFechEm.getText().toString();
        String direccion= editTextDirEm.getText().toString();
        String sueldo=editTextSueldoEm.getText().toString();
        String sexo=editTextSexoEm.getText().toString();
        long j=0;
        j=objempleadodao.insertarEmpleadoSQL(cod_empleado, dni_empleado,nombre_empleado,apellidos_empleado,fecha_ingreso,direccion,sueldo,sexo);
        if (j==0){
            Toast.makeText(getApplicationContext(), "Empleado no insertado", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Empleado insertado",Toast.LENGTH_LONG).show();
            editTextCodEm.setText("");
            editTextDNIEm.setText("");
            editTextNombEm.setText("");
            editTextApellEm.setText("");
            editTextFechEm.setText("");
            editTextDirEm.setText("");
            editTextSueldoEm.setText("");
            editTextSexoEm.setText("");
            editTextCodEm.requestFocus();
        }
    }
    public void verEmpleadosSpinner(View view){
        lista = new ArrayList<String>();

        lista = objempleadodao.VerEmpleadoSQL();
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
    public void eliminarEmpleado(View view){
        String cod_empleado=editTextCodEm.getText().toString();
        long j=0;
        j=objempleadodao.eliminarEmpleadoSQL(cod_empleado);
        if (j==0){
            Toast.makeText(getApplicationContext(),"Empleado no eliminado",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Empleado eliminado",Toast.LENGTH_SHORT).show();
            editTextCodEm.setText("");
        }
    }

    public void guardarEspecialista(View view){
        String cod_empleado=cod_espe.getText().toString();
        String especialidad=espe_e.getText().toString();
        long j=0;
        j=objempleadodao.insertarEspecialistaSQL(cod_empleado, especialidad);
        if (j==0){
            Toast.makeText(getApplicationContext(), "Especialista no insertado", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Especialista insertado",Toast.LENGTH_LONG).show();
            cod_espe.setText("");
            espe_e.setText("");
            cod_espe.requestFocus();
        }
    }
}
