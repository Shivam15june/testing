package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login {

	WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@Test
	public void correctionpage() throws InterruptedException {
		String Actualurl = driver.getCurrentUrl();

		String expectedurl = "https://www.saucedemo.com/";

		if (Actualurl.equals(expectedurl)) {
			System.out.println("correct page");
		} else {
			System.out.println("incorrect page");
		}

		
		Thread.sleep(2000);
		driver.close();
	}


@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}


