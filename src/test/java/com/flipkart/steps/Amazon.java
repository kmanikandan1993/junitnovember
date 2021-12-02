package com.flipkart.steps;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	static WebDriver driver;
	static long startTime;
	
	@BeforeClass
	public static void launch() {
		System.out.println("Before class");
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
@AfterClass
	public static void quit() {
		System.out.println("After class");
		// driver.quit();
	}
	@Before
public void startTime() {
		System.out.println("Before method");
		startTime = System.currentTimeMillis();
	}
	
	@After
	public void endTime() {
		System.out.println("After method");
		long endTime =System.currentTimeMillis();
		long tt = endTime-startTime;
		System.out.println("time taken;"+tt);
	}
	
	@Test
	
	public void test1() {
		
WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
search.sendKeys("mobile phones",Keys.ENTER);
WebElement  textvalue =driver.findElement(By.xpath("(//span[contains(text(),'Department')])[1]"));

Assert.assertEquals("Department",textvalue.getText());
		
	}
	
	
	}




