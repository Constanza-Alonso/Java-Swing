package com.mycompany.swingcompletomejorado;

import javax.swing.*;
import java.awt.*;

public class SaludoConTextField extends JFrame {

    private JTextField campoNombre;
    private JLabel resultado;

    public SaludoConTextField() {
        setTitle("Saludo con JTextField");
        setSize(380, 210);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 1, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        campoNombre = new JTextField();
        JButton saludar = new JButton("Saludar");
        resultado = new JLabel("Ingrese un nombre y presione Saludar", SwingConstants.CENTER);

        saludar.addActionListener(e -> saludar());

        panel.add(new JLabel("Nombre:"));
        panel.add(campoNombre);
        panel.add(saludar);
        panel.add(resultado);

        add(panel);
    }

    private void saludar() {
        String nombre = campoNombre.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre.", "Atención", JOptionPane.WARNING_MESSAGE);
        } else {
            resultado.setText("¡Hola, " + nombre + "!");
        }
    }
}
