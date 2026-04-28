package com.mycompany.swingcompletomejorado;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutDemo extends JFrame {

    public FlowLayoutDemo() {
        setTitle("FlowLayout");
        setSize(380, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 20));

        panel.add(new JButton("Botón 1"));
        panel.add(new JButton("Botón 2"));
        panel.add(new JButton("Botón 3"));
        panel.add(new JButton("Botón 4"));

        add(panel);
    }
}
