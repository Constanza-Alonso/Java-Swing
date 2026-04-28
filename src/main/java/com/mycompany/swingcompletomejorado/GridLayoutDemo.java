package com.mycompany.swingcompletomejorado;

import javax.swing.*;
import java.awt.*;

public class GridLayoutDemo extends JFrame {

    private JTextField pantalla;

    public GridLayoutDemo() {
        setTitle("GridLayout - Teclado numérico");
        setSize(320, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        pantalla = new JTextField();
        pantalla.setEditable(false);
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setFont(new Font("Arial", Font.BOLD, 24));

        JPanel teclado = new JPanel(new GridLayout(4, 3, 6, 6));
        teclado.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] botones = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#"};
        for (String texto : botones) {
            JButton b = new JButton(texto);
            b.setFont(new Font("Arial", Font.BOLD, 20));
            b.addActionListener(e -> pantalla.setText(pantalla.getText() + texto));
            teclado.add(b);
        }

        add(pantalla, BorderLayout.NORTH);
        add(teclado, BorderLayout.CENTER);
    }
}
