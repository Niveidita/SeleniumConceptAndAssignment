package com.ha.daySixAssign;
//Assignment 6
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoEMRMessage {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // to maximise the screen
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("http://demo.openemr.io/b/openemr/");
		driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.id("clearPass")).sendKeys("pass");

		Select sel = new Select(driver.findElement(By.name("languageChoice")));
		sel.selectByVisibleText("English (Indian)");

		driver.findElement(By.xpath("//button[@class='btn btn-login btn-lg']")).click(); // login

		driver.findElement(By.xpath("//div[text()=\"Messages\"]")).click(); // message tab

		// Switch statement to get into the part .
		driver.switchTo().frame(driver.findElement(By.name("msg"))); // iframe[@name='msg'] // can use this xpath too instead of name.
																		
		driver.findElement(By.xpath("//a[@class='btn btn-primary btn-add']")).click(); // BTN -add new

		driver.findElement(By.id("note")).sendKeys("Hello");

		Select sel1 = new Select(driver.findElement(By.id("form_note_type")));
		sel1.selectByVisibleText("Pharmacy");

		Select sel2 = new Select(driver.findElement(By.id("form_message_status")));
		sel2.selectByVisibleText("New");

		Select sel3 = new Select(driver.findElement(By.id("users")));
//		sel3.selectByVisibleText("New");
		sel3.selectByIndex(1);

		driver.findElement(By.id("newnote")).click();

		String error = driver.findElement(By.id("error_reply_to")).getText(); // to get the title :error_reply_to
		System.out.println(error);

//		Please choose a patient
		driver.quit();
	}

}
