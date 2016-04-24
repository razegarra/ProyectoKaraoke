package com.example.android.proyectokaraoke.Entity;

/**
 * Created by USUARIO1 on 03/04/2016.
 */
public class PiqueoConfirm extends Piqueo {
    private double cantidad;
    private double subtotal;

    public PiqueoConfirm(String titulo, String descripcion, String precio, int imagen, boolean tipo, double cantidad, double subtotal) {
        super(titulo, descripcion, precio, imagen, tipo);
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public PiqueoConfirm() {
        super();
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
