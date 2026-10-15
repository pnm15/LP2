package figures;
import ivisible.*;
import java.awt.*;
import java.awt.event.*;
public class Rect extends Figure {
    public Rect (int x, int y, int w, int h, Color c) {
        super(x,y,w,h,c);
    }
    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            getW(), getH(), getX(), getY());
    }

    public void paint (Graphics g,boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
	g2d.setColor(getC());
	g2d.fillRect(getX(),getY(), getW(),getH());
    if (focused) {
            g2d.setPaint(Color.RED);
            g2d.drawRect(getX()-2,getY()-2, getW()+4,getH()+4);
        } 
	g2d.setPaint(Color.BLACK);
	g2d.drawRect(getX(),getY(), getW(),getH());

    }
}
