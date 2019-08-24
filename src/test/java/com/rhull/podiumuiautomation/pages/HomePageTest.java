package com.rhull.podiumuiautomation.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

	HomePage homepage;
	
	@BeforeClass
	public void testInit() {

		webDriver.get(websiteUrl);
		homepage = PageFactory.initElements(webDriver, HomePage.class);
	}
	
	@Parameters({ "email", "password" })
	@Test
	public void loginWithIncorrectCredentailsTest(String email, String password) throws InterruptedException {
		homepage.navigateToLoginPage();
		homepage.typeInEmailOrPhone(email);
		homepage.typeInPassword(password);
		homepage.clickSignInButton();
		Assert.assertTrue(homepage.isDisabledButtonShowing());
	}
	
	@Parameters({ "email" })
	@Test
	public void getHelpSigningInTest(String email) throws InterruptedException {
		homepage.navigateToLoginPage();	
		homepage.navigateToGetHelpSigningIn();
		homepage.typeInEmailOrPhone(email);
		homepage.clickOnSendCodeButton();
		Assert.assertTrue(homepage.isRequestButtonDisabledShowing());
	}
	
	/*
	 * Navigation tests to pages that may be important to potential customers.
	 */
	@Parameters({ "url" })
	@Test
	public void navigateToWatchDemoTest(String url) throws InterruptedException {
		homepage.clickWatchDemoButton();
		Assert.assertTrue(webDriver.getCurrentUrl().contains(url));
		webDriver.close();
	}
	
	@Parameters({ "url" })
	@Test
	public void navigateToReviewsPageTest(String url) throws InterruptedException {
		homepage.navigateToReviewsPage();
		Assert.assertTrue(webDriver.getCurrentUrl().contains(url));
		webDriver.close();
	}
	
	@Parameters({ "url" })
	@Test
	public void navigateToWebChatPageTest(String url) throws InterruptedException {
		homepage.navigateToWebChatPage();
		Assert.assertTrue(webDriver.getCurrentUrl().contains(url));
		webDriver.close();
	}
	
	@Parameters({ "url" })
	@Test
	public void navigateToTeamChatPageTest(String url) throws InterruptedException {
		homepage.navigateToTeamChatPage();
		Assert.assertTrue(webDriver.getCurrentUrl().contains(url));
		webDriver.close();
	}
	
	@Parameters({ "url" })
	@Test
	public void navigatToFeedbackTest(String url) throws InterruptedException {
		homepage.navigateToFeedbackTestPage();
		Assert.assertTrue(webDriver.getCurrentUrl().contains(url));
		webDriver.close();
	}
}
