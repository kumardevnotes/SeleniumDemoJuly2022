package qa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SeleniumWithTestNGIntellijDuplicate {

    WebDriver  driver;

    @BeforeMethod //@BeforeMethod
    public void setup(){
        // Setup chromedriver path and launch chrome
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public  void launchGoogleSearchII() {
        try {
            // Search for results
            driver.get("https://google.co.in");
            // DOM - document object model
            Thread.sleep(1000);

        } catch (Exception e) {
            System.out.println("Caught an exception: " + e);
        }
    }

    @Test
    public  void launchWikipediaII() {
        try {
            // Search for results
            driver.get("https://www.wikipedia.org/");
            // DOM - document object model
            Thread.sleep(1000);
            Assert.fail("launchWikipediaII failed");
        } catch (Exception e) {
            System.out.println("Caught an exception: " + e);
        }

    }

    @AfterMethod //@AfterMethod
    public void teardown(){
        // Closing the chrome
        driver.close();
        driver.quit();
    }
}
