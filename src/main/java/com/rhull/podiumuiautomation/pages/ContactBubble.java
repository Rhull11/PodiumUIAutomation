package com.rhull.podiumuiautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

public class ContactBubble extends HomePage{
	
	public ContactBubble(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	private final String NAME_FIELD = "//*[@id=\"slider\"]/div/div[1]/div/div/h2";
	private final String PHONE_NUMBER_FIELD = "#menu-item-1317 > a";
	private final String MESSAGE_FIELD = "//*[@id=\"login\"]/form/div[1]/input";

	
	@FindBys({
		@FindBy(how = How.XPATH, using = NAME_FIELD),
		@FindBy(how = How.CSS, using = PHONE_NUMBER_FIELD),
		@FindBy(how = How.XPATH, using = MESSAGE_FIELD)
	})
	
	@CacheLookup
	private WebElement nameLabel;
	private WebElement phoneNumberLabel;
	private WebElement messageField;
	
	public boolean isNameLabelPresent() {
		clickOnContactBubbleIcon();
		if(nameLabel.getText() != null) {
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isMobilePhoneLabelPresent() {
		clickOnContactBubbleIcon();
		if(phoneNumberLabel.getText() != null) {
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isMessageLabelPresent() {
		clickOnContactBubbleIcon();
		if(messageField.getText() != null) {
			return true;
		}else{
			return false;
		}
	}
}
