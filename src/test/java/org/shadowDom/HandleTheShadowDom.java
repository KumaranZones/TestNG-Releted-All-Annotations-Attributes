package org.shadowDom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleTheShadowDom {

	public static void main(String[] args)  {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement shadowHost = driver.findElement(By.cssSelector("#shadow_host"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Object shadowRoot =  js.executeScript("return arguments[0].shadowRoot", shadowHost);
		WebElement inputField = (WebElement) js.executeScript(
                "return arguments[0].querySelector('input[type=\"text\"]')", shadowRoot);
            inputField.sendKeys("Hello, Shadow DOM!");
		
		
	}
}

//
//public static void main(String[] args) {
//    // Step 1: Set up WebDriver
//    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//    WebDriver driver = new ChromeDriver();
//
//    try {
//        // Step 2: Navigate to the webpage
//        driver.get("https://example.com");
//
//        // Step 3: Locate the Shadow Host
//        WebElement shadowHost = driver.findElement(By.cssSelector("#shadow_host"));
//
//        // Step 4: Access the Shadow Root
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        WebElement shadowRoot = (WebElement) jsExecutor.executeScript(
//            "return arguments[0].shadowRoot", shadowHost);
//
//        // Step 5: Locate an element inside the Shadow DOM
//        WebElement inputField = (WebElement) jsExecutor.executeScript(
//            "return arguments[0].querySelector('input[type=\"text\"]')", shadowRoot);
//        inputField.sendKeys("Hello, Shadow DOM!");
//
//        // Step 6: Handle nested Shadow DOM (if needed)
//        WebElement nestedShadowHost = (WebElement) jsExecutor.executeScript(
//            "return arguments[0].querySelector('#nested_shadow_host')", shadowRoot);
//        WebElement nestedShadowRoot = (WebElement) jsExecutor.executeScript(
//            "return arguments[0].shadowRoot", nestedShadowHost);
//        WebElement nestedInputField = (WebElement) jsExecutor.executeScript(
//            "return arguments[0].querySelector('input[type=\"text\"]')", nestedShadowRoot);
//        nestedInputField.sendKeys("Hello from Nested Shadow DOM!");
//
//    } catch (Exception e) {
//        e.printStackTrace();
//    } finally {
//        // Step 7: Close the browser
//        driver.quit();
//    }
//}
//}





//1. Using Selenium 4's WebDriver BiDi Protocol
//Selenium 4 provides better support for Shadow DOM. Instead of directly using JavaScript, you can use its findElement API in combination with shadow root handling.
//
//Here’s how:
//
//java
//Copy code
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class ShadowDomExample {
//    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//        WebDriver driver = new ChromeDriver();
//
//        try {
//            // Open the target webpage
//            driver.get("https://example.com");
//
//            // Locate the Shadow Host
//            WebElement shadowHost = driver.findElement(By.cssSelector("#shadow_host"));
//
//            // Access the shadowRoot directly with Selenium 4
//            WebElement shadowRoot = shadowHost.getShadowRoot();
//
//            // Locate the text input inside the Shadow DOM
//            WebElement inputField = shadowRoot.findElement(By.cssSelector("input[type='text']"));
//
//            // Interact with the element
//            inputField.sendKeys("Hello from Selenium 4!");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            driver.quit();
//        }
//    }
//}
