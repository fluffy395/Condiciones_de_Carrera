package Hilos.Procesos;

public class Prueba_Cola_Impresion {
    public static void main(String[] args) {
        Archivo.escribeEntrada("7");
        Cola_Impresion cola_impresionX = new Cola_Impresion();
        Thread procesoA = new Thread(cola_impresionX);
        procesoA.setName("A");
        Thread procesoB = new Thread(cola_impresionX);
        procesoB.setName("B");
        // Solo se arranca el hilo A
        procesoA.start();
        procesoB.start();
        // Hacer que el programa principal pueda continuar hasta
        // que se hayan ejecutado sus hilos hijo
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Hilo principal interrumpido");
            }
        } while (procesoA.isAlive() || procesoB.isAlive());
        // Se imprime el contenido de los primeros elementos de la cola de impresion
        System.out.println("-----------------------------");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": " + Variables_Compartidas.spooler[i]);
        }
    }
}