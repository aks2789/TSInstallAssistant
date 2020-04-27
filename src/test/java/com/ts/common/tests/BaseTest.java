package com.ts.common.tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import static org.testng.Assert.fail;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ts.common.pages.Browser;

/*
 * Base class for all tests
 */
public abstract class BaseTest {

	protected static Properties testProperties;
	protected static Browser browser;

	@BeforeSuite
	public void initializeSuite() throws IOException {
		testProperties = new Properties();
		testProperties.load(this.getClass().getClassLoader().getResourceAsStream("config/test.properties"));
	}

	@BeforeClass
	public void beforeClass() throws Exception, Throwable {
		browser = new Browser();
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		Reporter.log("Test Started : " + method.getName(), true);
	}

	//@AfterClass()
	public void afterClass() throws Exception, Throwable {
		try {
			browser.quit();
		} catch (Throwable e) {
			fail("Exception Occured - " + e.getMessage(), e);
		}
	}
}
