package com.mycompany.swingcompletomejorado;

import javax.swing.*;
import java.awt.*;

public class JPanelFormulario extends JFrame {

    private JTextField nombre;
    private JTextField dni;
    private JTextField edad;

    public JPanelFormulario() {
        setTitle("Formulario con JPanel");
        setSize(430, 260);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        nombre = new JTextField();
        dni = new JTextField();
        edad = new JTextField();

        JPanel panelDatos = new JPanel(new GridLayout(3, 2, 8, 8));
        panelDatos.setBorder(BorderFactory.createTitledBorder("Datos personales"));
        panelDatos.add(new JLabel("Nombre:"));
        panelDatos.add(nombre);
        panelDatos.add(new JLabel("DNI:"));
        panelDatos.add(dni);
        panelDatos.add(new JLabel("Edad:"));
        panelDatos.add(edad);

        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton aceptar = new JButton("Aceptar");
        JButton limpiar = new JButton("Limpiar");

        aceptar.addActionListener(e -> validar());
        limpiar.addActionListener(e -> {
            nombre.setText("");
            dni.setText("");
            edad.setText("");
        });

        panelBotones.add(aceptar);
        panelBotones.add(limpiar);

        add(panelDatos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void validar() {
        if (nombre.getText().trim().isEmpty() || dni.getText().trim().isEmpty() || edad.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos.", "Validación", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Formulario cargado correctamente.");
        }
    }
}
