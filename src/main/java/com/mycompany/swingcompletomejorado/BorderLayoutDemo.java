package com.mycompany.swingcompletomejorado;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo extends JFrame {

    public BorderLayoutDemo() {
        setTitle("BorderLayout");
        setSize(420, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout(5, 5));

        add(new JButton("NORTE"), BorderLayout.NORTH);
        add(new JButton("SUR"), BorderLayout.SOUTH);
        add(new JButton("ESTE"), BorderLayout.EAST);
        add(new JButton("OESTE"), BorderLayout.WEST);

        JLabel centro = new JLabel("CENTRO", SwingConstants.CENTER);
        centro.setFont(new Font("Arial", Font.BOLD, 22));
        centro.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(centro, BorderLayout.CENTER);
    }
}
