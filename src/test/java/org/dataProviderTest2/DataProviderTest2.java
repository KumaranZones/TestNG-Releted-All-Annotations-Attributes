package org.dataProviderTest2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTest2 {

	@Test(dataProvider="qaTestDatas")
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
	
	@DataProvider(name="qaTestDatas")
	public Object[][] datas() {
		ExcelReaderClass excel = new ExcelReaderClass(".\\Excel\\KumaranEx5.xlsx", "qaTestDatas");
		int rows = excel.findRow();
		int cells = excel.findCell();
		return excel.findValues(rows, cells);
	}
}
