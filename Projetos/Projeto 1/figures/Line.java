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
    public Figure foco (MouseEvent evt,Figure fig) { 
 			int maiorx=0; int maiory=0; int menorx=0; int menory=0;
			if (this.x < (this.x+this.w)) {
				 menorx = this.x; 
				maiorx = this.x+this.w;
			} 
			if (this.x > (this.x+this.w)) { 
				menorx = this.x+this.w; 
				maiorx = this.x; 
			} 
			if (this.y < (this.y+this.h)) { 
				menory = this.y; 
				maiory = this.y+fig.h; 
			} 
			if (this.y > (this.y+this.h)) { 
				menory = this.y+this.h; 
				maiory = this.y; 
			}
			if (evt.getX() >= menorx && evt.getX() <= maiorx) {
				if( evt.getY() >= menory && evt.getY() <= maiory) { 
					 return fig;
				}
			}
			return null;
    }
    @Override
    public int cantofig (MouseEvent evt) {
        int maiorx=0; int maiory=0; int menorx=0; int menory=0;
            if (this.x < (this.x+this.w)) {
				 menorx = this.x; 
				maiorx = this.x+this.w;
			} 
			if (this.x > (this.x+this.w)) { 
				menorx = this.x+this.w; 
				maiorx = this.x; 
			} 
			if (this.y < (this.y+this.h)) { 
				menory = this.y; 
				maiory = this.y+this.h; 
			} 
			if (this.y > (this.y+this.h)) { 
				menory = this.y+this.h; 
				maiory = this.y; 
			}
		if (menorx <= evt.getX() && evt.getX() <= (menorx + 5)) {
    			if(menory <= evt.getY() && evt.getY() <=(menory+5)) {
    				return 1;
			}
		}
		if ((maiorx-5) <= evt.getX() && evt.getX() <= maiorx) {
    			if(menory <= evt.getY() && evt.getY() <=(menory+5)) {
    				return 1;
			}
		}
		if ((maiorx - 5) <= evt.getX() && evt.getX() <= maiorx) {
    			if((maiory-5) <= evt.getY() && evt.getY() <= maiory) {
   				return 2;
			}
		}
		if (menorx <= evt.getX() && evt.getX() <= (menorx + 5)) {
    			if((maiory-5) <= evt.getY() && evt.getY() <= maiory) {
   				return 2;
			}
		}
	return 0;
    }
     @Override
     public void drag (MouseEvent evt,int cto,int dx,int dy) {
		switch(cto) {
			case 0:
				this.x = evt.getX()-dx;
                this.y = evt.getY()-dy;
			break;

			case 1:
			
				this.w+=this.x-evt.getX();
				this.h+=this.y-evt.getY();
				this.x=evt.getX();
				this.y=evt.getY();
				
			break;

			case 2:
				this.w = evt.getX() - this.x;
        		this.h = evt.getY() - this.y;
				
			break;
			}
		}	
    @Override
    public void paint (Graphics g,boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
	    g2d.setColor(this.c);
   	    g2d.drawLine(this.x, this.y, this.x + this.w, this.y + this.h);
    }
}
