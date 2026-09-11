package ivisible;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import figures.*;

public interface IVisible {
    public boolean clicked (int x, int y);
    public void    paint   (Graphics g);
    public abstract void drag(Figure focus,Figure fig,MouseEvent evt,int cto,int dx,int dy);
}
