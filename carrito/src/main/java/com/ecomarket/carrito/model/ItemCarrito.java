package com.ecomarket.carrito.model;

public class ItemCarrito {
    private Long productoId;
    private String nombre;
    private int cantidad;
    private int precioTotal;

    public ItemCarrito() {}

    public ItemCarrito(Long productoId, String nombre, int cantidad, int precioTotal) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }

    public Long getProductoId() { return productoId; }
    public void setProductoId(Long productoId) { this.productoId = productoId; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public int getPrecioTotal() { return precioTotal; }
    public void setPrecioTotal(int precioTotal) { this.precioTotal = precioTotal; }
}