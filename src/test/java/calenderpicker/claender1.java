package calenderpicker;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class claender1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");

		driver.manage().window().maximize();

		Thread.sleep(2000);

		String year = "2023";

		String date = "15";

		String month = "jun";

		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		Thread.sleep(2000);

		while (true) {
			String monyear = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			String arr[] = monyear.split(" ");

			String mon = arr[0];

			String yr = arr[1];
			System.out.println(mon);
			System.out.println(yr);
			if (mon.equalsIgnoreCase(month) && yr.equals(year)) {
				break;
			} else {
				driver.findElement(By.xpath("//button[normalize-space()='>']")).click();
			}

		}

		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));

		for (WebElement ele : dates) {
			String dt = ele.getText();
			if (dt.equals(date)) {
				ele.click();
				break;
			}
		}

		Thread.sleep(2000);
		driver.close();
	}

}
