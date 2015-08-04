package com.example.configurar.sistema_clinico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class Seleccion_Login extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion__login);
    }

    public void lanzarEquipoPrincipal(View view){
        Intent i = new Intent(this,EquipoPrincipal.class);
        startActivity(i);
    }
    public void lanzarReactivosPrincipal(View view){
        Intent i = new Intent(this,ReactivosPrincipal.class);
        startActivity(i);
    }
    public void lanzarMaterialesPrincipal(View view){
        Intent i = new Intent(this,MaterialesPrincipal.class);
        startActivity(i);
    }
    public void lanzarEmpleadoPrincipal(View view){
        Intent i = new Intent(this,EmpleadoPrincipal.class);
        startActivity(i);
    }
    public void lanzarClientePrincipal(View view){
        Intent i = new Intent(this,ClientePrincipal.class);
        startActivity(i);
    }
    /*public void lanzarResultadoPrincipal(View view){
        Intent i = new Intent(this,ResultadoPrincipal.class);
        startActivity(i);
    }*/
}
