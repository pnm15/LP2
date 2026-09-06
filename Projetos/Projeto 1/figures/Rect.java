package figures;
import ivisible.*;
import java.awt.*;

public class Rect extends Figure {
    public Rect (int x, int y, int w, int h, Color c,char k) {
        super(x,y,w,h,c,k);
    }
    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y,this.c);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g2d.setColor(this.c);
	g2d.fillRect(this.x,this.y, this.w,this.h);
	g2d.setPaint(Color.BLACK);
	g2d.drawRect(this.x,this.y, this.w,this.h);
    }
}
