package com.maven.cleartrip.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;

public class BaseTest {
	
	 protected static Properties prop=new Properties();
	
	@BeforeSuite
	public void loadUtilities()
	{ 
		//Code to load Properties File
		
		File file = new File("E:\\KeywordFramework\\PageWorkspace\\maven.sampleProject\\TestData.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
