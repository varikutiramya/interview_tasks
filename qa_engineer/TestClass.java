package automation_testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClass {
	WebDriver driver;
	String projectName = "Sample Automation10";

	@BeforeClass
	public void driverSetup() {
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.d3a.io/login");
	}

	@Test(priority = 0)
	public void login() throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys("ramyavarikuti23@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Ramya@99");
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Home']")).isDisplayed());
	}

	@Test(priority = 1)
	public void createProject() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='side-nav__main__wrapper']/div[2]/div")).click();
		driver.findElement(By.xpath("//span[text()='new project']")).click();
		driver.findElement(By.name("name")).sendKeys(projectName);
		driver.findElement(By.name("nameTextArea")).sendKeys("Project to test using Selenium");
		driver.findElement(By.xpath("//span[text()='Add']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='" + projectName + "']")).isDisplayed());
	}

	@Test(priority = 2)
	public void newSimulation() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='" + projectName + "']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//button[contains(@class,'new-simulation')]")).isDisplayed());
		driver.findElement(By.xpath("//button[contains(@class,'new-simulation')]")).click();
		driver.findElement(By.id("input-field-name")).clear();
		driver.findElement(By.id("input-field-name")).sendKeys("Testing Simulation");
		driver.findElement(By.id("textarea-field-description")).sendKeys("Test to simulate the new project created");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Modelling']")).isDisplayed());
	}

	@AfterClass
	public void closeDriver() {
		driver.quit();
	}
}
