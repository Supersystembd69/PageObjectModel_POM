package crossBrowser;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Base.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiBrowserTest extends BaseClass{
	
	
	@Test(dataProvider = "browserName")
	public void MultiBrowser(String browser) throws InterruptedException {
		
		test=report.createTest("Multi Browser Testing");
		
		if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		if(browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", "E:\\All Driver\\msedgedriver.exe");
			//WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		if(browser.equalsIgnoreCase("IE")) {
			//WebDriverManager.iedriver().setup();
			System.setProperty("webdriver.ie.driver", "E:\\All Driver\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
	
	
	
	
	 driver.get("https://www.gmail.com");
	 
	 WebElement ele = driver.findElement(By.xpath("//*[@id='identifierId']"));
	               
	 ele.sendKeys("Supersystembd69@yahoo.com");
	
	 JavascriptExecutor jse = ((JavascriptExecutor) driver);
	 jse.executeScript("arguments[0].setAttribute('style', 'background: yellow ; border: 2px solid red;');", ele);
	 
	 Thread.sleep(4000);
	 driver.close();
	 }
	
	@DataProvider(name="browserName")
	public Object[][] getBrowser(){
		return new Object[][] {
			{"Chrome"},
			{"Firefox"},
			{"Edge"},
			{"IE"},
		};
	}

}
