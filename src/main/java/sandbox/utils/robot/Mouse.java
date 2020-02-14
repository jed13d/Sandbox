package sandbox.utils.robot;

import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.security.SecureRandom;
import java.time.LocalTime;

public class Mouse {
	
	private static final int 		FREQ_MAX 	= 30;
	private static final Dimension 	MAX_SIZE 	= Toolkit.getDefaultToolkit().getScreenSize();
	private static final int 		MAX_X 		= (int) MAX_SIZE.getWidth(),
									MAX_Y 		= (int) MAX_SIZE.getHeight();
	private Mouse() {}
	
	public static void run() {
		try {
			Robot rob = new Robot();
			SecureRandom sr = new SecureRandom();
			
			int mx, omx = 0, dx, my, omy = 0, dy, st, steps = 50;
			
			while(LocalTime.now().isAfter(LocalTime.parse("00:00")) && LocalTime.now().isBefore(LocalTime.parse("23:59"))) {
				mx = sr.nextInt(MAX_X);
				my = sr.nextInt(MAX_Y);
				st = (sr.nextInt(FREQ_MAX) + 1) * ((sr.nextInt(3) + 1) * 1000);
				
				dx = (mx - omx) / steps;
				dy = (my - omy) / steps;
				for(int i = 0; i < steps; i++) {
					omx += dx;
					omy += dy;
					rob.mouseMove(omx, omy);
					Thread.sleep(10);
				}// ===== for
				
				Thread.sleep(st);
			}// ===== while
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}// ===== try, catch
	}// ==============================

}// ==============================
