package org.priorityAttribute;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PriorityAttribute {
	public static WebDriver driver;

	@BeforeClass
	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}

	@Test(priority = -50)
	public void urlLaunch() {
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@Test(priority = -40)
	public void nameField() {
		WebElement name = driver.findElement(By.xpath("//input[starts-with(@id,'name')]"));
		name.sendKeys("Kumaran");
	}

	@Test(priority = -30)
	public void eMailField() {
		WebElement eMail = driver.findElement(By.xpath("//input[starts-with(@id,'email')]"));
		eMail.sendKeys("kumaran@gmail.com");
	}

	@Test(priority = -20)
	public void phoneNumberField() {
		WebElement phoneNumber = driver.findElement(By.xpath("//input[starts-with(@id,'phone')]"));
		phoneNumber.sendKeys("9578603546");
	}

	@Test(priority = -10)
	public void addressField() {
		WebElement address = driver.findElement(By.xpath("//textarea[starts-with(@id,'textarea')]"));
		address.sendKeys("Salem");
	}

	@Test(priority = 10)
	public void genderRadioButton() {
		WebElement genderClick = driver.findElement(By.xpath("//input[@id='male']"));
		genderClick.click();
	}

	@Test(priority = 20)
	public void daysCheckBox() {
		WebElement dayClick = driver.findElement(By.xpath("//input[@id='friday']"));
		dayClick.click();
	}

	@AfterClass
	public void browserClose() {
		driver.close();
	}

}
