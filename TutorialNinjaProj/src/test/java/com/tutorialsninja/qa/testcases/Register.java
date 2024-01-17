package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialNinja.qa.util.Utilities;
import com.tutorialsninja.qa.base.Base;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register extends Base {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test(priority=1)
	public void verifyRegisteringAnAccountWithMandatoryFeilds() {
		driver.findElement(By.id("input-firstname")).sendKeys("Sush");
		driver.findElement(By.id("input-lastname")).sendKeys("Dhak");
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("9999999999");
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("input-confirm")).sendKeys("Santosh01@");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualSuccessHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(actualSuccessHeading,"Your Account Has Been Created!","Account Success Page Not Displayed");
		driver.quit();
	}
	@Test(priority= 2)
	public void verifyRegisteringAccountByProvidingAllFields() {
		
		driver.findElement(By.id("input-firstname")).sendKeys("Sush");
		driver.findElement(By.id("input-lastname")).sendKeys("Dhak");
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("9999999999");
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("password"));
		//driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		//driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();)
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualSuccessHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(actualSuccessHeading,"Your Account Has Been Created!","Account Success Page Not Displayed");
		
	}
	@Test (priority=3)
	public void verifyRegisteringAccountWithExistingEmailAddress() {
		
		driver.findElement(By.id("input-firstname")).sendKeys("Sush");
		driver.findElement(By.id("input-lastname")).sendKeys("Dhak");
		driver.findElement(By.id("input-email")).sendKeys("dhaknesush1@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("9999999999");
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("password"));
		//driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		//driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualWarning = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(actualWarning.contains("Warning: E-Mail Address is already registered!"),"Warning Message regarding duplicate email address is not displayed ");
		
	}
	@Test(priority=4)
	public void verifyRegisteringAccountWithFillingAnyDetails() {
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualPrivacyPolicyWarning= driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(actualPrivacyPolicyWarning.contains("Warning: You must agree to the Privacy Policy!"),"Privacy Policy Warning Message is not displayed");
		String acutalFirstNameWarning = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
		Assert.assertEquals(acutalFirstNameWarning,"First Name must be between 1 and 32 characters!", " First Name Warning Message Is Not Displayed");
		String acutalLastNameWarning = driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
		Assert.assertEquals(acutalLastNameWarning,"Last Name must be between 1 and 32 characters!", " Last Name Warning Message Is Not Displayed");
		String acutalEmailWarning = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
		Assert.assertEquals(acutalEmailWarning,"E-Mail Address does not appear to be valid!", "Email Warning Message Is Not Displayed");
		String acutalTelephoneWarning = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
		Assert.assertEquals(acutalTelephoneWarning,"Telephone must be between 3 and 32 characters!", "Telephone Warning Message Is Not Displayed");
		String acutalPasswordWarning = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
		Assert.assertEquals(acutalPasswordWarning,"Password must be between 4 and 20 characters!", "Password Warning Message Is Not Displayed");
	
	}
		
	

}
