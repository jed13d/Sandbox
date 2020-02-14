package sandbox.utils;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

public class JsonLogger {
	
	private static final String JSON_LOG_FILE_LOCATION = System.getProperty("user.dir")+ConfigProperties.getProperty("LogFilesPath");
	
	private static Logger logger = Logger.getLogger(JsonLogger.class);
	
	private JsonLogger() {}
	
	@SuppressWarnings("unchecked")
	public static void genReportTemplate() {
		String filename = "log.json";
		Path outputFile = Paths.get(JSON_LOG_FILE_LOCATION + filename);
		try(BufferedWriter osJsonFile = Files.newBufferedWriter(outputFile)) {
			
			if(osJsonFile != null) {
				JSONObject jsonObj = new JSONObject();
				
				jsonObj.put("Property One", ConfigProperties.getProperty("propOne"));
				
				osJsonFile.write(jsonObj.toJSONString());
			} else {
				throw new FileNotFoundException("Unable to open or create file.");
			}// ===== if, else
			
		} catch(Exception e) {
			logger.error(e.getMessage());
		}// ===== try, catch
	}// ==============================

}// ==============================
