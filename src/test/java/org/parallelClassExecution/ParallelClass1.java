package org.parallelClassExecution;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelClass1 {

	public WebDriver driver;

	@BeforeClass
	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@Test
	public void nameField() {
		WebElement name = driver.findElement(By.xpath("//input[starts-with(@id,'name')]"));
		name.sendKeys("Kumaran");
		System.out.println(Thread.currentThread().getId());
	}

	@Test
	public void eMailField() {
		WebElement eMail = driver.findElement(By.xpath("//input[starts-with(@id,'email')]"));
		eMail.sendKeys("kumaran@gmail.com");
		System.out.println(Thread.currentThread().getId());
	}

	@Test
	public void phoneNumberField() {
		WebElement phoneNumber = driver.findElement(By.xpath("//input[starts-with(@id,'phone')]"));
		phoneNumber.sendKeys("9578603546");
		System.out.println(Thread.currentThread().getId());
	}

	@Test
	public void addressField() {
		WebElement address = driver.findElement(By.xpath("//textarea[starts-with(@id,'textarea')]"));
		address.sendKeys("Salem");
		System.out.println(Thread.currentThread().getId());
	}

	@Test
	public void genderRadioButton() {
		WebElement genderClick = driver.findElement(By.xpath("//input[@id='male']"));
		genderClick.click();
		System.out.println(Thread.currentThread().getId());
	}

	@Test
	public void daysCheckBox() {
		WebElement dayClick = driver.findElement(By.xpath("//input[@id='friday']"));
		dayClick.click();
		System.out.println(Thread.currentThread().getId());
	}
	@AfterClass
	public void browserClose() {
		driver.close();
	}
}
