package modelo;

import java.io.Serializable;

public class TipoEntrada implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre, descripcion;
    private double precio;
    private int stockTotal;
    private int vendidos;

    public TipoEntrada(String nombre, String descripcion, double precio, int stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stockTotal = stock;
        this.vendidos = 0;
    }

    public void registrarVenta(int cantidad) {
        this.vendidos += cantidad;
    }

    public int getStockDisponible() {
        return stockTotal - vendidos;
    }

    public int getVendidos() {
        return vendidos;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStockTotal() {
        return stockTotal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStockTotal(int stockTotal) {
        this.stockTotal = stockTotal;
    }

    public void setVendidos(int vendidos) {
        this.vendidos = vendidos;
    }
}