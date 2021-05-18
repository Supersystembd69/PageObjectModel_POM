package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import com.Base.BaseClass;

public class FundTransferPage extends BaseClass{
	
	
	public FundTransferPage(WebDriver driver) {
		BaseClass.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="payee")
		WebElement payees;
	public void SelectPayee(String payee) {
		Select payeeSelect=new Select(payees);
		payeeSelect.selectByVisibleText(payee);
		
	}
	
	@FindBy(how=How.NAME, using="amount")
		WebElement amounts;
	public void enterAmount(String amnt) {
		amounts.sendKeys(amnt);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='transfer']")
		WebElement transferButton;
	public void clickOnTransferButton() {
		transferButton.click();
	}
	
	@FindBy(name="balance")
		WebElement balance;
	public void remainingBalance(String rbl) {
		rbl=balance.getAttribute("value");
		System.out.println("Remaining Balance is: "+rbl);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='message']")
	 	WebElement successMessage;
	public void verifySucessMessage(String message) {
		String actualSuccessMessage=successMessage.getText();
		
		Assert.assertEquals(actualSuccessMessage, message);
		
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='message']")
 	WebElement failMessage;
	public void verifyFailMessage(String message) {
		String actualFailMessage=failMessage.getText();
		
		Assert.assertEquals(actualFailMessage, message);
		
	}
	
	
}
