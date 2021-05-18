package com.TestCases;

import java.io.IOException;


import org.testng.Reporter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Pages.FundTransferPage;

import Datahelper.ExcelFileReader;


public class FundTransferTest extends  BaseClass{
	
	private String filePath = "E:\\CompanyData\\ExeclData.xlsx";
    private String sheetName = "FundTransfer";
	
	@Test(dataProvider = "excelData")

	public void FundTransferToValidPayeeAndValidAmount(String payee, String amount, String message) {
		test=report.createTest("FundTransferToValidPayeeAndValidAmount");
		
		driver.get("https://bnscorporation.com/fund-transfer");
		
		Reporter.log("In Test1 Application launched successfully");
		FundTransferPage fundpage=new FundTransferPage(driver);
		
		fundpage.SelectPayee(payee);
		logger.info("Payee Selected");
		//wdwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payee")));
		
		fundpage.enterAmount(amount);
		logger.info("Amount Entered");
		
		fundpage.clickOnTransferButton();
		logger.info("Clicked on Transfer Button");
		
		//fundpage.remainingBalance(toString());
		
		fundpage.verifySucessMessage(message);
		fundpage.verifyFailMessage(message);;
	
		Reporter.log("Test1 run and browser close successfully");
	}
	
	@DataProvider(name="excelData")
    public Object[][] readExcel() throws IOException {
        return ExcelFileReader.ExcelDataReader(filePath, sheetName);
    }
	
}
