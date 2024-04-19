package com.example.herenciaa.models;

public class Coche extends Automovil {
    private String cilindros;
    public Coche(String nombreAuto, String idAuto, String modeloAuto, String fecha, double precio) {
        super(nombreAuto, idAuto, modeloAuto, fecha, precio);
    }

}
