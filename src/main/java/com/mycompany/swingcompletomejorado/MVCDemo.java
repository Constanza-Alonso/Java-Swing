package com.mycompany.swingcompletomejorado;

import javax.swing.*;
import java.awt.*;

public class MVCDemo extends JFrame {

    private final ContadorModelo modelo;
    private final JLabel vistaContador;

    public MVCDemo() {
        setTitle("Ejemplo MVC básico");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        modelo = new ContadorModelo();

        vistaContador = new JLabel("Valor: 0", SwingConstants.CENTER);
        vistaContador.setFont(new Font("Arial", Font.BOLD, 24));

        JButton sumar = new JButton("Sumar");
        JButton restar = new JButton("Restar");
        JButton reiniciar = new JButton("Reiniciar");

        sumar.addActionListener(e -> {
            modelo.sumar();
            actualizarVista();
        });

        restar.addActionListener(e -> {
            modelo.restar();
            actualizarVista();
        });

        reiniciar.addActionListener(e -> {
            modelo.reiniciar();
            actualizarVista();
        });

        JPanel botones = new JPanel();
        botones.add(sumar);
        botones.add(restar);
        botones.add(reiniciar);

        add(vistaContador, BorderLayout.CENTER);
        add(botones, BorderLayout.SOUTH);
    }

    private void actualizarVista() {
        vistaContador.setText("Valor: " + modelo.getValor());
    }

    static class ContadorModelo {
        private int valor = 0;

        public void sumar() {
            valor++;
        }

        public void restar() {
            valor--;
        }

        public void reiniciar() {
            valor = 0;
        }

        public int getValor() {
            return valor;
        }
    }
}
