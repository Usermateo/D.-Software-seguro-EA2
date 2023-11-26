
package com.mycompany.supermercado;


/**
 *Por medio de esta clase y sus metodos permite asignar los nombres a cada producto y sus precios
 * @author MATEO
 */
public class Producto {
        private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    
}
