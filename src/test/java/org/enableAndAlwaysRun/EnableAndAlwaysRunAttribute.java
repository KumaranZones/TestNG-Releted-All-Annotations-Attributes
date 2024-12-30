package org.enableAndAlwaysRun;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EnableAndAlwaysRunAttribute {

	//When we use the alwaysRun=true & enabled=false the enabled=false 
	//triggered even if The alwaysRun=true method pass [OR] fail.
	public WebDriver driver;

	@BeforeClass(alwaysRun=true)
	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority=-5,groups="browserAndUrlLaunch")
	public void urlLaunch() {
		driver.get("https://testautomationpractice.blogspot.com/");
	}
	@Test(priority=-2,groups="textField",enabled=false,alwaysRun=true)
	public void nameField() {
		WebElement name = driver.findElement(By.xpath("//input[starts-with(@id,'name')]"));
		name.sendKeys("Kumaran");
	}

	@Test(priority=-1,groups="textField")
	public void eMailField() {
		WebElement eMail = driver.findElement(By.xpath("//input[starts-with(@id,'email')]"));
		eMail.sendKeys("kumaran@gmail.com");
	}

	@Test(priority=0,groups="textField")
	public void phoneNumberField() {
		WebElement phoneNumber = driver.findElement(By.xpath("//input[starts-with(@id,'phone')]"));
		phoneNumber.sendKeys("9578603546");
	}

	@Test(priority=1,groups="textField",enabled=false,alwaysRun=true)
	public void addressField() {
		WebElement address = driver.findElement(By.xpath("//textarea[starts-with(@id,'textarea')]"));
		address.sendKeys("Salem");
	}
}
