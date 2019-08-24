package com.rhull.podiumuiautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;


public class HomePage extends Page {

	private final String H2_TAG = "//*[@id=\"slider\"]/div/div[1]/div/div/h2";
	private final String LOGIN_MENU_ITEM = "menu-item-1317";
	private final String EMAIL_OR_PHONE_FIELD = "//*[@id=\"login\"]/form/div[1]/input";
	private final String PASSWORD_FIELD = "//*[@id=\"login\"]/form/div[2]/input";
	private final String SIGN_IN_BUTTON = "login-btn";
	private final String GET_HELP_SIGNING_IN_BUTTON = "//*[@id=\"login\"]/form/div[3]/a";
	private final String CLICK_ON_SEND_CODE_BUTTON = "//*[@id=\"request-code\"]/form/button/div/span/span";
	private final String WATCH_DEMO_BUTTON = "//*[@id=\"slider\"]/div/div[1]/div/div/div[2]/a";
	private final String REVIEWS_PAGE_BUTTON = "//*[@id=\"menu-item-1312\"]/a";
	private final String LEADS_MENU_ITEM = "//*[@id=\"menu-item-1309\"]/a";
	private final String WEB_CHAT_MENU_ITEM = "//*[@id=\"menu-item-1313\"]";
	private final String TEAM_CHAT_MENU_BUTTON = "//*[@id=\"menu-item-1350\"]";
	private final String CUSTOMERS_MENU_ITEM = "//*[@id=\"menu-item-1314\"]/a";
	private final String FEEDBACK_MENU_ITEM = "//*[@id=\"menu-item-1354\"]";
	private final String CONTACT_BUBBLE_ICON = "//*[@id=\"main\"]/div/div/div/div/button/div";
	
	@FindBys({
		@FindBy(how = How.XPATH, using = H2_TAG),	
		
		
		@FindBy(how = How.XPATH, using = CLICK_ON_SEND_CODE_BUTTON),
		@FindBy(how = How.XPATH, using = WATCH_DEMO_BUTTON),
		@FindBy(how = How.XPATH, using = REVIEWS_PAGE_BUTTON),
		@FindBy(how = How.XPATH, using = LEADS_MENU_ITEM),
		@FindBy(how = How.XPATH, using = WEB_CHAT_MENU_ITEM),
		@FindBy(how = How.XPATH, using = TEAM_CHAT_MENU_BUTTON),
		@FindBy(how = How.XPATH, using = CUSTOMERS_MENU_ITEM),
		@FindBy(how = How.XPATH, using = FEEDBACK_MENU_ITEM),
		@FindBy(how = How.XPATH, using = CONTACT_BUBBLE_ICON)
	})

	@CacheLookup
	private WebElement h2Element;
	
	@FindBy(how = How.ID, using = LOGIN_MENU_ITEM)
	private WebElement loginMenuItem;
	
	@FindBy(how = How.XPATH, using = EMAIL_OR_PHONE_FIELD)
	private WebElement emailOrPhoneField;
	
	@FindBy(how = How.XPATH, using = PASSWORD_FIELD)
	private WebElement passwordField;
	
	@FindBy(how = How.CLASS_NAME, using = SIGN_IN_BUTTON)
	private WebElement signInButton;
	
	@FindBy(how = How.XPATH, using = GET_HELP_SIGNING_IN_BUTTON)
	private WebElement getHelpSigningInButton;
	private WebElement clickOnSendCodeButton;
	private WebElement watchDemoButton;
	private WebElement reviewsPageButton;
	private WebElement contactBubbleIcon;
	private WebElement leadsMenuItem;
	private WebElement webChatMenuItem;
	private WebElement teamChatMenuItem;
	private WebElement customersMenuItem;
	private WebElement feedbackMenuItem;
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
		loginMenuItem.findElement(By.linkText("Login")).click();;
	}
	
	public void typeInEmailOrPhone(String emailOrPhone) {
		emailOrPhoneField.sendKeys(emailOrPhone);
	}
	
	public void typeInPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public boolean isDisabledButtonShowing() {
		String errorButtonClassName = signInButton.getAttribute("class");
		if(errorButtonClassName.equals("login-btn error")) {
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
		//Hover over
		//find element
		reviewsPageButton.click();
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
