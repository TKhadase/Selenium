package com.tushar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "App started" );
//        1.  Launch the Browser (Browser = Chrome)
        	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Browser_Drivers\\chromedriver.exe");
        	WebDriver chromeDriver= null;
        	chromeDriver = new ChromeDriver();
        	
//        2.  Maximize browser window
        	chromeDriver.manage().window().maximize();
        	
//        3.  Clear cookies from browser
        	chromeDriver.manage().deleteAllCookies();
        	
//        4.  Launch the Application (URL = https://www.google.com/)
        	chromeDriver.get("https://www.google.com/");
        	
//        5.  Verify application title
        	String googleTitle = chromeDriver.getTitle();
        	if("Google".equals(googleTitle)) {
        		 System.out.println( "google initialized" );
        	}else {
        		 System.out.println( "google not initialized" );
        	}
//        6.  Refresh/Reload the application
        	chromeDriver.navigate().refresh();
        	
//        7.  Navigate to other application (URL = https://in.search.yahoo.com/)
        	chromeDriver.navigate().to("https://in.search.yahoo.com/");
        	
//        8.  Verify application title
        	String yahooTitle = chromeDriver.getTitle();
        	if("Yahoo Search - Web Search".equals(yahooTitle)) {
        		 System.out.println( "Yahoo initialized" );
        	}else {
        		 System.out.println( "Yahoo not initialized" );
        	}
        	
//        9.  Go back to previous site
        	chromeDriver.navigate().back();
        	
//        10. Move forward to next site
        	chromeDriver.navigate().forward();
        	
//        11. Close the browser
        	chromeDriver.quit();
        
        System.out.println( "App Closed" );
    }
}
