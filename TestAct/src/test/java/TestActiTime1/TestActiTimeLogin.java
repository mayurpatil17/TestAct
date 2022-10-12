package TestActiTime1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestActiTimeLogin {
	WebDriver driver;
	
	@BeforeTest
	public void setPath()
	{
		System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
	}
	
	@BeforeMethod
    public void setUp()
    {
		
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://laptop-o7brkd6n/login.do");
		
		
    }
	
	@Test
	public void loginTest() throws InterruptedException
	{
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		Thread.sleep(5000);
		driver.findElement(By.id("loginButton")).click();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		
	}

}
