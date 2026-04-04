public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
	this.r2.paint(g);
	this.r3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    int c1,c2,c3;
    Rect (int x, int y, int w, int h,int c1,int c2,int c3) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
	this.c1=c1;
	this.c2=c2;
	this.c3=c3;
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d), Cor:(%d,%d,%d).\n",
            this.w, this.h, this.x, this.y,this.c1,this.c2,this.c3);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g2d.setColor(new Color(this.c1,this.c2,this.c3));
	g2d.fillRect(this.x,this.y, this.w,this.h);
	g2d.setPaint(Color.black);
	g2d.drawRect(this.x,this.y, this.w,this.h);
    }
}
