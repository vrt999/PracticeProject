package Assignment2;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPage1 extends TestBase1{
	
	@FindBy(className = "nav-number")
	WebElement reviewsbtn;
	
	@FindBy(css = "review-star[class = 'rvs-svg'] svg.rvs-star-svg:nth-child(4)")
	WebElement starfour;
	
	@FindBy(css = "review-star[class = 'rvs-svg'] svg.rvs-star-svg path[stroke='#4ae0e1']")
	List<WebElement> starcount ;
	
	@FindBy(xpath = "//div[@class = 'dropdown second']")
	WebElement select;
	
	@FindBy(xpath = "//li[text() = 'Health Insurance']")
	WebElement dropdownvalue;
	
	@FindBy(xpath = "//textarea[@placeholder = 'Write your review...']")
	WebElement textarea;
	
	@FindBy(xpath = "//div[text()='Submit']")
	WebElement submit;
	
	@FindBy(xpath = "//span[text() = ' Your Review']")
	WebElement user;
	
	public ReviewPage1() {
		PageFactory.initElements(driver, this);
	}
	
	public void hoverItem(WebElement e,WebDriver driver) {
		Actions a = new Actions(driver);
		a.moveToElement(e).build().perform();
	}


}
