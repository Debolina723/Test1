package com.facebook.Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.facebook.TestBase.Testbasefacebook;

public class Loginpagefacebook extends Testbasefacebook {

	public Loginpagefacebook() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="email")
	WebElement emailid;
	
	@FindBy(id="pass")
	WebElement password1;
	
	@FindBy(css=".login_form_login_button.uiButton.uiButtonConfirm")
	WebElement LoginBtn;
	
	@FindBy(id="creation_hub_entrypoint")
	WebElement createpost;
	
	
	public String GetTitle(){
		
		String title=driver.getTitle();
		return title;
		
	}
	
	public String Loginpage(String username, String password) throws InterruptedException{
		
		emailid.sendKeys(username);
		password1.sendKeys(password);
	    LoginBtn.click();
	    WebDriverWait wait= new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.textToBePresentInElement(createpost, "Create"));
	    String header=createpost.getText();
	    System.out.println(header);
		return header;
		
		
		
	}
	
	
}
