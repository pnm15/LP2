package figuras;
import java.awt.Graphics;
import ivisible.*;

public abstract class Figure implements IVisible {
    public int x, y;
    public int w, h;
    public int c1,c2,c3;

    public Figure (int x, int y, int w, int h,int c1, int c2, int c3) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
	this.c1 = c1;
	this.c2 = c2;
	this.c3 = c3;
    }

    public void drag (int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public boolean clicked (int x, int y) {
        return (this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
    }
    public abstract void paint (Graphics g);
}
