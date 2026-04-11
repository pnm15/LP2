import figuras2.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PackApp2 {
    public static void main (String[] args) {
        PackFrame2 frame = new PackFrame2();
        frame.setVisible(true);
    }
}

class PackFrame2 extends JFrame {
    Rect2 r2;
    Ellipse2 e2;
    Triangle2 t2;

    PackFrame2 () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java Packages");
        this.setSize(350, 350);
        this.r2 = new Rect2(50,50, 100,30,255, 182, 193);
        this.e2 = new Ellipse2(50,100, 100,30,128, 128, 128);
        this.t2 = new Triangle2(new int[]{50, 100, 150},new int[]{180, 150, 180},144, 238, 144);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r2.paint(g);
        this.e2.paint(g);
        this.t2.paint(g);
    }
}
