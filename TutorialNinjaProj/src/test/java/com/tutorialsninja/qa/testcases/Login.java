package com.tutorialsninja.qa.testcases;

import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialNinja.qa.util.Utilities;
public class Login {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		String browserName = " chrome ";
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
					
		}
		
		 driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
			driver.get("https://tutorialsninja.com/demo/");
			driver.findElement(By.xpath("//span[text()='My Account']")).click();
			driver.findElement(By.linkText("Login")).click();
		
	}
	@AfterMethod 
	public void tearDown()
	{
		driver.close();
	}
	@Test(priority=1)
	public void verifyLoginWithValidCredentials()
	{
		driver.findElement(By.id("input-email")).sendKeys("sushmita01dh@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Santosh01@");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.linkText("Edit your account information"));
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),"Edit Your Account Information Option Is Not Displayed");
		
	}
	@Test(priority=2)
	public void verifyWithInvalidCredentials() {
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys("Santosh01");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String acutalWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(acutalWarningMessage.contains(expectedWarningMessage),"Expected Warning Message is not Displayed " );
	     	
	}
	@Test(priority=3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys("Santosh01@");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String acutalWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(acutalWarningMessage.contains(expectedWarningMessage),"Expected Warning Message is not Displayed " );
	    
		
	}
	@Test(priority=4)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys("Santosh01");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String acutalWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(acutalWarningMessage.contains(expectedWarningMessage),"Expected Warning Message is not Displayed " );
	    
	    }
	@Test(priority=5)
	public void verifyLoginWithoutProvidingCredentials() {
		driver.findElement(By.id("input-email")).sendKeys("");
		driver.findElement(By.id("input-password")).sendKeys("");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String acutalWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(acutalWarningMessage.contains(expectedWarningMessage),"Expected Warning Message is not Displayed " );
	  
	
	
	}
}
