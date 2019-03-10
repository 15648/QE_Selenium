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

public class SignupTests {
	private static WebDriver driver;
	@BeforeClass
	public static void setUp() {
//		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dulce\\Downloads\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://localhost:8080/qeb_selenium_lesson/");
			
		WebElement nameInput = driver.findElement(By.name("name"));
		nameInput.sendKeys("testUser");
		
		driver.findElement(By.xpath("//*[@id='email_input']")).sendKeys("testEmail");
		
		WebElement passwordInput = driver.findElement(By.id("password_input"));
		passwordInput.sendKeys("testPassword");
		
		WebElement location = driver.findElement(By.xpath("//input[@value='Irving']"));
		//*[@class='featured-box']//*[test()='Testing']
		location.click();
		
		Select course = new Select(driver.findElement(By.id("course_select")));
		course.selectByVisibleText("Quality Assurance Engineering");
		
		WebElement language1 = driver.findElement(By.xpath("//input[@name='languages1']"));
		language1.click();
		
		WebElement language3 = driver.findElement(By.xpath("//input[@name='languages3']"));
		language3.click();
		
		WebElement startDate = driver.findElement(By.id("startdate_input"));
		startDate.sendKeys("4/21/2019");
		
		WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
		submitButton.click();
	}
	
	@AfterClass
	public static void tearDown() throws InterruptedException {
	driver.close();
	}
	
	@Test
	public void userNameTest() {
		WebElement userName = driver.findElement(By.id("success_userName"));
		assertThat("Name: testUser", equalTo(userName.getText()));	
	}
	
	@Test
	public void startDateTest() {
		WebElement successStartDate = driver.findElement(By.id("success_startDate"));
		assertThat("Start Date: 2019-04-21", equalTo(successStartDate.getText()));
	}

}
