package com.Base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class AbstractClass {
	public static WebDriver driver;
	public static WebDriverWait wdwait;
	protected static Logger logger;
	
	protected  static ExtentHtmlReporter exhrepo;
	protected  static ExtentTest test;
	protected  static ExtentReports report;
	
	public WebDriver getDriver() {
	
	if(driver!=null) {
		driver=new ChromeDriver();
	}
	return driver;
	}
}
