package sandbox.utils;

public class Strings {

	public static String getFormattedMessage(String message) {
		StringBuilder rv = new StringBuilder();
		
		rv.append(getSymbolRow('=', 80))
			.append(getArrow('>', 10)).append('\n')
			.append(message).append('\n')
			.append(getArrow('<', 10)).append('\n')
			.append(getSymbolRow('=', 80));
		
		return rv.toString();
	}// ==============================
	
	private static String getSymbolRow(Character symbol, Integer length) {
		StringBuilder rv = new StringBuilder();
		
		for(int i = 0; i < length; i++) {
			rv.append(symbol);
		}// ===== for
		rv.append('\n');
		
		return rv.toString();
	}// ==============================
	
	private static String getArrow(Character direction, Integer size) {
		StringBuilder rv = new StringBuilder();
		
		rv.append(getSymbolRow('-', size));
		switch(direction) {
		case '<':
			rv.insert(0, direction);
			break;
		case '>':
			rv.append(direction);
			break;
		}// ===== switch
		
		return rv.toString();
	}// ==============================
}// ==============================
