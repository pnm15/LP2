package figures;
import ivisible.*;
import java.awt.*;
import java.awt.event.*;
public class Carro extends Figure {
    Rect chassi;
    Ellipse roda1,roda2;

    public Carro (int x, int y, int w, int h, Color c) {
        super(x,y,w,h,c);
        this.chassi=new Rect(x,y,w,h,c);
        this.roda1=new Ellipse(x-w+10,y+h,w-10,h-10,c);
        this.roda2=new Ellipse(x+w,y+h,w-10,h-10,c);
    }
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
      g2d.setPaint(Color.BLACK);
 
	this.chassi.paint(g2d);
    this.roda1.paint(g2d);
    this.roda2.paint(g2d);
    g2d.setColor(this.c);
    }
    @Override
     public Figure foco (Figure fig,MouseEvent evt) {
        if ((fig.x-fig.w+10) <= evt.getX() && evt.getX() <= (fig.x+fig.w)) { 
		    if(fig.y <= evt.getY() && evt.getY() <= (fig.y + fig.h+fig.h-10)) {
			    return fig;
		    }
	    }
	return null;
    }
    @Override
    public void paintfocus (Graphics g,Figure focus,Figure fig) {
            if (fig==focus) {
   	                 g.setColor(Color.RED);
    		        g.drawRect(fig.x-fig.w+10,fig.y,fig.w+fig.w,fig.h+fig.h-10);   
		        }
    
    }

    @Override
    public void drag (Figure fig,MouseEvent evt,int cto,int dx,int dy) {
        cto=0;
        
		switch(cto) {
			case 0:
                fig.x = evt.getX()-dx;
                fig.y = evt.getY()-dy;
                this.roda1.x = evt.getX()-dx-this.roda1.w;
                this.roda1.y = evt.getY()-dy+this.chassi.h;
                this.roda2.x =evt.getX()-dx+this.chassi.w;
                this.roda2.y = evt.getY()-dy+this.chassi.h;
                
                this.chassi.drag(this.chassi,evt,cto,dx,dy);
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
    @Override
    public int cantofig (Figure focus,Figure fig,MouseEvent evt) {
	if (focus!=null) {
		if ((fig.x-fig.w+10) <= evt.getX() && evt.getX() <= (fig.x-fig.w+15)) { 
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

}
