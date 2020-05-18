package app;

import java.awt.Color;
import java.awt.Graphics;

public class Kugel {
	
	public int startX;
	public int v;
	public int el;
	public int m;
	public int d;
	public double time;
	public double xPos;
	public double deltaTime;
	public int width=_0_Constants.WINDOW_WIDTH;
	public int r;
	public int mittel;
	
	
	//Konstruktor1
 	public Kugel(int startX, int v, int el) {
		super();
		this.startX = startX;
		this.v = v;
		this.el = el;
		this.m=10;
		this.d=diameter(m);
		r=radius();
		mittel=(int)xPos+r;
	}
	
	//Konstruktor2
	public Kugel(int startX, int v, int el, int m) {
		super();
		this.startX = startX;
		this.v = v;
		this.el = el;
		this.m = m;
		this.d=diameter(m);
		r=radius();
		mittel=(int)xPos+r;
	}

	public int diameter(int m) {
		// Kreisfläche a=Pi*r^2
		//Bei doppelter Masse verdoppelt sich Fläche aber nicht radius
		int a=m;
		int d;
		d=((int)Math.sqrt(a/Math.PI))*2;
		return d;
	}
	
	public int radius() {
		int r=d/2;
		return r;
	}
	
	public void xPos(double _t, String name, Kugel kont1, Kugel kont2) {
		xPos=startX+((_t-deltaTime)*v);
		if(xPos+d>=width||xPos<=0) {
			System.out.println(name + " hat die Wand berührt");
			v=v*-1;
			startX=(int)xPos;
			deltaTime=_t;
		}
	}
	
	public void abbildung(Graphics g, Color c) {
		g.setColor(c);
		g.fillOval((int)xPos, _0_Constants.WINDOW_HEIGHT/2-d/2, d, d);
	}
	
	public void aufprallK(Kugel k2, double t) {
		System.out.println("Kugel 1 hat Kugel 2 berührt");
		this.v=v*-1;
		startX=(int)xPos;
		deltaTime=t;
	}
}