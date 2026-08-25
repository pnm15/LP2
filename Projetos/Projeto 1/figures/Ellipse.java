package figures;
import ivisible.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figure {
    public Ellipse (int x, int y, int w, int h,int c1, int c2, int c3) {
        super(x,y,w,h,c1,c2,c3);
    }

    public void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y,this.c1,this.c2,this.c3);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	    g2d.setColor(new Color(this.c1,this.c2,this.c3));
	    g2d.fillOval(this.x,this.y, this.w,this.h);
	    g2d.setPaint(new Color(this.c3,this.c2,this.c1));
        g2d.drawOval(this.x,this.y, this.w,this.h);
    }
}
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
}
