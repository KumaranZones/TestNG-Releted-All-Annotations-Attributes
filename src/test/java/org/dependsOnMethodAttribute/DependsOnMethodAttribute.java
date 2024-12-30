package org.dependsOnMethodAttribute;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DependsOnMethodAttribute {

	public WebDriver driver;

	@BeforeClass
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
	public void getTheAllTagsCount() {
		List<WebElement> aTags = driver.findElements(By.tagName("a"));
		System.out.println(aTags.size());
		List<WebElement> inputTags = driver.findElements(By.tagName("input"));
		System.out.println(inputTags.size());
		List<WebElement> buttonTags = driver.findElements(By.tagName("button"));
		System.out.println(buttonTags.size());
		List<WebElement> optionTags = driver.findElements(By.tagName("option"));
		System.out.println(optionTags.size());
		List<WebElement> liTags = driver.findElements(By.tagName("li"));
		System.out.println(liTags.size());
		List<WebElement> ulTags = driver.findElements(By.tagName("ul"));
		System.out.println(inputTags.size());
		List<WebElement> divTags = driver.findElements(By.tagName("div"));
		System.out.println(divTags.size());
		List<WebElement> htmlTags = driver.findElements(By.tagName("html"));
		System.out.println(htmlTags.size());
		List<WebElement> bodyTags = driver.findElements(By.tagName("body"));
		System.out.println(bodyTags.size());
		List<WebElement> selectTags = driver.findElements(By.tagName("select"));
		System.out.println(selectTags.size());
		List<WebElement> tbodyTags = driver.findElements(By.tagName("tbody"));
		System.out.println(tbodyTags.size());
		List<WebElement> theadTags = driver.findElements(By.tagName("thead"));
		System.out.println(theadTags.size());
		List<WebElement> trTags = driver.findElements(By.tagName("tr"));
		System.out.println(trTags.size());
		List<WebElement> tdTags = driver.findElements(By.tagName("td"));
		System.out.println(tdTags.size());
		List<WebElement> frameTags = driver.findElements(By.tagName("frame"));
		System.out.println(frameTags.size());
		List<WebElement> iframeTags = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeTags.size());
		List<WebElement> tableTags = driver.findElements(By.tagName("table"));
		System.out.println(tableTags.size());
		List<WebElement> svgTags = driver.findElements(By.tagName("svg"));
		System.out.println(svgTags.size());
		List<WebElement> h1Tags = driver.findElements(By.tagName("h1"));
		System.out.println(h1Tags.size());
		List<WebElement> spanTags = driver.findElements(By.tagName("span"));
		System.out.println(spanTags.size());
		List<WebElement> formTags = driver.findElements(By.tagName("form"));
		System.out.println(formTags.size());
		List<WebElement> scriptTags = driver.findElements(By.tagName("script"));
		System.out.println(scriptTags.size());
		List<WebElement> mainTags = driver.findElements(By.tagName("main"));
		System.out.println(mainTags.size());
	}

	@Test(dependsOnMethods="getTheAllTagsCount")
	public void getTheAllTextOfTheLinksAndText() {
		List<WebElement> aTags = driver.findElements(By.tagName("a"));
		for (WebElement allLinks : aTags) {
			System.out.println(allLinks.getText() + "----->" + allLinks.getAttribute("href"));
		}
	}

	@Test(dependsOnMethods="getTheAllTextOfTheLinksAndText")
	public void nameField() {
		WebElement name = driver.findElement(By.xpath("//input[starts-with(@id,'name')]"));
		name.sendKeys("Kumaran");
	}

	@Test(dependsOnMethods="nameField")
	public void eMailField() {
		WebElement eMail = driver.findElement(By.xpath("//input[starts-with(@id,'email')]"));
		eMail.sendKeys("kumaran@gmail.com");
	}

	@Test(dependsOnMethods="eMailField")
	public void phoneNumberField() {
		WebElement phoneNumber = driver.findElement(By.xpath("//input[starts-with(@id,'phone')]"));
		phoneNumber.sendKeys("9578603546");
	}

	@Test(dependsOnMethods="phoneNumberField")
	public void addressField() {
		WebElement address = driver.findElement(By.xpath("//textarea[starts-with(@id,'textarea')]"));
		address.sendKeys("Salem");
	}

	@Test(dependsOnMethods="addressField")
	public void genderRadioButton() {
		WebElement genderClick = driver.findElement(By.xpath("//input[@id='male']"));
		genderClick.click();
	}

	@Test(dependsOnMethods="genderRadioButton")
	public void daysCheckBox() {
		WebElement dayClick = driver.findElement(By.xpath("//input[@id='friday']"));
		dayClick.click();
	}

	@Test(dependsOnMethods="daysCheckBox")
	public void dropdown1() {
		WebElement selectAustralia = driver.findElement(By.xpath("//select[@id='country']"));
		Select s = new Select(selectAustralia);
		s.selectByValue("australia");

		WebElement selectChina = driver.findElement(By.xpath("//select[@id='country']"));
		selectChina.click();
		List<WebElement> allOptions = driver.findElements(By.xpath("//select[@id='country']//option"));
		for (WebElement all : allOptions) {
			if (all.getText().equalsIgnoreCase("China")) {
				all.click();
				break;
			}
		}
		List<WebElement> getAllText = driver.findElements(By.xpath("//select[@id='country']//option"));
		for (WebElement all : getAllText) {
			System.out.println(all.getText());
		}

	}

	@Test(dependsOnMethods="dropdown1")
	public void dropdown2() {
		WebElement selectGreen = driver.findElement(By.xpath("//select[@id='colors']"));
		Select s = new Select(selectGreen);
		s.selectByVisibleText("Green");

		List<WebElement> selectWhite = driver.findElements(By.xpath("//select[@id='colors']//option"));
		for (WebElement all : selectWhite) {
			if (all.getText().equalsIgnoreCase("White")) {
				all.click();
				break;
			}
		}
		List<WebElement> getAllText = driver.findElements(By.xpath("//select[@id='colors']//option"));
		for (WebElement all : getAllText) {
			System.out.println(all.getText());
		}
	}

	@Test(dependsOnMethods="dropdown2")
	public void dropdown3() {
		WebElement selectCat = driver.findElement(By.xpath("//select[@id='animals']"));
		Select s = new Select(selectCat);
		s.selectByVisibleText("Cat");

		List<WebElement> selectElephant = driver.findElements(By.xpath("//select[@id='animals']//option"));
		for (WebElement all : selectElephant) {
			if (all.getText().equalsIgnoreCase("Elephant")) {
				all.click();
				break;
			}
		}
		List<WebElement> getAllText = driver.findElements(By.xpath("//select[@id='animals']//option"));
		for (WebElement all : getAllText) {
			System.out.println(all.getText());
		}
	}

	@Test(dependsOnMethods="dropdown3")
	public void datePicker1() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		WebElement datePickerClick = driver.findElement(By.xpath("//input[@id='datepicker']"));
		datePickerClick.click();

		String month = "August";
		String year = "2025";
		String date = "15";

		while (true) {
			WebElement months = driver.findElement(By.xpath("(//div[@class='ui-datepicker-title']//span)[1]"));
			WebElement years = driver.findElement(By.xpath("(//div[@class='ui-datepicker-title']//span)[2]"));

			String augustMonth = months.getText();
			String yearss = years.getText();
			if (augustMonth.equalsIgnoreCase(month) && yearss.equalsIgnoreCase(year)) {
				break;
			} else {
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
		}
		List<WebElement> selectDate = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
		for (WebElement all : selectDate) {
			if (all.getText().equalsIgnoreCase(date)) {
				all.click();
				break;
			}
		}
	}

	@Test(dependsOnMethods="datePicker1")
	public void datePicker2() {
		WebElement datePickerClick = driver.findElement(By.xpath("//input[@id='txtDate']"));
		datePickerClick.click();

		WebElement monthDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select s = new Select(monthDropdown);
		s.selectByVisibleText("Aug");

		WebElement yearDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select s1 = new Select(yearDropdown);
		s1.selectByVisibleText("2025");

		List<WebElement> selectDate = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
		for (WebElement all : selectDate) {
			if (all.getText().equalsIgnoreCase("15")) {
				all.click();
				break;
			}
		}
	}

	@Test(dependsOnMethods="datePicker2")
	public void windowHandling1() throws InterruptedException {
		WebElement datePickerClick = driver.findElement(By.xpath("//a[text()='Posts (Atom)']"));
		datePickerClick.click();

		Set<String> allWindows = driver.getWindowHandles();
		List list = new ArrayList(allWindows);
		driver.switchTo().window((String) list.get(1));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(1000);

		driver.close();

		driver.switchTo().window((String) list.get(0));
	}

	@Test(dependsOnMethods="windowHandling1")
	public void windowHandling2() throws InterruptedException {
		WebElement datePickerClick = driver.findElement(By.xpath("//a[text()='Posts (Atom)']"));
		datePickerClick.click();

		Set<String> allWindows = driver.getWindowHandles();
		List list = new ArrayList(allWindows);
		driver.switchTo().window((String) list.get(1));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(1000);

		driver.close();

		driver.switchTo().window((String) list.get(0));
		WebElement getThePostAdomText = driver.findElement(By.xpath("//a[text()='Posts (Atom)']"));
		System.out.println(getThePostAdomText.getText());
	}

	@Test(dependsOnMethods="windowHandling2")
	public void uploadFile1() {
		WebElement uploadFiles = driver.findElement(By.xpath("//button[text()='Upload Single File']"));
		Actions as = new Actions(driver);
		as.moveToElement(uploadFiles).build().perform();
		uploadFiles.click();
	}

	@Test(dependsOnMethods="uploadFile1")
	public void uploadFile2() {
		WebElement uploadFiles = driver.findElement(By.xpath("//button[text()='Upload Multiple Files']"));
		Actions as = new Actions(driver);
		as.moveToElement(uploadFiles).build().perform();
		uploadFiles.click();
	}

	@Test(dependsOnMethods="uploadFile2")
	public void webTable1() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		List<WebElement> tableheaderRows = driver.findElements(By.xpath(
				"/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div/div/div/div[3]/div/table/tbody/tr"));
		int tableheaderRowsSize = tableheaderRows.size();
		for (int i = 1; i <= tableheaderRowsSize; i++) {
			List<WebElement> tableColumnRows = driver.findElements(By.xpath(
					"/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div/div/div/div[3]/div/table/tbody/tr["
							+ i + "]/td"));
			int tableColumnRowsSize = tableColumnRows.size();
			for (int j = 1; j <= tableColumnRowsSize; j++) {
				String value = driver.findElement(By.xpath(
						"/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div/div/div/div[3]/div/table/tbody/tr["
								+ i + "]/td[" + j + "]"))
						.getText();
				System.out.print(value + "|");

			}
			System.out.println();
		}
	}

	@Test(dependsOnMethods="webTable1")
	public void webTable2() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		List<WebElement> tableheaderRows = driver.findElements(By.xpath(
				"/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div/div/div/div[4]/div/table/tbody/tr"));
		int tableheaderRowsSize = tableheaderRows.size();
		for (int i = 1; i <= tableheaderRowsSize; i++) {
			List<WebElement> tableColumnRows = driver.findElements(By.xpath(
					"/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div/div/div/div[4]/div/table/tbody/tr["
							+ i + "]/td"));
			int tableColumnRowsSize = tableColumnRows.size();
			for (int j = 1; j <= tableColumnRowsSize; j++) {
				String value = driver.findElement(By.xpath(
						"/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div/div/div/div[4]/div/table/tbody/tr["
								+ i + "]/td[" + j + "]"))
						.getText();
				System.out.print(value + "|");

			}
			System.out.println();
		}
	}

	@Test(dependsOnMethods="webTable2")
	public void form1() {
		WebElement formText = driver.findElement(By.xpath("//input[@id='input1']"));
		formText.sendKeys("Java");
	}

	@Test(dependsOnMethods="form1")
	public void form2() {
		WebElement formText = driver.findElement(By.xpath("//input[@id='input2']"));
		formText.sendKeys("Selenium");
	}

	@Test(dependsOnMethods="form2")
	public void form3() {
		WebElement formText = driver.findElement(By.xpath("//input[@id='input3']"));
		formText.sendKeys("TestNG");
	}

	@Test(dependsOnMethods="form3")
	public void hiddenElements() {
		WebElement hiddenElementClick = driver.findElement(By.xpath("//a[text()='Hidden Elements & AJAX']"));
		hiddenElementClick.click();
		WebElement hiddenElementValue = driver.findElement(By.xpath("(//input[@id='input1'])[1]"));
		hiddenElementValue.sendKeys("Maven");
		WebElement hiddenElementCheckbox = driver.findElement(By.xpath("//input[@id='checkbox1']"));
		hiddenElementCheckbox.click();

	}

	@Test(dependsOnMethods="hiddenElements")
	public void downloadFileArea() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		WebElement downloadFileClick = driver.findElement(By.xpath("//a[text()='Download Files']"));
		downloadFileClick.click();

		WebElement enterTextField = driver.findElement(By.xpath("//textarea[@id='inputText']"));
		enterTextField.sendKeys("Cucumber");

		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		WebElement clickTheHomeLink = driver.findElement(By.xpath("(//a[text()='Home'])[2]"));
		clickTheHomeLink.click();
	}

	@Test(dependsOnMethods="downloadFileArea")
	public void handleTheNewTab1() {
		WebElement newTabTextField = driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']"));
		newTabTextField.sendKeys("TestNG");
		WebElement clickTheSearchButton = driver.findElement(By.xpath("//input[@type='submit']"));
		clickTheSearchButton.click();

		WebElement testNGClick = driver.findElement(By.xpath("//a[text()='TestNG']"));
		testNGClick.click();
		Set<String> allWindows = driver.getWindowHandles();
		List list = new ArrayList(allWindows);
		driver.switchTo().window((String) list.get(1));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		WebElement clickWikimediaFoundation = driver.findElement(By.xpath("//a[text()='Wikimedia Foundation, Inc.']"));
		clickWikimediaFoundation.click();

		Set<String> allWindows2 = driver.getWindowHandles();
		List list1 = new ArrayList(allWindows2);
		driver.switchTo().window((String) list1.get(1));
		driver.close();
		driver.switchTo().window((String) list1.get(0));

	}

	@Test(dependsOnMethods="handleTheNewTab1")
	public void handleTheNewTab2() {

		WebElement newTabClick1 = driver.findElement(By.xpath("//button[text()='New Tab']"));
		newTabClick1.click();
		WebElement newTabClick2 = driver.findElement(By.xpath("//button[text()='New Tab']"));
		newTabClick2.click();
		WebElement newTabClick3 = driver.findElement(By.xpath("//button[text()='New Tab']"));
		newTabClick3.click();
		WebElement newTabClick4 = driver.findElement(By.xpath("//button[text()='New Tab']"));
		newTabClick4.click();
		WebElement newTabClick5 = driver.findElement(By.xpath("//button[text()='New Tab']"));
		newTabClick5.click();
		WebElement newTabClick6 = driver.findElement(By.xpath("//button[text()='New Tab']"));
		newTabClick6.click();
		WebElement newTabClick7 = driver.findElement(By.xpath("//button[text()='New Tab']"));
		newTabClick7.click();
		WebElement newTabClick8 = driver.findElement(By.xpath("//button[text()='New Tab']"));
		newTabClick8.click();
		WebElement newTabClick9 = driver.findElement(By.xpath("//button[text()='New Tab']"));
		newTabClick9.click();
		WebElement newTabClick10 = driver.findElement(By.xpath("//button[text()='New Tab']"));
		newTabClick10.click();
		WebElement newTabClick11 = driver.findElement(By.xpath("//button[text()='New Tab']"));
		newTabClick11.click();
		WebElement newTabClick12 = driver.findElement(By.xpath("//button[text()='New Tab']"));
		newTabClick12.click();
		WebElement newTabClick13 = driver.findElement(By.xpath("//button[text()='New Tab']"));
		newTabClick13.click();
		WebElement newTabClick14 = driver.findElement(By.xpath("//button[text()='New Tab']"));
		newTabClick14.click();
		WebElement newTabClick15 = driver.findElement(By.xpath("//button[text()='New Tab']"));
		newTabClick15.click();

		Set<String> allWindows = driver.getWindowHandles();
		List list = new ArrayList(allWindows);
		driver.switchTo().window((String) list.get(15));
		driver.close();
		driver.switchTo().window((String) list.get(14));
		driver.close();
		driver.switchTo().window((String) list.get(13));
		driver.close();
		driver.switchTo().window((String) list.get(12));
		driver.close();
		driver.switchTo().window((String) list.get(11));
		driver.close();
		driver.switchTo().window((String) list.get(10));
		driver.close();
		driver.switchTo().window((String) list.get(9));
		driver.close();
		driver.switchTo().window((String) list.get(8));
		driver.close();
		driver.switchTo().window((String) list.get(7));
		driver.close();
		driver.switchTo().window((String) list.get(6));
		driver.close();
		driver.switchTo().window((String) list.get(5));
		driver.close();
		driver.switchTo().window((String) list.get(4));
		driver.close();
		driver.switchTo().window((String) list.get(3));
		driver.close();
		driver.switchTo().window((String) list.get(2));
		driver.close();
		driver.switchTo().window((String) list.get(1));
		driver.close();
		driver.switchTo().window((String) list.get(0));
	}

	@Test(dependsOnMethods="handleTheNewTab2")
	public void handleTheNewWindow() {
		WebElement newPopupWindowClick = driver.findElement(By.xpath("//button[text()='Popup Windows']"));
		newPopupWindowClick.click();

		Set<String> allWindows = driver.getWindowHandles();
		List list = new ArrayList(allWindows);
		driver.switchTo().window((String) list.get(2));

		driver.manage().window().maximize();
		WebElement aboutClick = driver.findElement(By.xpath("//a[text()='About']"));
		aboutClick.click();
		driver.close();
		driver.switchTo().window((String) list.get(1));
		driver.manage().window().maximize();

		WebElement getStartClick = driver.findElement(By.xpath("//a[text()='Get started']"));
		getStartClick.click();
		driver.close();
		driver.switchTo().window((String) list.get(0));
	}

	@Test(dependsOnMethods="handleTheNewWindow")
	public void simpleAlert() {
		WebElement simpleAlertBoxClick = driver.findElement(By.xpath("//button[text()='Simple Alert']"));
		simpleAlertBoxClick.click();
		driver.switchTo().alert().accept();
	}

	@Test(dependsOnMethods="simpleAlert")
	public void confirmAlert() {
		WebElement confirmAlertBoxClick = driver.findElement(By.xpath("//button[text()='Confirmation Alert']"));
		confirmAlertBoxClick.click();
		driver.switchTo().alert().accept();
	}

	@Test(dependsOnMethods="confirmAlert")
	public void promptAlert() {
		WebElement promptAlertBoxClick = driver.findElement(By.xpath("//button[text()='Prompt Alert']"));
		promptAlertBoxClick.click();
		driver.switchTo().alert().sendKeys("Hi Kumara!......");
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

	@Test(dependsOnMethods="promptAlert")
	public void mouseHover() {
		WebElement mouseHoverTheElement = driver.findElement(By.xpath("//button[text()='Point Me']"));
		Actions as = new Actions(driver);
		as.moveToElement(mouseHoverTheElement).build().perform();
	}

	@Test(dependsOnMethods="mouseHover")
	public void doubleClick() {
		WebElement doubleClickTheElement = driver.findElement(By.xpath("//button[text()='Copy Text']"));
		Actions as = new Actions(driver);
		as.doubleClick(doubleClickTheElement).build().perform();
	}

	@Test(dependsOnMethods="doubleClick")
	public void contextClick() throws InterruptedException {
		WebElement doubleClickTheElement = driver.findElement(By.xpath("//button[text()='Copy Text']"));
		Actions as = new Actions(driver);
		// as.contextClick(doubleClickTheElement).build().perform();
		// Thread.sleep(2000);
		// doubleClickTheElement.click();
	}

	@Test(dependsOnMethods="contextClick")
	public void dragAndDrop() {
		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions as = new Actions(driver);
		as.dragAndDrop(drag, drop).build().perform();
	}


	@Test(dependsOnMethods="dragAndDrop")
	public void svgElements() {
		WebElement svgElement1 = driver.findElement(By.xpath("(//*[local-name()='svg'])[1]"));
		Actions as = new Actions(driver);
		as.doubleClick(svgElement1).build().perform();
		WebElement svgElement2 = driver.findElement(By.xpath("(//*[local-name()='svg'])[2]"));
		as.doubleClick(svgElement2).build().perform();
		WebElement svgElement3 = driver.findElement(By.xpath("(//*[local-name()='svg'])[3]"));
		as.doubleClick(svgElement3).build().perform();
	}

	@Test(dependsOnMethods="svgElements")
	public void scrollingDropDown() {
		WebElement scrollDropdownClick = driver.findElement(By.xpath("//input[@id='comboBox']"));
		scrollDropdownClick.click();
		List<WebElement> clickTheItem66 = driver.findElements(By.xpath("//div[@id='dropdown']//div"));
		for (WebElement all : clickTheItem66) {
			if (all.getText().equalsIgnoreCase("Item 66")) {
				all.click();
				break;
			}
		}
	}

	@Test(dependsOnMethods="scrollingDropDown")
	public void brokenLinks() throws IOException {
		Set<String> brokenLinkUrl = new HashSet();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (WebElement allLinks : links) {
			String linkUrl = allLinks.getAttribute("href");
			try {
				URL url = new URL(linkUrl);
				URLConnection openConnection = url.openConnection();
				HttpURLConnection httpUrlConnection = (HttpURLConnection) openConnection;
				httpUrlConnection.setConnectTimeout(5000);
				httpUrlConnection.connect();
				if (httpUrlConnection.getResponseCode() == 404) {
					brokenLinkUrl.add(linkUrl);
				}
				httpUrlConnection.disconnect();
			} catch (Exception e) {

			}
			for (String brokenLinksUrls : brokenLinkUrl) {
				System.out.println(brokenLinksUrls);
			}
		}
	}

	@Test(dependsOnMethods="brokenLinks")
	public void shadowDomSendKeys() throws IOException {
		WebElement shadowHost = driver.findElement(By.cssSelector("#shadow_host"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object shadowRoot = js.executeScript("return arguments[0].shadowRoot", shadowHost);
		WebElement inputField = (WebElement) js.executeScript("return arguments[0].querySelector('input[type=\"text\"]')", shadowRoot);
		inputField.sendKeys("Hello, Shadow DOM!");
	}
//	@Test(priority = 35)
//	public void shadowDomClick() throws IOException {
//		WebElement shadowHost = driver.findElement(By.cssSelector("#shadow_host"));
//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		Object shadowRoot = js.executeScript("return arguments[0].shadowRoot", shadowHost);
//		WebElement inputField = (WebElement) js.executeScript("return arguments[0].querySelector('//input[@type='checkbox']')", shadowRoot);
//		inputField.click();
//	}

	@AfterClass
	public void browserClose() {
		driver.close();
	}

}
