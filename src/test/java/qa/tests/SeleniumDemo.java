package qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumDemo {
	static WebDriver driver;

	@Test
	public static void test() {
		try {

			// Setup chromedriver path and launch chrome
			String path = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\chromedriver.exe");

			WebDriver driver = new ChromeDriver(); //ChromeDriver implements WebDriver

			// Maximize browser
			// driver.manage().window().setSize(new Dimension(400, 400));
			driver.manage().window().maximize();

			// Search for results
			driver.get("https://www.speaklanguages.com/english/");
			// DOM - document object model
			Thread.sleep(1000);
//			driver.findElement(By.id("nav_login")).click();
//			Thread.sleep(2000);
//
//			// Backward forward refresh page
//			driver.navigate().back();
//			Thread.sleep(2000);
//			driver.navigate().forward();
//			Thread.sleep(2000);
//			driver.navigate().refresh();
//			Thread.sleep(2000);

			// Closing the chrome
			driver.close();
			driver.quit();
		} catch (Exception e) {
			System.out.println("Caught an exception: " + e);
		}
	}
}
