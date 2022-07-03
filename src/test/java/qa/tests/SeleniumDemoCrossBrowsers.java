package qa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumDemoCrossBrowsers {
	static WebDriver driver;

	@Test
	@Parameters({"browser"})
	public static void launchApp(String browser) { //Chrome
		try {
			String path = System.getProperty("user.dir");
			switch(browser) {
				case "Chrome":
					//Setup chromedriver path and launch chrome
					System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\chromedriver.exe");
					driver = new ChromeDriver();
					break;
				case "Firefox":
					//Setup chromedriver path and launch chrome
					System.setProperty("webdriver.gecko.driver", path + "\\src\\test\\resources\\geckodriver.exe");
					driver = new FirefoxDriver();
					break;
				case "Edge":
					//Setup chromedriver path and launch chrome
					System.setProperty("webdriver.edge.driver", path + "\\src\\test\\resources\\msedgedriver.exe");
					driver = new EdgeDriver(); //ChromeDriver implements WebDriver
					break;
			}
				// Maximize browser
				driver.manage().window().maximize();
				// Search for results
				driver.get("https://google.co.in");
				driver.close();
				driver.quit();
		} catch (Exception e) {
			System.out.println("Caught an exception: " + e);
		}
	}
}
