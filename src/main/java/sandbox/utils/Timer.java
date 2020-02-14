package sandbox.utils;

public class Timer {

	private long 	startTime, 
					endTime;
	
	private boolean running;
	
	public Timer() {
		start();
	}// ==============================
	
	public void start() {
		startTime = System.currentTimeMillis();
		running = true;
	}// ==============================
	
	public void stop() {
		if(running) {
			endTime = System.currentTimeMillis();
			running = !running;
		}// ===== if
	}// ==============================
	
	public void report() {
		if(running) {
			endTime = System.currentTimeMillis();
		}// ===== if
		System.out.println(getFormattedString());
	}// ==============================
	
	/**
	 * Delays application running for desired number of seconds.
	 * @param seconds
	 */
	public static void pause(long seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
			Thread.currentThread().interrupt();
		}// ===== try, catch
	}// ==============================

	/**
	 * Delays application running for desired number of seconds.
	 * @param seconds
	 */
	public static void pause(double seconds) {
		try {
			Thread.sleep((long)(seconds * 1000));
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
			Thread.currentThread().interrupt();
		}// ===== try, catch
	}// ==============================
	
	private String getFormattedString() {
		double elapsed = ((double) endTime) - startTime;
		String units = "ms";
		
		if(elapsed >= 1000.0) {
			elapsed /= 1000.0;
			units = "s";
			if(elapsed >= 60.0) {
				elapsed /= 60.0;
				units = "min";
				if(elapsed >= 60.0) {
					elapsed /= 60.0;
					units = "hr";
				}// ===== if
			}// ===== if
		}// ===== if
		
		return ("Elapsed time: "+ elapsed +" "+ units);
	}// ==============================
	
}// ==============================
