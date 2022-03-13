package com.tushar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Locators_Test 
{
    public static void main( String[] args )
    {
        System.out.println( "App started" );
        WebDriver driver= null;
        
//        1.  Launch the Browser 
			//(Browser = Chrome)
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Browser_Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
        	
			/*System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Browser_Drivers\\msedgedriver.exe");
        	Driver = new EdgeDriver();*/
        	
//        2.  Maximize browser window
			driver.manage().window().maximize();
        	
//        3.  Clear cookies from browser
			driver.manage().deleteAllCookies();
        	
//        4.  Launch the Application
			driver.get("https://parabank.parasoft.com/parabank/index.htm");
        	
//        5.  Verify application title
        	String appTitle = driver.getTitle();
        	if("ParaBank | Welcome | Online Banking".equals(appTitle)) {
        		 System.out.println( "parabank initialized" );
        	
        	//id, name, class, tag, linkText, partialLinkText
        	//cssSelector tag#if
        	//cssSelector tag.className
        	//cssSelector tag[attr='<attr-val>']
        	
        	//Orange logo
        	WebElement weLogoOrange_class =driver.findElement(By.cssSelector("img.admin"));
        	//WebElement weLogoOrange_css1=driver.findElement(By.cssSelector("img[src='/parabank/images/clear.gif']"));
        	
        	//bank logo
        	WebElement weLogo_class =driver.findElement(By.className("logo"));
        	WebElement weLogo_css1 =driver.findElement(By.cssSelector("img.logo"));
        	//WebElement weLogo_css2 =driver.findElement(By.cssSelector("img[src='/parabank/images/logo.gif']"));
        	
        	//left links
        	//WebElement weAboutUs_linkText =driver.findElement(By.linkText("About Us"));//2ocurance
        	//WebElement weServices_linkText =driver.findElement(By.linkText("Services"));//2ocurance
        	//WebElement weProducts_linkText =driver.findElement(By.linkText("Products"));//2ocurance
        	//WebElement weLocations_linkText =driver.findElement(By.linkText("Locations"));//2ocurance
         	WebElement weAdminPage_linkText =driver.findElement(By.linkText("Admin Page"));
        	
         	//right links
         	//WebElement weHome_linkText =driver.findElement(By.linkText("home"));//2ocurance
         	WebElement weAbout_linkText =driver.findElement(By.linkText("about"));
         	
         	WebElement weContact_linkText =driver.findElement(By.linkText("contact"));
        	
         	//login	
         	WebElement weUserName_name =driver.findElement(By.name("username"));
         	WebElement weUserName_css=driver.findElement(By.cssSelector("input[type='text']"));
         	
        	WebElement wePassword_name =driver.findElement(By.name("password"));
         	WebElement wePassword_css=driver.findElement(By.cssSelector("input[type='password']"));
         	
         	WebElement weLoginButton_css1=driver.findElement(By.cssSelector("input[type='submit']"));
        	WebElement weLoginButton_css2 =driver.findElement(By.cssSelector("input.button"));
        	
        	WebElement weForgotPass_linkText =driver.findElement(By.linkText("Forgot login info?"));
        	//WebElement weForgotPass_css=driver.findElement(By.cssSelector("a[href='lookup.htm']"));
        	
        	//ATM services
        	WebElement weWFunds_linkText =driver.findElement(By.linkText("Withdraw Funds"));
        	//WebElement weTFunds_linkText =driver.findElement(By.linkText("Transfer Funds")); //2 occurance
        	WebElement weBalance_linkText =driver.findElement(By.linkText("Check Balances"));
        	WebElement weDeposit_linkText =driver.findElement(By.linkText("Make Deposits"));
        	
        	//Online Services
        	WebElement weBpay_linkText =driver.findElement(By.linkText("Bill Pay"));
        	WebElement weHistory_linkText =driver.findElement(By.linkText("Account History"));
        	
        	//LATEST NEWS
        	WebElement weBOpend_linkText =driver.findElement(By.linkText("ParaBank Is Now Re-Opened"));
        	WebElement weOnlineBillPay_linkText =driver.findElement(By.linkText("New! Online Bill Pay")); 
        	WebElement weOnlineAccountTransfers_linkText =driver.findElement(By.linkText("New! Online Account Transfers"));
        	
        	//footer links
        	WebElement weForum_linkText =driver.findElement(By.linkText("Forum"));
        	WebElement weSiteMap_linkText =driver.findElement(By.linkText("Site Map")); 
        	WebElement weContactUs_linkText =driver.findElement(By.linkText("Contact Us"));
         	
        	}else {
       		 System.out.println( "parabank not initialized, please check url." );
       	}
        	
//        11. Close the browser
        			driver.quit();//close();
        System.out.println( "App Closed" );
    }
}
