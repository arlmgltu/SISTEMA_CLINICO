package com.example.configurar.sistema_clinico;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoAnalisisDAO {
    private DBHelper helper;
    private SQLiteDatabase db,db2;

    public TipoAnalisisDAO(Context context) {
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

    public List VerCostoAnalisisSQL() {

        List<String> lista = new ArrayList<String>();
        Cursor cur = db2.rawQuery("SELECT nomb_analisis,costo FROM TIPO_ANALISIS", null);
        while (cur.moveToNext()) {
            lista.add(cur.getString(0) + " S/." + cur.getString(1) );
        }
        cur.close();
        return (lista);
    }
    public List VerListaAnalisisSQL() {

        List<String> lista = new ArrayList<String>();
        Cursor cur = db2.rawQuery("SELECT nomb_analisis,descripcion_tipo_analisis,num_especificacion FROM TIPO_ANALISIS", null);
        while (cur.moveToNext()) {
            lista.add(cur.getString(0) + "  |  " + cur.getString(2)+ "  |  " + cur.getString(1) );
        }
        cur.close();
        return (lista);
    }
}
