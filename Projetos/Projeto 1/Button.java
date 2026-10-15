import ivisible.IVisible;
import figures.Figure;
import java.awt.Color;
import java.awt.*;

public class Button implements IVisible {
    private int SPC = 40;
    private int DIM = 40;
    private int PAD = 4;

    private  int    idx;
    private Figure fig;
    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }
    public Button (int idx, Figure fig) {
        this.idx = idx;
        this.fig = fig;
        this.fig.setX(PAD + SPC);
        this.fig.setY(PAD + SPC + idx * DIM);
        this.fig.setW(DIM - PAD * 2);
        this.fig.setH(DIM - PAD * 2);
       
    }

    public boolean clicked (int x, int y) {
        return SPC<=x && x<=SPC+DIM && SPC+this.idx*DIM<=y && y<=SPC+this.idx*DIM+DIM;
    }

    public void paint (Graphics g,boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        /*if (focused) { */
            g2d.setColor(focused ? Color.GRAY : Color.LIGHT_GRAY);
            g2d.fillRect(SPC, SPC+this.idx*DIM, DIM, DIM);

            g2d.setColor(Color.BLACK);
            g2d.drawRect(SPC, SPC+this.idx*DIM, DIM, DIM);
            this.fig.paint(g, false);
        /* } */
       /* else {
    
            g2d.setColor( focused ? Color.GRAY : Color.LIGHT_GRAY);
            g2d.fillRect(SPC, SPC+this.idx*DIM, DIM, DIM);

            g2d.setColor(Color.BLACK);
            g2d.drawRect(SPC, SPC+this.idx*DIM, DIM, DIM);
        this.fig.paint(g, false);
        } */
    }
}
