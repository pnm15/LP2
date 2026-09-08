package figures;
import java.awt.Graphics;
import ivisible.*;
import java.awt.Color;

public abstract class Figure implements IVisible {
    public int x, y;
    public int w, h;
    public Color c;
    public char k;

    public Figure (int x, int y, int w, int h, Color c,char k) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
	    this.c=c;
        this.k=k;
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
