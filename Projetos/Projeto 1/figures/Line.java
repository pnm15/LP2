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
             getW(),getH(),getX(),getY());
    }
    @Override
    public Figure foco (MouseEvent evt,Figure fig) { 
 			int maiorx=0; int maiory=0; int menorx=0; int menory=0;
			if (getX() < (getX()+getW())) {
				 menorx = getX(); 
				maiorx = getX()+getW();
			} 
			if (getX() > (getX()+getW())) { 
				menorx = getX()+getW(); 
				maiorx = getX(); 
			} 
			if (getY() < (getY()+getH())) { 
				menory = getY(); 
				maiory = getY()+getH(); 
			} 
			if (getY() > (getY()+getH())) { 
				menory = getY()+getH(); 
				maiory = getY(); 
			}
			if (evt.getX() >= menorx && evt.getX() <= maiorx) {
				if( evt.getY() >= menory && evt.getY() <= maiory) { 
					 return fig;
				}
			}
			return null;
    }
    @Override
    public  int cantofig (MouseEvent evt) {
        int maiorx=0; int maiory=0; int menorx=0; int menory=0;
            if (getX() < (getX()+getW())) {
				 menorx = getX(); 
				maiorx = getX()+getW();
			} 
			if (getX() > (getX()+getW())) { 
				menorx = getX()+getW(); 
				maiorx = getX(); 
			} 
			if (getY() < (getY()+getH())) { 
				menory = getY(); 
				maiory = getY()+getH(); 
			} 
			if (getY() > (getY()+getH())) { 
				menory = getY()+getH(); 
				maiory = getY(); 
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
				setX(evt.getX()-dx);
                setY(evt.getY()-dy); 
			break;

			case 1:
			
				setW(getW()+getX()-evt.getX());
				setH(getH()+getY()-evt.getY());
				setX(evt.getX());
				setY(evt.getY());
				
			break;

			case 2:
				setW(getW()-getX()+evt.getX());
        		setH(getH()-getY()+evt.getY());
				
			break;
			}
		}	
    @Override
    public void paint (Graphics g,boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
	    g2d.setColor(getC());
   	    g2d.drawLine(getX(), getY(), getX() + getW(), getY() + getH());
        if (focused) {
            g2d.setPaint(Color.RED);
            g2d.drawLine(getX(), getY(), getX() + getW(), getY() + getH());
        }
        g2d.setPaint(Color.BLACK);
    }
}
