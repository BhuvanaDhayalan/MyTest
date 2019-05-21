package config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyfilepath = "config//configuration.properties";
	
	public void configFileReader() {
		BufferedReader reader;
		try {
		reader = new BufferedReader(new FileReader(propertyfilepath));
		properties = new Properties();
		try {
		properties.load(reader);
		reader.close();
		} catch (IOException e) {
		e.printStackTrace();
		}
		}catch (FileNotFoundException e) {
		e.printStackTrace();
		throw new RuntimeException("Configuration properties not found at" + propertyfilepath);
		}
	}

	public String getDriverPath() {
		String driverpath = properties.getProperty("driverpath");
		if (driverpath != null) {
			return driverpath;
		}
		else {
			throw new RuntimeException("driverpath not specified in configuration.properties file");
		}
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null) {
			return url;
		}
		else {
			throw new RuntimeException("url not specified in configuration.properties file");
		}
	}
	
}
