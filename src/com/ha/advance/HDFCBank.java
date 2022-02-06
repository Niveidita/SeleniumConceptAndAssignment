package com.ha.advance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HDFCBank {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // to maximise the screen
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://netbanking.hdfcbank.com/netbanking/");

		// inside frame u have ID so choose frame first then select the value .
		driver.switchTo().frame(driver.findElement(By.name("login_page")));
		driver.findElement(By.xpath("//input[@name='fldLoginUserId'] ")).sendKeys("test123");
		driver.findElement(By.xpath("//a[text()='CONTINUE']")).click();

		// Click on ctrl+Shift+i when right click is restricted .

		driver.findElement(By.xpath("//a[text()='Forgot Password / IPIN']")).click();
		driver.findElement(By.xpath("//img[@src='gif/go.gif']")).click();

		String alertText = driver.switchTo().alert().getText();				//get out of the alert text box 
		System.out.println(alertText);

		driver.switchTo().alert().accept();

		Thread.sleep(5000);
		driver.quit();

//		driver.findElement(By.partialLinkText("Sign in")).click();
//		driver.findElement(By.id("truste-consent-button")).click();
//		
	}

}
