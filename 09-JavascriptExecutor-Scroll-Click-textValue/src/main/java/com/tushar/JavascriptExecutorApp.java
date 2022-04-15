package com.tushar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecutorApp 
{
    public static void main( String[] args )
    {
        System.out.println( "JavascriptExecutorApp started" );
//  Launch chrome Browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
       
// Maximize Browser Window
        driver.manage().window().maximize();
       
// Clear all cookies
        driver.manage().deleteAllCookies();
       
//Launch the application {url = https://demoqa.com/elements }
        driver.get("https://demoqa.com/elements"); 
        
        WebElement  menuInteraction = driver.findElement(By.xpath("//div[text()='Interactions']"));
        
        //Scroll screen upto Interactions Menu
        JavascriptExecutor jsExe = (JavascriptExecutor) driver;
        jsExe.executeScript("arguments[0].scrollIntoView()", menuInteraction);
        
        //Click on MEnu using JavascriptExecutor
        jsExe.executeScript("arguments[0].click()", menuInteraction);
        
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        
        driver.get("https://demoqa.com/text-box"); 
        
        WebElement textboxFullName = driver.findElement(By.xpath("//input[@id='userName']"));
        WebElement textboxEmail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        WebElement textboxCurrentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        WebElement textboxPermanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        
        //fill text value in textbox using JavascriptExecutor
        jsExe.executeScript("arguments[0].value='Tushar'", textboxFullName);        
        jsExe.executeScript("arguments[0].value='tk@gmail.com'", textboxEmail);        
        jsExe.executeScript("arguments[0].value='Pune'", textboxCurrentAddress);        
        jsExe.executeScript("arguments[0].value='Yavatmal'", textboxPermanentAddress);        
             
        //close browser
        driver.close();
        System.out.println( "JavascriptExecutorApp stopped successfully" );
    }
}
