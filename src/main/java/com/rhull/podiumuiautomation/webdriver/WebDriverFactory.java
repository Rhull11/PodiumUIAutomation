package com.rhull.podiumuiautomation.webdriver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.opera.core.systems.OperaDriver;
import com.rhull.podiumuiautomation.webdriver.AuthenticatedHtmlUnitDriver;

/*
 * Factory to instantiate a WebDriver object.
 * 
 * @author Sebastiano Armeli-Battana
 */
public class WebDriverFactory {

	/* Browsers constants */
	public static final String CHROME = "chrome";
	public static final String FIREFOX = "firefox";
	public static final String OPERA = "opera";
	public static final String INTERNET_EXPLORER = "ie";
    public static final String SAFARI = "safari";
	public static final String HTML_UNIT = "htmlunit";
	public static final String IPHONE = "iphone";

	/* Platform constants */
	public static final String WINDOWS = "windows";
	public static final String ANDROID = "android";
	public static final String XP = "xp";
	public static final String VISTA = "vista";
	public static final String MAC = "mac";
	public static final String LINUX = "linux";
        
        private WebDriverFactory(){}

	/*
	 * Factory method to return a WebDriver instance given the browser to hit
	 * 
	 * @param browser : String representing the local browser to hit
	 * 
	 * @param username : username for BASIC authentication on the page to test
	 * 
	 * @param password : password for BASIC authentication on the page to test
	 * 
	 * @return WebDriver instance
	 */
	public static WebDriver getInstance(String browser, String username,
			String password) {

		WebDriver webDriver = null;

		if (CHROME.equals(browser)) {
			setChromeDriver();

			webDriver = new ChromeDriver();

		} else if (FIREFOX.equals(browser)) {

			FirefoxProfile ffProfile = new FirefoxProfile();

			// Authenication Hack for Firefox
			if (username != null && password != null) {
				ffProfile.setPreference("network.http.phishy-userpass-length",
						255);
			}

			webDriver = new FirefoxDriver(ffProfile);

		} else if (INTERNET_EXPLORER.equals(browser)) {
            isSupportedPlatform(browser);
			webDriver = new InternetExplorerDriver();

		} else if (OPERA.equals(browser)) {
			webDriver = new OperaDriver();

        } else if (SAFARI.equals(browser)) {
            isSupportedPlatform(browser);
            webDriver = new SafariDriver();

    } else if (IPHONE.equals(browser)) {
      webDriver = new RemoteWebDriver(DesiredCapabilities.iphone());
      
    } else if (ANDROID.equals(browser)) {
      webDriver = new RemoteWebDriver(DesiredCapabilities.android());

    } else {

			// HTMLunit Check
			if (username != null && password != null) {
				webDriver = (HtmlUnitDriver) AuthenticatedHtmlUnitDriver
						.create(username, password);
			} else {
				webDriver = new HtmlUnitDriver(true);
			}
		}

		return webDriver;
	}

	/*
	 * Helper method to set ChromeDriver location into the right ststem property
	 */
	private static void setChromeDriver() {
		String os = System.getProperty("os.name").toLowerCase().substring(0, 3);
		String chromeBinary = "src/main/resources/drivers/chrome/chromedriver"
				+ (os.equals("win") ? ".exe" : "");
		System.setProperty("webdriver.chrome.driver", chromeBinary);
	}

    private static void isSupportedPlatform(String browser) {
        boolean is_supported = true;
        Platform current = Platform.getCurrent();
        if (INTERNET_EXPLORER.equals(browser)) {
            is_supported = Platform.WINDOWS.is(current);
        } else if (SAFARI.equals(browser)) {
            is_supported = Platform.MAC.is(current) || Platform.WINDOWS.is(current);
        }
        assert is_supported : "Platform is not supported by " + browser.toUpperCase() + " browser";
    }
}
