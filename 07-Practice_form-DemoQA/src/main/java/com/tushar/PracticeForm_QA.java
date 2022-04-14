package com.tushar;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeForm_QA 
{
    public static void main( String[] args )
    {
        System.out.println( "PracticeForm_QA started" );
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
        	driver.get("https://demoqa.com/automation-practice-form");
        	
//        5.  Verify application title
        	String pageTitle = driver.getTitle();
        	if("ToolsQA".equals(pageTitle)) {
        		 System.out.println( "PracticeForm_QA initialized" );
        	}else {
          		 System.out.println( "PracticeForm_QA not initialized" );
          	}
        	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); //Implicit wait
        	
        	WebElement formHeading = driver.findElement(By.xpath("//div[@class='main-header']"));
        	System.out.println("Form Heading: "+formHeading.getText());
        	
        	WebElement fName_input = driver.findElement(By.xpath("//input[@id='firstName']"));
        	if(fName_input.isDisplayed() && fName_input.isEnabled()) {
        		System.out.println("first name is visible &  editable");
        		fName_input.clear();
        		fName_input.sendKeys("Tushar");
        	}else {
        		System.out.println("first name is not visible or editable");
        	}
        	
        	WebElement lName_input = driver.findElement(By.xpath("//input[@id='lastName']"));
        	if(lName_input.isDisplayed() && lName_input.isEnabled()) {
        		System.out.println("last name is visible &  editable");
        		lName_input.clear();
        		lName_input.sendKeys("Khadse");
        	}else {
        		System.out.println("last name is not visible or editable");
        	}
        	
        	WebElement mail_input = driver.findElement(By.xpath("//input[@id='userEmail']"));
        	if(mail_input.isDisplayed() && mail_input.isEnabled()) {
        		System.out.println("mail is visible &  editable");
        		mail_input.clear();
        		mail_input.sendKeys("tushar.Khadase@gmail.com");
        	}else {
        		System.out.println("mail is not visible or editable");
        	}
        	
        	List<WebElement> gender_radio = driver.findElements(By.xpath("//input[@name='gender']"));
        	int gendersCount=gender_radio.size();
        	System.out.println("Genders are:"); 
        	for(int i=0; i<gendersCount;i++) {
        		System.out.println(""+gender_radio.get(i).getAttribute("value"));
        		
        		if(gender_radio.get(i).getAttribute("value").equals("Male")) {
        			WebElement gender = driver.findElement(By.xpath("//label[@for='gender-radio-"+(i+1)+"']"));
        			gender.click();
        			System.out.println(""+gender_radio.get(i).getAttribute("value")+" is selected");
        		}
        		
        	}
        	
        	WebElement number_input = driver.findElement(By.xpath("//input[@id='userNumber']"));
        	if(number_input.isDisplayed() && number_input.isEnabled()) {
        		System.out.println("phone No. is visible &  editable");
        		number_input.clear();
        		number_input.sendKeys("7798488512");
        	}else {
        		System.out.println("phone No. is not visible or editable");
        	}
        	
        	 // Open Calendar
            WebElement dob = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
            dob.click();
           
            //Select month
            WebElement month = driver.findElement(By.xpath("//select[contains(@class,'month')]"));
            Select mnth = new Select(month);
            mnth.selectByVisibleText("December");
           
            //Select Year
            WebElement year = driver.findElement(By.xpath("//select[contains(@class,'year')]"));
            Select yr = new Select(year);
            yr.selectByVisibleText("2022");
           
            //Select Date by using dynamic xpath
            WebElement date = driver.findElement(new PracticeForm_QA().selectDate("December", 2022, 1));
            date.click();
        	
        	WebElement address_textarea = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        	if(address_textarea.isDisplayed() && address_textarea.isEnabled()) {
        		System.out.println("address_textarea is visible &  editable");
        		address_textarea.clear();
        		address_textarea.sendKeys("Pune, Maharashtra");
        	}else {
        		System.out.println("address_textarea is not visible or editable");
        	}
            
        	 //Select Hobbies CheckBox
            WebElement hobbiesCheckbox = driver.findElement(By.xpath("//label[text()='Reading']"));
            if (!hobbiesCheckbox.isSelected())
                    hobbiesCheckbox.click();    
            
        	// Click on subject
            WebElement subjectTextBox = driver.findElement(By.xpath("//div[contains(@class,'value-container')]"));
            subjectTextBox.click();
           
            // Select subject using actions class
            Actions action = new Actions(driver);
            action.sendKeys("Eng").build().perform();
            WebElement english = driver.findElement(By.xpath("//div[contains(text(),'English')]"));
            english.click();
        	
        	
        	WebElement state_select = driver.findElement(By.xpath("//input[@id='react-select-3-input']"));
        	if(state_select.isDisplayed() && state_select.isEnabled()) {
        		System.out.println("state input is visible &  editable");
        		state_select.clear();
        		state_select.sendKeys("NCR");
        	}else {
        		System.out.println("state dropdown is not visible or editable");
        	}
        	
         	WebElement city_select = driver.findElement(By.xpath("//input[@id='react-select-4-input']"));
        	if(city_select.isDisplayed() && city_select.isEnabled()) {
        		System.out.println("City input is visible &  editable");
        		city_select.clear();
        		city_select.sendKeys("Delhi");
        	}else {
        		System.out.println("City input is not visible or editable");
        	}
        	

            //Click on submit button
            WebElement sumbmitbutton = driver.findElement(By.xpath("//button[@id='submit']"));
           
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click()", sumbmitbutton);
        	
//         Close the browser
        //	driver.quit();//close();
        
        System.out.println( "App Closed" );
    }
    public By selectDate(String month, int year, int day) {
        return By.xpath("//div[contains(@aria-label,'" + month + "') and contains(@aria-label,'" + year
                        + "') and text()='" + day + "']");
}

public By selectOption(String option) {
        return By.xpath("//div[text()='"+option+"']");
}
}
