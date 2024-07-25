package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginTest extends Base {
	

	@Test(priority=1)
	public void valid_Username_Password() throws InterruptedException {
		
		logger.info("Login with valid Username and valid Password test started");
		lp.enter_username("Anjanasingh799@gmail.com");
		lp.enter_password("Gg@123456");
		lp.click_login();
		
		
		
		Thread.sleep(3000);
		
		WebElement symboleHome = driver.findElement(By.xpath("//a[@aria-label='Home']"));
		
		boolean status=symboleHome.isDisplayed();
		
		Assert.assertTrue(status);
		
		logger.info("*****Login test has been passed*****");

		logger.info("Login with valid Username and valid Password test Ended");
		}
	
	
	@Test(priority=2)
	public void valid_Username_Invalid_Password() throws InterruptedException {
		
		logger.info("Login with valid User name and Invalid Password test started");
		lp.enter_username("RAMA@Radha12");
		lp.enter_password("xyz1234");
		lp.click_login();
		
		
		
        WebElement symboleHome = driver.findElement(By.xpath("//a[@aria-label='Home']"));
		
		boolean status=symboleHome.isDisplayed();
		
		Assert.assertTrue(status);
		
		logger.info("Login test has been failed");
		
		logger.info("Login with valid Username Invalid Password test Ended");
		
		
		}
	

		
	
	

}