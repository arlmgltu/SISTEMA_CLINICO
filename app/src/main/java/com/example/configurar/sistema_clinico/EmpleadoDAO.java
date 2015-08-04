package com.example.configurar.sistema_clinico;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmpleadoDAO {

    private DBHelper helper;
    private SQLiteDatabase db,db2;

    public EmpleadoDAO(Context context) {
        helper = new DBHelper(context,"analisis_clinico_bd", null, 1);
        // db= helper.getWritableDatabase();
    }
    public void open()throws SQLException {
        db = helper.getWritableDatabase();
        db2 = helper.getReadableDatabase();
    }
    public void close(){
        helper.close();
    }

    public long insertarEspecialistaSQL(String cod_empleado , String especialidad){
        long estado = 0;
        try {
            ContentValues valores = new ContentValues();
            valores.put("cod_empleado",cod_empleado);
            valores.put("especialidad",especialidad);
            estado=db.insert("ESPECIALISTA",null,valores);
        }
        catch (Exception e){estado=0;}
        return estado;
    }
    public List VerEspecialistaNSQL() {

        List<String> lista = new ArrayList<String>();
        Cursor cur = db2.rawQuery("SELECT * FROM empleado_usuarioNormal", null);
        while (cur.moveToNext()) {
            lista.add(cur.getString(0) + " | " + cur.getString(1) + " | " + cur.getString(2));
        }
        cur.close();
        return (lista);
    }
    public List VerEspecialistaASQL() {

        List<String> lista = new ArrayList<String>();
        Cursor cur = db2.rawQuery("SELECT * FROM empleado_usuarioNormal", null);
        while (cur.moveToNext()) {
            lista.add(cur.getString(1) + " | " + cur.getString(0) + " | " + cur.getString(2));
        }
        cur.close();
        return (lista);
    }
    public List VerEspecialistaESQL() {

        List<String> lista = new ArrayList<String>();
        Cursor cur = db2.rawQuery("SELECT * FROM empleado_usuarioNormal", null);
        while (cur.moveToNext()) {
            lista.add(cur.getString(2) + " | " + cur.getString(0) + " | " + cur.getString(1));
        }
        cur.close();
        return (lista);
    }
    public long insertarEmpleadoSQL(String cod_empleado , String dni_empleado, String nombre_empleado, String apellidos_empleado,String fecha_ingreso,String direccion,String sueldo,String sexo){
        long estado = 0;
        try {
            ContentValues valores = new ContentValues();
            valores.put("cod_empleado",cod_empleado);
            valores.put("dni_empleado",dni_empleado);
            valores.put("nombre_empleado",nombre_empleado);
            valores.put("apellidos_empleado",apellidos_empleado);
            valores.put("fecha_ingreso", fecha_ingreso);
            valores.put("direccion",direccion);
            valores.put("sueldo",sueldo);
            valores.put("sexo",sexo);
            estado=db.insert("EMPLEADO",null,valores);
        }
        catch (Exception e){estado=0;}
        return estado;
    }

    public long eliminarEmpleadoSQL(String cod_empleado){
        long estado=0;
        try {
            estado = db.delete("EMPLEADO","cod_empleado=?",new String[]{String.valueOf(cod_empleado)});
        }
        catch (Exception e){
            estado = 0;
        }
        return estado;
    }
    public List VerEmpleadoSQL() {

        List<String> lista = new ArrayList<String>();
        Cursor cur = db2.rawQuery("SELECT * FROM EMPLEADO", null);
        while (cur.moveToNext()) {
            lista.add(cur.getString(0) + " | " + cur.getString(1) + " | " + cur.getString(2) + " | " + cur.getString(3) + cur.getString(4) + " | " + cur.getString(5) + " | S/. " + cur.getString(6) + " | " + cur.getString(7));
        }
        cur.close();
        return (lista);
    }
}
