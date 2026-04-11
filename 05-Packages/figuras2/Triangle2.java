package figuras2;

import java.awt.*;

public class Triangle2{
    int[] x,y;
    int c1,c2,c3;

    public Triangle2 (int[] x, int[] y,int c1,int c2,int c3) {
        this.x = x;
        this.y = y;
	this.c1=c1;
	this.c2=c2;
	this.c3=c3;
    }

     public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	      g2d.setColor(new Color(this.c1,this.c2,this.c3));
	      g2d.fillPolygon(this.x,this.y,3);
	      g2d.setPaint(Color.black);
        g2d.drawPolygon(this.x,this.y,3);
    }
}
