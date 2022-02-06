package com.ha.daySixAssign;
//Assignment day 6 
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SalesForce {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // to maximise the screen
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/");
		driver.findElement(By.xpath("//input[@name='UserFirstName']")).sendKeys("john");
		driver.findElement(By.xpath("//input[@name='UserLastName']")).sendKeys("wick");
		driver.findElement(By.xpath("//input[@name='UserEmail']")).sendKeys("john@gmail.com");
		
//		Select sel = new Select(driver.findElement(By.id("CompanySize")));  
//		sel.selectByVisibleText("10 - 99");
		
		Select sel = new Select(driver.findElement(By.name("UserTitle")));
		sel.selectByVisibleText("IT Manager");
		
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("google");
		
		
//		driver.findElement(By.xpath("//input[@name='UserPhone']")).sendKeys("9393373739");
		
		Select sel3 = new Select(driver.findElement(By.name("CompanyCountry")));
		sel3.selectByVisibleText("United Kingdom");

		Select sel1 = new Select(driver.findElement(By.name("CompanyEmployees")));
		sel1.selectByVisibleText("101 - 500 employees");	
		
//		driver.findElement(By.id("SubscriptionAgreement")).click();
		driver.findElement(By.xpath("(//div[@class='checkbox-ui'])[1]")).click();
		
		driver.findElement(By.name("start my free trial")).click();
		
		
		String phoneErrorMsg = driver.findElement(By.xpath("//span[contains(text(),\"Enter a valid phone number\")]")).getText();
		System.out.println(phoneErrorMsg);
		
	
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
