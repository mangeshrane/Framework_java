package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import utils.Logging;
import utils.ResourceProvider;

public class Config {
	
	private static Properties prop = null;
	static Logger log = Logging.getLogger(Config.class);
	@SuppressWarnings("unused")
	private static Config config = null;
	
	private Config(){
		File file = new File(new ResourceProvider().getResource("configuration/configuration.properties"));
		log.info("Loaded configuration/configuration.properties");
		prop = new Properties();
		try {
			prop.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String get(String name){
		if (prop != null){
			String val = prop.getProperty(name);
			log.info("returning '" + name + " --> " + val + "'");
			return val;
		}else{
			config = new Config();
			String val = prop.getProperty(name);
			log.info("returning '" + name + " --> " + val + "'");
			return val;
		}
	}
	
}
