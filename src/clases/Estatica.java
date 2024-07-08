package clases;

import java.io.*;

public class Estatica {

    private static int contadorID;

    static {
        // Se carga el valor del contador desde el archivo al iniciar la clase
        try (BufferedReader br = new BufferedReader(new FileReader("contador.txt"))) {
            String linea = br.readLine();
            if (linea != null && !linea.isEmpty()) {
                contadorID = Integer.parseInt(linea);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private int id;
    private String nombre;
    private double precio;

    public Estatica(String nombre, double precio) {
        this.id = ++contadorID;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public static void guardarContador() {
        // Guardar el valor del contador en el archivo al detener el programa
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("contador.txt"))) {
            bw.write(Integer.toString(contadorID));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}