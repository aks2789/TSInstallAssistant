package com.ts.apps.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ts.apps.pages.DBSetupPage;
import com.ts.apps.pages.InstallOptionsPage;
import com.ts.apps.pages.LoginPage;
import com.ts.apps.pages.WindowsServiceAccountPage;
import com.ts.common.pages.Constants;
import com.ts.common.tests.BaseTest;

public class WindowsServiceAccountTest extends BaseTest{

	WindowsServiceAccountPage windowsServiceAccountPage = null;
	@BeforeClass
	public void launchApp() throws Throwable {
		LoginPage loginPage = (LoginPage) browser.navigateToUrl("http://localhost/configurator/login", "com.ts.apps.pages.LoginPage");
		InstallOptionsPage installOptionsPage = (InstallOptionsPage) loginPage.login("Admin", "Admin");
		DBSetupPage dbSetupPage = (DBSetupPage) installOptionsPage.fillInstallOptions(getProperty(Constants.INSTALLATION_TYPE), getProperty(Constants.EDN_USERNAME), 
				getProperty(Constants.EDN_PASSWORD), getProperty(Constants.LICENSE_KEY));
		windowsServiceAccountPage = (WindowsServiceAccountPage) dbSetupPage.fillDBOptions(getProperty(Constants.DB_TYPE), getProperty(Constants.DB_HOST), getProperty(Constants.DB_PORT), 
				getProperty(Constants.DB_USERNAME), getProperty(Constants.DB_PASSWORD), getProperty(Constants.DB_NAME));
	}
	
	@Test
	public void verifyWindowsCredentials() throws Throwable{
		assert(windowsServiceAccountPage.isValid());
		windowsServiceAccountPage.verifyWindowsCredentials(getProperty(Constants.INSTALLATION_TYPE), getProperty(Constants.WINDOWS_DOMAIN),
				getProperty(Constants.WINDOWS_USERNAME), getProperty(Constants.WINDOWS_PASSWORD));
	}
}
