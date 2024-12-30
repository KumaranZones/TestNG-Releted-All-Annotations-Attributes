package org.descriptionAttribute;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DescriptionAttribute {

	public static WebDriver driver;

	@BeforeClass(description="This method is used to BrowserLaunch,BrowserMaximize, and use implicit wait")
	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}

	@Test(priority = -50,description="This method is used to URL launch")
	public void urlLaunch() {
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@Test(priority = -40,description="This method is used to enter the name in namefield")
	public void nameField() {
		WebElement name = driver.findElement(By.xpath("//input[starts-with(@id,'name')]"));
		name.sendKeys("Kumaran");
	}

	@Test(priority = -30,description="This method is used to enter the email in emailfield")
	public void eMailField() {
		WebElement eMail = driver.findElement(By.xpath("//input[starts-with(@id,'email')]"));
		eMail.sendKeys("kumaran@gmail.com");
	}

	@Test(priority = -20,description="This method is used to enter the phonenumber in phoneNumberfield")
	public void phoneNumberField() {
		WebElement phoneNumber = driver.findElement(By.xpath("//input[starts-with(@id,'phone')]"));
		phoneNumber.sendKeys("9578603546");
	}

	@Test(priority = -10,description="This method is used to enter the address in addressfield")
	public void addressField() {
		WebElement address = driver.findElement(By.xpath("//textarea[starts-with(@id,'textarea')]"));
		address.sendKeys("Salem");
	}

	@Test(priority = 10,description="This method is used to click the male radiobutton")
	public void genderRadioButton() {
		WebElement genderClick = driver.findElement(By.xpath("//input[@id='male']"));
		genderClick.click();
	}

	@Test(priority = 20,description="This method is used to click the day checkbox")
	public void daysCheckBox() {
		WebElement dayClick = driver.findElement(By.xpath("//input[@id='friday']"));
		dayClick.click();
	}

	@AfterClass(description="This method is used to close the Current browser [OR] current active window")
	public void browserClose() {
		driver.close();
	}
}
