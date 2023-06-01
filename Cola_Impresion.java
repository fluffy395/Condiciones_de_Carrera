package Hilos.Procesos;

public class Cola_Impresion extends Thread {
    int siguiente_ranura_libre;
    String nombreArchivo;

    @Override
    public void run() {
        colocarArchivos();
    }

    public synchronized void colocarArchivos() { // Regresion critica
        /*
        * 1 Se lee la entrada (lee el archivo)
          2 siguiente_ranura_libre = entrada
          3 spooler[siguiente_ranura_libre] = nombreArchivo
          4 entrada = siguiente_ranura_libre + 1 (escribe en el archivo)
        * */
        // Se colocarán 2 documentos
        Variables_Compartidas.entrada = Archivo.leerEntrada();
        siguiente_ranura_libre = Variables_Compartidas.entrada;
        System.out.println("Ranura libre: " + siguiente_ranura_libre);
        nombreArchivo = Thread.currentThread().getName() + siguiente_ranura_libre + ".txt";
        Variables_Compartidas.spooler[siguiente_ranura_libre] = nombreArchivo;
        System.out.println(nombreArchivo);
        Variables_Compartidas.entrada = siguiente_ranura_libre + 1;
        Archivo.escribeEntrada("" + Variables_Compartidas.entrada);
        System.out.println("Siguiente ranura libre: " + Variables_Compartidas.entrada);
        System.out.println("-----------------------------");

    }
}