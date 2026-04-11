package figuras2;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse2 {
    int x, y;
    int w, h;
    int c1,c2,c3;

    public Ellipse2 (int x, int y, int w, int h,int c1,int c2,int c3) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
	this.c1=c1;
	this.c2=c2;
	this.c3=c3;
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.c1,this.c2,this.c3));
	g2d.fillOval(this.x,this.y, this.w,this.h);
	g2d.setPaint(Color.black);
        g2d.drawOval(this.x,this.y, this.w,this.h);
    }
}
