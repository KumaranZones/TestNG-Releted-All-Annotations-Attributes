package org.depndsOnMethodsAndPriority;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DependsOnMethodsAndPriority {

	public WebDriver driver;

	@BeforeClass
	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@Test(priority=2)
	public void nameField() {
		WebElement name = driver.findElement(By.xpath("//input[starts-with(@id,'name')]"));
		name.sendKeys("Kumaran");
	}

	@Test(priority=-1,dependsOnMethods="nameField")
	public void eMailField() {
		WebElement eMail = driver.findElement(By.xpath("//input[starts-with(@id,'email')]"));
		eMail.sendKeys("kumaran@gmail.com");
	}

	@Test(priority=5,dependsOnMethods="eMailField")
	public void phoneNumberField() {
		WebElement phoneNumber = driver.findElement(By.xpath("//input[starts-with(@id,'phone')]"));
		phoneNumber.sendKeys("9578603546");
	}

	@Test(priority=-1,dependsOnMethods="phoneNumberField")
	public void addressField() {
		WebElement address = driver.findElement(By.xpath("//textarea[starts-with(@id,'textarea')]"));
		address.sendKeys("Salem");
	}
	@Test(priority=-2,dependsOnMethods="addressField")
	public void genderRadioButton() {
		WebElement genderClick = driver.findElement(By.xpath("//input[@id='male']"));
		genderClick.click();
	}

	@Test(priority=-3,dependsOnMethods="genderRadioButton")
	public void daysCheckBox() {
		WebElement dayClick = driver.findElement(By.xpath("//input[@id='friday']"));
		dayClick.click();
	}
	@AfterClass(alwaysRun=true)
	public void browserClose() {
		driver.close();
	}
}
