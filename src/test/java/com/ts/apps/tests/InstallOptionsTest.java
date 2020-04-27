package com.ts.apps.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ts.apps.pages.InstallOptionsPage;
import com.ts.common.tests.BaseTest;

public class InstallOptionsTest  extends BaseTest {
	InstallOptionsPage installOptionsPage = null;;

	@BeforeClass
	public void launchApp() throws Throwable {
		//installOptionsPage = (InstallOptionsPage) browser.navigateToUrl("http://localhost/configurator/setup/options", "com.ts.apps.pages.InstallOptionsPage");
		installOptionsPage = (InstallOptionsPage) browser.makeWebPage("com.ts.apps.pages.InstallOptionsPage");
	}
	
	@Test
	public void fillInstallOptions() throws Throwable{
		assert(installOptionsPage.isValid());
		installOptionsPage.fillInstallOptions();
	}

}
