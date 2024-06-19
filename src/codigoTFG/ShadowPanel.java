/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoTFG;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Hugo
 */
public class ShadowPanel extends JPanel{
   
     private static final int SHADOW_SIZE = 10;

    public ShadowPanel() {
        setOpaque(false); // Ensure that the panel is not opaque
        setLayout(new BorderLayout()); // Set layout to BorderLayout
        setBorder(new ShadowBorder(SHADOW_SIZE)); // Add a shadow border
    }
}
