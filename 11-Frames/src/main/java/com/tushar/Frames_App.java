package com.tushar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames_App 
{
    public static void main( String[] args )
    {
        System.out.println( "Frames_App started" );
        
        //Setup & Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        
        driver.get("https://demoqa.com/frames");
        
        //locate  main window element
        WebElement menuElement = driver.findElement(By.xpath("//div[text()='Elements']"));
        
//      Switch to Frame from main window
        //driver.switchTo().frame(0);//by index
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'frame1')]"))); // by frame element
        driver.switchTo().frame("frame1"); //by frame name
        
        //locate  frame window elements
        WebElement frameHeading = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
        System.out.println(frameHeading.getText());
        
//      Switch back to main window  from frame
        driver.switchTo().defaultContent();
        
//click on any element of main window         
        menuElement.click();
        
 //close browser
//        driver.close();
        
        System.out.println( "Frames_App stopped");
    }
}
