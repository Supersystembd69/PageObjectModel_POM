package com.Base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass{
	
	
   protected static WebDriver driver;
	
	protected static ExtentHtmlReporter exthtmlreport;
	protected static ExtentTest test;
	protected static ExtentReports report;
	
	public static WebDriverWait wdwait;
	protected static Logger logger;
	
	@BeforeTest
	public void setup() {
		exthtmlreport=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\ExtentHtmlReport.html");
		exthtmlreport.config().setDocumentTitle("Automation Report");
		exthtmlreport.config().setReportName("Fuctional Testing Report");
		exthtmlreport.config().setTheme(Theme.STANDARD);
		
		report = new ExtentReports();
		report.attachReporter(exthtmlreport);
		report.setSystemInfo("Hostname","LocalHost");
		report.setSystemInfo("OS", "Windows10");
		report.setSystemInfo("Testing Name", "Automation");
		report.setSystemInfo("Automation Tool", "Selenium");
		report.setSystemInfo("Browser name", "Chrome");
		report.setSystemInfo("Tester name", "A.R Tarafder");
		
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://bnscorporation.com/fund-transfer");

		
	}
	@AfterMethod
	public void teatdown(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case Failed Is : "+result.getName());
			test.log(Status.FAIL, "Test Case Failed Is : "+result.getThrowable());
			String screenShotPath=getScreenShot(result.getName());
			test.addScreenCaptureFromPath(screenShotPath);
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case Skiped Is : "+result.getName());
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case Paased Is : "+result.getName());
			
		}
	}
	public  static String getScreenShot(String screenshotName) throws IOException {
		String dateName=new SimpleDateFormat("yyyy-MM-dd-hh-ss").format(new Date());
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\ScreenShots\\"+screenshotName+" "+dateName+ ".png";
		FileUtils.copyFile(f, new File(destination));
		return destination;
		
	}
	@AfterTest
	public void teardown() {
		report.flush();
		driver.quit();
	}
}
