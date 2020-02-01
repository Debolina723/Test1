package com.facebook.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.facebook.TestBase.Testbasefacebook;

public class Facebookpage extends Testbasefacebook {

	public Facebookpage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	Loginpagefacebook facebook= new Loginpagefacebook();
	

	@FindBy(css="._5qtp")
	WebElement divbody;
	
	
	@FindBy(css="#feedx_sprouts_container>div>div>div>div>div:nth-child(2)>div>div>div>div>div>div>div._3nd0")
	WebElement textarea;
	
	
	@FindBy(css="._45wg>button")
	WebElement button;
	
	public void PostStatus() throws InterruptedException{
		
		
		Actions actions = new Actions(driver);
        actions.moveToElement(divbody);
        actions.click();
        actions.build().perform(); 
		System.out.println("CreateTest"+divbody.getText());
		WebDriverWait wait= new WebDriverWait(driver,2000);
		wait.until(ExpectedConditions.textToBePresentInElement(divbody, "Create post"));
		Actions actions1 = new Actions(driver);
        actions1.moveToElement(textarea);
        //actions.click();
        actions1.sendKeys( "Hello");
        actions1.build().perform();
		if (button.isEnabled()){
			button.click();
		}
	}
}
