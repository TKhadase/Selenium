package com.tushar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Relative_Basic_XPath_App 
{
    public static void main( String[] args )
    {
        System.out.println( "Relative_Basic_XPath_App  started" );
        WebDriver driver= null;
        
      //  Syntax 1:  tagName[@attribute='attribute-value']
     //  Syntax 2:  tagName[text()='TextValue']
        
//        1.  Launch the Browser 
	    	//(Browser = Chrome)
	    	WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
        	
//        2.  Maximize browser window
			driver.manage().window().maximize();
        	
//        3.  Clear cookies from browser
			driver.manage().deleteAllCookies();
        	
//        4.  Launch the Application
			driver.get("https://parabank.parasoft.com/parabank/index.htm");
        	
        	WebElement loginIDInput = driver.findElement(By.xpath("//input[@name='username']"));
        	loginIDInput.clear();
        	loginIDInput.sendKeys("Tushar");
        	
        	WebElement loginPassInput = driver.findElement(By.xpath("//input[@name='password']"));
        	loginPassInput.clear();
        	loginPassInput.sendKeys("Tushar");
        	
        	WebElement btnLogin =  driver.findElement(By.xpath("//input[@value='Log In']"));
        	btnLogin.click();

        	driver.quit();//close();
        System.out.println( "App Closed" );
    }
}
