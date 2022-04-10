package com.tushar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait 
{
    public static void main( String[] args )
    {
        System.out.println( "ExplicitWait app  started" );
        WebDriver driver= null;
        
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
        	
        	//Explicit wait
        	WebDriverWait wait = new WebDriverWait(driver, 50);
        	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//a[contains(text(),'Log Out')]"), 0));

        	WebElement aLogOut =  driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));
        	aLogOut.click();
        	
        	driver.quit();//close();
        System.out.println( "App Closed" );
    }
}
