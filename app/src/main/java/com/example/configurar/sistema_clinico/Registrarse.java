package com.example.configurar.sistema_clinico;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class Registrarse extends Activity {
    private UsuarioDAO objusuariodao;
    EditText editTextIdU,editTextNombU,editTextApellU,editTextlogU,editTextPassU,editTextAccU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        editTextIdU = (EditText)findViewById(R.id.txt_idusuario1);
        editTextNombU = (EditText)findViewById(R.id.txt_nombre1);
        editTextApellU= (EditText)findViewById(R.id.txt_apellidos1);
        editTextlogU = (EditText)findViewById(R.id.txt_nick1);
        editTextPassU= (EditText)findViewById(R.id.txt_password1);
        editTextAccU = (EditText)findViewById(R.id.txt_acceso1);
        objusuariodao = new UsuarioDAO(this);
        try {
            objusuariodao.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Button btnRegistro = (Button)findViewById(R.id.btn_Registrarse);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer idusuario= Integer.valueOf(editTextIdU.getText().toString());
                String nombre=editTextNombU.getText().toString();
                String apellido=editTextApellU.getText().toString();
                String login=editTextlogU.getText().toString();
                String password=editTextPassU.getText().toString();
                String acceso=editTextAccU.getText().toString();
                if (idusuario==3||idusuario==4||idusuario==5||idusuario==6){
                    long j=0;
                    j=objusuariodao.insertarUsuarioSQL(idusuario,nombre,apellido,login,password,acceso);
                    if (j==0){
                        Toast.makeText(getApplicationContext(), "No se ha podido registrar", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Registrado correctamente",Toast.LENGTH_LONG).show();
                        editTextIdU.setText("");
                        editTextNombU.setText("");
                        editTextApellU.setText("");
                        editTextlogU.setText("");
                        editTextPassU.setText("");
                        editTextAccU.setText("");
                        editTextIdU.requestFocus();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"La Clave de Usuario no es Valida, Solicite una Clave valida a un Administrador Superior",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /*public void RegistrarUsuario(View view){
        Integer idusuario= Integer.valueOf(editTextIdU.getText().toString());
        String nombre=editTextNombU.getText().toString();
        String apellido=editTextApellU.getText().toString();
        String login=editTextlogU.getText().toString();
        String password=editTextPassU.getText().toString();
        String acceso=editTextAccU.getText().toString();

        long j=0;
        j=objusuariodao.insertarUsuarioSQL(idusuario,nombre,apellido,login,password,acceso);
        if (j==0){
            Toast.makeText(getApplicationContext(), "No se ha podido registrar", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Registrado correctamente",Toast.LENGTH_LONG).show();
            editTextIdU.setText("");
            editTextNombU.setText("");
            editTextApellU.setText("");
            editTextlogU.setText("");
            editTextPassU.setText("");
            editTextAccU.setText("");
            editTextIdU.requestFocus();
        }
    }*/
}
