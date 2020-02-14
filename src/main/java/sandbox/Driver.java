package sandbox;

import sandbox.utils.Timer;

/**
 * This is the Driver class.
 * It merely runs selected functions for demonstration purposes.
 */
public class Driver {

	public static void main(String[] args) {
		Timer timer = new Timer();
		// ==========
		
		runMethod();
		
		// ==========
		timer.report();
	}// ==============================
	
	private static void runMethod() {
		System.out.println("Driver class ran.");
	}// ==============================

}// ==============================