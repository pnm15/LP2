package figures;
import java.awt.Graphics;
import java.awt.Color;
import ivisible.*;
import java.awt.event.*;

public abstract class Figure implements IVisible {
    public int x, y;
    public int w, h;
    public Color c;


    public Figure (int x, int y, int w, int h,Color c) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
	this.c=c;
    }
	
    public void drag (Figure focus,Figure fig,MouseEvent evt,int cto,int dx,int dy) {
	if (focus==fig) {
		switch(cto) {
			case 0:
				fig.x = evt.getX()-dx;
                                fig.y = evt.getY()-dy;
			break;

			case 1:
				if ((fig.w + fig.x -  evt.getX())>0) {
					if ((fig.h + fig.y -  evt.getY())>0) {
						fig.w += fig.x -  evt.getX();
                                		fig.h += fig.y - evt.getY();
						fig.x = evt.getX();
                                		fig.y = evt.getY();
					}
				}
			break;

			case 2:
				if((evt.getX() - fig.x)>0) {
					if ((fig.h+fig.y - evt.getY())>0) {
						fig.w=evt.getX() - fig.x;
						fig.h+=fig.y - evt.getY();
                                		fig.y = evt.getY();
					}
				}
			break;

			case 3:
				if ((fig.w + fig.x -  evt.getX())>0) {
					if((evt.getY()-fig.y)>0) {
						fig.w += fig.x -  evt.getX();
                                      		fig.h = evt.getY()-fig.y;
						fig.x = evt.getX();
					}
				}
			break;

			case 4:
				if ((evt.getX()-fig.x)>0) {
					if ((evt.getY()-fig.y)>0) {
						fig.w =evt.getX()-fig.x ;
                                      		fig.h = evt.getY()-fig.y;
					}
                                }
			break;
		}
	}	
    }
    public Figure  foco (Figure fig,MouseEvent evt) {
        if (fig.x <= evt.getX() && evt.getX() <= fig.x + fig.w) { 
		if(fig.y <= evt.getY() && evt.getY() <= fig.y + fig.h) {
			return fig;
		}
	}
	return null;
    }
    public int cantofig (Figure focus,Figure fig,MouseEvent evt) {
	if (focus!=null) {
		if (fig.x <= evt.getX() && evt.getX() <= fig.x + 5) { 
            		if(fig.y <= evt.getY() && evt.getY() <= fig.y + 5) {
            			return 1;
        		}
		}
        	if (fig.x + fig.w - 5 <= evt.getX() && evt.getX() <= fig.x + fig.w) {
            		if (fig.y <= evt.getY() && evt.getY() <= fig.y + 5) {
            			return 2;
			}
       		}
        	if (fig.x <= evt.getX() && evt.getX() <= fig.x + 5) {
            		if(fig.y + fig.h - 5 <= evt.getY() && evt.getY() <= fig.y + fig.h) {
            			return 3;
			}
        	}
        	if (fig.x + fig.w - 5 <= evt.getX() && evt.getX() <= fig.x + fig.w) {
            		if(fig.y + fig.h - 5 <= evt.getY() && evt.getY() <= fig.y + fig.h) {
            			return 4;
        		}
		}
	}
	return 0;
    }
    public boolean clicked (int x, int y) {
        return (this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
    }
    public abstract void paint (Graphics g);
}
