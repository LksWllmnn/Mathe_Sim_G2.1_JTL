package app;

import java.awt.Color;
import java.awt.Graphics;

public class schwerPunkt {
	public double xPosS;
	public int xP;
	public int r;
	public int mittel;
	public double el;
	
	//Konstruktor
	public schwerPunkt(Kugel k1, Kugel k2, double el) {
		super();
		this.r = 5/2;
		this.mittel = (int)xPosS+r;
		this.el=el;
	}

	public void xPosS(double t, Kugel k1, Kugel k2) {
		xPosS=Math.abs((k2.xPos+k2.mittel)-(k1.xPos+k1.mittel));
		//this.xP=(int)(1/k1.m+k2.m)*(int)(k1.m*(k1.xPos+k1.mittel)+k2.m*(k2.xPos+k2.mittel));
		this.xP=(int)(1/(k1.m+k2.m)*(k1.m*(k1.startX+k1.mittel)+k2.m*(k2.startX+k2.mittel))+(1/(k1.m+k2.m)*(k1.m*k1.v+k2.m*k2.v))*(t-k1.deltaTime));
		
		if(xPosS<=k2.r+k1.r) {
			double q;
			double v1=k1.v;
			double v2=k2.v;
			k1.v=((k1.m-this.el*k2.m)*v1+k2.m*(1+this.el)*v2)/(k1.m+k2.m);
			k2.v=(k1.m*(1+this.el)*v1+(k2.m-this.el*k1.m)*v2)/(k1.m+k2.m);
			//q=(0.5)*k1.m*(v1*v1)+(0.5)*k2.m*(v2*v2)-(0.5)*k1.m*(k1.v*k1.v)-(0.5)*k2.m*(k2.v*k2.v);
			q=(0.5)*((k1.m*k2.m)/(k1.m+k2.m))*(1-el)*((v2-v1)*(v2-v1));
			
			System.out.println(k1.name + " Geschwindigkeit " + (int)k1.v);
			System.out.println(k2.name + " Geschwindigkeit " + (int)k2.v);
			System.out.println("Der Energieverlust beträgt: " + q);
			
			k1.startX=(int)k1.xPos+1;
			k2.startX=(int)k2.xPos-1;
			
			k1.deltaTime=t;
			k2.deltaTime=t;
		}
	}
	
	public void xPSch(Kugel k1, Kugel k2) {
		//this.xP=(int)(1/k1.m+k2.m)*(int)(k1.m*(k1.xPos+k1.mittel)+k2.m*(k2.xPos+k2.mittel));
	}
	
	public void abbildung(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(this.xP, _0_Constants.WINDOW_HEIGHT/2-5/2, 5, 5);
	}
}