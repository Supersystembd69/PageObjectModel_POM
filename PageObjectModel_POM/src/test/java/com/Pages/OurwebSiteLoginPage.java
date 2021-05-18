package com.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import com.Base.BaseClass;

public class OurwebSiteLoginPage extends BaseClass{
	
	
	public OurwebSiteLoginPage(WebDriver driver){

		BaseClass.driver = driver;

        PageFactory.initElements(driver, this);

    }

	@FindBy(how=How.NAME, using="FName")
    	WebElement FName;

    @FindBy(name="LName")
    	WebElement LName;    

    @FindBy(how=How.ID, using="EM")
    	WebElement Email;

    @FindBy(id="AGE")
    	WebElement againEmail;

    @FindBy(how=How.XPATH, using="//*[@id='PW']")
    	WebElement password;
    
    @FindBy(how=How.XPATH, using="//input[7]")
    	WebElement male;
    
    @FindBy(how=How.XPATH, using="//input[8]")
    	WebElement female;
    
    @FindBy(how=How.ID, using="MN")
    
    	WebElement month;
    
    @FindBy(how=How.NAME, using="day")
    	WebElement day;
    
    @FindBy(how=How.NAME, using="Year")
		WebElement year;

    //===================================================================
  
    //Set user  first name in textbox

    public void setFirstName(String firstName){
    	
    	FName.sendKeys(firstName);
           
    }
    //Set user last name in textbox

    public void setLastName(String lastName){

    	LName.sendKeys(lastName);
    }
  //Set user email in textbox

    public void setEmail(String email){

    	Email.sendKeys(email);
    }
  //Set user again email in textbox

    public void setAgainEmail(String AgEmail){

    	againEmail.sendKeys(AgEmail);
    }
  //Set user password textbox

    public void setPassword(String pass){

    	password.sendKeys(pass);
    }
    //Click on male radio button
    public void ClicOnMale() {
    	male.click();
		
	}
    //Click on Female radio button
    public void ClicOnfemale() {
    	female.click();
		
	}
    public void selectMonth(String MN) {
    	Select mselect=new Select(month);
    	mselect.selectByVisibleText(MN);
    }
    public void selectDay(String DY) {
    	Select mselect=new Select(day);
    	mselect.selectByVisibleText(DY);
    }
    public void selectYear(String YR) {
    	Select mselect=new Select(year);
    	mselect.selectByVisibleText(YR);
    }
}