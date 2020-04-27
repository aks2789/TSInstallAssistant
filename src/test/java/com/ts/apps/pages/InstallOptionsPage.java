package com.ts.apps.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

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
	
	@FindBy(xpath="//*[@id=\"serialNumber\"]")
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
	
	public void fillInstallOptions() {
		try {
			enterpriseType.click();
			newInstallation.click();
			ednUsername.sendKeys("mabbusaivardhan.reddy@accoliteindia.com");
			ednPassword.sendKeys("V@rdhan!43");
			serialNumberRadio.click();
			//Actions action = new Actions(browser.getDriver());
			//action.moveToElement(serialNumber);
			//action.perform();
			browser.scrollTillElementNotFound(serialNumber);
			serialNumber.sendKeys("K5AL-ATAN28-ETP4AK-C2K6");
			//action.moveToElement(nextButton);
			//action.perform();
			browser.scrollTillElementNotFound(nextButton);
			nextButton.click();
			//action.moveToElement(licenseRetrivedButton);
			//action.perform();
			licenseRetrivedButton.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
}
