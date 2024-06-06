/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoTFG;

import java.awt.*;
import javax.swing.border.AbstractBorder;
/**
 *
 * @author Hugo
 */
public class ShadowBorder extends AbstractBorder{
    private int thickness;

    public ShadowBorder(int thickness) {
        this.thickness = thickness;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(thickness, thickness, thickness, thickness);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.top = insets.right = insets.bottom = thickness;
        return insets;
    }

@Override
public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
    Graphics2D g2d = (Graphics2D) g.create();

    int shadowSize = 25; // Tamaño de la sombra (aumentado)
    int shadowAlpha = 150; // Opacidad de la sombra (aumentada)

    Color shadowStartColor = new Color(0, 0, 0, 0); // Color de inicio del degradado (transparente)
    Color shadowEndColor = new Color(0, 0, 0, shadowAlpha); // Color de fin del degradado (opaco)

    // Crea un degradado de color para la sombra en la parte izquierda
    Paint paint = new GradientPaint(0, 0, shadowStartColor, shadowSize, 0, shadowEndColor);

    g2d.setPaint(paint);

    // Dibuja la sombra en el lado izquierdo
    g2d.fillRect(x, y + shadowSize, shadowSize, height - shadowSize);

    // Crea un degradado de color para la sombra en la parte inferior
    paint = new GradientPaint(0, height - shadowSize, shadowStartColor, 0, height, shadowEndColor);

    g2d.setPaint(paint);

    // Dibuja la sombra en la parte inferior (aumentando la difusión)
    g2d.fillRect(x + shadowSize, y + height - shadowSize, width - shadowSize * 2, shadowSize); // Se reduce el ancho en el doble del tamaño de la sombra para que no se superponga con la sombra izquierda

    g2d.dispose();
}
}
