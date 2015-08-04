package com.example.configurar.sistema_clinico;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAO {
    private DBHelper helper;
    private SQLiteDatabase db,db2;

    public EquipoDAO(Context context) {
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
    public long insertarEquipoSQL1(String cod_equipo, String nombre_equipo, String marca_equipo,String estado_equipo ){
        long estado = 0;
        try {
            ContentValues valores = new ContentValues();
            valores.put("cod_equipo",cod_equipo);
            valores.put("nombre_equipo",nombre_equipo);
            valores.put("marca_equipo",marca_equipo);
            valores.put("estado_equipo",estado_equipo);
            estado=db.insert("EQUIPO",null,valores);
        }
        catch (Exception e){estado=0;}
        return estado;
    }

    public long eliminarEquipoSQL(String cod_equipo){
        long estado1=0;
        try {
            estado1 = db.delete("EQUIPO","cod_equipo=?",new String[]{String.valueOf(cod_equipo)});
        }
        catch (Exception e){
            estado1 = 0;
        }
        return estado1;
    }
   /* public ArrayList<EquipoMandar> ListaEquiposSQL(){
        Cursor c;
        ArrayList<EquipoMandar> listado = new ArrayList<EquipoMandar>();
        c = db.rawQuery(" SELECT * FROM EQUIPO ", null);
        while (c.moveToNext()){
            EquipoMandar objtequipo =new EquipoMandar();
            objtequipo.setCod_equipo(c.getString(0));
            objtequipo.setNombre_equipo(c.getString(1));
            objtequipo.setMarca_equipo(c.getString(2));
            objtequipo.setEstado_equipo(c.getString(3));
            listado.add(objtequipo);
        }
        c.close();
        return listado;
    }*/

    public List consultarVerEquipo2SQL() {

        List<String> lista = new ArrayList<String>();
        Cursor cur = db2.rawQuery("SELECT * FROM EQUIPO", null);
        while (cur.moveToNext()) {
            lista.add(cur.getString(0) + " | " + cur.getString(1) + " | " + cur.getString(2) + " | " + cur.getString(3));
        }
        cur.close();
        return (lista);
    }
 /*   public long modificarEquipoSQL(String cod_equipo, String nombre_equipo, String marca_equipo,String estado_equipo){
        long estado = 0;
        try {
            ContentValues valores = new ContentValues();

            valores.put("nombre_equipo",nombre_equipo);
            valores.put("marca_equipo",marca_equipo);
            valores.put("estado_equipo",estado_equipo);
            estado=db.update("EQUIPO",valores,"cod_equipo="+cod_equipo,null);
        }
        catch (Exception e){estado=0;}
        return estado;
    }*/
}
