package app;

import java.awt.Color;
import java.awt.Graphics;

public class schwerPunkt {
	public double xPosS;
	public int r;
	public int mittel;
	
	


	public schwerPunkt(Kugel k1, Kugel k2) {
		super();
		this.r = 5/2;
		this.mittel = (int)xPosS+r;
	}

	public void xPosS(double t, Kugel k1, Kugel k2) {
		xPosS=Math.abs(k2.xPos-k1.xPos);
		
		if(xPosS<=1) {
			k1.aufprallK(k2, t);
			k2.aufprallK(k1, t);
		}
		
	}
	
	public void abbildung(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval((int)xPosS, _0_Constants.WINDOW_HEIGHT/2-5/2, 5, 5);
	}

}