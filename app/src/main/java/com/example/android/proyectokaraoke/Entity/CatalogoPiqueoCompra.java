package com.example.android.proyectokaraoke.Entity;

/**
 * Created by USUARIO1 on 03/04/2016.
 */
public class CatalogoPiqueoCompra extends CatalogoPiqueo {
    private int cantidad;
    private double subtotal;

    public CatalogoPiqueoCompra(String titulo, String descripcion, String precio, int imagen, boolean tipo, int cantidad, double subtotal) {
        super(titulo, descripcion, precio, imagen, tipo);
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public CatalogoPiqueoCompra() {
        super();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
