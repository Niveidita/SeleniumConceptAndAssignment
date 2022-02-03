package com.ha.dayfive;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GitHub {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // to maximise the screen
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://github.com/");
		driver.findElement(By.partialLinkText("Sign in")).click();
		driver.findElement(By.id("login_field")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("admin123");
		driver.findElement(By.id("password")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//input[@name='commit']")).click();
		
	}

}
