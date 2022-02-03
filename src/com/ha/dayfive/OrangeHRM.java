package com.ha.dayfive;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OrangeHRM {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // to maximise the screen
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		String actualTitle = driver.getTitle();				// to get the title 
		System.out.println(actualTitle);
		
		String url = driver.getCurrentUrl();				// to get the url 
		System.out.println(url);
		
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();	
		
		driver.quit();	
		
	}

}
