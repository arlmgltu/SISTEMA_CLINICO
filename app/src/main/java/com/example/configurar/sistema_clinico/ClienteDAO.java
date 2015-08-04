package com.example.configurar.sistema_clinico;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private DBHelper helper;
    private SQLiteDatabase db,db2;

    public ClienteDAO(Context context) {
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

    public long insertarClienteSQL(String cod_cliente,String dni_cliente,String nomb_cliente,String apell_cliente,String ciudad_cliente,String sexo_cliente,String fecha_nac,String distrito_cliente){
        long estado = 0;
        try {
            ContentValues valores = new ContentValues();
            valores.put("cod_cliente",cod_cliente);
            valores.put("dni_cliente",dni_cliente);
            valores.put("nomb_cliente",nomb_cliente);
            valores.put("apell_cliente",apell_cliente);
            valores.put("ciudad_cliente",ciudad_cliente);
            valores.put("sexo_cliente",sexo_cliente);
            valores.put("fecha_nac",fecha_nac);
            valores.put("distrito_cliente",distrito_cliente);
            estado=db.insert("CLIENTE",null,valores);
        }
        catch (Exception e){estado=0;}
        return estado;
    }

    public long eliminarClienteSQL(String cod_cliente){
        long estado=0;
        try {
            estado = db.delete("CLIENTE","cod_cliente=?",new String[]{String.valueOf(cod_cliente)});
        }
        catch (Exception e){
            estado = 0;
        }
        return estado;
    }
    public List VerClienteSQL() {

        List<String> lista = new ArrayList<String>();
        Cursor cur = db2.rawQuery("SELECT * FROM CLIENTE", null);
        while (cur.moveToNext()) {
            lista.add(cur.getString(0) + " | " + cur.getString(1) + " | " + cur.getString(2) + " | " + cur.getString(3) + cur.getString(4) + " | " + cur.getString(5) + " | S/. " + cur.getString(6) + " | " + cur.getString(7));
        }
        cur.close();
        return (lista);
    }

}
