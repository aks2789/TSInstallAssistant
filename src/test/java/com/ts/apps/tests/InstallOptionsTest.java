package com.ts.apps.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ts.apps.pages.InstallOptionsPage;
import com.ts.apps.pages.LoginPage;
import com.ts.common.pages.Constants;
import com.ts.common.tests.BaseTest;

public class InstallOptionsTest  extends BaseTest {
	
	LoginPage loginPage = null;
	InstallOptionsPage installOptionsPage = null;

	@BeforeClass
	public void launchApp() throws Throwable {
		loginPage = (LoginPage) browser.navigateToUrl("http://localhost/configurator/login", "com.ts.apps.pages.LoginPage");
		//installOptionsPage = (InstallOptionsPage) browser.navigateToUrl("http://localhost/configurator/setup/options", "com.ts.apps.pages.InstallOptionsPage");
		//installOptionsPage = (InstallOptionsPage) browser.makeWebPage("com.ts.apps.pages.InstallOptionsPage");
		installOptionsPage=(InstallOptionsPage) loginPage.login("Admin", "Admin");
	}
	
	@Test
	public void fillInstallOptions() throws Throwable{
		assert(installOptionsPage.isValid());
		installOptionsPage.fillInstallOptions(getProperty(Constants.INSTALLATION_TYPE), getProperty(Constants.EDN_USERNAME), 
				getProperty(Constants.EDN_PASSWORD), getProperty(Constants.LICENSE_KEY));
	}

}
