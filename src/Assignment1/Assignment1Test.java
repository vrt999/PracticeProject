package Assignment1;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment1Test {
	WebDriver driver;
	Scanner sc;
	String username;
	String password;
	String message;
	
	@BeforeMethod
	public void beforeMethod() {
		
		//collect credentials
		sc = new Scanner(System.in);
		System.out.println("Enter UserName: ");
		username = sc.nextLine();
		System.out.println("Enter password: ");
		password = sc.nextLine();
		
		message = "Hello World";
		
		//Set up Driver
		System.setProperty ("webdriver.chrome.driver","C:\\Users\\vrt999\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe" );
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws Exception {
		
		//Login the FaceBook
		driver.get("https://www.facebook.com");
		driver.findElement(By.cssSelector("#email")).sendKeys(username);
		driver.findElement(By.cssSelector("#pass")).sendKeys(password);
		driver.findElement(By.cssSelector("#u_0_b")).click();
		
		//Add post
		driver.findElement(By.cssSelector("span._5qtp")).click();
		driver.findElement(By.xpath("//div[@class = '_1mf _1mj']")).sendKeys(message);
		driver.findElement(By.xpath("//button[@class = '_1mf7 _4r1q _4jy0 _4jy3 _4jy1 _51sy selected _42ft']")).click();
		
		Thread.sleep(5000);
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
