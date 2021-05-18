package Datahelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Base.BaseClass;

public class DataProviderDemo extends BaseClass {

    //private String filePath = "E:\\CompanyData\\FacebookData.xlsx";
   // private String sheetName = "Data1";

    @Test(dataProvider = "FacebookData")
    public void read(String FName, String LName, String Email,String AgEmail, String Pword, 
    		String Gender, String Month, String Day, String Year ) throws Exception {
        test=report.createTest("read");
    	//System.out.println(FName + ":" + LName+":"+Email+":"+AgEmail+ ":" +Pword+":"+Gender+":"+Month+ ":" +Day+":"+Year);
    	driver.get("https://www.facebook.com/");
    	driver.findElement(By.name("firstname")).sendKeys(FName);
    	
    	driver.findElement(By.name("lastname")).sendKeys(LName);
    	
    	driver.findElement(By.name("reg_email__")).sendKeys(Email);
    	
    	driver.findElement(By.name("reg_email_confirmation__")).sendKeys(AgEmail);
    	
    	driver.findElement(By.name("reg_passwd__")).sendKeys(Pword);
    	
    	Thread.sleep(3000);
    	
    	//Select monthSelect=new Select(driver.findElement(By.xpath("//*[@id='month']")));
    	//monthSelect.selectByVisibleText(Month);
    	
    	driver.findElement(By.xpath("//*[@id='month']")).sendKeys(Month);
    	Thread.sleep(3000);
    	Select daySelect=new Select(driver.findElement(By.id("day")));
    	daySelect.selectByVisibleText(Day);
    	
    	Select yearSelect=new Select(driver.findElement(By.id("year")));
    	yearSelect.selectByVisibleText(Year);
    	Thread.sleep(3000);
    	
    	if(Gender.equalsIgnoreCase("Male")){
    			driver.findElement(By.xpath("//*[@id='u_0_7']")).click();
    	}
    	else {
    		driver.findElement(By.xpath("//*[@id='u_0_6']")).click();
    	}

    }

    @DataProvider(name="FacebookData")
    public Object[][] readExcel() throws IOException {
    	File f=new File("E:\\CompanyData\\FacebookData.xlsx");
    	FileInputStream fis = new FileInputStream(f);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet ws = wb.getSheet("Data1");

		int rowCount = ws.getLastRowNum();
		
		int colCount = ws.getRow(0).getLastCellNum();

		Object[][] object = new Object[rowCount][colCount];
		
		for (int i = 0; i <rowCount; i++) {
			
			Row row = ws.getRow(i+1);
	
			for (int j = 0; j < row.getLastCellNum(); j++) {
	
				object[i][j] = row.getCell(j).toString(); 
			} 
			
		}

		return object;
		
	}

}
