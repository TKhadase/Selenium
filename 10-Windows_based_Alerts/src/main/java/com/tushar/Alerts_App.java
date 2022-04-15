package com.tushar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts_App 
{
    public static void main( String[] args )
    {
        System.out.println( "Alerts_App started" );
        
        //Setup & launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new  ChromeDriver();
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        
        //Navigate to URL
        driver.get("https://demoqa.com/alerts");
        
        //Alert Window
        WebElement infoAlertBtn = driver.findElement(By.xpath("//button[@id='alertButton']"));
        	infoAlertBtn.click();
        	//switch to alert window
        	Alert alert  =driver.switchTo().alert();
        	//get messgae Details from alert window
        	System.out.println(alert.getText());
        	//Ok
        	alert.accept();
        	//cancel /dismiss: alert.dismiss();
        	
        	
        WebElement confirmationAlertBtn = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        confirmationAlertBtn.click();
        //get messgae Details from alert window
        System.out.println(alert.getText());
        alert.dismiss();
        
        WebElement promtAlertBtn = driver.findElement(By.xpath("//button[@id='promtButton']"));
        promtAlertBtn.click();
        System.out.println(alert.getText());
        alert.sendKeys("Tushar");
        alert.accept();
        
        //close browser
        driver.close();
        
        System.out.println( "Alerts_App stopped" );
    }
}
