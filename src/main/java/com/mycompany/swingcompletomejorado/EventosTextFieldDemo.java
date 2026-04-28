package com.mycompany.swingcompletomejorado;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class EventosTextFieldDemo extends JFrame {

    public EventosTextFieldDemo() {
        setTitle("Eventos en JTextField");
        setSize(420, 210);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JTextField campo = new JTextField();
        JLabel contador = new JLabel("Caracteres: 0", SwingConstants.CENTER);
        JLabel espejo = new JLabel("Texto escrito: ", SwingConstants.CENTER);

        campo.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { actualizar(); }
            public void removeUpdate(DocumentEvent e) { actualizar(); }
            public void changedUpdate(DocumentEvent e) { actualizar(); }

            private void actualizar() {
                contador.setText("Caracteres: " + campo.getText().length());
                espejo.setText("Texto escrito: " + campo.getText());
            }
        });

        JPanel panel = new JPanel(new GridLayout(4, 1, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.add(new JLabel("Escriba algo:"));
        panel.add(campo);
        panel.add(contador);
        panel.add(espejo);

        add(panel);
    }
}
