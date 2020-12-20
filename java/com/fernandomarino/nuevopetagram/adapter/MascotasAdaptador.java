package com.fernandomarino.nuevopetagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fernandomarino.nuevopetagram.R;
import com.fernandomarino.nuevopetagram.db.ConstructorMascotas;
import com.fernandomarino.nuevopetagram.pojo.Mascotas;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MascotasAdaptador extends RecyclerView.Adapter<MascotasAdaptador.MascotasViewHolder> {
    private ArrayList<Mascotas> mascotas;
    private Activity activity;

    public MascotasAdaptador(ArrayList<Mascotas> mascotas, Activity activity){

        this.mascotas = mascotas;
        this.activity = activity;
    }


    @NonNull
    @Override
    public MascotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);

        return new MascotasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotasViewHolder mascotasViewHolder, int position) {
        final Mascotas mascota = mascotas.get(position);
        mascotasViewHolder.fotoMascota.setImageResource(mascota.getFoto());
        mascotasViewHolder.tvNombreMascotaCV.setText(mascota.getNombre());
        mascotasViewHolder.tvVisitasCV.setText(String.valueOf(mascota.getVisitas()) + " " + activity.getString(R.string.hueseos));
        mascotasViewHolder.imgHuesear.setOnClickListener((v) -> {
            Snackbar.make(v, "Hueseaste a " + mascota.getNombre(), Snackbar.LENGTH_LONG).show();

            ConstructorMascotas constructorMascota = new ConstructorMascotas(activity);
            constructorMascota.darHueseoMascota(mascota);
            mascotasViewHolder.tvVisitasCV.setText(constructorMascota.obtenerHueseosMascota(mascota));
        });


    }


    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder{

        private ImageView fotoMascota;
        private TextView tvNombreMascotaCV;
        private TextView tvVisitasCV;
        private ImageButton imgHuesear;

        public MascotasViewHolder(View itemView) {
            super(itemView);

            fotoMascota        = (ImageView) itemView.findViewById(R.id.fotoMascota);
            tvNombreMascotaCV  = (TextView) itemView.findViewById(R.id.tvNombreMascotaCV);
            tvVisitasCV        = (TextView) itemView.findViewById(R.id.tvVisitasCV);
            imgHuesear         = (ImageButton) itemView.findViewById(R.id.imgHuesear);

        }
    }

}
