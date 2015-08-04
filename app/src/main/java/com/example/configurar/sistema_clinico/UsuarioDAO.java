package com.example.configurar.sistema_clinico;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {
    private DBHelper helper;
    private SQLiteDatabase db,db2;

    public UsuarioDAO(Context context) {
        helper = new DBHelper(context,"analisis_clinico_bd.db", null, 1);
        // db= helper.getWritableDatabase();
    }
    public void open()throws SQLException {
        db = helper.getWritableDatabase();
        db2 = helper.getReadableDatabase();
    }
    public void close(){
        helper.close();
    }
    public long insertarUsuarioSQL(int idusuario, String nombre, String apellido,String login,String password, String acceso){
        long estado = 0;
        try {
            ContentValues valores = new ContentValues();
            valores.put("idusuario",idusuario);
            valores.put("nombre",nombre);
            valores.put("apellido",apellido);
            valores.put("login",login);
            valores.put("password",password);
            valores.put("acceso", acceso);
            estado=db.insert("usuario",null,valores);
        }
        catch (Exception e){estado=0;}
        return estado;
    }
    public ArrayList<UsuarioMandar> ListaUsuario(){
        Cursor c;
        ArrayList<UsuarioMandar> listado = new ArrayList<UsuarioMandar>();
        c = db.rawQuery(" SELECT login,password FROM usuario", null);
        while (c.moveToNext()){
            UsuarioMandar objusario =new UsuarioMandar();
            objusario.setLogin(c.getString(0));
            objusario.setPassword(c.getString(1));
            listado.add(objusario);
        }
        c.close();
        return listado;
    }
}
