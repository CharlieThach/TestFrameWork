package utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class property {

	public Properties readPropFile() throws IOException{
		String result ="";
		Properties prop = new Properties();
		String propFileName = "resources/lib/config.properties";
		
		InputStream in = getClass().getClassLoader().getResourceAsStream(propFileName);
		if(in!= null){
			prop.load(in);
		}else{
			throw new FileNotFoundException("property file '"+propFileName+"' not found found in class path");
		}
	return prop; 
	}
}
