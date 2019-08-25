package com.rhull.podiumuiautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends Page {

	private final String H2_TAG = "//*[@id=\"slider\"]/div/div[1]/div/div/h2";
	private final String LOGIN_MENU_ITEM = "menu-item-1317";
	private final String EMAIL_OR_PHONE_FIELD = "//*[@id=\"login\"]/form/div[1]/input";
	private final String REQUEST_EMAIL_OR_PHONE_FIELD = "//*[@id=\"request-code\"]/form/div[1]/input";
	private final String PASSWORD_FIELD = "//*[@id=\"login\"]/form/div[2]/input";
	private final String SIGN_IN_BUTTON = "login-btn";
	private final String GET_HELP_SIGNING_IN_BUTTON = "//*[@id=\"login\"]/form/div[3]/a";
	private final String SEND_CODE_BUTTON = "//*[@id=\"request-code\"]/form/button";
	private final String WATCH_DEMO_BUTTON = "//*[@id=\"slider\"]/div/div[1]/div/div/div[2]/a";
	private final String REVIEWS_PAGE_BUTTON = "//*[@id=\"menu-item-1312\"]/a";
	private final String LEADS_MENU_ITEM = "//*[@id=\"menu-item-1309\"]/a";
	private final String WEB_CHAT_MENU_ITEM = "//*[@id=\"menu-item-1313\"]";
	private final String TEAM_CHAT_MENU_BUTTON = "//*[@id=\"menu-item-1350\"]";
	private final String CUSTOMERS_MENU_ITEM = "//*[@id=\"menu-item-1314\"]/a";
	private final String FEEDBACK_MENU_ITEM = "//*[@id=\"menu-item-1354\"]";
	private final String SEND_SMS_PAGE = "//*[@id=\"main\"]/div/div/div/div/div/div/form";

	@CacheLookup
	@FindBy(how = How.ID, using = H2_TAG)
	private WebElement h2Element;
	
	@FindBy(how = How.ID, using = LOGIN_MENU_ITEM)
	private WebElement loginMenuItem;
	
	@FindBy(how = How.XPATH, using = REQUEST_EMAIL_OR_PHONE_FIELD)
	private WebElement requestEmailOrPhoneField;
	
	@FindBy(how = How.XPATH, using = EMAIL_OR_PHONE_FIELD)
	private WebElement emailOrPhoneField;
	
	@FindBy(how = How.XPATH, using = PASSWORD_FIELD)
	private WebElement passwordField;
	
	@FindBy(how = How.CLASS_NAME, using = SIGN_IN_BUTTON)
	private WebElement signInButton;
	
	@FindBy(how = How.XPATH, using = GET_HELP_SIGNING_IN_BUTTON)
	private WebElement getHelpSigningInButton;
	
	@FindBy(how = How.XPATH, using = SEND_CODE_BUTTON)
	private WebElement sendCodeButton;
	
	@FindBy(how = How.XPATH, using = WATCH_DEMO_BUTTON)
	private WebElement watchDemoButton;
	
	@FindBy(how = How.XPATH, using = REVIEWS_PAGE_BUTTON)
	private WebElement reviewsMenuItem;
	
	@FindBy(how = How.XPATH, using = SEND_SMS_PAGE)
	private WebElement feedbackMenuItem;
	
	@FindBy(how = How.XPATH, using = LEADS_MENU_ITEM)
	private WebElement leadsMenuItem;
	
	@FindBy(how = How.XPATH, using = WEB_CHAT_MENU_ITEM)
	private WebElement webChatMenuItem;
	
	@FindBy(how = How.XPATH, using = TEAM_CHAT_MENU_BUTTON)
	private WebElement teamChatMenuItem;
	
	@FindBy(how = How.XPATH, using = CUSTOMERS_MENU_ITEM)
	private WebElement customersMenuItem;
	
	@FindBy(how = How.XPATH, using = FEEDBACK_MENU_ITEM)
	private WebElement sendSmsPage;
	
	public HomePage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public String getH2() {
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
	
	public void typeInEmailOrPhonePasswordRequest(String emailOrPhone) {
		requestEmailOrPhoneField.sendKeys(emailOrPhone);
	}
	
	public void typeInPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public boolean isDisabledLoginButtonVisable() throws InterruptedException {
		webDriver.findElement(By.className("error"));
		String errorButtonClassName = signInButton.getAttribute("class");
		if(errorButtonClassName.equals("login-btn error")) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isRequestButtonDisabledShowing() {
		webDriver.findElement(By.className("error"));
		String errorButtonClassName = sendCodeButton.getAttribute("class");
		if(errorButtonClassName.equals("error")) {
			return true;
		}else {
			return false;
		}
	}
	
	public String getContactBubbleIcon() {
		return contactBubbleButton.getAttribute("class");
	}
	
	public void clickSignInButton() {
		signInButton.click();
	}
	
	public void navigateToGetHelpSigningIn() {
		getHelpSigningInButton.click();
	}
	
	public void clickOnSendCodeButton() {
		sendCodeButton.click();
	}
	
	public void clickWatchDemoButton() {
		watchDemoButton.click();
	}
	
	public void navigateToReviewsPage() {
		Actions actions = new Actions(webDriver);
		
		actions.moveToElement(leadsMenuItem).perform();
		actions.moveToElement(reviewsMenuItem).perform();
		reviewsMenuItem.click();
	}
	
	public void navigateToWebChatPage() {
		Actions actions = new Actions(webDriver);
		
		actions.moveToElement(leadsMenuItem).perform();
		actions.moveToElement(webChatMenuItem).perform();
		webChatMenuItem.click();
	}
	
	public void navigateToTeamChatPage() {
		Actions actions = new Actions(webDriver);
		
		actions.moveToElement(leadsMenuItem).perform();
		actions.moveToElement(teamChatMenuItem).perform();
		teamChatMenuItem.click();
	}
	
	public void navigateToFeedbackTestPage() {
		Actions actions = new Actions(webDriver);
		
		actions.moveToElement(customersMenuItem).perform();
		actions.moveToElement(feedbackMenuItem).perform();
		feedbackMenuItem.click();
	}
}
