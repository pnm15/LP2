import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Random;

import figuras.*;
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
                        int sum1=fig.x+fig.w;
                        int sum2=fig.y+fig.h;
                        if (fig.x <= evt.getX() && evt.getX() <= sum1 ) {
                            if (fig.y >= evt.getY() && evt.getY() >= sum2) {
                            focus = fig;
                            }
                        }
                    repaint();
                    }
                }
                public void mouseReleased( MouseEvent evt ) {
                    focus=null;
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
                    int x = rand.nextInt(350);
                    int y = rand.nextInt(350);
                    int w = rand.nextInt(50);
                    int h = rand.nextInt(50);
                    if (evt.getKeyChar() == 'r') {
                        Rect r = new Rect(x,y, w,h);
                        figs.add(r);
                    }
                    else if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y, w,h));
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
