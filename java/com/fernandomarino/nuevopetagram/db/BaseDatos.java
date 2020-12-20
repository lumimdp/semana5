package com.fernandomarino.nuevopetagram.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.fernandomarino.nuevopetagram.pojo.Mascotas;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA + "(" +
                ConstantesBaseDatos.TABLE_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO + " INTEGER)";

        String queryCrearTablaHueseos = "CREATE TABLE " + ConstantesBaseDatos.TABLE_HUESEOS + "(" +
                ConstantesBaseDatos.TABLE_HUESEOS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_HUESEOS_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TABLE_HUESEOS_HUESEOS + " INTEGER, FOREIGN KEY (" + ConstantesBaseDatos.TABLE_HUESEOS_ID_MASCOTA +
                ") REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTA + " (" + ConstantesBaseDatos.TABLE_MASCOTA_ID + "))";


        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaHueseos);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {

        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_HUESEOS);
        onCreate(db);
    }

    public ArrayList<Mascotas> obtenerTodasLasMascotas() {
        ArrayList<Mascotas> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            Mascotas mascotaActual = new Mascotas();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);
        db.close();


    }

    public void insertarHueseoMascota(ContentValues contentValues) {
        SQLiteDatabase db;
        db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_HUESEOS, null, contentValues);
        db.close();
    }

    public int obtenerHueseosMascota(Mascotas mascotas) {
        int hueseos = 0;

        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_HUESEOS_HUESEOS + ") FROM " + ConstantesBaseDatos.TABLE_HUESEOS + " WHERE " + ConstantesBaseDatos.TABLE_HUESEOS_ID_MASCOTA + " = " + mascotas.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()) {
            hueseos = registros.getInt(0);
        }

        db.close();
        return hueseos;
    }
}
