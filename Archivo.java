package Hilos.Procesos;

import java.io.*;

public class Archivo {
    public static int leerEntrada() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea = "";
        try {
            archivo = new File("variables.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura de Entrada
            linea = br.readLine();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Integer.parseInt(linea);
    }

    public static void escribeEntrada(String numero) {
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter("variables.txt",false);
            pw = new PrintWriter(fw);
            pw.print("" + numero); // Aqui se escribe en el archivo
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}