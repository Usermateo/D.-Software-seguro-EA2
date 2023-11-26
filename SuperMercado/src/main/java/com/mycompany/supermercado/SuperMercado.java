package com.mycompany.supermercado;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 *Clase principal que permite la ejecución del programa 
 * Los clientes se asignan a las cajeras usando ExecutorService,
 * se envia la información a cada Sout para calcular el valor total y el tiempo transcurrido
 * @author MATEO
 */
public class SuperMercado {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Pablo");
        cliente1.agregarProducto(new Producto("Panela", 10.0));
        cliente1.agregarProducto(new Producto("Tomates", 5.0));

        Cliente cliente2 = new Cliente("Jose");
        cliente2.agregarProducto(new Producto("Pastas", 8.0));
        cliente2.agregarProducto(new Producto("Cebolla", 12.0));

        Cajera cajera1 = new Cajera("Sofia");
        Cajera cajera2 = new Cajera("Maria");

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            long startTime = System.currentTimeMillis();
            cajera1.procesarCompra(cliente1);
            long endTime = System.currentTimeMillis();
            calcularTotalYTiempo(cliente1, endTime - startTime);
        });

        executorService.submit(() -> {
            long startTime = System.currentTimeMillis();
            cajera2.procesarCompra(cliente2);
            long endTime = System.currentTimeMillis();
            calcularTotalYTiempo(cliente2, endTime - startTime);
        });

        executorService.shutdown();
    }

    private static void calcularTotalYTiempo(Cliente cliente, long tiempo) {
        double total = 0.0;
        for (Producto producto : cliente.getProductos()) {
            total += producto.getPrecio();
        }
        System.out.println("Total para " + cliente.getNombre() + ": $" + total);
        System.out.println("Tiempo de compra para " + cliente.getNombre() + ": " + tiempo + " milisegundos");
    }   
}
