package com.mycompany.swingcompletomejorado;

import javax.swing.*;
import java.awt.*;

public class EventoBotonDemo extends JFrame {

    private int contador = 0;

    public EventoBotonDemo() {
        setTitle("Evento de botón");
        setSize(320, 170);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel etiqueta = new JLabel("Clicks: 0", SwingConstants.CENTER);
        etiqueta.setFont(new Font("Arial", Font.BOLD, 18));

        JButton boton = new JButton("Pulsame");
        boton.addActionListener(e -> {
            contador++;
            etiqueta.setText("Clicks: " + contador);
            boton.setText("¡Gracias!");
        });

        add(etiqueta, BorderLayout.CENTER);
        add(boton, BorderLayout.SOUTH);
    }
}
