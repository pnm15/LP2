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
                        if (fig.x <= evt.getX() && evt.getX() <= (fig.x + fig.w)  ) {
                            if (fig.y <= evt.getY() && evt.getY() <= (fig.y + fig.h)) {
                            focus = fig;
                            }
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
                                fig.x = evt.getX();
                                fig.y = evt.getY();
                            }
                        }
                }
        });
        this.addKeyListener (new KeyAdapter() {
            public void keyPressed (KeyEvent evt) {
                    int x = rand.nextInt(100);
                    int y = rand.nextInt(100);
                    int w = rand.nextInt(100);
                    int h = rand.nextInt(100);
	            int c1 = rand.nextInt(256);
		    int c2 = rand.nextInt(256);
		    int c3 = rand.nextInt(256);
                    if (evt.getKeyChar() == 'r') {
                        Rect r = new Rect(x,y, w,h,c1,c2,c3);
                        figs.add(r);
                    }
                    else if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y, w,h,c1,c2,c3));
                    }
		    else if (evt.getKeyChar() == 's') {
                        figs.add(new Square(x,y, h,h,c1,c2,c3));
                    }
	            else if (evt.getKeyChar() == 'c') {
                        figs.add(new Circle(x,y, w,w,c1,c2,c3));
                    }
		    for (Figure fig: figs) {
			if (focus==fig) {
				if (fig.w<340 && fig.h<340) {
		    			if (evt.getKeyChar() == 'i') {
                        			fig.w +=5;
                        			fig.h +=5;
                    			}
				}
				if (fig.w>5 && fig.h>5) {
		    			if (evt.getKeyChar() == 'd') {
                        			fig.w -=5;
                        			fig.h -=5;
                    			}
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
                fig.paint(g);
            }
        }
}
