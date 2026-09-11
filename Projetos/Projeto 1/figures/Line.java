package figures;

import ivisible.*;
import java.awt.*;
import java.awt.event.*;


public class Line extends Figure {
    public Line (int x, int y, int w, int h,Color c) {
        super(x,y,w,h,c);
    }

    public void print () {
        System.out.format("linha de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
    @Override
    public Figure foco (Figure fig,MouseEvent evt) { 
 			int maiorx=0;
			int menory=0;
			int maiory=0;
			int menorx=0;
			if (fig.x < (fig.x+fig.w)) {
				 menorx = fig.x; 
				maiorx = fig.x+fig.w;
			} 
			if (fig.x > (fig.x+fig.w)) { 
				menorx = fig.x+fig.w; 
				maiorx = fig.x; 
			} 
			if (fig.y < (fig.y+fig.h)) { 
				menory = fig.y; 
				maiory = fig.y+fig.h; 
			} 
			if (fig.y > (fig.y+fig.h)) { 
				menory = fig.y+fig.h; 
				maiory = fig.y; 
			}
			if (evt.getX() >= menorx && evt.getX() <= maiorx) {
				if( evt.getY() >= menory && evt.getY() <= maiory) { 
					return fig;
				}
			}
			return null;
    }
    @Override
    public int cantofig (Figure focus, Figure fig,MouseEvent evt) {
        if (focus==fig){
		if (fig.x <= evt.getX() && evt.getX() <= (fig.x + 5)) {
    			if((fig.y - 5) <= evt.getY() && evt.getY() <=fig.y) {
    				return 1;
			}
		}
		if ((fig.x+fig.w - 5) <= evt.getX() && evt.getX() <= (fig.x+fig.w)){
    			if((fig.y+fig.h-5) <= evt.getY() && evt.getY() <= (fig.y+fig.h)) {
   				return 2;
			}
		}
	}
	return 0;
    }
     @Override
     public void drag (Figure focus,Figure fig,MouseEvent evt,int cto) {
	if (focus==fig) {
		switch(cto) {
			case 0:
				fig.x = evt.getX();
                                fig.y = evt.getY();
			break;

			case 1:
				fig.w+=fig.x-evt.getX();
				fig.h+=fig.y-evt.getY();
				fig.x=evt.getX();
				fig.y=evt.getY();
			break;

			case 2:
				fig.w = evt.getX() - fig.x;
        			fig.h = evt.getY() - fig.y;
			break;
		}	
	}
    }
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g2d.setColor(this.c);
   	g2d.drawLine(this.x, this.y, this.x + this.w, this.y + this.h);
    }
}
