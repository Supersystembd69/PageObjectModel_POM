package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Base.BaseClass;

public class FacebookSignUpPage  extends BaseClass{
	
	
	public FacebookSignUpPage(WebDriver driver){

		BaseClass.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

	
	@FindBy(how=How.NAME, using="firstname")
    	WebElement FName;

    @FindBy(name="lastname")
    	WebElement LName;    

    @FindBy(how=How.NAME, using="reg_email__")
    	WebElement Email;

    @FindBy(name="reg_email_confirmation__")
    	WebElement againEmail;

    @FindBy(how=How.NAME, using="reg_passwd__")
    	WebElement password;
   
    
    @FindBy(how=How.ID, using="month")
    
    	WebElement month;
    
    @FindBy(how=How.ID, using="day")
    	WebElement day;
    
    @FindBy(how=How.ID, using="year")
		WebElement year;
    
    
    @FindBy(how=How.XPATH, using="//*[@id='u_0_a']")
    	WebElement male;
    
    @FindBy(how=How.XPATH, using="//*[@id='u_0_9']")
    	WebElement female;

    //===================================================================
  
    //Set user  first name in textbox

    public void setFirstName(String firstName){

        FName.sendKeys(firstName);     
    }

    //Set user last name textbox

    public void setLastName(String lastName){

    	LName.sendKeys(lastName);

    }
  //Set user email textbox

    public void setEmail(String email){

    	Email.sendKeys(email);

    }
  //Set user again email textbox

    public void setAgainEmail(String AgEmail){

    	againEmail.sendKeys(AgEmail);

    }
  //Set user password textbox

    public void setPassword(String pass){

    	password.sendKeys(pass);
    }
    //Select from dropdown box
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
  //Click on male radio button
    
    public void ClicOnMale() {
    	male.click();
		
	}
    //Click on Female radio button
    public void ClicOnfemale() {
    	female.click();
		
	}
}
