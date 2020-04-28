package com.ts.apps.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ts.common.pages.WebPage;

public class ConfigurationExecutionPage extends WebPage{
	
	@FindBy(id = "btnStartMigration")
	private WebElement startConfigurationButton;

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		if(startConfigurationButton.isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public void startConfiguration() {
		startConfigurationButton.click();
		
	}
	
}
