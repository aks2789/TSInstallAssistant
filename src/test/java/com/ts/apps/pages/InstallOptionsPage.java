package com.ts.apps.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ts.common.pages.Constants;
import com.ts.common.pages.WebPage;

public class InstallOptionsPage extends WebPage {

	@FindBy(id="entEdition")
	private WebElement enterpriseType;
	
	@FindBy(id="profEdition")
	private WebElement professionalType;
	
	@FindBy(id="newInstallation")
	private WebElement newInstallation;
	
	@FindBy(id="upgradation")
	private WebElement upgradation;
	
	@FindBy(id="ednLogin")
	private WebElement ednUsername;
	
	@FindBy(id="ednPassword")
	private WebElement ednPassword;
	
	@FindBy(id="haveSerialNumber")
	private WebElement serialNumberRadio;
	
	@FindBy(xpath="//*[text()='Serial Number']/following::input[1]")
	private WebElement serialNumber;
	
	@FindBy(id="next-link")
	private WebElement nextButton;
	
	@FindBy(id="buttonInfoDialog")
	private WebElement licenseRetrivedButton;
	
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		if(enterpriseType.isDisplayed() && professionalType.isDisplayed() && newInstallation.isDisplayed()
				&& upgradation.isDisplayed())
			return true;
		return false;
	}
	
	public WebPage fillInstallOptions(String installationType, String username, String password, String licenseKey) {
		if(installationType.equalsIgnoreCase(Constants.PROFESSIONAL_EDITION)) {
			professionalType.click();
			newInstallation.click();
			nextButton.click();
		}
		else {
			enterpriseType.click();
			newInstallation.click();
			ednUsername.sendKeys(username);
			ednPassword.sendKeys(password);
			browser.scrollToBottomOfAPage();
			serialNumberRadio.click();
			serialNumber.sendKeys(licenseKey);
			nextButton.click();
			licenseRetrivedButton.click();
		}
		return browser.makeWebPage("com.ts.apps.pages.DBSetupPage");
	}
	
}
