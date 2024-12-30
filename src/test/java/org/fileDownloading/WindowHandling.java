package org.fileDownloading;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement newTabTextField = driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']"));
		newTabTextField.sendKeys("TestNG");
		WebElement clickTheSearchButton = driver.findElement(By.xpath("//input[@type='submit']"));
		clickTheSearchButton.click();
		
		WebElement testNGClick = driver.findElement(By.xpath("//a[text()='TestNG']"));
		testNGClick.click();
		Set<String> allWindows = driver.getWindowHandles();
		List list = new ArrayList(allWindows);
		driver.switchTo().window( (String) list.get(1));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		WebElement clickWikimediaFoundation = driver.findElement(By.xpath("//a[text()='Wikimedia Foundation, Inc.']"));
		clickWikimediaFoundation.click();
		
		WebElement tab1 = driver.findElement(By.xpath("(//a[contains(text(),'CC BY-SA 4.0')])[1]"));
		js.executeScript("arguments[0].scrollIntoView();",tab1);
		js.executeScript("window.scrollBy(0,-100)");
		tab1.click();
		
		
		
		Set<String> allWindows2 = driver.getWindowHandles();
		List list1 = new ArrayList(allWindows2);
		driver.switchTo().window( (String) list1.get(3));
		driver.close();
		driver.switchTo().window( (String) list1.get(2));
		driver.close();
		driver.switchTo().window( (String) list1.get(1));
		driver.close();
		driver.switchTo().window( (String) list1.get(0));
	}
}
