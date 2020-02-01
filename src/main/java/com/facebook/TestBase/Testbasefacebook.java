package com.facebook.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

import com.facebook.TestUtil.TestUtil;
import com.facebook.Testdata.TestData;

public class Testbasefacebook {

	
	static Properties prop;
	public static WebDriver driver;
	public static TestData testdata;
	
	
	
	public Testbasefacebook() throws IOException{
		
		prop= new Properties();
		String path=System.getProperty("user.dir");
		FileInputStream fis= new FileInputStream(path+"/"+"/Folder"+"/config.properties");
		prop.load(fis);
		
	}
	
	@DataProvider
	
	public static Object[][] getarray(){
		
		Object[][] arr1=null;
		try {
			arr1=testdata.getData("Sheet1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("**************");
		return arr1;
		
		
		
	}
	
	
	
	public static void initialisation(){
		
		String browsername=prop.getProperty("browser");
		if (browsername.equalsIgnoreCase("chrome"))
		{
			
	     ChromeOptions option= new ChromeOptions();
	     option.addArguments("--disable-notifications"); 
	     String path=System.getProperty("user.dir");
		System.getProperty("webdriver.chrome.driver", path+"/"+"/chromedriver");
		 driver=new ChromeDriver(option);
	    }
		else if(browsername.equalsIgnoreCase("FF")){
			
			String path=System.getProperty("user.dir");
			System.getProperty("webdriver.gecko.driver", path+"/"+"/geckodriver");
			driver=new FirefoxDriver();	
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIATWAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.manage().window().fullscreen();
	}
}
