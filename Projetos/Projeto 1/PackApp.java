import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Random;

import java.io.*;

import figures.*;
import ivisible.*;
public class PackApp {
     public static void main(String[] args) {
       PackFrame frame = new PackFrame();
        frame.setVisible(true);
     }
}  

class PackFrame extends JFrame {
    boolean focused;
    private Button focus_but=null;
    private Button focus_but2=null;
    private ArrayList<Figure> figs = new ArrayList<Figure>();
    private ArrayList<Button> buts = new ArrayList<Button>();
    private ArrayList<Button> butsc = new ArrayList<Button>();
    private Figure focus = null;
    private Random rand = new Random();
    private int dx=0,dy=0;
    private int cto=0;private int i=0;
    private int mx=0; private int my=0;private int mnx=0;
    private int mny=0;
    private Color c=null;
    PackFrame() {
        try {
            FileInputStream f=new FileInputStream ("proj.bin");
            ObjectInputStream o=new ObjectInputStream(f);
            this.figs=(ArrayList<Figure>) o.readObject();
            o.close();
        } catch (Exception x) {
            System.out.println("ERRO!");
        }
        buts.add(new Button(1,0,60,40,4,new Rect (20,20,0,0,Color.BLACK)));
        buts.add(new Button(2,0,60,40,4,new Ellipse (20,20,0,0,Color.BLACK)));
        buts.add(new Button(3,0,60,40,4,new Line (20,20,0,0,Color.BLACK)));
        buts.add(new Button(4,0,60,40,4,new Arc (20,20,0,0,Color.BLACK,90,270)));
        
        
        butsc.add(new Button(0,1,36,24,4,new Ellipse (20,20,0,0,Color.GREEN)));
        butsc.add(new Button(0,2,36,24,4,new Ellipse (20,20,0,0,Color.RED)));
        butsc.add(new Button(0,3,36,24,4,new Ellipse (20,20,0,0,Color.BLUE)));
        butsc.add(new Button(0,4,36,24,4,new Ellipse (20,20,0,0,Color.YELLOW)));
        butsc.add(new Button(0,5,36,24,4,new Ellipse (20,20,0,0,Color.ORANGE)));
        butsc.add(new Button(0,6,36,24,4,new Ellipse (20,20,0,0,Color.GRAY)));
        butsc.add(new Button(0,7,36,24,4,new Ellipse (20,20,0,0,Color.MAGENTA)));
        butsc.add(new Button(0,8,36,24,4,new Ellipse (20,20,0,0,Color.BLACK))); 
        
        this.addWindowListener (
            new WindowAdapter() {
                    public void windowClosing (WindowEvent e) {
                        try {
                            FileOutputStream f= new FileOutputStream("proj.bin");
                            ObjectOutputStream o= new ObjectOutputStream(f);
                            o.writeObject(figs);
                            o.flush();
                            o.close();
                        }
                        catch (Exception x) {
            System.out.println("ERRO 2!");
        }
                        System.exit(0);
                    }
            
                }
            );
        this.addMouseListener (new MouseAdapter() {
                public void mousePressed (MouseEvent evt) {
                    int x = 100;
                    int y = 100;
                    int w = 20;
                    int h = 20;
		            int ang1 = rand.nextInt(20);
                    int ang2 = rand.nextInt(359);
                   
                    focus = null;
                    for (Figure fig : figs) {
			            if (fig.foco(evt,fig)!=null) {
                            
				            focus=fig.foco (evt,fig);
				            cto=fig.cantofig(evt);
				            dx = evt.getX() - fig.getX();
                            dy = evt.getY() - fig.getY();
			            }
		            }
		            if (focus!=null) {
		                figs.remove(focus);
		    		    figs.add(focus);
		    		}
		    		focus_but2=null;
		    		for (Button but : buts) {
                        if (but.clicked(evt.getX() ,evt.getY())){
                            focus_but2=but; 
                        }
                        
                    } 
		    		for (Button but : butsc) {
                        if (but.clicked(evt.getX() ,evt.getY())){
                            focus_but2=but; 
                        }
                 
                        
                    }  
                    if (focus_but!=null && focus_but2==null){ 
                             switch (focus_but.getIdx()) {
                                case 1:
                                    
                                    Rect r = new Rect(evt.getX(),evt.getY(), w,h,c);
                                    figs.add(focus=r);
                                    
                                break;
                                case 2:
                                    
                                    figs.add(focus=new Ellipse(evt.getX(),evt.getY(), w,h,c));
                                    
                                break;
                                case 3:
                                    figs.add(focus=new Line(evt.getX(),evt.getY(), w,h,c));
                                break;
                                case 4:
                                    figs.add(focus=new Arc(evt.getX(),evt.getY(), w,h,c,ang1,ang2));
                                break;
                            }
                            
                            focus_but=null;
                            focus_but2=null;
                            
                         }
                     if (focus_but!=null) {
                         switch (focus_but.getIdxc()) {
                                case 1:
                                    
                                    c=Color.GREEN;
                                    
                                break;
                                case 2:
                                    
                                    c=Color.RED;
                                    
                                break;
                                case 3:
                                    c=Color.BLUE;
                                break;
                                case 4:
                                    c=Color.YELLOW;
                                break;
                                case 5:
                                    c=Color.ORANGE;
                                break;
                                case 6:
                                    c=Color.GRAY;
                                break;
                                case 7:
                                    c=Color.MAGENTA;
                                break;
                                case 8:
                                    c=Color.BLACK;
                                break;
                            }
                            focus_but=null;
                         }
                    for (Button but : buts) {
                        if (but.clicked(evt.getX() ,evt.getY())){
                            focus_but=but; 
                        }
                        
                    }    
                    for (Button but : butsc) {
                        if (but.clicked(evt.getX() ,evt.getY())){
                            focus_but=but; 
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
                        if (focus==fig) {
				            fig.drag(evt,cto,dx,dy);
                        }
                       }
			repaint();
                }
	    }
        );
        this.addKeyListener (new KeyAdapter() {
            public void keyPressed (KeyEvent evt) {
                    int x = 100;
                    int y = 100;
                    int w = 20;
                    int h = 20;
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
                    
                    if (evt.getKeyChar() == '2') {
                        for (Figure fig: figs) {
                            if (focus!=null) {
                                int i=figs.indexOf(focus);
                                focus=figs.get((i+1)%figs.size());
                                break;
                                }
                            }
                        }
                    
                    if (evt.getKeyChar() == 'r') {
                        
                        Rect r = new Rect(x,y, w,h,c);
                        figs.add(r);
                    }
                    else if (evt.getKeyChar() == 'e') {
                        
                        figs.add(new Ellipse(x,y, w,h,c));
                    }
                    else if (evt.getKeyChar() == 'l') {
                        
                        figs.add(new Line(x,y, w,h,c));
                    }
		    else if (evt.getKeyChar() == 'a') {
                        
                        figs.add(new Arc(x,y, w,h,c,ang1,ang2));
                    }
		    if(evt.getKeyCode() == evt.VK_BACK_SPACE) {
			figs.remove(focus);
		    }
		    for (Figure fig : figs) {
			if (focus==fig) {
				if(evt.getKeyCode() == 	evt.VK_UP) {
					fig.setY(fig.getY()-5);
				}
				if(evt.getKeyCode() == 	evt.VK_LEFT) {
					fig.setX(fig.getX()-5);
				}
				if(evt.getKeyCode() == 	evt.VK_DOWN) {
					fig.setY(fig.getY()+5);
				}
				if(evt.getKeyCode() == 	evt.VK_RIGHT) {
					fig.setX(fig.getX()+5);
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
                   
                
          
                    fig.paint(g,fig==focus);
                
                   
		   }
            for (Button but: this.buts){
                but.paint(g,but==focus_but);
            }
            for (Button but: this.butsc){
                but.paint(g,but==focus_but);
            }
       }
    }

