package com.fernandomarino.nuevopetagram.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fernandomarino.nuevopetagram.R;
import com.fernandomarino.nuevopetagram.adapter.MascotasAdaptador;
import com.fernandomarino.nuevopetagram.pojo.Mascotas;
import com.fernandomarino.nuevopetagram.presentador.IReciclerViewFragmentPresenter;
import com.fernandomarino.nuevopetagram.presentador.ReciclerViewFragmentPresenter;

import java.util.ArrayList;


public class ReciclerWiev extends Fragment implements IReciclerViewFragmentView {

    ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;
    private IReciclerViewFragmentPresenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recicler_wiev, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.reciclerViewActivityMain);
        presenter = new ReciclerViewFragmentPresenter(this, getContext());

        return v;
    }
/*
    public void iniciarListaMascotas() {

        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas(R.drawable.p1, "Charlie", 2));
        mascotas.add(new Mascotas(R.drawable.p2, "Lolita", 4));
        mascotas.add(new Mascotas(R.drawable.p3,"Gaston", 3));
        mascotas.add(new Mascotas(R.drawable.p4, "Catalina", 5));
        mascotas.add(new Mascotas(R.drawable.p5, "Rodolfo", 1));
    }*/

    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

    }

    @Override
    public MascotasAdaptador crearAdaptador(ArrayList<Mascotas> mascotas) {
        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotasAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}