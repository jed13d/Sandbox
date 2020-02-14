package sandbox.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTime {
	
	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
	private static SimpleDateFormat tsFormatter = new SimpleDateFormat("HH:mm:ss");
	private static SimpleDateFormat fileStampFormatter = new SimpleDateFormat("_MM_dd_yyyy_HH_mm_ss");
	
	private DateTime() {}
	
	public static String getCurrentDateString() {
		return dateFormatter.format(Calendar.getInstance().getTime());
	}// ==============================
	
	public static String getFileStamp() {
		return fileStampFormatter.format(Calendar.getInstance().getTime());
	}
	
	public static String getFutureDateString(Integer days) {
		Calendar c = Calendar.getInstance();
		c.roll(Calendar.DAY_OF_YEAR, days);
		return dateFormatter.format(c.getTime());
	}// ==============================
	
	public static String getTimestampString() {
		return tsFormatter.format(Calendar.getInstance().getTime());
	}// ==============================

}// ==============================
