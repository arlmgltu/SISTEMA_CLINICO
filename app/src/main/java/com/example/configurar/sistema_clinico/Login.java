package com.example.configurar.sistema_clinico;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends Activity {
    private UsuarioDAO objuser;
    ArrayList<UsuarioMandar> lista=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login = (Button)findViewById(R.id.btn_IngresarSistemaA);

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String user = ((EditText)findViewById(R.id.txt_usuario)).getText().toString();
                String contra = ((EditText)findViewById(R.id.txt_pass)).getText().toString();

                if ((user.equals("edward")&& contra.equals("edward"))||(user.equals("javier")&& contra.equals("javier"))||(user.equals("admin")&& contra.equals("admin"))) {
                    Intent i = new Intent(Login.this, Seleccion_Login.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Usuario o Contraseña Incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void volver(View view){
        Intent volv=new Intent(this,Inicio.class);
        startActivity(volv);
    }
    public void registrarse(View view){
        Intent i = new Intent(this,Registrarse.class);
        startActivity(i);
    }

}
