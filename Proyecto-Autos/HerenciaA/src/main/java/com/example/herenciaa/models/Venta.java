package com.example.herenciaa.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    private SimpleStringProperty nombreAuto;
    private SimpleStringProperty idAuto;
    private SimpleStringProperty modeloAuto;
    private SimpleStringProperty fecha;
    private SimpleDoubleProperty precio;
    private SimpleStringProperty idVenta;
    private static List<Venta> listaVentas = new ArrayList<>();

    public Venta(String nombreAuto, String idAuto, String modeloAuto, String fecha, double precio, String idVenta) {
        this.nombreAuto = new SimpleStringProperty(nombreAuto);
        this.idAuto = new SimpleStringProperty(idAuto);
        this.modeloAuto = new SimpleStringProperty(modeloAuto);
        this.fecha = new SimpleStringProperty(fecha);
        this.precio = new SimpleDoubleProperty(precio);
        this.idVenta = new SimpleStringProperty(idVenta);
    }

    public String getNombreAuto() {
        return nombreAuto.get();
    }

    public SimpleStringProperty nombreAutoProperty() {
        return nombreAuto;
    }

    public void setNombreAuto(String nombreAuto) {
        this.nombreAuto.set(nombreAuto);
    }

    public String getIdAuto() {
        return idAuto.get();
    }

    public SimpleStringProperty idAutoProperty() {
        return idAuto;
    }

    public void setIdAuto(String idAuto) {
        this.idAuto.set(idAuto);
    }

    public String getModeloAuto() {
        return modeloAuto.get();
    }

    public SimpleStringProperty modeloAutoProperty() {
        return modeloAuto;
    }

    public void setModeloAuto(String modeloAuto) {
        this.modeloAuto.set(modeloAuto);
    }

    public String getFecha() {
        return fecha.get();
    }

    public SimpleStringProperty fechaProperty() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha.set(fecha);
    }

    public double getPrecio() {
        return precio.get();
    }

    public SimpleDoubleProperty precioProperty() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio.set(precio);
    }

    public String getIdVenta() {
        return idVenta.get();
    }

    public SimpleStringProperty idVentaProperty() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta.set(idVenta);
    }

    public static List<Venta> getListaVentas() {
        return listaVentas;
    }

    public static void setListaVentas(List<Venta> listaVentas) {
        Venta.listaVentas = listaVentas;
    }

    public static void agregarVenta(Venta venta) {
        listaVentas.add(venta);
    }
}
