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
            this.w, this.h, this.x, this.y,this.c);
    }

    public void paint (Graphics g,boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
	g2d.setColor(this.c);
	g2d.fillRect(this.x,this.y, this.w,this.h);
    if (focused) {
            g2d.setPaint(Color.RED);
            g2d.fillRect(this.x-2,this.y-2, this.w+4,this.h+4);
        }
	g2d.setPaint(Color.BLACK);
	g2d.drawRect(this.x,this.y, this.w,this.h);

    }
}
