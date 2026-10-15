package figures;

import ivisible.*;
import java.awt.*;
import java.awt.event.*;

public class Arc extends Figure {
	private int ang1,ang2;
	
	public int getang1() {
        return ang1;
    }

    public void setang1(int ang1) {
        this.ang1 = ang1;
    }
    
    public int getang2() {
        return ang2;
    }

    public void setang2(int ang2) {
        this.ang2 = ang2;
    }
    	public Arc (int x, int y, int w, int h,Color c,int ang1,int ang2) {
        super(x,y,w,h,c);
	this.ang1=ang1;
	this.ang2=ang2;
    }

    public void print () {
        System.out.format("linha de tamanho (%d,%d) na posicao (%d,%d).\n",
             getW(),getH(),getX(),getY());
    }

    public void paint (Graphics g,boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
	g2d.setColor(getC());
   	g2d.drawArc(getX(),getY(), getW(),getH(), getang1(),getang2());
	g2d.fillArc(getX(),getY(), getW(),getH(), getang1(),getang2());
        if (focused) {
            g2d.setPaint(Color.RED);
            g2d.drawArc(getX()-2, getY()-2, getW()+4, getH()+4, getang1(),getang2());
        }
        g2d.setPaint(Color.BLACK);
    }
}

