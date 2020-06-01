package app;
import javax.swing.JFrame;
import javax.swing.JPanel;

import utils.ApplicationTime;
import utils.FrameUpdate;
import java.util.Timer;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

public class Gruppe_2 {
	
	/**
	 * Gruppe 2 wurde aus der Vorlesungs Klasse herauskommentiert
	 * 
	 */

		private static JFrame frame;

		public static void main(String[] args) {
			
			//open new thread for time measurement
			ApplicationTime animThread = new ApplicationTime();
			animThread.start();

			CreateFrame(animThread);
			
			Timer timer = new Timer();
			timer.scheduleAtFixedRate(new FrameUpdate(frame), 100, _0_Constants.TPF);
		}
		
		//create a JFrame as my container for the simulation content
		private static void CreateFrame(ApplicationTime thread) {
			
			//Create a new frame
			frame = new JFrame("Mathematik und Simulation");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			//Add a JPanel as the new drawing surface
			JPanel panel = new YourGraphicsContent2(thread);
			frame.add(panel);
			frame.pack(); //adjusts size of the JFrame to fit the size of it's components
			frame.setVisible(true);
		}
	}


	@SuppressWarnings("serial") 
	class YourGraphicsContent2 extends JPanel {
		
		//panel has a single time tracking thread associated with it
		private ApplicationTime t;
		private double time;
		
		public YourGraphicsContent2(ApplicationTime thread) {
			this.t = thread;
		}
		
		//set this panel's preferred size for auto-sizing the container JFrame
		public Dimension getPreferredSize() {
			return new Dimension(_0_Constants.WINDOW_WIDTH, _0_Constants.WINDOW_HEIGHT);
		}
		
		public int weite=_0_Constants.WINDOW_WIDTH;
		public int höhe= _0_Constants.WINDOW_HEIGHT;
		//Kugel1
		Kugel k1= new Kugel(weite/2,0,5000, "rot");
		//Kugel2
		Kugel k2= new Kugel(50,30,5000, "grün");
		//Kugel3
		Kugel k3= new Kugel(weite-50,0,3000, "blau");
		
		//Schwerpunkt zwischen k1 und k2
		schwerPunkt s1=new schwerPunkt(k1,k2,0);
		//Schwerpunkt zwischen k2 und k3
		schwerPunkt s2=new schwerPunkt(k3,k2,1);
		//Schwerpunkt zwischen k1 und k3
		schwerPunkt s3=new schwerPunkt(k3,k1,1);
		
		
		//drawing operations should be done in this method
		@Override protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			time = t.GetTimeInSeconds(); 
			
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, weite , höhe);

			k1.xPos(time);
			k1.abbildung(g, Color.RED);
			k2.xPos(time);
			k2.abbildung(g, Color.GREEN);
			k3.xPos(time);
			k3.abbildung(g, Color.BLUE);
			
			s1.xPosS(time,k1,k2);
			s1.abbildung(g);
			s2.xPosS(time,k3, k2);
			s2.abbildung(g);
			s3.xPosS(time,k3, k1);
			s3.abbildung(g);
		}
	}