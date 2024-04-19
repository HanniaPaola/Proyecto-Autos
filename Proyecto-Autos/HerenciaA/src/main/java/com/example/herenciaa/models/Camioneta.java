package com.example.herenciaa.models;

public class Camioneta extends Automovil {
    private String cabina;
    public Camioneta(String nombreAuto, String idAuto, String modeloAuto, String fecha, double precio) {
        super(nombreAuto, idAuto, modeloAuto, fecha, precio);
    }
}
