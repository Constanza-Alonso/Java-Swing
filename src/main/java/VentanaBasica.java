package com.mycompany.swingcompletomejorado;

import javax.swing.*;
import java.awt.*;

public class VentanaBasica extends JFrame {

    public VentanaBasica() {
        setTitle("Ventana básica mejorada");
        setSize(420, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel mensaje = new JLabel("Esta es una ventana JFrame centrada.", SwingConstants.CENTER);
        mensaje.setFont(new Font("Arial", Font.BOLD, 16));

        add(mensaje);
    }
}
