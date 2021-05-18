package com.TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Pages.FacebookSignUpPage;

import Datahelper.ExcelFileReader;

public class FacebookSignUp extends BaseClass{
	private String filePath = "E:\\CompanyData\\FacebookData.xlsx";
    private String sheetName = "Data1";
	
	@Test(dataProvider="excelData")
	public void Facebook(String firstname, String lastname, String email, String againemail, String password,
			String month,String day, String year, String gender) throws InterruptedException {
		test=report.createTest("Facebook");
		driver.get("https://www.facebook.com/");
		FacebookSignUpPage fp=new FacebookSignUpPage(driver);
		
		fp.setFirstName(firstname);
		fp.setLastName(lastname);
		fp.setEmail(email);
		fp.setAgainEmail(againemail);
		fp.setPassword(password);
		fp.selectMonth(month);
		fp.selectDay(day);
		fp.selectYear(year);
		if(gender.equalsIgnoreCase("Male")) {
			fp.ClicOnMale();
			Thread.sleep(3000);
		}
		else if(gender.equalsIgnoreCase("Female")) {
			fp.ClicOnfemale();
			Thread.sleep(3000);
		}
		
	}
	
	 @DataProvider(name="excelData")
	  public Object[][] getExcelData() throws IOException {
		 
	        return ExcelFileReader.ExcelDataReader(filePath, sheetName);
	  }
}
