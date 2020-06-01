package app;

import java.awt.Color;
import java.awt.Graphics;

public class Kugel {
	
	public int startX;
	public double v;
	public int el;
	public double m;
	public int d;
	public double time;
	public double xPos;
	public double deltaTime;
	public int width=_0_Constants.WINDOW_WIDTH;
	public int r;
	public int mittel;
	public String name;
	public double vOri;
	
	//Konstruktor
	public Kugel(int startX, double v, double m, String name) {
		super();
		this.startX = startX;
		this.v = v;
		this.m = m;
		this.d=diameter(m);
		r=radius();
		mittel=(int)xPos+r;
		this.name=name;
		vOri=v;
	}

	public int diameter(double m) {
		// Kreisfläche a=Pi*r^2
		//Bei doppelter Masse verdoppelt sich Fläche aber nicht radius
		int a=(int)m;
		int d;
		d=((int)Math.sqrt(a/Math.PI))*2;
		return d;
	}
	
	public int radius() {
		int r=d/2;
		return r;
	}
	
	public void xPos(double _t) {
		xPos=startX+((_t-deltaTime)*v);
		if(xPos+d>=width) {
			System.out.println(this.name + " hat die Wand berührt");
			v=v*-1;
			startX=(int)xPos-1;
			deltaTime=_t;
		}
		if(xPos<=0) {
			System.out.println(this.name + " hat die Wand berührt");
			v=v*-1;
			startX=(int)xPos+1;
			deltaTime=_t;
		}
	}
	
	public void abbildung(Graphics g, Color c) {
		g.setColor(c);
		g.fillOval((int)xPos, _0_Constants.WINDOW_HEIGHT/2-d/2, d, d);
	}
}