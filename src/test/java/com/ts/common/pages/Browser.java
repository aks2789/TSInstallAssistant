package com.ts.common.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

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
}
