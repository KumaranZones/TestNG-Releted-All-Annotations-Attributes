package org.dataProviderTest1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTest1 {

	@Test(dataProvider="qaTestData")
	public void dataProviderTests(String name1,String eMail1,String phoneNumber1,String address1) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://testautomationpractice.blogspot.com/");
	
		WebElement name = driver.findElement(By.xpath("//input[starts-with(@id,'name')]"));
		name.sendKeys(name1);
	
		WebElement eMail = driver.findElement(By.xpath("//input[starts-with(@id,'email')]"));
		eMail.sendKeys(eMail1);
	
		WebElement phoneNumber = driver.findElement(By.xpath("//input[starts-with(@id,'phone')]"));
		phoneNumber.sendKeys(phoneNumber1);
	
		WebElement address = driver.findElement(By.xpath("//textarea[starts-with(@id,'textarea')]"));
		address.sendKeys(address1);
	
		driver.close();
	}
	@DataProvider(name="qaTestData")
	public Object[][] qaData() {
		Object[][] data = {{"Kumaran","kumaran@gmail.com","9845236734","Salem"},
										{"Maran","maran@gmail.com","9856435638","Salem"},
										{"Mohan","mohan@gmail.com","9087654326","Salem"},
										{"Karthick","karthick@gmail.com","9845236734","Salem"},
										{"Karuppannan","karuppannan@gmail.com","9856435638","Salem"},
										{"Amutha","amutha@gmail.com","9845236734","Salem"},
										{"Palanigoundar","palanigoundar@gmail.com","9856435638","Salem"},
										{"Pachchiyammal","pachchiyammal@gmail.com","9087654326","Salem"},
										{"Palaniyappan","palaniyappan@gmail.com","9078667989","Salem"},
										{"Rajamani","rajamani@gmail.com","8975645353","Salem"},
										{"Harsanth","harsh@gmail.com","9087654326","Salem"},
										{"Rithvik","rithu@gmail.com","9845236734","Salem"},
										{"Murugan","murugan@gmail.com","9856435638","Salem"},
										{"Venky","venky@gmail.com","9087654326","Salem"},
										{"Iyyappan","iyyappan@gmail.com","87675647364","Salem"},
										{"Periyandavar","periyaandavar@gmail.com","9087654326","Salem"},
										{"Iyyanarappan","iyyanaarappan@gmail.com","9856435638","Salem"},
										{"Karuppusamy","karuppusamy@gmail.com","9845236734","Salem"}
										};
		return data;
	}
}
