package org.assertion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertions {

	public static WebDriver driver;

	@BeforeClass(alwaysRun=true)
	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void urlLaunch() {
		driver.get("https://testautomationpractice.blogspot.com/");
	}
	@Test(dependsOnMethods="urlLaunch")
	public void urlAndPageTitleValidation() {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String actualCurrentUrl = driver.getCurrentUrl();
		System.out.println(actualCurrentUrl);
		String expectedTitle = "Automation Testing Practice";
		String expectedCurrentUrl = "https://testautomationpractice.blogspot.com/";
		
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertEquals(actualCurrentUrl, expectedCurrentUrl);
	}
	@Test(dependsOnMethods="urlAndPageTitleValidation")
	public void nameField() {
		WebElement name = driver.findElement(By.xpath("//input[starts-with(@id,'name')]"));
		name.sendKeys("Kumaran");
		
		String actual = "Kumaran";
		String expected = name.getAttribute("value");
		Assert.assertEquals(expected, actual);
		boolean displayed = name.isDisplayed();
		boolean enabled = name.isEnabled();
		Assert.assertTrue(displayed);
		Assert.assertTrue(enabled);
	}
	@Test(dependsOnMethods="nameField")
	public void eMailField() {
		WebElement eMail = driver.findElement(By.xpath("//input[starts-with(@id,'email')]"));
		eMail.sendKeys("kumaran@gmail.com");
		
		String actual = "kumaran@gmail.com";
		String expected = eMail.getAttribute("value");
		Assert.assertEquals(expected, actual);
		boolean displayed = eMail.isDisplayed();
		boolean enabled = eMail.isEnabled();
		Assert.assertTrue(displayed);
		Assert.assertTrue(enabled);
	}
	@Test(dependsOnMethods="eMailField")
	public void phoneNumberField() {
		WebElement phoneNumber = driver.findElement(By.xpath("//input[starts-with(@id,'phone')]"));
		phoneNumber.sendKeys("9578603546");
		
		String actual = "9578603546";
		String expected = phoneNumber.getAttribute("value");
		Assert.assertEquals(expected, actual);
		boolean displayed = phoneNumber.isDisplayed();
		boolean enabled = phoneNumber.isEnabled();
		Assert.assertTrue(displayed);
		Assert.assertTrue(enabled);
	}
	@Test(dependsOnMethods="phoneNumberField")
	public void addressField() {
		WebElement address = driver.findElement(By.xpath("//textarea[starts-with(@id,'textarea')]"));
		address.sendKeys("Salem");
		
		String actual = "Salem";
		String expected = address.getAttribute("value");
		Assert.assertEquals(expected, actual);
		boolean displayed = address.isDisplayed();
		boolean enabled = address.isEnabled();
		Assert.assertTrue(displayed);
		Assert.assertTrue(enabled);
		
		WebElement genderClick = driver.findElement(By.xpath("//input[@id='male']"));
		boolean selected = genderClick.isSelected();
		Assert.assertFalse(selected);
	}
	@Test(dependsOnMethods="addressField")
	public void genderRadioButton() {
		WebElement genderClick = driver.findElement(By.xpath("//input[@id='male']"));
		genderClick.click();
		boolean displayed = genderClick.isDisplayed();
		boolean enabled = genderClick.isEnabled();
		boolean selected = genderClick.isSelected();
		Assert.assertTrue(displayed);
		Assert.assertTrue(enabled);
		Assert.assertTrue(selected);
		
		WebElement dayClick = driver.findElement(By.xpath("//input[@id='friday']"));
		boolean selected1 = dayClick.isSelected();
		Assert.assertFalse(selected1);
		
	}
	@Test(dependsOnMethods="genderRadioButton")
	public void dayCheckBox() {
		WebElement dayClick = driver.findElement(By.xpath("//input[@id='friday']"));
		boolean displayed = dayClick.isDisplayed();
		boolean enabled = dayClick.isEnabled();
		Assert.assertTrue(displayed);
		Assert.assertTrue(enabled);
		dayClick.click();
		boolean selected = dayClick.isSelected();
		Assert.assertTrue(selected);
		
	}

}
