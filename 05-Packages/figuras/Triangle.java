package figuras;

import java.awt.*;

public class Triangle{
    int[] x,y;

    public Triangle (int[] x, int[] y) {
        this.x = x;
        this.y = y;
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawPolygon(this.x,this.y,3);
    }
}
