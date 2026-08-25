package figuras;
import ivisible.*;
import java.awt.*;

public class Rect extends Figure {
    public Rect (int x, int y, int w, int h, int c1, int c2, int c3) {
        super(x,y,w,h,c1,c2,c3);
    }
    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y,this.c1,this.c2,this.c3);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g2d.setColor(new Color(this.c1,this.c2,this.c3));
	g2d.fillRect(this.x,this.y, this.w,this.h);
	g2d.setPaint(new Color(c3,c2,c1));
	g2d.drawRect(this.x,this.y, this.w,this.h);
    }
}
