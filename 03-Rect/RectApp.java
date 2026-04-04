public class RectApp {
	public static void main (String[] args) {
		Rect r1 = new Rect(1,1,10,10);
		r1.drag(2,3);
		r1.print();
	}
}
class Rect {
	int x, y;
	int w, h;
	int a;
        Rect (int x, int y, int w, int h,int a;) {
             this.x=x;
             this.y=y;
             this.w=w;
             this.h=h;
             this.a=area();
        }
	int area (int w,int h) {
		this.a=w*h;
	}
	void drag (int dx, int dy){
		this.x+=dx; 
		this.y+=dy; 
	}
	void print () {
		System.out.format ("Tam (%d,%d) /
		Pos (%d,%d)/ Area (%d)\n",this.w, this.h, this.x, this.y,this.a);
	}
}
