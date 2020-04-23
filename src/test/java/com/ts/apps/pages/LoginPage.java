package com.ts.apps.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ts.common.pages.WebPage;

public class LoginPage extends WebPage {

	@FindBy(id = "j_username")
	private WebElement userName;

	@FindBy(name = "j_password")
	private WebElement password;

	@FindBy(name = "Submit")
	private WebElement loginBtn;

	@Override
	public boolean isValid() {
		return userName.isDisplayed() && password.isDisplayed() && loginBtn.isDisplayed();
	}

	public void login(String username, String pwd) {
		userName.sendKeys(username);
		password.sendKeys(pwd);
		loginBtn.click();
	}

}
