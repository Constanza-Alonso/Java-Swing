package com.mycompany.swingcompletomejorado;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {
        setTitle("Swing Completo - Proyecto Mejorado");
        setSize(520, 620);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 1, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("Ejemplos Swing mejorados", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        add(titulo, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        agregarBoton(panel, "1. Ventana básica", () -> new VentanaBasica().setVisible(true));
        agregarBoton(panel, "2. Componentes básicos", () -> new ComponentesBasicos().setVisible(true));
        agregarBoton(panel, "3. FlowLayout", () -> new FlowLayoutDemo().setVisible(true));
        agregarBoton(panel, "4. GridLayout - teclado", () -> new GridLayoutDemo().setVisible(true));
        agregarBoton(panel, "5. BorderLayout", () -> new BorderLayoutDemo().setVisible(true));
        agregarBoton(panel, "6. Formulario con JPanel", () -> new JPanelFormulario().setVisible(true));
        agregarBoton(panel, "7. GridBagLayout", () -> new GridBagLayoutFormulario().setVisible(true));
        agregarBoton(panel, "8. Evento de botón", () -> new EventoBotonDemo().setVisible(true));
        agregarBoton(panel, "9. Saludo con JTextField", () -> new SaludoConTextField().setVisible(true));
        agregarBoton(panel, "10. Eventos de JTextField", () -> new EventosTextFieldDemo().setVisible(true));
        agregarBoton(panel, "11. Diálogos JOptionPane", () -> new DialogosDemo().setVisible(true));
        agregarBoton(panel, "12. Dibujo gráfico", () -> new DibujoGraficoDemo().setVisible(true));
        agregarBoton(panel, "13. MVC básico", () -> new MVCDemo().setVisible(true));
        agregarBoton(panel, "14. Eventos mouse/teclado",  () -> new EventosMouseTecladoDemo().setVisible(true));
    }

    private void agregarBoton(JPanel panel, String texto, Runnable accion) {
        JButton boton = new JButton(texto);
        boton.setFocusPainted(false);
        boton.addActionListener(e -> accion.run());
        panel.add(boton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
