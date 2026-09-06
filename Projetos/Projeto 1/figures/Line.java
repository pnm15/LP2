package figures;

import ivisible.*;
import java.awt.*;


public class Line extends Figure {
    public Line (int x, int y, int w, int h,Color c,char k) {
        super(x,y,w,h,c,k);
    }

    public void print () {
        System.out.format("linha de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g2d.setColor(this.c);
   	g2d.drawLine(this.x, this.y, this.x + this.w, this.y + this.h);
    }
}
