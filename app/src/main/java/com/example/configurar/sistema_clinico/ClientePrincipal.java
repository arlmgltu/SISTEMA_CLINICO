package com.example.configurar.sistema_clinico;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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

public class ClientePrincipal extends ActionBarActivity {
    private ClienteDAO objclientedao;
    EditText editTextCodCli,editTextDNICli,editTextNombCli,editTextApellCli,editTextCiuCli,editTextSexoCli,editTextFechCli,editTextDisCli;

    private List<String> lista;
    private TextView textView;
    private EditText editText;
    private Spinner spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_principal);

        editTextCodCli = (EditText)findViewById(R.id.txt_CodCli);
        editTextDNICli = (EditText)findViewById(R.id.txt_DNICli);
        editTextNombCli = (EditText)findViewById(R.id.txt_NombCli);
        editTextApellCli = (EditText)findViewById(R.id.txt_ApellCli);
        editTextCiuCli = (EditText)findViewById(R.id.txt_CiuCli);
        editTextSexoCli = (EditText)findViewById(R.id.txt_SexoCli);
        editTextFechCli = (EditText)findViewById(R.id.txt_FechCli);
        editTextDisCli = (EditText)findViewById(R.id.txt_DistCli);
        textView =(TextView)findViewById(R.id.TextView_VerClientes);
        objclientedao = new ClienteDAO(this);
        try {
            objclientedao.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        spinner1 = (Spinner)findViewById(R.id.VerSpinnerClientes);
        lista = new ArrayList<String>();
    }

    public void limpiarCliente(View view) {
        editTextCodCli.setText("");
        editTextDNICli.setText("");
        editTextNombCli.setText("");
        editTextApellCli.setText("");
        editTextCiuCli.setText("");
        editTextSexoCli.setText("");
        editTextFechCli.setText("");
        editTextDisCli.setText("");
    }
    public void guardarCliente(View view){
        String cod_cliente=editTextCodCli.getText().toString();
        String dni_cliente=editTextDNICli.getText().toString();
        String nomb_cliente=editTextNombCli.getText().toString();
        String apell_cliente= editTextApellCli.getText().toString();
        String ciudad_cliente=editTextCiuCli.getText().toString();
        String sexo_cliente= editTextSexoCli.getText().toString();
        String fecha_nac=editTextFechCli.getText().toString();
        String distrito_cliente=editTextDisCli.getText().toString();
        long j=0;
        j=objclientedao.insertarClienteSQL(cod_cliente,dni_cliente,nomb_cliente,apell_cliente,ciudad_cliente,sexo_cliente,fecha_nac,distrito_cliente);
        if (j==0){
            Toast.makeText(getApplicationContext(), "Cliente no insertado", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Cliente insertado",Toast.LENGTH_LONG).show();
            editTextCodCli.setText("");
            editTextDNICli.setText("");
            editTextNombCli.setText("");
            editTextApellCli.setText("");
            editTextCiuCli.setText("");
            editTextSexoCli.setText("");
            editTextFechCli.setText("");
            editTextDisCli.setText("");
            editTextCodCli.requestFocus();
        }
    }
    public void verClienteSpinner(View view){
        lista = new ArrayList<String>();

        lista = objclientedao.VerClienteSQL();
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
    public void eliminarCliente(View view){
        String cod_cliente=editTextCodCli.getText().toString();
        long j=0;
        j=objclientedao.eliminarClienteSQL(cod_cliente);
        if (j==0){
            Toast.makeText(getApplicationContext(),"Cliente no eliminado",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Cliente eliminado",Toast.LENGTH_SHORT).show();
            editTextCodCli.setText("");
        }
    }

}
