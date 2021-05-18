package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.Base.BaseClass;

public class BNSExcelDataPage extends BaseClass {
	
	public BNSExcelDataPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.ID, using="FN")
	WebElement Fname;
	public void enterFirstName(String Fn) {
		List<WebElement>fname=driver.findElements(By.id("FN"));
		int count=fname.size();
		for(int i=0; i<count; i++){
			WebElement ele=fname.get(i);
			int x=ele.getLocation().getX();
			if(x!=0){
				ele.sendKeys(Fn);;
				break;
			}
		}
		
	}
	@FindBy(how=How.ID, using="LN")
	
	WebElement Lname;
	public void enterLastName(String Ln) {
		Lname.sendKeys(Ln);
	}
	@FindBy(how=How.XPATH, using="//*[@id='EM']")
	
	WebElement Email;
	public void enterEmail(String Em) {
		Email.sendKeys(Em);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='PW']")
	
	WebElement passWord;
	public void enterPassword(String Pw) {
		passWord.sendKeys(Pw);
	}
	   
	@FindBy(how=How.XPATH, using="//*[@id='PH']")
	
	WebElement phoneNumber;
	public void enterPhoneNumber(String Pho) {
		phoneNumber.sendKeys(Pho);
	}
	@FindBy(how=How.NAME, using="month")
	
	WebElement BDmonth;
	public void selectMonth(String MN) {
		Select monthSelect=new Select(BDmonth);
		monthSelect.selectByVisibleText(MN);
	}
	@FindBy(how=How.NAME, using="day")
	
	WebElement BDday;
	public void selectDay(String DY) {
		Select daySelect=new Select(BDday);
		daySelect.selectByVisibleText(DY);
	}
	
	@FindBy(how=How.NAME, using="year")
	
	WebElement BDyear;
	public void selectYear(String YR){
		Select yearSelect=new Select(BDyear);
		yearSelect.selectByVisibleText(YR);
	}
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"content\"]/article/div/div/div/div/section[1]/div/div/div/div/div/div/div/div/div[2]/input[7]")
	
	WebElement male;
	public void ClickOnMale() {
		List<WebElement>radio=driver.findElements(By.xpath("//*[@id=\"content\"]/article/div/div/div/div/section[1]/div/div/div/div/div/div/div/div/div[2]/input[7]"));
		int count=radio.size();
		
		for(int i=0; i<count; i++){
			WebElement ele=radio.get(i);
			int x=ele.getLocation().getX();
			
			if(x!=0){
				ele.click();
				break;
			}
		}
		
	}
	@FindBy(how=How.XPATH, using="//*[@id=\"content\"]/article/div/div/div/div/section[1]/div/div/div/div/div/div/div/div/div[2]/input[9]")
	
	WebElement female;
	public void ClickOnFemale() {
		female.click();
	}
	@FindBy(how=How.XPATH, using="//*[@id=\"content\"]/article/div/div/div/div/section[1]/div/div/div/div/div/div/div/div/div[2]/input[12]")
	
	WebElement submitButton;
	public void ClickOnSubmit() {
		submitButton.click();
	}
	
	
	

}
