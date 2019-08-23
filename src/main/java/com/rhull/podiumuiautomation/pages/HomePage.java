package com.rhull.podiumuiautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

/*
 * Sample page
 * 
 * @author Sebastiano Armeli-Battana
 */
public class HomePage extends Page {

	private final String H2_TAG = "//*[@id=\"slider\"]/div/div[1]/div/div/h2";
	private final String LOGIN_MENU_ITEM = "#menu-item-1317 > a";
	private final String EMAIL_OR_PHONE_FIELD = "//*[@id=\"login\"]/form/div[1]/input";
	private final String PASSWORD_FIELD = "//*[@id=\"login\"]/form/div[2]/input";
	private final String GET_HELP_SIGNING_IN_BUTTON = "//*[@id=\"login\"]/form/button/div/span";
	private final String CLICK_ON_SEND_CODE_BUTTON = "//*[@id=\"login\"]/form/button/div/span";
	private final String WATCH_DEMO_BUTTON = "//*[@id=\"login\"]/form/button/div/span";
	private final String REVIEWS_PAGE_BUTTON = "//*[@id=\"login\"]/form/button/div/span";
	private final String CONTACT_BUBBLE_ICON = "//*[@id=\"login\"]/form/button/div/span";
	
	@FindBys({
		@FindBy(how = How.XPATH, using = H2_TAG),
		@FindBy(how = How.CSS, using = LOGIN_MENU_ITEM),
		@FindBy(how = How.XPATH, using = EMAIL_OR_PHONE_FIELD),
		@FindBy(how = How.XPATH, using = PASSWORD_FIELD),
		@FindBy(how = How.XPATH, using = GET_HELP_SIGNING_IN_BUTTON),
		@FindBy(how = How.XPATH, using = CLICK_ON_SEND_CODE_BUTTON),
		@FindBy(how = How.XPATH, using = WATCH_DEMO_BUTTON),
		@FindBy(how = How.XPATH, using = REVIEWS_PAGE_BUTTON),
		@FindBy(how = How.XPATH, using = CONTACT_BUBBLE_ICON)
	})

	@CacheLookup
	private WebElement h2Element;
	private WebElement loginMenuItem;
	private WebElement emailOrPhoneField;
	private WebElement passwordField;
	private WebElement signInButton;
	private WebElement getHelpSigningInButton;
	private WebElement clickOnSendCodeButton;
	private WebElement watchDemoButton;
	private WebElement reviewsPageButton;
	private WebElement contactBubbleIcon;
	public ContactBubble contactBubble;
	
	public HomePage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public String getH1() {
		return h2Element.getText();
	}
	
	public String getLoginMenuItem() {
		return loginMenuItem.getText();
	}
	
	public void navigateToLoginPage() {
		loginMenuItem.click();
	}
	
	public void typeInEmailOrPhone(String emailOrPhone) {
		emailOrPhoneField.sendKeys(emailOrPhone);
	}
	
	public void typeInPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public boolean isDisabledButtonShowing() {
		if(signInButton.getAttribute("disabled") == "true") {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isForgotLoginDetailsTextDisplayed() {
		if(signInButton.getAttribute("disabled") == "true") {
			return true;
		}else {
			return false;
		}
	}
	
	public void clickOnContactBubbleIcon() {
		contactBubbleIcon.click();
	}
	
	public String getContactBubbleIcon() {
		return contactBubbleIcon.getAttribute("class");
	}
	
	public void clickSignInButton() {
		signInButton.click();
	}
	
	public void navigateToGetHelpSigningIn() {
		loginMenuItem.click();
		getHelpSigningInButton.click();
	}
	
	public void clickOnSendCodeButton() {
		loginMenuItem.click();
		clickOnSendCodeButton.click();
	}
	
	public void clickWatchDemoButton() {
		watchDemoButton.click();
	}
	
	public void navigateToReviewsPage() {
		reviewsPageButton.click();
	}
	
	public void navigateToWebChatPage() {
		we
	}

}
