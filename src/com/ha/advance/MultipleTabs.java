package com.ha.advance;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleTabs {

	public static void main(String[] args) throws InterruptedException {
			
			System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Webdrivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize(); // to maximise the screen
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			driver.get("https://db4free.net/");
			driver.findElement(By.partialLinkText("phpMyAdmin")).click();
			
			// to change to second tab opened after clicking first tab use array concept .
		    List<String> windows = new ArrayList<String>(driver.getWindowHandles());
		    driver.switchTo().window(windows.get(1));
		    
		    driver.findElement(By.id("input_username")).sendKeys("Scooby");
		    driver.findElement(By.id("input_password")).sendKeys("doo");
		    driver.findElement(By.id("input_go")).click();
		    
		    Thread.sleep(5000);
		    driver.quit();

	}

}
