package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		prop=new Properties();
		
	   // FileInputStream fis=new FileInputStream("C:\\Users\\Yousuf\\my-eclipse-workspace\\E2EFramework\\src\\main\\java\\Resources\\data.properties");
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
	    prop.load(fis);
	    //String browserName=System.getProperty("browser");
	    String browserName= prop.getProperty("browser");
	    String Url=prop.getProperty("Url");
	    
	    
		if(browserName.contains("Chrome")) {
			
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yousuf\\Desktop\\Selenium_Automation-testing Course\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\chromedriver.exe");
			ChromeOptions options= new ChromeOptions();
			
			if(browserName.contains("headless"))
			{
			options.addArguments("headless");
			}
			driver= new ChromeDriver(options);
	    	
	    }
	    else if(browserName.equals("Firefox"))
	    {
	    		    	
	    	//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Yousuf\\Desktop\\Selenium_Automation-testing Course\\geckodriver.exe");
	    	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\geckodriver.exe");
	    	driver=new FirefoxDriver();
	    } 
	    else if(browserName.equals("IE")) 
	    {
	    	//System.setProperty("webdriver.ie.driver", "C:\\Users\\Yousuf\\Desktop\\Selenium_Automation-testing Course\\IEDriverServer.exe");
	    	System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\IEDriverServer.exe");
	    	
	    	driver=new InternetExplorerDriver();
	    }
	    

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return driver;
	    
	}
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot gs= (TakesScreenshot) driver;
		File source= gs.getScreenshotAs(OutputType.FILE);
		String destinationFile= System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
	
	}
