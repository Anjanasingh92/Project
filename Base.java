package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import pageObjects.LoginPage;




public class Base {
	
public static   WebDriver driver;
public 	Logger logger;
public LoginPage lp;

	
static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());     //time stamp

	
	@BeforeMethod
	public void setup() {
		

	
		logger=Logger.getLogger("Facebook");
	    PropertyConfigurator.configure("Log4j.properties");
	
		String browser="chrome";
		if(browser.equals("chrome")) {
			
			    ChromeOptions ops = new ChromeOptions();
		        ops.addArguments("--disable-notifications");
		        ops.addArguments("start-maximized");
			   driver=new ChromeDriver(ops);
			   logger.info("***********Chrome has been Broswer invoked**********");
			
		}else if(browser.equals("firefox")) {
		
			driver=new FirefoxDriver();
			logger.info("# Firefox Broswer invoked#");
		}else if(browser.equals("edge")) {
			
			driver=new EdgeDriver();
			logger.info("# Edge Broswer invoked#");
		}else {
			
			System.out.println("Broser Not Found");
			 
		}
		
		lp=new LoginPage(driver);
		
		driver.get("https://www.facebook.com/");
		logger.info("***********URL has been launched*********");
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		logger.info("*********Broswer has been Terminated********");
		
	}

	
	public void captureScreen(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+timeStamp+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}


	
}
