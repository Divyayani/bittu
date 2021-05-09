package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import CommonUtil.TestBrowser;



public class employeelist_Add {
	
	WebDriver driver;
	String Hurl1 = "https://opensource-demo.orangehrmlive.com/";
    String uname = "Admin";
	String pass = "admin123";
	String empid = "022";
	String fname="Ram";
    String lname="N";

	@Test
  
  
  public void edit_emploee() throws Exception{
	  
	  
	  employeelist_Add e=new employeelist_Add();
	  e.openb();
	  e.Hurl12(Hurl1);
	  e.Hrmlogin1(uname,pass);
	  e.addemp1(fname,lname,empid);
	  
	  
	  
  }
  
  public   void openb() throws Exception {
	  
	  

		driver = TestBrowser.OpenChromeBrowser();

  }
  public   void Hurl12(String Hurl1) throws Exception {
		driver.get(Hurl1);
  
  
}
  public  void Hrmlogin1(String uname, String pass) throws Exception {
		driver.findElement(By.id("txtUsername")).sendKeys(uname);
		driver.findElement(By.id("txtPassword")).sendKeys(pass);
		driver.findElement(By.id("btnLogin")).click();
  }
  public  void addemp1(String fname, String lname, String empid) throws Exception {

		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		driver.findElement(By.id("firstName")).sendKeys(fname);
		driver.findElement(By.id("lastName")).sendKeys(lname);
		driver.findElement(By.id("employeeId")).clear();
		driver.findElement(By.id("employeeId")).sendKeys(empid);
		driver.findElement(By.id("btnSave")).click();
		
		
		
		
		
		
	}
}

