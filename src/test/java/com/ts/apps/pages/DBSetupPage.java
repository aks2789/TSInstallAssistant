package com.ts.apps.pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ts.common.pages.Constants;
import com.ts.common.pages.WebPage;
import com.ts.common.tests.BaseTest;

public class DBSetupPage extends WebPage{

	@FindBy(id = "dbType1")
	private WebElement sqlServerRadio;
	
	@FindBy(id = "dbType2")
	private WebElement oracleRadio;
	
	@FindBy(id = "hostName")
	private WebElement hostName;
	
	@FindBy(id = "hostPort")
	private WebElement hostPort;
	
	@FindBy(id = "adminLogin")
	private WebElement username;
	
	@FindBy(id = "adminPassword")
	private WebElement password;
	
	@FindBy(id = "dbName")
	private WebElement dbName;
	
	@FindBy(id = "oracleserviceName1")
	private WebElement oracleServiceCheckbox;
	
	@FindBy(id = "db-test-link")
	private WebElement dbTestButton;
	
	@FindBy(xpath = "((//*[@role=\"dialog\"])[9])//div//div//button")
	private WebElement connectionSuccessfulDialog;
	
	@FindBy(id = "next-link")
	private WebElement nextButton;
	
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public WebPage fillDBOptions(String dbType, String host, String port, String dbUsername, String dbPassword, String databaseName) throws InterruptedException {
		//Properties properties = BaseTest.getTestProperties();
		if(dbType.equalsIgnoreCase(Constants.ORACLE)) {
			oracleRadio.click();
		} else {
			sqlServerRadio.click();
			dbName.clear();
			dbName.sendKeys(databaseName);
		}
		hostName.clear();
		hostName.sendKeys(host);
		hostPort.clear();
		hostPort.sendKeys(port);
		username.sendKeys(dbUsername);
		password.sendKeys(dbPassword);
		browser.scrollTillElementNotFound(dbTestButton);
		dbTestButton.click();
		connectionSuccessfulDialog.click();
		browser.scrollTillElementNotFound(nextButton);
		nextButton.click();
		return browser.makeWebPage("com.ts.apps.pages.WindowsServiceAccountPage");
	}
	
}
