package com.fernandomarino.nuevopetagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.fernandomarino.nuevopetagram.R;
import com.fernandomarino.nuevopetagram.pojo.Mascotas;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final int HUESEO = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascotas> obtenerDatos() {


        BaseDatos db  = new BaseDatos(context);
        /*insertarMascotas(db);*/
        return db.obtenerTodasLasMascotas();
    }

    /*public void insertarMascotas (BaseDatos db) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Charlie");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.p1);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Lolita");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.p2);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Gaston");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.p3);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Catalina");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.p4);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Rodolfo");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.p5);
        db.insertarMascota(contentValues);


    }*/


    public void darHueseoMascota(Mascotas mascotas) {
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_HUESEOS_ID_MASCOTA, mascotas.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_HUESEOS_HUESEOS, HUESEO);
        db.insertarHueseoMascota(contentValues);
    }

    public int obtenerHueseosMascota(Mascotas mascotas) {
        BaseDatos db = new BaseDatos(context);
        return db.obtenerHueseosMascota(mascotas);
    }
}
