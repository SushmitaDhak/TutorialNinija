package com.tutorialsninja.qa.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	WebDriver driver;
	public WebDriver intilizeBrowserAndOpenApplicationURL(String browserName ) {
		
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
			driver.get("https://tutorialsninja.com/demo/");
			driver.findElement(By.xpath("//span[text()='My Account']")).click();
			driver.findElement(By.linkText("Login")).click();
			return driver;
	}
	

}
