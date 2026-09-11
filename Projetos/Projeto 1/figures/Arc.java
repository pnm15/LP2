package figures;

import ivisible.*;
import java.awt.*;
import java.awt.event.*;

public class Arc extends Figure {
	public int ang1,ang2;
    	public Arc (int x, int y, int w, int h,Color c,int ang1,int ang2) {
        super(x,y,w,h,c);
	this.ang1=ang1;
	this.ang2=ang2;
    }

    public void print () {
        System.out.format("linha de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g2d.setColor(this.c);
   	g2d.drawArc(this.x, this.y, this.w, this.h, this.ang1,this.ang2);
	g2d.fillArc(this.x, this.y, this.w, this.h, this.ang1,this.ang2);
    }
}
