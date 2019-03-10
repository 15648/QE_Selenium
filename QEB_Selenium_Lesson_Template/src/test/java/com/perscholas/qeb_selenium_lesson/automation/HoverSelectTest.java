package com.perscholas.qeb_selenium_lesson.automation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HoverSelectTest {
	private static WebDriver driver;
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dulce\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/qeb_selenium_lesson/");
		
		WebElement dropDown = driver.findElement(By.xpath("/html/body/header/div/button"));
		Actions action = new Actions(driver);
		action.moveToElement(dropDown).perform();
		/* We can use the following line, but it is risky because the item may not 
		 * become visible prior to the code attempting to locate the item which will
		 * result in an exception being thrown */
		
//      driver.findElement(By.xpath("/html/body/header/div/div/a[3]")).click();
        
       /* The following lines are preferable when working with drop-down menus and 
        * other similar hover functions.
        */
       WebDriverWait wait = new WebDriverWait(driver, 10);
       WebElement goToBookstore = 
               wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/header/div/div/a[3]")));
       goToBookstore.click();
       
       driver.findElement(By.xpath("//*[@id=\"book1Add\"]")).click();
       driver.findElement(By.xpath("//*[@id=\"book2Add\"]")).click();
       driver.findElement(By.xpath("//*[@id=\"book3Add\"]")).click();		
	}
	
//	@AfterClass
//	public static void tearDown() throws InterruptedException {
//		driver.close();
//	}
	
	@Test
	public void selectBooksTest() {
		String total = driver.findElement(By.xpath("//*[@id=\"cart_total\"]")).getText();
//		System.out.println(total);
//		assertThat("Cart Total: 49.97", equalTo(total));
		assertEquals("Cart Total: 49.97", total);
	}

}
