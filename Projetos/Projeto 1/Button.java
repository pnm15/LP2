import ivisible.IVisible;
import figures.Figure;
import java.awt.Color;
import java.awt.*;

public class Button implements IVisible {
    private int SPC;
    private int DIM;
    private int PAD;

    private  int    idx;
    private  int    idxc;
    private Figure fig;
    
    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }
    
    public int getIdxc() {
        return idxc;
    }

    public void setIdxc(int idxc) {
        this.idxc = idxc;
    }
    
    public int getSPC() {
        return SPC;
    }

    public void setSPC(int SPC) {
        this.SPC = SPC;
    }
    
    public int getDIM() {
        return DIM;
    }

    public void setDIM(int DIM) {
        this.DIM = DIM;
    }
    
    public int getPAD() {
        return PAD;
    }

    public void setPAD(int PAD) {
        this.PAD = PAD;
    }
    
    public Button (int idx,int idxc,int SPC, int DIM,int PAD,Figure fig) {
        this.idx = idx;
        this.idxc = idxc;
        this.SPC = SPC;
        this.DIM = DIM;
        this.PAD = PAD;
        this.fig = fig;
        this.fig.setX(PAD + SPC);
        this.fig.setY(PAD + SPC + idx * DIM+idxc * DIM);
        this.fig.setW(DIM - PAD * 2);
        this.fig.setH(DIM - PAD * 2);
       
    }

    public boolean clicked (int x, int y) {
  return SPC<=x && x<=SPC+DIM && SPC+this.idx*DIM+this.idxc*DIM<=y && y<=SPC+
  this.idx*DIM+this.idxc*DIM+DIM;
    }

    public void paint (Graphics g,boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        
            g2d.setColor(focused ? Color.GRAY : Color.LIGHT_GRAY);
            g2d.fillRect(SPC, SPC+this.idx*DIM+this.idxc*DIM, DIM, DIM);

            g2d.setColor(Color.BLACK);
            g2d.drawRect(SPC, SPC+this.idx*DIM+this.idxc * DIM, DIM, DIM);
            this.fig.paint(g, false);
        
       
    }
}
