package com.TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Pages.BNSExcelDataPage;

import Datahelper.ExcelFileReader;


public class BNSPageTest extends BaseClass{
	
	
	//static String filePath=System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\ExeclData.xlsx";
	static String filePath="C:\\Users\\A R Tarafder\\eclipse-workspace\\PageObjectModel_POM\\src\\test\\resources\\TestData\\ExeclData.xlsx";
	static String sheetName="BNSData1";

@Test(dataProvider = "bnsdata")
public void ExcelTest(String Fn, String Ln, String Em,String Pw, String Pho, String  Mn,String Dy, String Yr, String  Gen) throws IOException, InterruptedException {
	
	test=report.createTest("BNS Excel Data Test");
	BNSExcelDataPage bnsexcel=new BNSExcelDataPage(driver);
	driver.get("https://bnscorporation.com/bns-login/");
	
	bnsexcel.enterFirstName(Fn);
	bnsexcel.enterLastName(Ln);
	bnsexcel.enterEmail(Em);
	bnsexcel.enterPassword(Pw);
	bnsexcel.enterPhoneNumber(Pho);
	bnsexcel.selectMonth(Mn);
	bnsexcel.selectDay(Dy);
	bnsexcel.selectYear(Yr);
	
	if(Gen.equalsIgnoreCase("Male")) {
		bnsexcel.ClickOnMale();
	}
	else {
		bnsexcel.ClickOnFemale();
	}
	bnsexcel.ClickOnSubmit();
	
	Thread.sleep(4000);
	
	
}
@DataProvider(name="bnsdata")
public static Object[][] getData() throws IOException{
	
	return ExcelFileReader .ExcelDataReader(filePath,sheetName);
}

}
