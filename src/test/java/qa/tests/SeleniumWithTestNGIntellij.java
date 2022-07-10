package qa.tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SeleniumWithTestNGIntellij {
    WebDriver  driver;
    @BeforeMethod (alwaysRun = true)
    public void setup(){
        // Setup chromedriver path and launch chrome
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(groups = { "regression" })
    public  void launchGoogleSearchI() {
        try {
            // Search for results
            driver.get("https://google.co.in");
            // DOM - document object model
            Thread.sleep(1000);
            //Assert.fail("launchGoogleSearchI failed");
            System.out.println("test");
        } catch (Exception e) {
            System.out.println("Caught an exception: " + e);
        }
    }

    @Test(groups = { "smoke" })
    public  void launchGoogleSearchII() {
        try {
//            // Search for results
//            driver.get("https://google.co.in");
//            // DOM - document object model
//            Thread.sleep(1000);
//            //Assert.fail("launchGoogleSearchI failed");
            System.out.println("test");
        } catch (Exception e) {
            System.out.println("Caught an exception: " + e);
        }
    }

    @Test(groups = { "smoke" })
    public  void launchGoogleSearchIII() {
        try {
            // Search for results
            driver.get("https://google.co.in");
            // DOM - document object model
            Thread.sleep(1000);
            //Assert.fail("launchGoogleSearchI failed");
            System.out.println("test");
        } catch (Exception e) {
            System.out.println("Caught an exception: " + e);
        }
    }

    @Test(groups = { "smoke" })
    public  void launchWikipediaI() {
        try {
//            // Search for results
//            driver.get("https://www.wikipedia.org/");
//            // DOM - document object model
//            Thread.sleep(1000);

            System.out.println("Test");

        } catch (Exception e) {
            System.out.println("Caught an exception: " + e);
        }

    }

    @Test(groups = { "regression" })
    public  void launchWikipediaII() {
        try {
            // Search for results
            driver.get("https://www.wikipedia.org/");
            // DOM - document object model
            Thread.sleep(1000);

            System.out.println("Test");

        } catch (Exception e) {
            System.out.println("Caught an exception: " + e);
        }
    }

    @AfterMethod (alwaysRun = true)
    public void teardown(){
        // Closing the chrome
        driver.close();
        driver.quit();
    }
}
