package com.mycompany.swingcompletomejorado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventosMouseTecladoDemo extends JFrame {

    private JLabel etiqueta;

    public EventosMouseTecladoDemo() {
        setTitle("Eventos de Mouse y Teclado");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        etiqueta = new JLabel("Interactúe con el mouse o teclado", SwingConstants.CENTER);

        add(etiqueta);

        // Evento teclado
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                etiqueta.setText("Tecla presionada: " + e.getKeyChar());
            }
        });

        // Evento mouse
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                etiqueta.setText("Click en: X=" + e.getX() + " Y=" + e.getY());
            }
        });

        setFocusable(true);
    }
}