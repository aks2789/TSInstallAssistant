package com.ts.apps.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ts.common.pages.Constants;
import com.ts.common.pages.WebPage;

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
	
	@FindBy(id = "db-test-link")
	private WebElement dbTestButton;
	
	@FindBy(xpath = "((//*[@role=\"dialog\"])[9])//div//div//button")
	private WebElement connectionSuccessfulDialog;
	
	@FindBy(id = "next-link")
	private WebElement nextButton;
	
	@FindBy(id ="oracleServiceName1")
	private WebElement userOracleServiceCheckBox;
	
	@FindBy(id = "ssl1")
	private WebElement useSSLCheckBox;
	
	@FindBy(id = "windowsAuth")
	private WebElement windowsAuthCheckBox;
	
	@FindBy(id = "windowsDomain")
	private WebElement windowsDomain;
	
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		if(oracleRadio.isDisplayed() && sqlServerRadio.isDisplayed() && username.isDisplayed() && password.isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public WebPage fillDBOptions(String dbType, String host, String port, String useSSL, String useWindowsAuthenticataion, String isServiceName, 
			String oracleServiceName, String dbDomain, String dbUsername, String dbPassword, String databaseName) throws InterruptedException {
		//Properties properties = BaseTest.getTestProperties();
		if(dbType.equalsIgnoreCase(Constants.ORACLE)) {
			oracleRadio.click();
			if(isServiceName.equalsIgnoreCase("true")) {
				userOracleServiceCheckBox.click();
			}
			if(!oracleServiceName.isEmpty()) {
				dbName.clear();
				dbName.sendKeys(oracleServiceName);
			}
		} else {
			sqlServerRadio.click();
			if(useSSL.equalsIgnoreCase("true")) {
				useSSLCheckBox.click();
			}
			if(!databaseName.isEmpty()) {
				dbName.clear();
				dbName.sendKeys(databaseName);
			}
			if(useWindowsAuthenticataion.equalsIgnoreCase("true")) {
				windowsAuthCheckBox.click();
				windowsDomain.sendKeys(dbDomain);
			}
		}
		if(!host.isEmpty()) {
			hostName.clear();
			hostName.sendKeys(host);
		}
		if(!port.isEmpty()) {
			hostPort.clear();
			hostPort.sendKeys(port);
		}
		username.sendKeys(dbUsername);
		password.sendKeys(dbPassword);
		browser.scrollTillElementNotFound(dbTestButton);
		dbTestButton.click();
		if(dbType.equalsIgnoreCase(Constants.ORACLE)) {
			dbTestButton.click();
		}
		connectionSuccessfulDialog.click();
		browser.scrollTillElementNotFound(nextButton);
		nextButton.click();
		return browser.makeWebPage("com.ts.apps.pages.WindowsServiceAccountPage");
	}
	
}
