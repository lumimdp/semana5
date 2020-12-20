package com.fernandomarino.nuevopetagram.fragment;

import com.fernandomarino.nuevopetagram.adapter.MascotasAdaptador;
import com.fernandomarino.nuevopetagram.pojo.Mascotas;

import java.util.ArrayList;

public interface IReciclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotasAdaptador crearAdaptador(ArrayList<Mascotas> mascotas);

    public void inicializarAdaptadorRV(MascotasAdaptador adaptador);

}
