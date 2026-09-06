import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Random;

import figures.*;
import ivisible.*;
public class PackApp {
     public static void main(String[] args) {
       PackFrame frame = new PackFrame();
        frame.setVisible(true);
     }
}  

class PackFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Figure focus = null;
    Random rand = new Random();
    int cse=0,csd=0,cie=0,cid=0;
    int maiorx=0,menorx=0,maiory=0,menory=0;
    int cim=0,bxo=0;
    Color c=null;
    PackFrame() {
        this.addWindowListener (
            new WindowAdapter() {
                    public void windowClosing (WindowEvent e) {
                        System.exit(0);
                    }
                }
            );
        this.addMouseListener (new MouseAdapter() {
                public void mousePressed (MouseEvent evt) {
                    focus = null;
		    cse=csd=cie=cid=0;
		    cim=bxo=0;
                    for (Figure fig : figs) {
			
    			if (fig.k == 'e' || fig.k == 'r'||fig.k=='a') {
        			if (fig.x <= evt.getX() && evt.getX() <= fig.x + fig.w) { 
					if(fig.y <= evt.getY() && evt.getY() <= fig.y + fig.h) {
						focus = fig;
					}
				}
       			}
			if (fig.k == 'e' || fig.k == 'r'|| fig.k=='a'){
        			if (fig.x <= evt.getX() && evt.getX() <= fig.x + 5) { 
            				if(fig.y <= evt.getY() && evt.getY() <= fig.y + 5) {
            					cse = 1;
        				}
				}
        			if (fig.x + fig.w - 5 <= evt.getX() && evt.getX() <= fig.x + fig.w) {
            				if (fig.y <= evt.getY() && evt.getY() <= fig.y + 5) {
            					csd = 1;
					}
       				}
        			if (fig.x <= evt.getX() && evt.getX() <= fig.x + 5) {
            				if(fig.y + fig.h - 5 <= evt.getY() && evt.getY() <= fig.y + fig.h) {
            					cie = 1;
					}
        			}
        			if (fig.x + fig.w - 5 <= evt.getX() && evt.getX() <= fig.x + fig.w) {
            				if(fig.y + fig.h - 5 <= evt.getY() && evt.getY() <= fig.y + fig.h) {
            					cid = 1;
        				}
				}
			}
    			if (fig.k == 'l') { 
 				maiorx=menory=maiory=menorx=0;
				if (fig.x < (fig.x+fig.w)) {
				 	menorx = fig.x; 
					maiorx = fig.x+fig.w;
				 } 
				if (fig.x > (fig.x+fig.w)) { 
					menorx = fig.x+fig.w; 
					maiorx = fig.x; } 
				if (fig.y < (fig.y+fig.h)) { 
					menory = fig.y; 
					maiory = fig.y+fig.h; 
				} 
				if (fig.y > (fig.y+fig.h)) { 
					menory = fig.y+fig.h; 
					maiory = fig.y; 
				}
				if (evt.getX() >= menorx && evt.getX() <= maiorx) {
					if( evt.getY() >= menory && evt.getY() <= maiory) { 
					focus = fig;
					}
				 }
				if (fig.x <= evt.getX() && evt.getX() <= (fig.x + 5))
    					if((fig.y - 5) <= evt.getY() && evt.getY() <=fig.y) {
    						cim = 1;
					}

				if ((fig.x+fig.w - 5) <= evt.getX() && evt.getX() <= (fig.x+fig.w)){
    					if((fig.y+fig.h-5) <= evt.getY() && evt.getY() <= (fig.y+fig.h)) {
   					bxo = 1;
					}
				}
			}
		}
	}	
                public void mouseReleased( MouseEvent evt ) {
                    repaint();
                }  
            }
        );
        this.addMouseMotionListener(
            new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent evt) {
                       for (Figure fig: figs) {
				if (fig==focus) {
  					if(fig.k == 'l') {
						if (cim==1) {
							fig.w+=fig.x-evt.getX();
							fig.h+=fig.y-evt.getY();
							fig.x=evt.getX();
							fig.y=evt.getY();	
						}
						else if (bxo == 1) {
        						fig.w = evt.getX() - fig.x;
        						fig.h = evt.getY() - fig.y;
    						}
						else{
                                      			fig.x = evt.getX();
                                      			fig.y = evt.getY();
						}
                                	}
                               		 if (fig.k == 'r' || fig.k==  'e'||fig.k=='a' ) {
						if (cse == 1) {
							if ((fig.w + fig.x -  evt.getX())>0 &&
							(fig.h + fig.y -  evt.getY())>0) {
								fig.w += fig.x -  evt.getX();
                                      				fig.h += fig.y - evt.getY();
								fig.x = evt.getX();
                                				fig.y = evt.getY();
							}
                                		}
						else if (csd==1) {
							if((evt.getX() - fig.x)>0 && (fig.h+fig.y - evt.getY())>0) {
								fig.w=evt.getX() - fig.x;
								fig.h+=fig.y - evt.getY();
                                				fig.y = evt.getY();
							}
						}
						else if (cie == 1) {
							if ((fig.w + fig.x -  evt.getX())>0) {
								if((evt.getY()-fig.y)>0) {
								fig.w += fig.x -  evt.getX();
                                      				fig.h = evt.getY()-fig.y;
								fig.x = evt.getX();
								}
							}
                                		}
						else if (cid == 1) {
							if ((evt.getX()-fig.x)>0 &&
							(evt.getY()-fig.y)>0) {
								fig.w =evt.getX()-fig.x ;
                                      				fig.h = evt.getY()-fig.y;
							}
                                		}
						else {
							fig.x = evt.getX();
                                			fig.y = evt.getY();
                              			}
					}
				}
                       }
                }
        });
        this.addKeyListener (new KeyAdapter() {
            public void keyPressed (KeyEvent evt) {
                    int x = rand.nextInt(100);
                    int y = rand.nextInt(100);
                    int w = rand.nextInt(100);
                    int h = rand.nextInt(100);
		    int ang1 = rand.nextInt(20);
                    int ang2 = rand.nextInt(359);
		    if (evt.getKeyChar() == 'g') {
                        c=Color.GREEN;
                    }
		    if (evt.getKeyChar() == 'v') {
                        c=Color.RED;
                    }
		    if (evt.getKeyChar() == 'b') {
                        c=Color.BLUE;
                    }
		    if (evt.getKeyChar() == 'y') {
                        c=Color.YELLOW;
                    }
		    if (evt.getKeyChar() == 'o') {
                        c=Color.ORANGE;
                    }
		    if (evt.getKeyChar() == 'c') {
                        c=Color.GRAY;
                    }
		    if (evt.getKeyChar() == 'm') {
                        c=Color.MAGENTA;
                    }
		    if(c==null){
			c=Color.BLACK;
		    }
                    if (evt.getKeyChar() == 'r') {
                        char k='r';
                        Rect r = new Rect(x,y, w,h,c,k);
                        figs.add(r);
                    }
                    else if (evt.getKeyChar() == 'e') {
                        char k='e';
                        figs.add(new Ellipse(x,y, w,h,c,k));
                    }
                    else if (evt.getKeyChar() == 'l') {
                        char k='l';
                        figs.add(new Line(x,y, w,h,c,k));
                    }
		    else if (evt.getKeyChar() == 'a') {
                        char k='a';
                        figs.add(new Arc(x,y, w,h,c,k,ang1,ang2));
                    }
		    if(evt.getKeyCode() == evt.VK_BACK_SPACE) {
			figs.remove(focus);
		    }
		    for (Figure fig : figs) {
			if (focus==fig) {
				if(evt.getKeyCode() == 	evt.VK_UP) {
					fig.y-=5;
				}
				if(evt.getKeyCode() == 	evt.VK_LEFT) {
					fig.x-=5;
				}
				if(evt.getKeyCode() == 	evt.VK_DOWN) {
					fig.y+=5;
				}
				if(evt.getKeyCode() == 	evt.VK_RIGHT) {
					fig.x+=5;
				}
			}
		    }

		repaint();
   		}
        });
        this.setTitle("Editor grafico");
        this.setSize(350, 350);
}
        public void paint (Graphics g) {
            super.paint(g);
            for (Figure fig:this.figs) {
		int x=fig.x;
		int y=fig.y;
		int w=fig.w;
		int h=fig.h;
                fig.paint(g);
		if (fig==focus) {
			if (fig.w < 0) {
   		 		x +=fig.w;
    				w = -fig.w;
			}

			if (fig.h < 0) {
    				y += fig.h;
    				h = -fig.h;
			}		
    			g.setColor(Color.RED);
    			g.drawRect(x, y, w, h);
			}
		}
         }
}
