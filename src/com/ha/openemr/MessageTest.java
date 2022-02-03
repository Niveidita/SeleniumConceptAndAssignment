package com.ha.openemr;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MessageTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // to maximise the screen
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // to set timer to authenticate the creds if its wrong for all fields .
		
		driver.get("https://demo.openemr.io/b/openemr");
		
		// to do it separately one by one 
//		WebElement ele = driver.findElement(By.id("authUser"));
//		ele.sendKeys("admin");
//		ele.sendKeys("clearPass");
		
		// to do it all in one 
		driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		
		Select sel = new Select(driver.findElement(By.name("languageChoice")));  // try this for dropdown, when u have select tag 
		sel.selectByVisibleText("English (Indian)");
			
		driver.findElement(By.xpath("//button[@type='submit']")).click();		
		
		String actualTitle = driver.getTitle();				// to get the title 
		System.out.println(actualTitle);
		
		String url = driver.getCurrentUrl();				// to get the url 
		System.out.println(url);
		
		driver.quit();
		
		
		
	}
	

}
