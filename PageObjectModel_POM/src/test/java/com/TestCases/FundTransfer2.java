package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Pages.FundTransferPage;

public class FundTransfer2 extends BaseClass{
	
	  
	@Test(priority=0)
	public void validPayeeValidAmount() throws InterruptedException {
		FundTransferPage ftp=PageFactory.initElements(driver, FundTransferPage.class);
		
		test=report.createTest("FundTransfer To Valid Payee And Valid Amount");
		
		driver.get("https://bnscorporation.com/fund-transfer");
		ftp.SelectPayee("Jim");
		ftp.enterAmount("400");
		Thread.sleep(3000);
		ftp.clickOnTransferButton();
		ftp.remainingBalance("4600");
		ftp.verifySucessMessage("$400 transferred successfully to Jim!!");
	}
	@Test(priority=1)
	public void validPayeeInvalidAmount() throws InterruptedException {
		FundTransferPage ftp=PageFactory.initElements(driver, FundTransferPage.class);
		
		test=report.createTest("FundTransfer To Valid Payee And Invalid Amount");
		
		//driver.get("https://bnscorporation.com/fund-transfer");
		ftp.SelectPayee("Tim");
		ftp.enterAmount("6400");
		Thread.sleep(3000);
		ftp.clickOnTransferButton();
		ftp.remainingBalance("5000");
		ftp.verifySucessMessage("Transfer failed!! account cannot be overdrawn");
	}
	@Test(priority=2)
	public void InvalidPayeeValidAmount() throws InterruptedException {
		FundTransferPage ftp=PageFactory.initElements(driver, FundTransferPage.class);
		
		test=report.createTest("FundTransfer To Valid Payee And Invalid Amount");
		
		//driver.get("https://bnscorporation.com/fund-transfer");
		ftp.SelectPayee("John");
		ftp.enterAmount("400");
		Thread.sleep(3000);
		ftp.clickOnTransferButton();
		ftp.remainingBalance("5000");
		ftp.verifySucessMessage("Transfer failed!! 'John' is not approved. Please contact your branch");
	}
}
