package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

	WebDriver driver;
	
  public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		
		
	}
	
 	By username=By.xpath("//input[@id='email']");
	
	                     
	By password=By.xpath("//input[@id='pass']");
	

	By loginButton=By.xpath("//button[@name='login']");
	
	
	
	
	
	public void enter_username(String uName) {
		
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(uName);
		
	}
	
    public void enter_password(String pw) {
		
    	driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pw);
		
	}
	
   public void click_login() {
	
	
	driver.findElement(loginButton).click();
	
}

	
	

}