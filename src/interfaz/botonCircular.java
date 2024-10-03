
package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
//constructor
public class botonCircular extends JButton {

    public botonCircular(String texto) {
        super(texto);
        setContentAreaFilled(false);
        setFocusPainted(false);
    }
//funcionabilidades externos para darle forma a tus venatanas como(darle color,figura.estilo...ect
    // darle forma a tus botones y cada cuadro de cad numero o letras.
    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.LIGHT_GRAY); 
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getWidth() - 1, getHeight() - 1);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        int diameter = Math.max(size.width, size.height);
        size.setSize(diameter, diameter);
        return size;
    }

    @Override
    public boolean contains(int x, int y) {
        Ellipse2D circle = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        return circle.contains(x, y);
    }
}

