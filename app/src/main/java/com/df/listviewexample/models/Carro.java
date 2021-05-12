package com.df.listviewexample.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Carro implements Parcelable {
    private String nombre;
    private String modelo;
    private String cilindrage;
    private String precio;
    private String imagen;

    public Carro(String nombre, String modelo, String cilindrage, String precio, String imagen) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.cilindrage = cilindrage;
        this.precio = precio;
        this.imagen = imagen;
    }

    protected Carro(Parcel in) {
        nombre = in.readString();
        modelo = in.readString();
        cilindrage = in.readString();
        precio = in.readString();
        imagen = in.readString();
    }

    public static final Creator<Carro> CREATOR = new Creator<Carro>() {
        @Override
        public Carro createFromParcel(Parcel in) {
            return new Carro(in);
        }

        @Override
        public Carro[] newArray(int size) {
            return new Carro[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCilindrage() {
        return cilindrage;
    }

    public void setCilindrage(String cilindrage) {
        this.cilindrage = cilindrage;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(modelo);
        dest.writeString(cilindrage);
        dest.writeString(precio);
        dest.writeString(imagen);
    }
}
