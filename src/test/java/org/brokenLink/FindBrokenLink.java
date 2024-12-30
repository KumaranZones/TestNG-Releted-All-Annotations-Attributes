package org.brokenLink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindBrokenLink {

	public static void main(String[] args)  {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://testautomationpractice.blogspot.com/");
	
		Set<String> brokenLinkUrl = new HashSet();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(WebElement allLinks : links) {
			String linkUrl = allLinks.getAttribute("href");
			try {
			URL url = new URL(linkUrl);
			URLConnection openConnection = url.openConnection();
			HttpURLConnection httpUrlConnection = (HttpURLConnection)openConnection;
			httpUrlConnection.setConnectTimeout(5000);
			httpUrlConnection.connect();
			if(httpUrlConnection.getResponseCode()==404) {
				brokenLinkUrl.add(linkUrl);
			}
			httpUrlConnection.disconnect();
			}catch(Exception e) {
				
			}
			for(String brokenLinksUrls :brokenLinkUrl) {
				System.out.println(brokenLinksUrls);
			}
		}
//		WebElement brokenLink1 = driver.findElement(By.xpath("//a[text()='Errorcode 400']"));
//		String brokenLinks1 = brokenLink1.getAttribute("href");
		

		
	}
}
