package com.ha.dayfive;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Nasscom {

	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // to maximise the screen
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://nasscom.in/");
		
//		driver.findElement(By.xpath(" //a[text()=' New User ']")).click();    //try this or nxt both works 
		driver.findElement(By.partialLinkText("New User")).click();			  //both are alternative
		
		driver.findElement(By.id("edit-field-fname-reg")).sendKeys("Admin");
		driver.findElement(By.id("edit-field-lname")).sendKeys("pass");
		driver.findElement(By.id("edit-mail")).sendKeys("admin@gmail.com");
		driver.findElement(By.id("edit-field-company-name-registration")).sendKeys("google");
		driver.findElement(By.id("edit-field-business-focus-reg")).click();
		
		Select sel = new Select(driver.findElement(By.id("edit-field-business-focus-reg")));  
		sel.selectByVisibleText("IT Consulting");
		
		driver.findElement(By.id("edit-submit--2")).click(); 
		
		

	}

}
