package com.ts.common.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
	
	private static Driver d=null;
	private WebDriver driver;
	private Driver(){
		
	}
	public static Driver getInstance(){
		if(d==null){
			d=new Driver();
		}
		return d;
	}
	/*
	 * Initialize web driver instance
	 */
	public WebDriver buildWebDriver(){
		if (driver == null) {
			ChromeOptions chromeOptions = new ChromeOptions();
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver(chromeOptions);
		}
		return driver;
	}

}
