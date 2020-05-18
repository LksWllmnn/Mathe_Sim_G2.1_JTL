package utils;

import app._0_Constants;

public class ApplicationTime extends Thread {
	//time in ms
	public double timeSinceStart = 0;
	public long currentTime = 0;
	public long formerTime = 0;
	private double timeScale = _0_Constants.TIMESCALE;
	
	public ApplicationTime() {
	}
	
	@Override
	public void run() {
		
		formerTime = System.currentTimeMillis();
		
		while(true) {
			
			currentTime = System.currentTimeMillis();
			timeSinceStart += (currentTime - formerTime) * timeScale;
			formerTime = currentTime;
		}
	}
	
	public double GetTime() {
		return timeSinceStart;
	}
	
	public double GetTimeInSeconds() {
		return (double)timeSinceStart / 1000;
	}
	
	public void ChangeTimeScaling(double newValue) {
		timeScale = newValue;
	}
	
}