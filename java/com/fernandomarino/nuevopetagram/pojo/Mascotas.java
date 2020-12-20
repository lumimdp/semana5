package com.fernandomarino.nuevopetagram.pojo;

public class Mascotas {

    private int id;
    private int foto;
    private String nombre;
    private int visitas;
    private int huesear;

    public Mascotas(int foto, String nombre, int visitas) {
        this.foto = foto;
        this.nombre = nombre;
        this.visitas = visitas;
    }

    public Mascotas() {

    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVisitas() {
        return visitas;
    }

    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHuesear() {
        return huesear;
    }

    public void setHuesear(int huesear) {
        this.huesear = huesear;
    }
}