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
//Foco quando a figura é selecioanada pelo cursor do mouse
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                focus = null;
                for (Figure fig : figs) {
                    if (fig.x <= evt.getX() && fig.y >= evt.getY()) {
                        focus = fig;
                    }
                }
            }
        });
//iterações quando a figura esta sendo arrastada no quadro
        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
            int x = evt.getX();
            int y = evt.getY();
            if (fig.x != evt.getX()) {
       
            }
            repaint();
        });
//Adiciona as figuras no quadro e no vetor figs dependendo da tecla digitada
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
