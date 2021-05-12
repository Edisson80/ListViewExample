package com.df.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.df.listviewexample.models.Carro;

import java.util.ArrayList;

public class FormularioCarros extends AppCompatActivity implements View.OnClickListener {
    private EditText txtNombre;
    private EditText txtModelo;
    private EditText txtCilindrage;
    private EditText txtPrecio;
    private EditText txtUrlImagen;
    private Button btnGuardar;
    private Button btnListar;
    private ArrayList<Carro> listaCarros = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_carros);
        txtNombre = findViewById(R.id.txtNombre);
        txtCilindrage = findViewById(R.id.txtCilindrage);
        txtModelo = findViewById(R.id.txtModelo);
        txtPrecio = findViewById(R.id.txtPrecio);
        txtUrlImagen = findViewById(R.id.txtUrlImagen);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnListar = findViewById(R.id.btnListar);

        btnGuardar.setOnClickListener(this);
        btnListar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnGuardar) {
            agregarCarros();
        }
        if (v.getId() == R.id.btnListar) {
            Intent intemt = new Intent(this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("listaCarros", listaCarros);
            intemt.putExtras(bundle);
            startActivity(intemt);
        }

    }

    private void agregarCarros() {
        String nombre = txtNombre.getText().toString();
        String modelo = txtModelo.getText().toString();
        String cilindrage = txtCilindrage.getText().toString();
        String precio = txtPrecio.getText().toString();
        String imagen = txtUrlImagen.getText().toString();

        Carro carro = new Carro(nombre, modelo, cilindrage, precio, imagen);
        listaCarros.add(carro);
        limpiar();
    }

    private void limpiar() {
        txtNombre.getText().clear();
        txtModelo.getText().clear();
        txtCilindrage.getText().clear();
        txtPrecio.getText().clear();
        txtUrlImagen.getText().clear();
    }
}