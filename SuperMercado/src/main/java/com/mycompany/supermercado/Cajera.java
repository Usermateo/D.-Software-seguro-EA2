package com.mycompany.supermercado;


/**
 *Esta clase inicializa los hilos para concatenar las demas variables
 * @author MATEO
 */
class Cajera implements Runnable {
    private String nombre;

    public Cajera(String nombre) {
        this.nombre = nombre;
    }

    public synchronized void procesarCompra(Cliente cliente) {
        System.out.println("Cajera " + nombre + " comienza a procesar la compra de " + cliente.getNombre());

        for (Producto producto : cliente.getProductos()) {
            System.out.println("Procesando producto: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
            try {
                // Simula el tiempo de procesamiento de cada producto
                Thread.sleep((long) (Math.random() * 3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Cajera " + nombre + " ha terminado de procesar la compra de " + cliente.getNombre());
    }

    @Override
    public void run() {
        // Este método se ejecutará cuando se inicie el hilo de la cajera
    }
}
