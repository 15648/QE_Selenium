package com.perscholas.qeb_selenium_lesson.automation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PurchaseBooksTest {
	private static WebDriver driver;
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dulce\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/qeb_selenium_lesson/successPage/");
		
		WebElement submitButton = driver.findElement(By.xpath("//input[@value='By Books']"));
		submitButton.click();
		
	}
	
//	@AfterClass
//	public static void tearDown() throws InterruptedException {
//		driver.close();
//	}
	
	@Test
	public void purchaseBooksTest() {
		
	}

}
