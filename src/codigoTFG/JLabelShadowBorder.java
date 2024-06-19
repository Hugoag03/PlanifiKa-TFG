/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoTFG;

/**
 *
 * @author Hugo
 */

import java.awt.*;
import javax.swing.border.*;

public class JLabelShadowBorder extends AbstractBorder{
     private int thickness;

    public JLabelShadowBorder(int thickness) {
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

    int shadowSize = 20; // Tamaño de la sombra
    int shadowAlpha = 150; // Opacidad de la sombra

    Color shadowStartColor = new Color(0, 0, 0, 0); // Color de inicio del degradado (transparente)
    Color shadowEndColor = new Color(0, 0, 0, shadowAlpha); // Color de fin del degradado (opaco)

    // Crea un degradado de color para la sombra en la parte izquierda
    Paint paint = new GradientPaint(0, 0, shadowStartColor, shadowSize, 0, shadowEndColor);

    g2d.setPaint(paint);

    // Dibuja la sombra en la parte izquierda
    g2d.fillRect(x, y, shadowSize, height);

    // Crea un degradado de color para la sombra en la parte inferior
    paint = new GradientPaint(0, height - shadowSize, shadowStartColor, 0, height, shadowEndColor);

    g2d.setPaint(paint);

    // Dibuja la sombra en la parte inferior
    g2d.fillRect(x + shadowSize, y + height - shadowSize, width - shadowSize, shadowSize);

    g2d.dispose();

    // Pinta el componente (JLabel) encima de la sombra
    super.paintBorder(c, g, x, y, width, height);
}
}
