import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Random;

import figures.*;
import ivisible.*;
public class PackApp {
     public static void main(String[] args) {
       PackFrame frame = new PackFrame();
        frame.setVisible(true);
     }
}  

class PackFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Figure focus = null;
    Random rand = new Random();
    int dx=0,dy=0;
    int cto=0;
    Color c=null;
    PackFrame() {
        this.addWindowListener (
            new WindowAdapter() {
                    public void windowClosing (WindowEvent e) {
                        System.exit(0);
                    }
                }
            );
        this.addMouseListener (new MouseAdapter() {
                public void mousePressed (MouseEvent evt) {
                    focus = null;
                    for (Figure fig : figs) {
			if (fig.foco(fig,evt)!=null) {
				focus=fig.foco ( fig,evt);
				cto=fig.cantofig(focus, fig,evt);
				dx=evt.getX()-fig.x;
		    		dy=evt.getY()-fig.y;
			}
		    }
		}	
                public void mouseReleased( MouseEvent evt ) {
                    repaint();
                }  
            }
        );
        this.addMouseMotionListener(
            new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent evt) {
                       for (Figure fig: figs) {
				fig.drag(focus, fig,evt,cto,dx,dy);
				
                       }
			repaint();
                }
	    }
        );
        this.addKeyListener (new KeyAdapter() {
            public void keyPressed (KeyEvent evt) {
                    int x = rand.nextInt(100);
                    int y = rand.nextInt(100);
                    int w = rand.nextInt(100);
                    int h = rand.nextInt(100);
		    int ang1 = rand.nextInt(20);
                    int ang2 = rand.nextInt(359);
		    if (evt.getKeyChar() == 'g') {
                        c=Color.GREEN;
                    }
		    if (evt.getKeyChar() == 'v') {
                        c=Color.RED;
                    }
		    if (evt.getKeyChar() == 'b') {
                        c=Color.BLUE;
                    }
		    if (evt.getKeyChar() == 'y') {
                        c=Color.YELLOW;
                    }
		    if (evt.getKeyChar() == 'o') {
                        c=Color.ORANGE;
                    }
		    if (evt.getKeyChar() == 'c') {
                        c=Color.GRAY;
                    }
		    if (evt.getKeyChar() == 'm') {
                        c=Color.MAGENTA;
                    }
		    if(c==null){
			c=Color.BLACK;
		    }
                    if (evt.getKeyChar() == 'r') {
                        
                        Rect r = new Rect(x,y, w,h,c);
                        figs.add(r);
                    }
                    else if (evt.getKeyChar() == 'e') {
                        
                        figs.add(new Ellipse(x,y, w,h,c));
                    }
                    else if (evt.getKeyChar() == 'l') {
                        
                        figs.add(new Line(x,y, w,h,c));
                    }
		    else if (evt.getKeyChar() == 'a') {
                        
                        figs.add(new Arc(x,y, w,h,c,ang1,ang2));
                    }
		    if(evt.getKeyCode() == evt.VK_BACK_SPACE) {
			figs.remove(focus);
		    }
		    for (Figure fig : figs) {
			if (focus==fig) {
				if(evt.getKeyCode() == 	evt.VK_UP) {
					fig.y-=5;
				}
				if(evt.getKeyCode() == 	evt.VK_LEFT) {
					fig.x-=5;
				}
				if(evt.getKeyCode() == 	evt.VK_DOWN) {
					fig.y+=5;
				}
				if(evt.getKeyCode() == 	evt.VK_RIGHT) {
					fig.x+=5;
				}
			}
		    }

		repaint();
   		}
        });
        this.setTitle("Editor grafico");
        this.setSize(350, 350);
}
        public void paint (Graphics g) {
            super.paint(g);
            for (Figure fig:this.figs) {
		int x=fig.x;
		int y=fig.y;
		int w=fig.w;
		int h=fig.h;
                fig.paint(g);
		if (fig==focus) {
			if (fig.w < 0) {
   		 		x +=fig.w;
    				w = -fig.w;
			}

			if (fig.h < 0) {
    				y += fig.h;
    				h = -fig.h;
			}		
    			g.setColor(Color.RED);
    			g.drawRect(x, y, w, h);
			}
		}
         }
}
