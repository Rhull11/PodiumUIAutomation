package com.rhull.podiumuiautomation.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

	HomePage homepage;
	
	@Parameters({ "path" })
	@BeforeClass
	public void testInit(@Optional String path) {

		webDriver.get(websiteUrl);
		homepage = PageFactory.initElements(webDriver, HomePage.class);
	}
	
	@Parameters({ "email", "password" })
	@Test
	public void loginWithIncorrectCredentailsTest(String email, String password) throws InterruptedException {
		if(homepage.getLoginMenuItem() != null) {
			homepage.navigateToLoginPage();
		}else{
			Reporter.log("could not access the login button to log in.");
			webDriver.close();
		}
		webDriver.get(websiteUrl);
			homepage.typeInEmailOrPhone(email);
			homepage.typeInPassword(password);
			homepage.clickSignInButton();
			Assert.assertTrue(homepage.isDisabledButtonShowing());
	}
	
	@Parameters({ "email" })
	@Test
	public void getHelpSigningInTest(String email) throws InterruptedException {
		if(homepage.getLoginMenuItem() != null) {
			homepage.navigateToLoginPage();
		}else{
			Reporter.log("could not access the login button to log in.");
			webDriver.close();
		}
			homepage.navigateToGetHelpSigningIn();
			homepage.typeInEmailOrPhone(email);
			homepage.clickOnSendCodeButton();
			Assert.assertTrue(homepage.isDisabledButtonShowing());
	}
	
	@Test
	public void contactBubbleFormTest() throws InterruptedException {
		if(homepage.getContactBubbleIcon() != null) {
			homepage.clickOnContactBubbleIcon();
			webDriver.close();
		}else{
			Reporter.log("No contact bubble was found");
			webDriver.close();
		}
		Assert.assertTrue(homepage.contactBubble.isNameLabelPresent());
		Assert.assertTrue(homepage.contactBubble.isMobilePhoneLabelPresent());
		Assert.assertTrue(homepage.contactBubble.isMessageLabelPresent());
	}
	
	/*
	 * Navigation tests to pages that may be important to potential customers.
	 */
	@Test
	public void navigateToWatchDemoTest() throws InterruptedException {
		homepage.clickWatchDemoButton();
		Assert.assertEquals(websiteUrl, "https://learn.podium.com/watch");
	}
	
	@Test
	public void navigateToReviewsPageTest() throws InterruptedException {
		homepage.navigateToReviewsPage();
		Assert.assertEquals(websiteUrl, "https://www.podium.com/reviews/");
	}
	
	@Test
	public void navigateToWebChatPageTest() throws InterruptedException {
		homepage.navigateToWebChatPage();
		Assert.assertEquals(websiteUrl, "https://www.podium.com/webchat/");
	}
	
	@Test
	public void navigateToTeamChatPageTest() throws InterruptedException {
		homepage.navigateToTeamChatPage();
		Assert.assertEquals(websiteUrl, "https://www.podium.com/reviews/");
	}
	
	@Test
	public void navigatToFeedbackTest() throws InterruptedException {
		homepage.navigateToFeedbackTestPage();
		Assert.assertEquals(websiteUrl, "https://www.podium.com/reviews/");
	}
}
