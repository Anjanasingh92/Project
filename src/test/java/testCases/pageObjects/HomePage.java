package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	
	WebDriver driver;
	
	  public HomePage(WebDriver driver) {
			
			this.driver=driver;
			
			
		}
		
	 	By iconProfile=By.xpath("//div[@class='x78zum5 x1n2onr6']");
		
		                     
		By btnLogout=By.xpath("//span[.='Log out']");
		

	
		
		
		public void logout() throws InterruptedException {
			
			driver.findElement(iconProfile).click();	
			
			Thread.sleep(2000);
			
			driver.findElement(btnLogout).click();
			
			Thread.sleep(2000);
		}
		

}
