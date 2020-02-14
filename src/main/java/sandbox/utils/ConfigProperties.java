package sandbox.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigProperties {
	
	private static final String CONFIG_PROPERTIES_FILE = System.getProperty("user.dir")+"\\src\\config\\config.properties";
	
	private static Properties configProperties = new Properties();
	
	private ConfigProperties() {}
	
	public static String getProperty(String property) {
		validateNotEmpty();
		
		return configProperties.getProperty(property);
	}// ==============================
	
	public static void reportContents() {
		validateNotEmpty();
		
		System.out.println(configProperties.toString());
	}// ==============================
	
	private static void setupProperties() {
		Path inputFilePath = Paths.get(CONFIG_PROPERTIES_FILE);
		try(BufferedReader isPropertyFile = Files.newBufferedReader(inputFilePath)) {
			
			if(isPropertyFile != null) {
				configProperties.load(isPropertyFile);
			} else {
				throw new FileNotFoundException("Unable to find or read file: \""+ CONFIG_PROPERTIES_FILE +"\" returned null.");
			}// ===== if
			
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}// ===== try, catch
	}// ==============================
	
	private static void validateNotEmpty() {
		if(configProperties.isEmpty()) setupProperties();
	}// ==============================

}// ==============================
