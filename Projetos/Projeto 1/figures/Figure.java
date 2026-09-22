package figures;
import java.awt.Graphics;
import java.awt.Color;
import ivisible.*;

import java.io.Serializable;
import java.awt.event.*;

public abstract class Figure implements IVisible, Serializable {
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
    public void drag (MouseEvent evt,int cto,int dx,int dy) {
		switch(cto) {
			case 0:
				this.x = evt.getX()-dx;
                               this.y = evt.getY()-dy;
			break;

			case 1:
				if ((this.w + this.x -  evt.getX())>0) {
					if ((this.h + this.y -  evt.getY())>0) {
						this.w += this.x -  evt.getX();
                                		this.h += this.y - evt.getY();
						this.x = evt.getX();
                                		this.y = evt.getY();
					}
				}
			break;

			case 2:
				if((evt.getX() - this.x)>0) {
					if ((this.h+this.y - evt.getY())>0) {
						this.w=evt.getX() - this.x;
						this.h+=this.y - evt.getY();
                                		this.y = evt.getY();
					}
				}
			break;

			case 3:
				if ((this.w + this.x -  evt.getX())>0) {
					if((evt.getY()-this.y)>0) {
						this.w += this.x -  evt.getX();
                                      		this.h = evt.getY()-this.y;
						this.x = evt.getX();
					}
				}
			break;

			case 4:
				if ((evt.getX()-this.x)>0) {
					if ((evt.getY()-this.y)>0) {
						this.w=evt.getX()-this.x ;
                                      		this.h = evt.getY()-this.y;
					}
                                }
			break;
		}
	}	
    public Figure foco (MouseEvent evt,Figure fig) {
        if (this.x <= evt.getX() && evt.getX() <= this.x + this.w) { 
		    if(this.y <= evt.getY() && evt.getY() <= this.y + this.h) {
			    return fig; 
		    }
	    }
	return null;
    }
    public int cantofig (MouseEvent evt) {
		if (this.x <= evt.getX() && evt.getX() <= this.x + 5) { 
            		if(this.y <= evt.getY() && evt.getY() <= this.y + 5) {
            			return 1;
        		}
		}
        	if (this.x + this.w - 5 <= evt.getX() && evt.getX() <= this.x + this.w) {
            		if (this.y <= evt.getY() && evt.getY() <= this.y + 5) {
            			return 2;
			}
       		}
        	if (this.x <= evt.getX() && evt.getX() <= this.x + 5) {
            		if(this.y + this.h - 5 <= evt.getY() && evt.getY() <= this.y + this.h) {
            			return 3;
			}
        	}
        	if (this.x + this.w - 5 <= evt.getX() && evt.getX() <= this.x + this.w) {
            		if(this.y + this.h - 5 <= evt.getY() && evt.getY() <= this.y + this.h) {
            			return 4;
        		}
		}
	return 0;
    }
    public void paintfocus (Graphics g) {
            int x=this.x;
		        int y=this.y;
		        int w=this.w;
		        int h=this.h;
          
                    if(this.w<0) {
   	                 w=-w;
   	                 x-=w;
   	                }
   	            if(this.h<0) {
   	                 h=-h;
   	                 y-=h;
   	                }
   	                 g.setColor(Color.RED);
    		        g.drawRect(x, y, w, h);   
    
    }
    public boolean clicked (int x, int y) {
        return (this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
    }
    public abstract void paint (Graphics g,boolean focused) ;
  } 
