package com.mycompany.swingcompletomejorado;

import javax.swing.*;
import java.awt.*;

public class ComponentesBasicos extends JFrame {

    public ComponentesBasicos() {
        setTitle("Componentes básicos");
        setSize(430, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JTextField nombre = new JTextField(15);
        JCheckBox acepta = new JCheckBox("Acepto condiciones");
        JRadioButton alumno = new JRadioButton("Alumno");
        JRadioButton docente = new JRadioButton("Docente");
        JButton boton = new JButton("Mostrar");

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(alumno);
        grupo.add(docente);

        boton.addActionListener(e -> {
            String rol = alumno.isSelected() ? "Alumno" : docente.isSelected() ? "Docente" : "Sin rol";
            JOptionPane.showMessageDialog(this,
                    "Nombre: " + nombre.getText() +
                    "\nRol: " + rol +
                    "\nAcepta: " + (acepta.isSelected() ? "Sí" : "No"));
        });

        panel.add(new JLabel("Nombre:"));
        panel.add(nombre);
        panel.add(acepta);
        panel.add(alumno);
        panel.add(docente);
        panel.add(boton);

        add(panel);
    }
}
