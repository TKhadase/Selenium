package com.tushar;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable 
{
	
	  public static void main( String[] args )
	    {
	        System.out.println( "WebTable app  started" );
	        WebDriver driver= null;
	        
//	        1.  Launch the Browser 
		    	//(Browser = Chrome)
		    	WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
	        	
//	        2.  Maximize browser window
				driver.manage().window().maximize();
	        	
//	        3.  Clear cookies from browser
				driver.manage().deleteAllCookies();
	        	
//	        4.  Launch the Application
				driver.get("https://opensource-demo.orangehrmlive.com/");
	        	
	        	WebElement loginIDInput = driver.findElement(By.xpath("//input[@id='txtUsername']"));
	        	loginIDInput.clear();
	        	loginIDInput.sendKeys("Admin");
	        	
	        	WebElement loginPassInput = driver.findElement(By.xpath("//input[@id='txtPassword']"));
	        	loginPassInput.clear();
	        	loginPassInput.sendKeys("admin123");
	        	
//		     5. Login application
	        	WebElement btnLogin =  driver.findElement(By.xpath("//input[@id='btnLogin']"));
	        	btnLogin.click();

	        	//Implicit wait
	        	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	        	
//			6. goto webtable	        	
	        	WebElement adminMenu =   driver.findElement(By.xpath("//b[text()='Admin']"));
	        	adminMenu.click();

//			7. selecting value from DropDown
	        	WebElement selectUserRoleElement = driver.findElement(By.xpath("//select[@id='searchSystemUser_userType']"));
	        	Select selectUserRole = new Select(selectUserRoleElement);
	        	selectUserRole.selectByVisibleText("ESS");
	        	
//			8. selecting all check box from WebTable
	        	WebElement checkBox = driver.findElement(By.xpath("//input[@id='ohrmList_chkSelectAll']"));
	        	if(! checkBox.isSelected()) {
	        		checkBox.click();
	        	}
	        	
//           9. Printing  Web Table values   	        	
	        	//find no. of rows
	        	List<WebElement> rows = driver.findElements(By.xpath("//tr[@class]"));
	        	int totalRows = rows.size();
	        	System.out.println("totalRows: "+totalRows);
	        	
	        	//find no. of columns
	          	List<WebElement> columns = driver.findElements(By.xpath("//th[@rowspan='1']"));
	        	int totalColumns = columns.size();
	        	System.out.println("totalColumns: "+totalColumns);
	        	
	        	//print table headers
	        	for(int i=0;i<totalColumns;i++) {
	        		System.out.println("totalColumns ("+i+") :"+columns.get(i).getText());
	        	}
	        	
	        	//print table values
	        	List<WebElement> rowValues = driver.findElements(By.xpath("//td[@class='left']"));
	        	for(int i=0;i<rowValues.size();i++) {
	        		System.out.print("---- Row ("+i+") :"+rowValues.get(i).getText());
	        	}
	        	
	        	for(int row=1;row<totalRows;row++) {
	        		for(int col=1;col<totalColumns;col++) {
	        			WebElement element = driver.findElement(new WebTable().getLocator(row,col));
	        			System.out.print(element.getText()+" | ");
	        	}//totalColumns
	        		System.out.print("\n--------------------------- \n");
	        	}//totalRows
	        	
// 			10.logout	        	
	         	WebElement btnUser =  driver.findElement(By.xpath("//a[@id='welcome']"));
	         	btnUser.click();
	         	
	        	//Implicit wait
	        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        	
	        	WebElement btnLogOut =  driver.findElement(By.xpath("//a[text()='Logout']"));
	        	btnLogOut.click();
	        	System.out.println( "LogOut clicked" );
	        	//Implicit wait
	        	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	        	
//			11.close
	        	driver.quit();
	        System.out.println( "App Closed" );
	    }
	  
	  public By getLocator(int rowNum , int columnNum) {
	        return By.xpath("//tbody/child::tr["+rowNum+"]/child::td["+columnNum+"]");
		}
	  
	}