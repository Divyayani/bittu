package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;
import Reporter_Example_Word.ImageAttachmentInDocument1;
import Reporter_Example_Word.Reporter1;

public class Edit_employee {

	WebDriver driver;

	Reporter1 R1;
	
	@DataProvider(name = "Seetha")
	public static Object[][] Authentication1() throws Exception {
		
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C://HTML Report//seetha.xlsx", "Sheet2");
		System.out.println(testObjArray.length);
		return (testObjArray);
	}
	

	//String Hurl1 = "https://opensource-demo.orangehrmlive.com/";
    //String uname = "Admin";
	//String pass = "admin123";
	//String empid = "022";

	@Test(dataProvider = "Seetha")
	public void empppp_ed(String Hurl1,String uname,String pass, String empid,String fname,String mname,String lname,String mpid,String PID,String RC) throws Exception {

		Edit_employee E1 = new Edit_employee(); 
		E1.openb();
		E1.Hurl12(Hurl1);
		E1.Hrmlogin1(uname, pass);
		E1.editemp(empid,fname,mname,lname,mpid,PID,RC);

	}

	public void openb() throws Exception {

		driver = TestBrowser.OpenChromeBrowser();

	}

	public void Hurl12(String Hurl1) throws Exception {
		driver.get(Hurl1);

	}

	public void Hrmlogin1(String uname, String pass) throws Exception {
		driver.findElement(By.id("txtUsername")).sendKeys(uname);
		driver.findElement(By.id("txtPassword")).sendKeys(pass);
		driver.findElement(By.id("btnLogin")).click();

	}

	public  void  editemp(String empid,String fname,String mname,String lname,String mpid,String PID,String RC) throws Exception {

		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		driver.findElement(By.id("empsearch_id")).sendKeys(empid);

		driver.findElement(By.id("searchBtn")).click();

		driver.findElement(By.linkText("022")).click();
		
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();
		
		driver.findElement(By.id("personal_txtEmpFirstName")).clear();
		driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys(fname);
		
		driver.findElement(By.xpath("//*[@id='personal_txtEmpMiddleName']")).clear();
		driver.findElement(By.xpath("//*[@id='personal_txtEmpMiddleName']")).sendKeys(mname);
		
		driver.findElement(By.id("personal_txtEmpLastName")).clear();
		driver.findElement(By.id("personal_txtEmpLastName")).sendKeys(lname);
		
		
		driver.findElement(By.id("personal_txtEmployeeId")).clear();
		driver.findElement(By.id("personal_txtEmployeeId")).sendKeys(mpid);
		
		
		driver.findElement(By.xpath("//*[@id='personal_txtOtherID']")).clear();
		driver.findElement(By.xpath("//*[@id='personal_txtOtherID']")).sendKeys(PID);
		
		driver.findElement(By.xpath("//*[@id='personal_txtLicenNo']")).clear();
		driver.findElement(By.xpath("//*[@id='personal_txtLicenNo']")).sendKeys(RC);
		
		driver.findElement(By.xpath("//*[@class ='ui-datepicker-trigger']")).click();
		
		Thread.sleep(4000);
		
		
	   
		
		Select l1=new Select(driver.findElement(By.className("ui-datepicker-year")));
		l1.selectByValue("2017");
		
		Thread.sleep(5000);
		
		Select l2=new Select(driver.findElement(By.className("ui-datepicker-month")));
		l2.selectByValue("6");
		
		Thread.sleep(5000);
		
		Actions act1 = new Actions(driver);
	
	 	WebElement date2=driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[3]/a"));
	 	act1.moveToElement(date2).click().build().perform();
	 	
	 	driver.findElement(By.name("personal[txtNICNo]")).clear();
	 	driver.findElement(By.name("personal[txtNICNo]")).sendKeys("ssn986557");
	 	
	 	driver.findElement(By.name("personal[txtSINNo]")).clear();
	 	driver.findElement(By.name("personal[txtSINNo]")).sendKeys("ssid98765463979");
	 	
	 	
	 	driver.findElement(By.xpath("//*[@id='personal_optGender_1']")).click();
	 	
	 	Thread.sleep(2000);
	 	Select l3=new Select (driver.findElement(By.id("personal_cmbMarital")));
	 	l3.selectByValue("Single");
	 	
	 	Thread.sleep(2000);
	 	
	 	Select l4=new Select(driver.findElement(By.id("personal_cmbNation")));
	 	l4.selectByValue("82");
	 	
	 	driver.findElement(By.cssSelector("#frmEmpPersonalDetails > fieldset > ol:nth-child(3) > li:nth-child(4) > img")).click();
	 	
	 	
	 	String str="//*[@id='ui-datepicker-div']/div/div/select[2]";
	 	Select l5=new Select(driver.findElement(By.xpath(str)));
		l5.selectByVisibleText("2018");
		
		Thread.sleep(2000);
		
		
		String str1="//*[@id='ui-datepicker-div']/div/div/select[1]";
		Select l6=new Select(driver.findElement(By.xpath(str1)));
		l6.selectByVisibleText("Feb");
		
		Thread.sleep(2000);
		
		Actions act2=new Actions(driver);
		String Str2="//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[2]/a";
		WebElement dat3=driver.findElement(By.xpath(Str2));
		act2.moveToElement(dat3).click().build().perform();
		
		driver.findElement(By.xpath("//*[@id='personal_txtEmpNickName']")).sendKeys("Nani");
			
		driver.findElement(By.xpath("//*[@id='personal_txtMilitarySer']")).sendKeys("No");
		
		
		driver.findElement(By.id("btnSave")).click();
		
		Reporter1 R1=new Reporter1(driver,"Employee Details After Modification") ;
		
		String S3=R1.TakeScreenShotAuto(driver,"emploeee modification sucess","Pass");
		
		
		ImageAttachmentInDocument1 IA = new ImageAttachmentInDocument1();
		IA.CreateHeader("Test_Case : Employee Modification ");
		IA.PasteImage("Employee Modific", S3);
	 	
	 	
		
	}

	
}
