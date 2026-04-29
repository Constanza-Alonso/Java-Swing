package com.mycompany.swingcompletomejorado;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutFormulario extends JFrame {

    public GridBagLayoutFormulario() {
        setTitle("Formulario con GridBagLayout");
        setSize(450, 260);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        agregar(panel, new JLabel("Nombre:"), 0, 0, 1, 1, 0);
        agregar(panel, new JTextField(20), 1, 0, 2, 1, 1);

        agregar(panel, new JLabel("Apellido:"), 0, 1, 1, 1, 0);
        agregar(panel, new JTextField(20), 1, 1, 2, 1, 1);

        agregar(panel, new JLabel("Correo:"), 0, 2, 1, 1, 0);
        agregar(panel, new JTextField(20), 1, 2, 2, 1, 1);

        JButton aceptar = new JButton("Aceptar");
        aceptar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Datos enviados."));
        agregar(panel, aceptar, 1, 3, 1, 1, 0);

        add(panel);
    }

    private void agregar(JPanel panel, Component componente, int x, int y, int ancho, int alto, double pesoX) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = ancho;
        gbc.gridheight = alto;
        gbc.weightx = pesoX;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(6, 6, 6, 6);
        panel.add(componente, gbc);
    }
}
