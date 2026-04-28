package com.mycompany.swingcompletomejorado;

import javax.swing.*;
import java.awt.*;

public class DialogosDemo extends JFrame {

    public DialogosDemo() {
        setTitle("Cuadros de diálogo");
        setSize(360, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 1, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton mensaje = new JButton("Mostrar mensaje");
        JButton entrada = new JButton("Pedir nombre");
        JButton confirmacion = new JButton("Confirmar salida");

        mensaje.addActionListener(e -> JOptionPane.showMessageDialog(this, "Este es un mensaje informativo."));
        entrada.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog(this, "Ingrese su nombre:");
            if (nombre != null && !nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Hola, " + nombre);
            }
        });
        confirmacion.addActionListener(e -> {
            int r = JOptionPane.showConfirmDialog(this, "¿Desea cerrar esta ventana?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (r == JOptionPane.YES_OPTION) {
                dispose();
            }
        });

        panel.add(mensaje);
        panel.add(entrada);
        panel.add(confirmacion);

        add(panel);
    }
}
