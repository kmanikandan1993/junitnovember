package com.flipkart.steps;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
	static WebDriver driver;
	static long startTime;
	
	@BeforeClass
	public static void launch() {
		System.out.println("Before class");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
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
	public void test1() throws InterruptedException{
		Thread.sleep(2000);
			try {
			
			WebElement button = driver.findElement(By.xpath("//button[text()='✕']"));
			Thread.sleep(2000);
			button.isDisplayed();
			Thread.sleep(2000);
			button.click();
		} catch (Exception e) {
			
		System.out.println("pop up not displayed");	
		}
		
		WebElement bar = driver.findElement(By.name("q"));
		bar.sendKeys("realme mobile",Keys.ENTER);
	}
	static String MobileName;
	@Test
	public void test2() throws InterruptedException{
		Thread.sleep(2000);
	WebElement mobileName =	driver.findElement(By.xpath("(//div[contains(text(),'realme 8 (Cyber Black, 128 GB)')])[1]"));
	 MobileName = mobileName.getText();
	 System.out.println(MobileName);
	 Thread.sleep(2000);
	mobileName.click();
	}
	
	@Test
	public void test3() throws InterruptedException{
		String parentURL =driver.getWindowHandle();
		
		Set<String> childURL=driver.getWindowHandles();
  for(String child : childURL) {
	  if (!parentURL.equals(child)) {
		driver.switchTo().window(child);
	}
  }
	}
	@Ignore
	public void test4() {
		
WebElement newMobileName=driver.findElement(By.xpath("//span[contains(text(),'realme')]"));

String newMobile = newMobileName.getText();	
System.out.println(newMobile);

Assert.assertTrue(newMobile.equals(MobileName));
		
	}
	
	
	}

