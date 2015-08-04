package com.example.configurar.sistema_clinico;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialesDAO {

    private DBHelper helper;
    private SQLiteDatabase db,db2;

    public MaterialesDAO(Context context) {
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
    public long insertarMaterialesSQL(String cod_materiales, String nom_material,String marca,String funcion,String material_fabricacion ){
        long estado = 0;
        try {
            ContentValues valores = new ContentValues();
            valores.put("cod_materiales",cod_materiales);
            valores.put("nom_material",nom_material);
            valores.put("marca",marca);
            valores.put("funcion",funcion);
            valores.put("material_fabricacion",material_fabricacion);
            estado=db.insert("MATERIALES",null,valores);
        }
        catch (Exception e){estado=0;}
        return estado;
    }

    public long eliminarMaterialesSQL(String cod_materiales){
        long estado1=0;
        try {
            estado1 = db.delete("MATERIALES","cod_materiales=?",new String[]{String.valueOf(cod_materiales)});
        }
        catch (Exception e){
            estado1 = 0;
        }
        return estado1;
    }
    public List VerMaterialesSQL() {

        List<String> lista = new ArrayList<String>();
        Cursor cur = db2.rawQuery("SELECT * FROM MATERIALES", null);
        while (cur.moveToNext()) {
            lista.add("1. "+cur.getString(0) + " | 2. " + cur.getString(1) + " | 3. " + cur.getString(2) + " | 4. " + cur.getString(3)+ " | 5. " + cur.getString(4));
        }
        cur.close();
        return (lista);
    }
}
