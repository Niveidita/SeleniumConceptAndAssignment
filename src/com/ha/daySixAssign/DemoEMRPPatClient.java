package com.ha.daySixAssign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoEMRPPatClient {

	public static void main(String[] args) throws InterruptedException {

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

		driver.findElement(By.xpath("//div[text()='Patient/Client']")).click();
		driver.findElement(By.xpath("//div[text()='Patients']")).click();
		
		
		driver.switchTo().frame(driver.findElement(By.name("fin")));
		driver.findElement(By.id("create_patient_btn1")).click();  // BTN -Add New Patient

		driver.switchTo().defaultContent();		// used to get out of framework once we get in it 
		
//		driver.findElement(By.xpath("//input[@name='form_cb_1']")).click();   // who tick box????
		driver.switchTo().frame(driver.findElement(By.name("pat")));
		driver.findElement(By.id("form_fname")).sendKeys("Sam");   // first name 
		driver.findElement(By.id("form_lname")).sendKeys("Philip");   // last name 
		
		
		driver.findElement(By.id("form_DOB")).sendKeys("2022-02-06"); // dob
		
		Select sel1 = new Select(driver.findElement(By.id("form_sex")));
		sel1.selectByVisibleText("Male");
		
		driver.findElement(By.id("create")).click();  // BTN =create new pat
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.id("modalframe")));
		
		driver.findElement(By.xpath("//input[@value='Confirm Create New Patient']")).click();
		driver.switchTo().defaultContent();
		
		Thread.sleep(5000);
		
		String alertText = driver.switchTo().alert().getText();				//get out of the alert text box 
		System.out.println(alertText);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//div[@class='closeDlgIframe']")).click();
		
		String pName = driver.findElement(By.xpath("//span[@data-bind=\"text: pname()\"]")).getText();
		System.out.println(pName);
		
		driver.quit();
	}

}
