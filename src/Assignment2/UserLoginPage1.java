package Assignment2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage1 extends TestBase {
	
	@FindBy(xpath = "//span[@class = 'brgm-button brgm-signup']")
	WebElement login;
	
	@FindBy(xpath = "//input[@name = 'em']")
	WebElement username;
	
	@FindBy(xpath = "//input[@name = 'pw']")
	WebElement password;
	
	@FindBy(xpath = "//label[@class = 'toggle inline-block small']")
	WebElement rememberMe;
	
	@FindBy(xpath = "//button[contains(@class,'btn blue ')]")
	WebElement loginbtn;
	
	@FindBy(xpath = "//div[@class = 'brgm-button brgm-user brgm-list-box']/span")
	WebElement loggedinuser;
	
	public UserLoginPage1() {
		PageFactory.initElements(driver, this);
	}

}
