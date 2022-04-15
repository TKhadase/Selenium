package com.tushar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTab_newWindow_App 
{
    public static void main( String[] args )
    {
        System.out.println( "NewTab_newWindow_App started" );
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        
        driver.navigate().to("https://demoqa.com/browser-windows");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        WebElement newTabBtn = driver.findElement(By.xpath("//button[@id='tabButton']"));        
        
        newTabBtn.click();
        
     List<String> windowsList = new ArrayList<String>(driver.getWindowHandles());
     System.out.println("windows list is: "+windowsList);
     
     	//Switch to new tab
        driver.switchTo().window(windowsList.get(1));
        WebElement newTabElement = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
        System.out.println(newTabElement.getText());
        driver.close(); //close active window
        
      //Switch to main tab
        driver.switchTo().window(windowsList.get(0));
        WebElement mainWindowElement = driver.findElement(By.xpath("//div[text()='Elements']"));
        WebElement newWindowBtn = driver.findElement(By.xpath("//button[@id='windowButton']"));
        newWindowBtn.click();
        
        windowsList = new ArrayList(driver.getWindowHandles());
        System.out.println("updated windows list is: "+windowsList);
      //Switch to new Window
        driver.switchTo().window(windowsList.get(1));
        WebElement newWindowElement = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
        System.out.println(newWindowElement.getText());

        //Close new window
        driver.close();
        
       // Switch back to main window  from new window
        driver.switchTo().window(windowsList.get(0));
        
        mainWindowElement.click();
        
        //driver.close();
        System.out.println( "newTab_newWindow_App stopped" );
    }
}
