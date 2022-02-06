package com.ha.dayfive;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GoTo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // to maximise the screen
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.goto.com/meeting/");
//		driver.findElement(By.partialLinkText("Sign in")).click();
		driver.findElement(By.id("truste-consent-button")).click();
		driver.findElement(By.xpath("//a[text()='Try Free']")).click();
		
		
		driver.findElement(By.id("first-name")).sendKeys("john");
		driver.findElement(By.id("last-name")).sendKeys("wick");
		driver.findElement(By.id("login__email")).sendKeys("“john@gmail.com");
		
		
		Select sel = new Select(driver.findElement(By.id("CompanySize")));  
		sel.selectByVisibleText("10 - 99");
//		sel.selectByIndex(2);
//		sel.selectByVisibleText("Company Size");
		
		driver.findElement(By.xpath("//button[text()='Start My Trial']")).click();
		
		String actualTitle = driver.getTitle();				// to get the title 
		System.out.println(actualTitle);
		
		
	}

}
