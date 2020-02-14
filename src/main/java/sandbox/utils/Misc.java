package sandbox.utils;

public class Misc {

	private Misc() {}
	
	public static String getCallerClassName() {
		String rv = "";
		
		try {
			rv = new Throwable().getStackTrace()[1].getClassName();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}// ===== try, catch
		
		return rv;
	}// ==============================
	
	public static String getCallerMethodName() {
		String rv = "";
		
		try {
			rv = new Throwable().getStackTrace()[1].getMethodName();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}// ===== try, catch
		
		return rv;
	}// ==============================
	
}// ==============================
