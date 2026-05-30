package vista;

import controlador.Controlador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

        setLayout(new BorderLayout());
        add(scroll, BorderLayout.CENTER);
        add(boton, BorderLayout.SOUTH);

        // Guardar automáticamente al cerrar la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                controlador.guardarEstado();
                System.out.println("Estado guardado automáticamente antes de cerrar");
            }
        });

        setVisible(true);
        actualizarPantalla();
    }

    private void actualizarPantalla() {
        controlador.actualizarTodo();
        String texto = controlador.getCasa().getEstadoComoString();
        areaEstado.setText(texto);
    }
}