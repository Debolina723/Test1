package com.facebook.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.Pages.Facebookpage;
import com.facebook.Pages.Loginpagefacebook;

public class Facebookpagetestcases extends Facebookpage {

	public Facebookpagetestcases() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	Loginpagefacebook login;
	Facebookpage facebook;
	
@BeforeMethod
	
	public void setup() throws IOException{
		
		initialisation();
		login= new Loginpagefacebook();
		facebook= new Facebookpage();
		
	}
	
@Test(dataProvider="getarray",priority=3)
public void VerifyPostaStatusinpage(String user, String pass) throws InterruptedException{
	
	login.Loginpage(user, pass);
	facebook.PostStatus();
	
}

@AfterMethod
public void teardown(){
	
	driver.quit();
}
}
