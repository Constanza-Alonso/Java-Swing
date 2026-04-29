package com.mycompany.formularioswingvalidado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormularioContacto extends JFrame {

    private JTextField txtNombre, txtApellido, txtDni, txtPasaporte,
            txtTelefono, txtCodigoPostal, txtDomicilio;

    public FormularioContacto() {
        setTitle("Carga de contacto");
        setSize(620, 430);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        txtNombre = new JTextField(20);
        txtApellido = new JTextField(20);
        txtDni = new JTextField(12);
        txtPasaporte = new JTextField(12);
        txtTelefono = new JTextField(18);
        txtCodigoPostal = new JTextField(6);
        txtDomicilio = new JTextField(30);

        agregarCampo(panel, "Nombre:", txtNombre, 0);
        agregarCampo(panel, "Apellido:", txtApellido, 1);
        agregarCampo(panel, "DNI:", txtDni, 2);
        agregarCampo(panel, "Pasaporte:", txtPasaporte, 3);
        agregarCampo(panel, "Teléfono:", txtTelefono, 4);
        agregarCampo(panel, "Código Postal:", txtCodigoPostal, 5);
        agregarCampo(panel, "Domicilio:", txtDomicilio, 6);

        JButton btnValidar = new JButton("Validar");
        JButton btnLimpiar = new JButton("Limpiar");
        JButton btnCerrar = new JButton("Cerrar");

        JPanel botones = new JPanel();
        botones.add(btnValidar);
        botones.add(btnLimpiar);
        botones.add(btnCerrar);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(15, 5, 5, 5);
        panel.add(botones, gbc);

        add(panel);

        // Validaciones por carácter
        soloLetras(txtNombre);
        soloLetras(txtApellido);
        soloNumeros(txtDni);
        soloNumeros(txtCodigoPostal);
        validarTelefonoPorCaracter();
        validarPasaportePorCaracter();

        // Límites de caracteres
        limitar(txtNombre, 20);
        limitar(txtApellido, 20);
        limitar(txtDni, 8);
        limitar(txtCodigoPostal, 4);
        limitar(txtDomicilio, 50);
        limitar(txtPasaporte, 9);

        btnValidar.addActionListener(e -> validarFormulario());
        btnLimpiar.addActionListener(e -> limpiarFormulario());
        btnCerrar.addActionListener(e -> cerrarFormulario());
    }

    private void agregarCampo(JPanel panel, String etiqueta, JTextField campo, int fila) {
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(6, 6, 6, 6);
        panel.add(new JLabel(etiqueta), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(campo, gbc);
    }

    private void soloLetras(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ' && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }
        });
    }

    private void soloNumeros(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }

    private void validarTelefonoPorCaracter() {
        txtTelefono.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == '+' || c == '(' || c == ')' || c == '-' || c == ' ')) {
                    e.consume();
                }
            }
        });
    }

    private void validarPasaportePorCaracter() {
        txtPasaporte.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (txtPasaporte.getText().length() == 0) {
                    if (!Character.isLetter(c)) {
                        e.consume();
                    }
                } else {
                    if (!Character.isDigit(c)) {
                        e.consume();
                    }
                }
            }
        });
    }

    private void limitar(JTextField campo, int max) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (campo.getText().length() >= max) {
                    e.consume();
                }
            }
        });
    }

    private void validarFormulario() {
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String dni = txtDni.getText().trim();
        String pasaporte = txtPasaporte.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String cp = txtCodigoPostal.getText().trim();
        String domicilio = txtDomicilio.getText().trim();

        if (nombre.isEmpty()) {
            mostrarError("Debe ingresar el nombre.");
            return;
        }

        if (apellido.isEmpty()) {
            mostrarError("Debe ingresar el apellido.");
            return;
        }

        if (!dni.isEmpty() && !pasaporte.isEmpty()) {
            mostrarError("Debe ingresar DNI o Pasaporte, no ambos.");
            return;
        }

        if (dni.isEmpty() && pasaporte.isEmpty()) {
            mostrarError("Debe ingresar DNI o Pasaporte.");
            return;
        }

        if (!dni.isEmpty()) {
            if (dni.length() != 8) {
                mostrarError("El DNI debe tener 8 dígitos.");
                return;
            }

            int valorDni = Integer.parseInt(dni);
            if (valorDni < 10000000 || valorDni > 60000000) {
                mostrarError("El DNI debe estar entre 10.000.000 y 60.000.000.");
                return;
            }
        }

        if (!pasaporte.isEmpty()) {
            if (!pasaporte.matches("[A-Za-z][0-9]{8}")) {
                mostrarError("El pasaporte debe tener 1 letra y 8 números. Ej: N39392288");
                return;
            }

            int numeroPasaporte = Integer.parseInt(pasaporte.substring(1));
            if (numeroPasaporte < 10000000 || numeroPasaporte > 60000000) {
                mostrarError("El número del pasaporte debe estar entre 10.000.000 y 60.000.000.");
                return;
            }
        }

        if (telefono.length() <= 6) {
            mostrarError("El teléfono debe tener más de 6 caracteres.");
            return;
        }

        if (cp.length() != 4) {
            mostrarError("El código postal debe tener 4 dígitos.");
            return;
        }

        if (domicilio.isEmpty()) {
            mostrarError("Debe ingresar el domicilio.");
            return;
        }

        JOptionPane.showMessageDialog(this, "Formulario validado correctamente.");
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error de validación", JOptionPane.ERROR_MESSAGE);
    }

    private void limpiarFormulario() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtDni.setText("");
        txtPasaporte.setText("");
        txtTelefono.setText("");
        txtCodigoPostal.setText("");
        txtDomicilio.setText("");
        txtNombre.requestFocus();
    }

    private void cerrarFormulario() {
        int opcion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea salir?",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION
        );

        if (opcion == JOptionPane.YES_OPTION) {
            dispose();
        }
    }
}