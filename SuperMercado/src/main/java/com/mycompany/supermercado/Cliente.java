package com.mycompany.supermercado;
import java.util.ArrayList;
import java.util.List;


/**
 *Por medio de esta clase permite almacenar en listas los productos asociados a cada cliente
 * @author MATEO
 */
public class Cliente {
        private String nombre;
    private List<Producto> productos;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }
    
}
