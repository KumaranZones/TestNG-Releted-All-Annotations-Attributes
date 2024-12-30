package org.fileDownloading;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownloadAndValidate {


	@Test
	public void browserLaunch() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		driver.get("https://www.tutorialspoint.com/selenium/practice/upload-download.php");
		
		WebElement downloadClick = driver.findElement(By.xpath("//a[text()='Download']"));
		downloadClick.click();
		
		Thread.sleep(10000);
		
		File fileLocation = new File("C:\\Users\\kumar\\Downloads");
		File[] allFiles = fileLocation.listFiles();
		for(File files : allFiles) {
			if(files.getName().equals("sampleFile.JPEG File")) {
				System.out.println("File Downloaded");
				break;
			}else {
				System.out.println("File not Downloaded");
			}
		}
	}
}
