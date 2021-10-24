package Assignment2;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

class TestBase {
	
	public static WebDriver driver;
	
	public static WebDriver initializeDriver() {
		
		System.setProperty ("webdriver.chrome.driver","C:\\Users\\vrt999\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe" );
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		return driver;
		
	}

}

class UserLoginPage extends TestBase {
	
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
	
	public UserLoginPage() {
		PageFactory.initElements(driver, this);
	}

}


class ReviewPage extends TestBase{
	
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
	
	public ReviewPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void hoverItem(WebElement e,WebDriver driver) {
		Actions a = new Actions(driver);
		a.moveToElement(e).build().perform();
	}


}


public class Assignment2Test extends TestBase {
	WebDriver driver;
	UserLoginPage userloginpage;
	ReviewPage reviewpage;
	Scanner sc;
	String userval;
	String passval;
	
	
	@BeforeMethod
	public void beforeTest() throws Exception {
		sc = new Scanner(System.in);
		System.out.println("Enter UserName: ");
		userval = sc.nextLine();
		System.out.println("Enter password: ");
		passval = sc.nextLine();
		
		driver = TestBase.initializeDriver();
	}
	
	@Test
	public void submitReviewTest() throws InterruptedException {
		driver.get("https://wallethub.com/profile/test_insurance_company");
		String text = "I have given this review for testing purposes on the test insurance company for the internal validation on the website provided by the insurance company";
		
		//User Login
		userloginpage = new UserLoginPage();
		userloginpage.login.click();
		userloginpage.username.sendKeys(userval);
		userloginpage.password.sendKeys(passval);
		userloginpage.rememberMe.click();
		userloginpage.loginbtn.click();
		System.out.println("User login successful");
		Assert.assertEquals("valid",userloginpage.loggedinuser.getText(),"User isnot same");
		
		//navigate to the review link
		driver.navigate().to("https://wallethub.com/profile/test_insurance_company");		
		reviewpage = new ReviewPage();
		reviewpage.reviewsbtn.click();
		
		//Move to and verify on four star and click
		reviewpage.hoverItem(reviewpage.starfour, driver);
		reviewpage.hoverItem(reviewpage.starfour, driver);
		Assert.assertEquals(reviewpage.starcount.size(), 4);
		reviewpage.starfour.click();
		
		//write Review
		reviewpage.select.click();
		reviewpage.dropdownvalue.click();
		reviewpage.textarea.sendKeys(text);
		reviewpage.submit.click();
		
		//validation of review
		driver.navigate().to("https://wallethub.com/profile/test_insurance_company");
		reviewpage.hoverItem(reviewpage.user, driver);
		Assert.assertEquals(reviewpage.user.isDisplayed(),true);		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}	

}
