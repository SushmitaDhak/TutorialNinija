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
	import com.tutorialsninja.qa.base.Base;
	public class Login extends Base {
		public Login() {
			super();
		}
		WebDriver driver;
		
		@BeforeMethod
		public void setUp() {
			
			driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
				driver.findElement(By.xpath("//span[text()='My Account']")).click();
				driver.findElement(By.linkText("Login")).click();
		}
		@AfterMethod 
		public void tearDown()
		{
			driver.quit();
		}
		@Test(priority=1)
		public void verifyLoginWithValidCredentials()
		{
			driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("email"));
			driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("password"));
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			driver.findElement(By.linkText("Edit your account information"));
			Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),"Edit Your Account Information Option Is Not Displayed");
			
		}
		@Test(priority=2)
		public void verifyWithInvalidCredentials() {
			driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
			driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			
			String acutalWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
			String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
			Assert.assertTrue(acutalWarningMessage.contains(expectedWarningMessage),"Expected Warning Message is not Displayed " );
		     	
		}
		@Test(priority=3)
		public void verifyLoginWithInvalidEmailAndValidPassword() {
			driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
			driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("password"));
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			
			String acutalWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
			String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
			Assert.assertTrue(acutalWarningMessage.contains(expectedWarningMessage),"Expected Warning Message is not Displayed " );
		    
			
		}
	@Test(priority=4)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("password"));
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
