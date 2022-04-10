package com.tushar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Relative_combination_multiple_XPath_App 
{
    public static void main( String[] args )
    {
        System.out.println( "Relative_combination_multiple_XPath_App  started" );
        WebDriver driver= null;
        
//        Syntax :  tagName[@attribute='attribute-value'  and  text()='TextValue']
        
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
        	
        	WebElement aLocations = driver.findElement(By.xpath("//a[@href='http://www.parasoft.com/jsp/pr/contacts.jsp' and text()='Locations']"));
        	aLocations.click();

        	driver.quit();//close();
        System.out.println( "App Closed" );
    }
}
