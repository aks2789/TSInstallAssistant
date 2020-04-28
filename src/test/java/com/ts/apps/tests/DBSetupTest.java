package com.ts.apps.tests;

import java.awt.HeadlessException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ts.apps.pages.DBSetupPage;
import com.ts.apps.pages.InstallOptionsPage;
import com.ts.apps.pages.LoginPage;
import com.ts.common.pages.Constants;
import com.ts.common.tests.BaseTest;

public class DBSetupTest extends BaseTest{
	
	DBSetupPage dbSetupPage = null;
	@BeforeClass
	public void launchApp() throws Throwable {
		LoginPage loginPage = (LoginPage) browser.navigateToUrl("http://localhost/configurator/login", "com.ts.apps.pages.LoginPage");
		InstallOptionsPage installOptionsPage = (InstallOptionsPage) loginPage.login("Admin", "Admin");
		//dbSetupPage = (DBSetupPage) browser.navigateToUrl("http://localhost/configurator/setup/dbms", "com.ts.apps.pages.DBSetupPage");
		//dbSetupPage = (DBSetupPage) browser.makeWebPage("com.ts.apps.pages.DBSetupPage");
		dbSetupPage = (DBSetupPage) installOptionsPage.fillInstallOptions(getProperty(Constants.INSTALLATION_TYPE), getProperty(Constants.EDN_USERNAME), 
				getProperty(Constants.EDN_PASSWORD), getProperty(Constants.LICENSE_KEY));
	}
	
	@Test
	public void fillDBOptions() throws Throwable{
		assert(dbSetupPage.isValid());
		dbSetupPage.fillDBOptions(getProperty(Constants.DB_TYPE), getProperty(Constants.DB_HOST), getProperty(Constants.DB_PORT), 
				getProperty(Constants.DB_USERNAME), getProperty(Constants.DB_PASSWORD), getProperty(Constants.DB_NAME));
	}

}
