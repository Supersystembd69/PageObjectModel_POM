package com.TestCases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Pages.OurwebSiteLoginPage ;
import com.aventstack.extentreports.Status;

import Datahelper.*;



public class WebsiteexcelDataTest2 extends BaseClass {
	
	
	 	private String filePath = "E:\\CompanyData\\ExeclData.xlsx";
	    private String sheetName = "Demo";

	    @Test(dataProvider = "excelData")
	    public void WebsiteSignUp(String firstname, String lastname, String email, String againemail, String password,
	    		String gender, String Bmonth,String  Bday, String Byear) throws InterruptedException {
	    	test=report.createTest("Website SignUp");
	    	
	    	OurwebSiteLoginPage owsp=new OurwebSiteLoginPage(driver);
	    	driver.get("file:///E:/Dynamic/OurWebSite.html");
	    	Reporter.log("Application launch Successfully" );
	    	owsp.setFirstName(firstname);
			logger.info("First Name Entered");
			owsp.setLastName(lastname);
			logger.info("Last Name Entered");
			owsp.setEmail(email);
			logger.info("Email Entered");
			owsp.setAgainEmail(againemail);
			logger.info("Again Email Entered");
	    	
			owsp.setPassword(password);
			logger.info("Password Entered");
			
			if(gender.equalsIgnoreCase("Male")) {
				owsp.ClicOnMale();
				Thread.sleep(3000);
				logger.info("Clicked on Male radio button");
			}
			else {
				owsp.ClicOnfemale();
				
				logger.info("Clicked on Female radio button");
				
			}
			
			owsp.selectMonth(Bmonth);
			
			logger.info("Selected birth month");
			
			owsp.selectDay(Bday);
			
			logger.info("Selected birth day");
			
			owsp.selectYear(Byear);
			
			logger.info("Selected birth year");
	    }

	    @DataProvider(name="excelData")
	    public Object[][] readExcel() throws IOException {
	        return ExcelFileReader.ExcelDataReader(filePath, sheetName);
	    }

}
