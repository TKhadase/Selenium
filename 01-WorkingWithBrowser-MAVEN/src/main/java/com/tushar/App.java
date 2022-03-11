package com.tushar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "App started" );
        WebDriver Driver= null;
        
//        1.  Launch the Browser 
		/*	//(Browser = Chrome)
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Browser_Drivers\\Driver.exe");
			Driver = new ChromeDriver();*/
        	
        	System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Browser_Drivers\\msedgedriver.exe");
        	Driver = new EdgeDriver();
        	
//        2.  Maximize browser window
        	Driver.manage().window().maximize();
        	
//        3.  Clear cookies from browser
        	Driver.manage().deleteAllCookies();
        	
//        4.  Launch the Application (URL = https://www.google.com/)
        	Driver.get("https://www.google.com/");
        	
//        5.  Verify application title
        	String googleTitle = Driver.getTitle();
        	if("Google".equals(googleTitle)) {
        		 System.out.println( "google initialized" );
        	}else {
        		 System.out.println( "google not initialized" );
        	}
//        6.  Refresh/Reload the application
        	Driver.navigate().refresh();
        	
//        7.  Navigate to other application (URL = https://in.search.yahoo.com/)
        	Driver.navigate().to("https://in.search.yahoo.com/");
        	
//        8.  Verify application title
        	String yahooTitle = Driver.getTitle();
        	if("Yahoo Search - Web Search".equals(yahooTitle)) {
        		 System.out.println( "Yahoo initialized" );
        	}else {
        		 System.out.println( "Yahoo not initialized" );
        	}
        	
//        9.  Go back to previous site
        	Driver.navigate().back();
        	
//        10. Move forward to next site
        	Driver.navigate().forward();
        	
//        11. Close the browser
        	Driver.quit();//close();
        
        System.out.println( "App Closed" );
    }
}
