package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login3 {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();

		Thread.sleep(2000);

		String pagesource = driver.getPageSource();

		System.out.println("Source code of the page is=:" + pagesource);

		String ExcpectedUrl = "https://www.saucedemo.com/";

		String actualUrl = driver.getCurrentUrl();

		if (ExcpectedUrl.equals(actualUrl)) {
			System.out.println("Correct url");
		} else {
			System.out.println("wrong url");
		}

		String ExpectedTitle = "Swag Labs";

		String actualTitle = driver.getTitle();

		if (ExpectedTitle.equals(actualTitle)) {
			System.out.println("correct title");
		} else {
			System.out.println("incorrect title");
		}

		WebElement ele = driver.findElement(By.id("user-name"));
		ele.sendKeys("standard_user");
		Thread.sleep(2000);
		WebElement ele1 = driver.findElement(By.id("password"));
		ele1.sendKeys("secret_sauce");
		Thread.sleep(2000);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(3000);
		driver.close();

	}

}
