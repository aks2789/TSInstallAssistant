package com.ts.common.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Browser {

	private final WebDriver driver;
	private final int IMPLICIT_WAIT_TIME = 10;

	public Browser() {
		driver = Driver.getInstance().buildWebDriver();
		setImpicitWait(IMPLICIT_WAIT_TIME);
		maximizeWindow();
	}

	public void setImpicitWait(Integer timeInSeconds) {
		driver.manage().timeouts().implicitlyWait((int) timeInSeconds, TimeUnit.SECONDS);
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public WebPage makeWebPage(String pageClassName) {
		try {
			Class<WebPage> pageClass = (Class<WebPage>) Class.forName(pageClassName);
			WebPage page = PageFactory.initElements(driver, pageClass);
			page.setBrowser(this);
			return page;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to create Page instance for " + pageClassName);
		}
	}

	public WebPage navigateToUrl(String url, String pageClassName) {
		driver.get(url);
		return makeWebPage(pageClassName);
	}

	public void quit() {
		driver.quit();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void scrollTillElementNotFound(WebElement e) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);

	}
}
