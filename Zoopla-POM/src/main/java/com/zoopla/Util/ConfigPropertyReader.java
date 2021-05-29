package com.zoopla.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertyReader {
	
	private static Properties props;
	
	public  static Properties readProperties() throws IOException 
	{
		try {
			FileInputStream file = new FileInputStream("/Users/sayanna/work/bindu-work/Zoopla-POM/Zoopla-POM/src/test/resourses/config.properties");
			props = new Properties();
			props.load(file);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props;
	}
	

}
