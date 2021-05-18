package extentReport;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;

import com.Base.BaseClass;
import com.aventstack.extentreports.Status;

public class DemoForExtentReportTest extends BaseClass {
	
	//@Test
	public void googleTest(){
		driver.get("https://www.google.com");
		test=report.createTest("googleTest");
		Assert.assertEquals(driver.getTitle(), "oogle");
		
	}
	//@Test
	public void googleTest1(){
		driver.get("https://www.google.com");
		test=report.createTest("googleTest1");
		driver.findElement(By.name("q")).sendKeys("Bangaldesh");
	
		
	}
	//@AfterMethod
	public void teatdown(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case Failed Is: "+result.getName());
			test.log(Status.FAIL, "Test Case Failed Is: "+result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case Skiped Is: "+result.getName());
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case Paased Is: "+result.getName());
			
		}
	}
	
}
