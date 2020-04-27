package com.ts.apps.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import com.ts.apps.pages.LoginPage;
import com.ts.common.tests.BaseTest;

public class LoginTest extends BaseTest {

	LoginPage loginPage = null;

	@BeforeClass
	public void launchApp() throws Throwable {
		loginPage = (LoginPage) browser.navigateToUrl("http://localhost/configurator/login", "com.ts.apps.pages.LoginPage");
	}
	
	@Test(priority = 1)
	public void verifyLogin() throws Throwable {
		assertTrue(loginPage.isValid());
		loginPage.login("Admin", "Admin");
	}
	
}
