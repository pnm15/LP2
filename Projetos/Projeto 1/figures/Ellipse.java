package figures;

import ivisible.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.event.*;

public class Ellipse extends Figure {
    public Ellipse (int x, int y, int w, int h,Color c) {
        super(x,y,w,h,c);
    }

    public void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            getW(),getH(),getX(),getY());
    }

    public void paint (Graphics g,boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getC());
        g2d.fillOval(getX(),getY(), getW(),getH());
    if (focused) {
            g2d.setPaint(Color.RED);
            g2d.drawOval(getX()-2, getY()-2, getW()+4, getH()+4);
            
        }
    
  	 g2d.setPaint(Color.BLACK);
        g2d.drawOval(getX(),getY(), getW(),getH());
        
    }
}
