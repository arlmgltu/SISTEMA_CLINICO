package com.example.configurar.sistema_clinico;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edward on 10/12/2014.
 */
public class ResultadosDAO {
    private DBHelper helper;
    private SQLiteDatabase db,db2;

    public ResultadosDAO(Context context) {
        helper = new DBHelper(context,"analisis_clinico_bd", null, 1);
        // db= helper.getWritableDatabase();
    }
    public void open()throws SQLException {
        db = helper.getWritableDatabase();
        db2 = helper.getReadableDatabase();
    }

    public List VerResultadosNSQL() {

        List<String> lista = new ArrayList<String>();
        Cursor cur = db2.rawQuery("SELECT * FROM resultado_cliente", null);
        while (cur.moveToNext()) {
            lista.add("1. "+cur.getString(4) + " | 2. " + cur.getString(5) + " | 3. " + cur.getString(0) + " | 4. " + cur.getString(1)+ " | 5. " + cur.getString(2)+ " | 5. " + cur.getString(3));
        }
        cur.close();
        return (lista);
    }

    public List VerResultadosNASQL() {

        List<String> lista = new ArrayList<String>();
        Cursor cur = db2.rawQuery("SELECT * FROM resultado_cliente", null);
        while (cur.moveToNext()) {
            lista.add("1. "+cur.getString(0) + " | 2. " + cur.getString(1) + " | 3. " + cur.getString(2) + " | 4. " + cur.getString(3)+ " | 5. " + cur.getString(4)+ " | 5. " + cur.getString(5));
        }
        cur.close();
        return (lista);
    }
}
