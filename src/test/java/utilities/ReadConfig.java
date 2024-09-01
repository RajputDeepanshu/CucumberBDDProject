package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	String path="config.properties";
	
	//constructor
	public ReadConfig()
	{
		try 
		{
			properties = new Properties();
			FileInputStream file=new FileInputStream(path);
			properties.load(file);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String getBrowser()
	{
		String value=properties.getProperty("browser");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("Browser name not specified in config  file.");

	}
	

}
