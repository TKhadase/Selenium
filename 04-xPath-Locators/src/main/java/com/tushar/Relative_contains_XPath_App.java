package com.tushar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Relative_contains_XPath_App 
{
    public static void main( String[] args )
    {
        System.out.println( "Relative_contains_XPath_App  started" );
        WebDriver driver= null;
        
//        Syntax :  tagName[contains(@attribute,'partial-attribute-value')]
//        Syntax :  tagName[contains(text(),'partial-TextValue')]
        
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
        	
        	WebElement loginIDInput = driver.findElement(By.xpath("//input[contains(@name,'username')]"));
        	loginIDInput.clear();
        	loginIDInput.sendKeys("Tushar");
        	
        	WebElement loginPassInput = driver.findElement(By.xpath("//input[contains(@name,'password')]"));
        	loginPassInput.clear();
        	loginPassInput.sendKeys("Tushar");
        	
        	WebElement btnLogin =  driver.findElement(By.xpath("//input[contains(@value,'Log In')]"));
        	btnLogin.click();

        	driver.quit();//close();
        System.out.println( "App Closed" );
    }
}
