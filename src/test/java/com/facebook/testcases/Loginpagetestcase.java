package com.facebook.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.Pages.Facebookpage;
import com.facebook.Pages.Loginpagefacebook;

import junit.framework.Assert;

public class Loginpagetestcase extends Loginpagefacebook {

	public Loginpagetestcase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	Loginpagefacebook login;
	
	
	
	@BeforeMethod
	
	public void setup() throws IOException{
		
		initialisation();
		login= new Loginpagefacebook();
		
	}
	
	
	    @Test(priority=1)
		public void VerifypageTitle(){
			
			String title=login.GetTitle();
			Assert.assertEquals("Facebook – log in or sign up", title);
		}
	
	    
	    
	    @Test(dataProvider="getarray",priority=2)
	    public void Loginpagetestcase(String user, String pass) throws InterruptedException{
	    	
	    	String title=login.Loginpage(user, pass);
	    	Assert.assertEquals("Create", title);
	    	
	    }
	    
	    
	    
	@AfterMethod
	
	public void teardown(){
		
		driver.quit();
	}
	}

