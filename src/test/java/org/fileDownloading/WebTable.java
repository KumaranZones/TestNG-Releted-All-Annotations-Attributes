package org.fileDownloading;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	driver.get("https://testautomationpractice.blogspot.com/");
	
	List<WebElement> tableheaderRows = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div/div/div/div[3]/div/table/tbody/tr"));
	int tableheaderRowsSize = tableheaderRows.size();
	for(int i=1; i<=tableheaderRowsSize; i++) {
		List<WebElement> tableColumnRows = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div/div/div/div[3]/div/table/tbody/tr["+i+"]/td"));
		int tableColumnRowsSize = tableColumnRows.size();
		for(int j=1; j<=tableColumnRowsSize; j++) {
			String value = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div/div/div/div[3]/div/table/tbody/tr["+i+"]/td["+j+"]")).getText();
			System.out.print(value+"|");
		}
		System.out.println();
	}
}
}
