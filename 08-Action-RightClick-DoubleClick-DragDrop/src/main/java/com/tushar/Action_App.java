package com.tushar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Action_App {
	public static void main(String[] args) {
		System.out.println("Action_App started");
//      1. Launch chrome Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

//2. Maximize Browser Window
		driver.manage().window().maximize();

//3. Clear all cookies
		driver.manage().deleteAllCookies();

//4. Launch the application {url = https://demoqa.com/buttons }
		driver.get("https://demoqa.com/buttons");

//Initialize actions class
		Actions action = new Actions(driver);

		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//5. Perform double click action
		 WebElement doubleClickBtn = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		 action.doubleClick(doubleClickBtn).build().perform();
		
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
//6. Perform right click action
		 WebElement rightClickBtn = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
		 action.doubleClick(rightClickBtn).build().perform();
		 
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
//7.  Perform Drag and Drop Operation
		 driver.navigate().to("https://demoqa.com/droppable");
		 WebElement sourceElement = driver.findElement(By.xpath("//div[@id='draggable']"));
         WebElement targetElement = driver.findElement(By.xpath("//div[@id='draggable']/following-sibling::div[@id='droppable']"));
         action.dragAndDrop(sourceElement, targetElement).build().perform();
         
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

// Close the Browser        
		driver.close();

	}
}
