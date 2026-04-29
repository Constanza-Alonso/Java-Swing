

package com.mycompany.formularioswingvalidado;
import javax.swing.SwingUtilities;

/**
 *
 * @author constanzaalonsowinter
 */
public class FormularioSwingValidado {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormularioContacto().setVisible(true));
    }
}
