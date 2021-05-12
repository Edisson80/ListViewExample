package com.df.listviewexample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.df.listviewexample.models.Carro;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterCar extends BaseAdapter {
    protected Activity activity;
    protected ArrayList<Carro> listaCarros;

    public AdapterCar(Activity activity, ArrayList<Carro> listaCarros) {
        this.activity = activity;
        this.listaCarros = listaCarros;
    }

    @Override
    public int getCount() {
        return listaCarros.size();
    }

    @Override
    public Object getItem(int position) {
        return listaCarros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.car_item,null);
        }
        Carro carro = listaCarros.get(position);
        TextView nombreCarro = vista.findViewById(R.id.tvNombre);
        TextView precio = vista.findViewById(R.id.tvProcio);
        TextView modelo = vista.findViewById(R.id.tvModelo);
        TextView cilindrege = vista.findViewById(R.id.tvCilindrege);
        ImageView imagen = vista.findViewById(R.id.imgCarro);

        nombreCarro.setText(carro.getNombre());
        precio.setText(carro.getPrecio());
        modelo.setText(carro.getModelo());
        cilindrege.setText(carro.getCilindrage());
        Picasso.get()
                .load(carro.getImagen())
                .resize(100,100)
                .centerCrop()
                .error(R.mipmap.ic_launcher)
                .into(imagen);
        return vista;
    }
}
