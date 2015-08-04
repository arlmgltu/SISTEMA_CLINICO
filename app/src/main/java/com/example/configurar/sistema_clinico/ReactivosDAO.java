package com.example.configurar.sistema_clinico;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReactivosDAO {
    private DBHelper helper;
    private SQLiteDatabase db,db2;

    public ReactivosDAO(Context context) {
        helper = new DBHelper(context, "analisis_clinico_bd.db", null, 1);
        //db= helper.getWritableDatabase();
    }
    public void open()throws SQLException {
        db = helper.getWritableDatabase();
        db2 = helper.getReadableDatabase();
    }
    public void close(){
        helper.close();
    }

    public long insertarReactivosSQL(String cod_reactivos, String nom_reactivo, String grupo_reactivo,String unidad_reactivo,String esp_quimica){
        long estado = 0;
        try {
            ContentValues valores=new ContentValues();
            valores.put("cod_reactivos",cod_reactivos);
            valores.put("nom_reactivo",nom_reactivo);
            valores.put("grupo_reactivo",grupo_reactivo);
            valores.put("unidad_reactivo",unidad_reactivo);
            valores.put("esp_quimica",esp_quimica);
            estado=db.insert("REACTIVOS",null,valores);
        }
        catch (Exception e){
            estado = 0;
        }
        return estado;
    }

    public List VerReactivosSQL() {

        List<String> lista = new ArrayList<String>();
        Cursor cur = db2.rawQuery("SELECT * FROM REACTIVOS", null);
        while (cur.moveToNext()) {
            lista.add("1."+cur.getString(0) + " |  2." + cur.getString(1)+ " |  3." + cur.getString(2)+ " |  4." + cur.getString(3)+ " |  5." + cur.getString(4) );
        }
        cur.close();
        return (lista);
    }
    public long eliminarReactivosSQL(String cod_reactivos){
        long estado=0;
        try {
            estado= db.delete("REACTIVOS","cod_reactivos=?",new String[]{String.valueOf(cod_reactivos)});
        }
        catch (Exception e){
            estado = 0;
        }
        return estado;
    }
}
