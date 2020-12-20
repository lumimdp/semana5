package com.fernandomarino.nuevopetagram.presentador;

import android.content.Context;
import android.widget.ImageButton;

import com.fernandomarino.nuevopetagram.adapter.MascotasAdaptador;
import com.fernandomarino.nuevopetagram.db.ConstructorMascotas;
import com.fernandomarino.nuevopetagram.fragment.IReciclerViewFragmentView;
import com.fernandomarino.nuevopetagram.pojo.Mascotas;

import java.util.ArrayList;

public class ReciclerViewFragmentPresenter implements IReciclerViewFragmentPresenter {

    private final IReciclerViewFragmentView iReciclerViewFragmentView;
    private final Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascotas> mascotas;

    public ReciclerViewFragmentPresenter(IReciclerViewFragmentView iReciclerViewFragmentView, Context context) {

        this.iReciclerViewFragmentView = iReciclerViewFragmentView;
        this.context = context;
        obtenerDatos();

    }
    @Override
    public void obtenerDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotas();
    }

    @Override
    public void mostrarMascotas() {
        iReciclerViewFragmentView.inicializarAdaptadorRV(iReciclerViewFragmentView.crearAdaptador(mascotas));
        iReciclerViewFragmentView.generarLinearLayoutVertical();
    }
}
