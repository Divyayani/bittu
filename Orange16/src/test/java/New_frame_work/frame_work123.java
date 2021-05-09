package New_frame_work;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class frame_work123 {
	WebDriver driver;
	
	
  @Test
  public void AddNationalitiess() throws Exception
	{
		
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.manage().window().maximize() ;	
	driver.get("https://opensource-demo.orangehrmlive.com/");  
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	driver.findElement(By.id("btnLogin")).click();
	
	WebElement PIM=findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b"));
	WebElement EMPLOYEE=findElement(By.id("menu_pim_viewEmployeeList"));
	
	Actions actions = new Actions(driver);
	
			
	   actions.moveToElement(PIM).
	   moveToElement(EMPLOYEE).click().build().perform();
	   
	   
	 	 Thread.sleep(100);
	 	 findElement(By.id("empsearch_id")).sendKeys("0002");
	 	Thread.sleep(100);
	 	
	 	findElement(By.xpath("//*[@id=\"searchBtn\"]")).click();
	 	findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[3]/a")).click();
	 	driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("chandra308");
	 	driver.findElement(By.id("personal_txtEmployeeId")).sendKeys("0002");
			
	}

  public  WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}
  
  
}
