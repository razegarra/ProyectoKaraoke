package com.example.android.proyectokaraoke.Entity;

import android.graphics.Bitmap;

/**
 * Created by USUARIO1 on 03/04/2016.
 */
public class PiqueoConfirm extends Piqueo {
    private Long id;
    private double cantidad;
    private double subtotal;

    public PiqueoConfirm(Long id, String titulo, String descripcion, String precio, double cantidad, double subtotal) {
        super(titulo, descripcion, precio);
        this.id = id;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public PiqueoConfirm() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
