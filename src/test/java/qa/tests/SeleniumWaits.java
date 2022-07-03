package qa.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class SeleniumWaits {
    static WebDriver driver;

    @Test
    @Parameters({"browser"})
    public static void launchApp(String browser) { //Chrome
        try {
            String path = System.getProperty("user.dir");
            //Setup chromedriver path and launch chrome
            System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\chromedriver.exe");
            driver = new ChromeDriver();

            //implicit wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3 * 60));

            // Maximize browser
            driver.manage().window().maximize();
            System.out.println("browser maximized");

            // Search for results
            driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
            System.out.println("App Launched");

            Thread.sleep(2000);

            //explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(By.name("proceed")));
            wait.until(ExpectedConditions.elementToBeClickable(By.name("proceed")));
            driver.findElement(By.name("proceed")).click();


        } catch (Exception e) {
            System.out.println("Caught an exception: " + e);
        }
    }
}
