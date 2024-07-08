import clases.Estatica;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Contador de Productos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        // Crear el botón para iniciar el contador
        JButton iniciarButton = new JButton("Iniciar Contador");
        frame.add(iniciarButton);

        // Crear el área de texto para mostrar el contenido del archivo
        JTextArea textArea = new JTextArea(10, 25);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);

        // Acción del botón para iniciar el contador
        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear un nuevo producto para incrementar el contador
                Estatica estatica = new Estatica("Producto", 29.99);

                // Mostrar el ID del nuevo producto en el área de texto
                textArea.append("Nuevo producto creado con ID: " + estatica.getId() + "\n");

                // Guardar el contador en el archivo
                Estatica.guardarContador();
            }
        });

        // Crear el botón para mostrar el contenido del archivo
        JButton mostrarButton = new JButton("Mostrar Contenido del Archivo");
        frame.add(mostrarButton);

        // Acción del botón para mostrar el contenido del archivo
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (BufferedReader br = new BufferedReader(new FileReader("contador.txt"))) {
                    String linea;
                    textArea.setText(""); // Limpiar el área de texto
                    while ((linea = br.readLine()) != null) {
                        textArea.append(linea + "\n");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Crear el botón para salir del programa
        JButton salirButton = new JButton("Salir");
        frame.add(salirButton);

        // Acción del botón para salir del programa
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Mostrar la ventana
        frame.setVisible(true);
    }
}