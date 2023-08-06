package com.boatHeadphonesAssignment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.boatHeadphonesAssignment.base.TestBase;
import com.boatHeadphonesAssignment.utils.TestUtils;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//input[@name='q']")
	WebElement searchBar;
	
	@FindBy(xpath="//a[contains(@href,'bluetooth+earphone')]")
	WebElement boatBluetoothEarphoneOption;
	
	@FindBy(xpath="//button[text()='✕']")
	WebElement popUpCloseBtn;
	
	@FindBy(xpath="//div[text()='Relevance']")
	WebElement relevanceText;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage closePopUp() {
		 if(isVisible(popUpCloseBtn)) {
		    click(popUpCloseBtn);
		 }
		return this;
	}
		
    
	public HomePage searchEarphones() {
		sendKeys(searchBar,TestUtils.KeywordToSearch);
		return this;
	}
	
	public SearchPage selectEarphones() {
		click(boatBluetoothEarphoneOption);
		Assert.assertTrue(isVisible(relevanceText));
		return new SearchPage();
	}

}
