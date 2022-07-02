package qa.tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SelniumWithTestNGEclipse {
	
  @Test
  public void launchSearchEngine() {
	  try {
          // Setup chromedriver path and launch chrome
          String path = System.getProperty("user.dir");
          System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\chromedriver.exe");

          WebDriver driver = new ChromeDriver();

          driver.manage().window().setSize(new Dimension(800, 800));

          // Search for results
          driver.get("https://google.co.in");
          // DOM - document object model
          Thread.sleep(1000);

          // Closing the chrome
          driver.close();
          driver.quit();
      } catch (Exception e) {
          System.out.println("Caught an exception: " + e);
      }
  }
}
