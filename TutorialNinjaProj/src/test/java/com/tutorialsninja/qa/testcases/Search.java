
package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;

public class Search extends Base{
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplicationURL("chrome");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		
		driver.findElement(By.name("search")).sendKeys("HP");
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(),"Valid product HP is Not Displayes in the search results");
	}
	@Test
	public void verifySearchWithInvalidProduct() {
		driver.findElement(By.name("search")).sendKeys("Hond");
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		String acualSearchMessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
		Assert.assertEquals(acualSearchMessage, "There is no product that matches the search criteria.","No product message in search is not displayed");
		}
	@Test
	public void verifySearchWithoutAnyProduct() {
		driver.findElement(By.name("search")).sendKeys("");
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		String acualSearchMessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
		Assert.assertEquals(acualSearchMessage, "There is no product that matches the search criteria.","No product message in search is not displayed");
		
		
	}

}
