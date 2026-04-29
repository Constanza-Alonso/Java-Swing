package com.mycompany.swingcompletomejorado;

import javax.swing.*;
import java.awt.*;

public class DibujoGraficoDemo extends JFrame {

    public DibujoGraficoDemo() {
        setTitle("Dibujo gráfico con Swing");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        add(new PanelDibujo());
    }

    static class PanelDibujo extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawString("Dibujo realizado con paintComponent()", 30, 30);
            g.drawRect(50, 60, 120, 80);
            g.drawOval(220, 60, 120, 80);
            g.drawLine(50, 190, 350, 190);

            g.fillRect(70, 220, 60, 60);
            g.fillOval(240, 220, 60, 60);
        }
    }
}
