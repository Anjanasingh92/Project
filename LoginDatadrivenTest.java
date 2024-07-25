package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import utilities.XLUtils;

public class LoginDatadrivenTest extends Base {
	
	
	
	@Test(priority=1,dataProvider="LoginDataProvider")
	public void loginDatadriven(String username,String pwd) throws InterruptedException {
		
		logger.info("Datadriven Login Test Started");
		
		
		lp.enter_username(username);
		lp.enter_password(pwd);
		lp.click_login();
		
		Thread.sleep(3000);

        WebElement symboleHome = driver.findElement(By.xpath("//a[@aria-label='Home']"));
		
		boolean status=symboleHome.isDisplayed();
		
		if(symboleHome.isDisplayed()) {
		
		
		Assert.assertTrue(status);
		logger.info("Login test has been passed");
		
		}else {
			
			
			Assert.assertFalse(status);
			logger.info("Login test has been failed");
			
		}

	    logger.info("Datadriven Login Test Ends");
		
	}
	
	
	
	
	
	@DataProvider(name="LoginDataProvider")
	public String[][] userDataProvider() throws IOException{
		String filePath="./DataFiles/loginData.xlsx";
		XLUtils xl=new XLUtils(filePath);
		int rows=xl.getRowCount("Sheet1");
		System.out.println("Number of Rows are: "+rows);
		int colums=xl.getCellCount("Sheet1",1);
		System.out.println("Number of Colums are: "+colums);
		String[][] userdata=new String[rows][colums];
		for(int i=1;i<=rows;i++) {
			
			
			for(int j=0;j<=colums-1;j++) {
				
			
				userdata[i-1][j]=xl.getCellData("Sheet1",i,j);
				
				}		
			
		}
		return userdata;
		
		
		
	}

}