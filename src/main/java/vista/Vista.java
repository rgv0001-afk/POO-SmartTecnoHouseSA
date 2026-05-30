package vista;

import controlador.Controlador;
import javax.swing.*;
import java.awt.*;

public class Vista extends JFrame {

    private Controlador controlador;
    private JTextArea areaEstado;

    public Vista() {
        controlador = new Controlador();

        setTitle("Smart TecnoHouse - Sistema Domótico");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        areaEstado = new JTextArea();
        areaEstado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaEstado);

        JButton boton = new JButton("Actualizar Estado");
        boton.addActionListener(e -> actualizarPantalla());

        // Layout que sí funciona
        setLayout(new BorderLayout());
        add(scroll, BorderLayout.CENTER);
        add(boton, BorderLayout.SOUTH);

        setVisible(true);

        actualizarPantalla(); // primera carga
    }

    private void actualizarPantalla() {
        controlador.actualizarTodo();
        String texto = controlador.getCasa().getEstadoComoString();
        areaEstado.setText(texto);
    }
}