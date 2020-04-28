package com.ts.apps.pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ts.common.pages.Constants;
import com.ts.common.pages.WebPage;
import com.ts.common.tests.BaseTest;

public class WindowsServiceAccountPage extends WebPage {
	
	@FindBy(id = "username")
	private WebElement username;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "test-windows")
	private WebElement testButton;
	
	@FindBy(id = "buttonInfoDialog")
	private WebElement verificationSuccessfulDialog;
	
	@FindBy(xpath = "/html/body/div[1]/div[4]/div[1]/div/table/tbody/tr/td[1]/ul[2]/li/a")
	private WebElement configurarionExecutionLink;

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		if(username.isDisplayed() && password.isDisplayed() && testButton.isDisplayed()) {
			return true;
		}
		return false;
	}

	public WebPage verifyWindowsCredentials(String installationType, String domain,String windowsUsername, String windowsPassword) {
		//Properties properties = BaseTest.getTestProperties();
		if(installationType.equalsIgnoreCase(Constants.ENTERPRISE_TEAM_EDITION)) {
			username.sendKeys(domain+"\\"+windowsUsername);
			password.sendKeys(windowsPassword);
			testButton.click();
			verificationSuccessfulDialog.click();
			configurarionExecutionLink.click();
		}
		return browser.makeWebPage("com.ts.apps.pages.ConfigurationExecutionPage");
	}
	
}
