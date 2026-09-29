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
    boolean focused;
    Button focus_but=null;
    ArrayList<Figure> figs = new ArrayList<Figure>();
    ArrayList<Button> buts = new ArrayList<Button>();
    Figure focus = null;
    Random rand = new Random();
    int dx=0,dy=0;
    int cto=0;int i=0;
    int mx=0; int my=0;int mnx=0;int mny=0;
    Color c=null;
    PackFrame() {
        buts.add(new Button(0,new Rect (0,0,0,0,Color.BLACK)));
        buts.add(new Button(1,new Ellipse (0,0,0,0,Color.BLACK)));
        this.addWindowListener (
            new WindowAdapter() {
                    public void windowClosing (WindowEvent e) {
                        System.exit(0);
                    }
                }
            );
        this.addMouseListener (new MouseAdapter() {
                public void mousePressed (MouseEvent evt) {
                    int x = 100;
                    int y = 100;
                    int w = 20;
                    int h = 20;
		            int ang1 = rand.nextInt(20);
                    int ang2 = rand.nextInt(359);
                   
                    focus = null;
                    for (Figure fig : figs) {
			            if (fig.foco(evt,fig)!=null) {
                            
				            focus=fig.foco (evt,fig);
				            cto=fig.cantofig(evt);
				            dx=evt.getX()-fig.x;
		    		        dy=evt.getY()-fig.y;
			            }
		            }
		            if (focus!=null) {
		                figs.remove(focus);
		    		    figs.add(focus);
		    		}
                    if (focus_but!=null){ 
                             switch (focus_but.idx) {
                                case 0:
                                    
                                    Rect r = new Rect(evt.getX(),evt.getY(), w,h,c);
                                    figs.add(focus=r);
                                    
                                break;
                                case 1:
                                    
                                    figs.add(focus=new Ellipse(evt.getX(),evt.getY(), w,h,c));
                                    
                                break;
                                case 2:
                                    
                                break;
                                case 3:
                                    
                                break;
                            }
                            
                            focus_but=null;
                         }
                    for (Button but : buts) {
                        if (but.clicked(evt.getX() ,evt.getY())){
                            focus_but=but;
                            
                            
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
                        if (focus==fig) {
				            fig.drag(evt,cto,dx,dy);
                        }
                       }
			repaint();
                }
	    }
        );
        this.addKeyListener (new KeyAdapter() {
            public void keyPressed (KeyEvent evt) {
                    int x = 100;
                    int y = 100;
                    int w = 20;
                    int h = 20;
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
                    /*if (evt.getKeyChar() == '1') {
                        figs.add(new Carro(x,y, w,h,c));
                    } */
                    if (evt.getKeyChar() == '2') {
                        for (Figure fig: figs) {
                            if (focus!=null) {
                                int i=figs.indexOf(focus);
                                focus=figs.get((i+1)%figs.size());
                                break;
                                }
                            }
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
                   
                if (fig==focus) {
                    /*fig.paintfocus(g,fig.c);*/
                }
          
                    fig.paint(g,fig==focus);
                
                   
		   }
            for (Button but: this.buts){
                but.paint(g,but==focus_but);
            }
       }
    }
