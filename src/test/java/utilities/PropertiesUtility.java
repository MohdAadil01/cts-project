package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	private FileInputStream file;
	private Properties propObject;
	
	public PropertiesUtility(String filepath) {
		try {
			file = new FileInputStream(filepath);
			propObject = new Properties();
			propObject.load(file);
		}catch(IOException e) {
			System.out.println("Error in properties utility.");
			e.printStackTrace();
		}
		
	}
	public String getProperty(String key) {
		return propObject.getProperty(key);
	}
}
