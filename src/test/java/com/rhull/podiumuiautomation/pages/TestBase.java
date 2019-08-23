package com.rhull.podiumuiautomation.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.rhull.podiumuiautomation.util.PropertyLoader;
import com.rhull.podiumuiautomation.util.Browser;
import com.rhull.podiumuiautomation.webdriver.WebDriverFactory;

/*
 * Base class for all the test classes
 * 
 * @author Sebastiano Armeli-Battana
 */

public class TestBase {
	protected WebDriver webDriver;

	protected String gridHubUrl;

	protected String websiteUrl;

	protected Browser browser;

	@BeforeClass
	public void init() {
		websiteUrl = PropertyLoader.loadProperty("site.url");
		gridHubUrl = PropertyLoader.loadProperty("grid2.hub");

		browser = new Browser();
		browser.setName(PropertyLoader.loadProperty("browser.name"));
		browser.setVersion(PropertyLoader.loadProperty("browser.version"));
		browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));

		String username = PropertyLoader.loadProperty("user.username");
		String password = PropertyLoader.loadProperty("user.password");
		
		webDriver = WebDriverFactory.getInstance(browser.getName(), username, password);
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}
}
