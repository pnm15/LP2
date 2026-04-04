import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class EllipseApp {
    public static void main (String[] args) {
        EllipseFrame frame = new EllipseFrame();
        frame.setVisible(true);
    }
}

class EllipseFrame extends JFrame {
    Ellipse e1,e2,e3;
    EllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Ellipse");
        this.setSize(350, 350);
        this.e1 = new Ellipse(25,150, 85,30,255,0,255);
	this.e2 = new Ellipse(110,95, 30,140,255,255,0);
	this.e3 = new Ellipse(140,95, 85,140,0,255,255);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
	this.e2.paint(g);
	this.e3.paint(g);
    }
}

class Ellipse {
    int x, y;
    int w, h;
    int c1,c2,c3;

    Ellipse (int x, int y, int w, int h,int c1,int c2,int c3) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
	this.c1=c1;
	this.c2=c2;
	this.c3=c3;
    }

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d), Cor:(%d,%d,%d).\n",
            this.w, this.h, this.x, this.y,this.c1,this.c2,this.c3);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g2d.setColor(new Color(this.c1,this.c2,this.c3));
	g2d.fillOval(this.x,this.y, this.w,this.h);
	g2d.setPaint(Color.black);
        g2d.drawOval(this.x,this.y, this.w,this.h);
    }
}
