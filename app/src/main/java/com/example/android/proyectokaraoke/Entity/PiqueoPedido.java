package com.example.android.proyectokaraoke.Entity;

/**
 * Created by USUARIO1 on 23/04/2016.
 */
public class PiqueoPedido extends Piqueo {
    private double cantidad;
    private double subtotal;

    public PiqueoPedido(String titulo, String descripcion, String precio, int imagen, boolean tipo, double cantidad, double subtotal) {
        super(titulo, descripcion, precio, imagen, tipo);
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public PiqueoPedido() {
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
