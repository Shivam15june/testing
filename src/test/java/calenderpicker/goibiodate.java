package calenderpicker;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class goibiodate {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");

		driver.manage().window().maximize();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/div/div[2]/span/span")).click();
		Thread.sleep(2000);

		String year = "2023";

		String date = "15";

		String month = "july";

		driver.findElement(By.xpath("//div[@class='sc-1gt8xf5-0 cEQQxj']//div[3]//div[1]")).click();

		while (true) {

			String monyear = driver.findElement(By.xpath(
					"//body[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]"))
					.getText();

			String arr[] = monyear.split(" ");

			String mon = arr[0];

			String yr = arr[1];
			System.out.println(mon);
			System.out.println(yr);

			if (mon.equalsIgnoreCase(month) && yr.equals(year)) {
				break;
			} else {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}

		List<WebElement> dates = driver.findElements(By.xpath(
				"//body[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[3]//p[@class='fsw__date']"));

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
